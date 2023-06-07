package my.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

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
            handle(accept);
        }


    }

    private static void handle(Socket accept) throws IOException {

        byte[] buff = new byte[1024];

        InputStream inputStream = accept.getInputStream();

        int read = inputStream.read(buff);

        if (read!=-1){
            System.out.println("server receive msg :"+new String(buff,0,read));
        }

        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("你好啊👋".getBytes(StandardCharsets.UTF_8));

    }
}
