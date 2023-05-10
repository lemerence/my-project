package my.juc;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/1/11 10:47
 * @description:
 */
public class ThreadState {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(() -> {
            while (count < 100) {
                if (count % 2 == 0) {
                    System.out.print("A");
                    count++;
                }

            }
        });

        Thread threadB = new Thread(() -> {
            while (count < 100) {
                if (count % 2 == 1) {
                    System.out.print("B");
                    count++;
                }
            }
        });


        threadA.start();
        threadB.start();

        Thread.sleep(1000);
        System.out.println();
        System.out.println("ABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABAB".length());
    }

}
