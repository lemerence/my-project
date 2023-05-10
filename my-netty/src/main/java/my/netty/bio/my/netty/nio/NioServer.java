package my.netty.bio.my.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/5/10 15:22
 * @description:
 */
public class NioServer {
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;

    public NioServer() throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 9090));

        selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        handleKeys();
    }

    private void handleKeys() throws IOException {

        while (true){
            int select = selector.select(30 * 3000);
            if (select == 0){
                continue;
            }
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                iterator.remove();

                handleKey(selectionKey);

            }
        }

    }

    private void handleKey(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isAcceptable()){
            handleAcceptable(selectionKey);
        }
        if (selectionKey.isReadable()){
            handleReadable(selectionKey);
        }
        if (selectionKey.isWritable()){

        }
    }

    private void handleReadable(SelectionKey selectionKey) {
        selectionKey.channel();
    }

    private void handleAcceptable(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();

        socketChannel.configureBlocking(false);

        socketChannel.register(selector,SelectionKey.OP_READ,new ArrayList<String>());
    }
}
