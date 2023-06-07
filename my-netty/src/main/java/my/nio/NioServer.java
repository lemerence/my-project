package my.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/5/10 15:22
 * @description:
 */
public class NioServer {

    private static List<SocketChannel> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));
        serverSocketChannel.configureBlocking(false);

        while (true){

            SocketChannel accept = serverSocketChannel.accept();
            if (accept!=null){
                accept.configureBlocking(false);
                list.add(accept);
            }


            Iterator<SocketChannel> iterator = list.iterator();

            while (iterator.hasNext()){
                SocketChannel socketChannel = iterator.next();

                ByteBuffer buffer = ByteBuffer.allocate(128);

                int read = socketChannel.read(buffer);

                if (read > 0){
                    System.out.println("server receive msg :"+new String(buffer.array()));
                }else if (read==-1){
                    iterator.remove();
                }

            }
        }

    }


}
