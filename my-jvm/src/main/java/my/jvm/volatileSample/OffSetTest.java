package my.jvm.volatileSample;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/2/27 16:17
 * @description:
 */
public class OffSetTest {



    public static void main(String[] args) {


        String str = "a";
        System.out.println(str.length());

        Byte b = new Byte("100");
        Short s = new Short("100");
        Integer i = new Integer("100");
        Long l = new Long("100");


        System.out.println(ClassLayout.parseInstance(b).toPrintable());
        System.out.println(ClassLayout.parseInstance(s).toPrintable());
        System.out.println(ClassLayout.parseInstance(i).toPrintable());
        System.out.println(ClassLayout.parseInstance(l).toPrintable());



        new OffSetTest().maxProfit(new int[]{7,1,5,3,6,4});

    }

//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        for(int i = 0;i < prices.length-1;i++){
//            for(int j = i+1;j < prices.length;j++){
//                maxProfit = Math.max(maxProfit,prices[j]-prices[i]);
//            }
//        }
//        return maxProfit;
//    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for(int i = 1;i < prices.length;i++){
            dp[i] = Math.min(dp[i-1],prices[i]);
            maxProfit = Math.max(prices[i]-dp[i],maxProfit);
        }
        return maxProfit;
    }
}
