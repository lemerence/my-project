package my.netty.bio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/5/10 14:16
 * @description:
 */
public class BufferTest {


    public static void main(String[] args) throws IOException {
//        Buffer buffer = ByteBuffer.allocate(1024);
//        Buffer directBuffer = ByteBuffer.allocateDirect(1024);
//        ByteBuffer heapBuffer = ByteBuffer.wrap(new byte[1024]);
//
//        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9090));
//
//
//        Selector selector = Selector.open();
//
//        socketChannel.configureBlocking(false);
//        socketChannel.register(selector,SelectionKey.OP_ACCEPT | SelectionKey.OP_CONNECT);


        System.out.println(SelectionKey.OP_ACCEPT);
        System.out.println(SelectionKey.OP_CONNECT);
        System.out.println(SelectionKey.OP_WRITE);
        System.out.println(SelectionKey.OP_READ);
        System.out.println(3 << 4);
        System.out.println(32 >> 5);

    }
}
