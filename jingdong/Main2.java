package jingdong;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int counts = 0;
        for (int i = 1; i <= n; ++i) {
            int twoSum = twoSum(i);
            int xSum = xSum(i);
            if (twoSum == xSum) {
                counts++;
            }
        }
        System.out.println(counts);
    }

    //计算给定十进制数的二进制各数之和
    private static int twoSum(int x) {
            int sum = 0;
            while (x != 0) {
                int temp = x % 2;
                x /= 2;
                sum += temp;
            }
            return sum;
    }

        //求给定十进制数各个数位之和
        private static int xSum(int x) {
            if (x < 10) {
                return x;
            }
            //计算十进制数的位数
            int numSize = intSize(x);
            int sum = 0;
            for (int i = numSize; i >= 1; --i) {
                int oneNum = (int)Math.pow(10, i -1);
                //取最高位
                int temp = x / oneNum;
                x -= oneNum * temp;
                sum += temp;
            }
            return sum;
        }

    //判断一个十进制数的位数
    private static int intSize(int x) {
            final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999};
            for (int i = 0; ; ++i) {
                if (x < sizeTable[i]) {
                    return i + 1;
                }
            }
    }
}
