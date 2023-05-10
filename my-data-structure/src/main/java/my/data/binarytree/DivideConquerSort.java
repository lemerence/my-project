package my.data.binarytree;


import java.util.Random;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/2/24 16:04
 * @description: 快排 O（nlogn）
 * 队列中取一个基准值，小于放左边大于放右边等于两边都行  递归
 */
public class DivideConquerSort {




    public static void main(String[] args) {
        int[] arr = generate(1000, 1000);
//        int[] arr = new int[]{20,1,40,19,9};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println();
        System.out.println("--------------");

        quickSort2(arr,0,arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }

    }

    public static int[] generate(int length, int bound) {

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            int n = new Random().nextInt(bound);
            arr[i] = n;
        }
        return arr;

    }

    /**
     * @param arr
     * @param s   左
     * @param m   右
     */
    private static void quickSort2(int[] arr, int s, int m) {
        if (s >= m) {
            return;
        }
        int l = s, r = m;
        int pivotVal = arr[s];

        while (l < r) {

            while (arr[r] > pivotVal && l<r){
                r--;
            }
            while (arr[l] <= pivotVal && l<r){
                l++;
            }

            if (l<r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }

        arr[s] = arr[l];
        arr[l] = pivotVal;

        quickSort2(arr,s,l-1);
        quickSort2(arr,l+1,m);


    }



    public static void quickSort1(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort1(arr, low, j-1);
        //递归调用右半数组
        quickSort1(arr, j+1, high);
    }
}
