package my.juc;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/2/3 11:06
 * @description:
 */
public class ThreadAtomicityTest {

    private int step;

    public int getStep(){
        return step;
    }

    public void increaseStep(){
        step++;
    }

}
