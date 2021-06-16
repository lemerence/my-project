package my.zookeeper.client;

import cn.hutool.core.util.ArrayUtil;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @Author: YST
 * @Date: 2021/4/24 21:56
 * @Version: 1.0
 * @Description:
 */
public class ZookeeperTest {

    private ZkClient zkClient = null;

    /**
     * @Author: YST
     * @Date: 23:30 2021/4/24
     * @Param: []
     * @Return: void
     * @Description: String zkServers, int sessionTimeout, int connectionTimeout, ZkSerializer zkSerializer, long operationRetryTimeout
     **/
    @Before
    public void init() {
        zkClient = new ZkClient("192.168.101.101:2181", 30 * 1000, 60 * 1000,new MyZkSerializer());
    }

    @Test
    public void test() {
//        CreateMode.EPHEMERAL;
//        CreateMode.EPHEMERAL_SEQUENTIAL;
//        CreateMode.PERSISTENT;
//        CreateMode.PERSISTENT_SEQUENTIAL;
//
//        CREATE 允许对子节点Create操作
//        READ 允许对本节点GetChildren和GetData操作
//        WRITE 允许对本节点SetData操作
//        DELETE 允许对子节点Delete操作
//        ADMIN 允许对本节点setAcl操作
//        ALL

//        int perm = ZooDefs.Perms.ADMIN | ZooDefs.Perms.READ | ZooDefs.Perms.WRITE;
//        List<ACL> aclList1 = new ArrayList<>();
//        aclList1.add(new ACL(perm, new Id("world", "anyone")));
//        aclList1.add(new ACL(ZooDefs.Perms.ALL, new Id("ip", "192.168.101.100")));
//        aclList1.add(new ACL(ZooDefs.Perms.ALL, new Id("ip", "192.168.101.101")));
//
//        List<ACL> aclList2 = new ArrayList<>();
//        aclList2.add(new ACL(perm, new Id("world", "anyone")));
//        aclList2.add(new ACL(perm, new Id("ip", "192.168.101.100")));
//        aclList2.add(new ACL(ZooDefs.Perms.ALL, new Id("ip", "192.168.101.101")));
//
//        String tempData1 = zkClient.create("/temp_num", "temp_num_data", aclList1, CreateMode.EPHEMERAL_SEQUENTIAL);
//        String tempData2 = zkClient.create("/temp_num", "temp_num_data", aclList1, CreateMode.EPHEMERAL_SEQUENTIAL);
//        System.out.println(tempData1);
//        System.out.println(tempData2);
//        String persistentData = zkClient.create("/persistent", "persistent_data", CreateMode.PERSISTENT);
//        System.out.println(persistentData);
//        zkClient.setAcl("/persistent",aclList2);
//        boolean delete1 = zkClient.deleteRecursive("/temp_num");
//        System.out.println(delete1);
//        boolean delete2 = zkClient.delete("/persistentData");
//        System.out.println(delete2);

//        zkClient.create("/a",new ArrayList<String>(){{add("a");add("b");}},aclList1,CreateMode.PERSISTENT); //失败？？
//        zkClient.createPersistent("/a/b/c/d",true);
//        zkClient.writeData("/persistent", "persistent_data1");
//        List<String> children = zkClient.getChildren("/a");
//        for (String child : children) {
//            System.out.println(child);
//        }
//
//        Object o = zkClient.readData("/persistent",new Stat());
//        System.out.println(o);

        zkClient.subscribeChildChanges("/a", new IZkChildListener() {
            @Override
            public void handleChildChange(String s, List<String> list) throws Exception {
                System.out.println(s+"节点的子节点变化。。。当前节点为："+ (ArrayUtil.isAllEmpty(list)?"":"/")+ (ArrayUtil.isAllEmpty(list)?"":ArrayUtil.join(ArrayUtil.toArray(list,String.class),",/")));
            }
        });

        zkClient.subscribeDataChanges("/persistent", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println(s+"节点的数据变化。。。当前数据为："+o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println(s+"节点的数据删除。。。当前数据为：");
            }
        });

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
