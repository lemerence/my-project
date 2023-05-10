package y2022.m12;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2022/12/4 16:36
 * @description: ABC
 */
public class ThreadPrint {

    private static int COUNT = 0;


    public static void main(String[] args) {


        new Thread(() -> {
            while (COUNT < 100) {
                if (COUNT % 3 == 0) {
                    System.out.print("A");
                    COUNT++;
                }
            }

        }).start();

        new Thread(() -> {
            while (COUNT < 100) {
                if (COUNT % 3 == 1) {
                    System.out.print("B");
                    COUNT++;
                }
            }
        }).start();

        new Thread(() -> {
            while (COUNT < 100) {
                if (COUNT % 3 == 2) {
                    System.out.print("C");
                    COUNT++;
                }
            }
        }).start();


    }



}
