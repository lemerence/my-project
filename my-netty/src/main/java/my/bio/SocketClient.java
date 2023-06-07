package my.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @Author: YST
 * @Date: 2021/5/30 22:12
 * @Version: 1.0
 * @Description: socket客户端
 */
public class SocketClient {


    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",9000);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("长江长江，我是黄河，收到请回复".getBytes(StandardCharsets.UTF_8));
        System.out.println("client send msg --->");

        byte[] buff = new byte[1024];

        InputStream inputStream = socket.getInputStream();
        int read = inputStream.read(buff);
        if (read!=-1){
            System.out.println("client receive msg："+ new String(buff,0,read));
        }

    }

}
