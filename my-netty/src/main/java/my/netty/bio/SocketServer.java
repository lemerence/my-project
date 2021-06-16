package my.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: YST
 * @Date: 2021/5/30 22:13
 * @Version: 1.0
 * @Description: socket服务端
 */
public class SocketServer {


    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9000);
        while (true){
            Socket accept = serverSocket.accept();
            handler(accept);

        }


    }

    private static void handler(Socket accept) throws IOException {
        //读取消息
        byte[] bytes = new byte[1023];
        int read = accept.getInputStream().read(bytes);

        if (read==-1){
            //读取完毕
            System.out.println(new String(bytes, 0, read));

        }
        accept.getOutputStream().write("HelloClient".getBytes());
        accept.getOutputStream().flush();
    }
}
