package my.netty.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * @Author: YST
 * @Date: 2021/5/30 22:12
 * @Version: 1.0
 * @Description: socket客户端
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",9000);

        socket.getOutputStream().write("客户端发送消息".getBytes());
        socket.getOutputStream().flush();
        System.out.println("向服务端发送数据结束");
        byte[] bytes = new byte[1024];
        int read = socket.getInputStream().read(bytes);
        System.out.println("接收到服务端的数据：" + new String(bytes));
        socket.close();



    }

}
