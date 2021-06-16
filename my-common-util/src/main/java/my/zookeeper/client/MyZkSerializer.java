package my.zookeeper.client;

import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Author: YST
 * @Date: 2021/4/25 1:28
 * @Version: 1.0
 * @Description: zk序列化
 */
public class MyZkSerializer implements ZkSerializer {
    /**
     * 序列化，将对象转化为字节数组
     */
    @Override
    public byte[] serialize(Object obj) throws ZkMarshallingError {
        return String.valueOf(obj).getBytes(StandardCharsets.UTF_8);
    }

    /**
     * 反序列化，将字节数组转化为UTF_8字符串
     */
    @Override
    public Object deserialize(byte[] bytes) throws ZkMarshallingError {
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
