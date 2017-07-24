package jingdong;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        for (int i = 2; i < num; ++i) {
            sum += caseType(num, i);
        }

        if (num == 1 || num == 2) {
            System.out.println("1/1");
        } else {
            int sumTemp = sum;
            int n = num - 2;
            while (n != 0) {
                int temp = sumTemp % n;
                sumTemp = n;
                n = temp;
            }

            System.out.println(sum/sumTemp + "/" + (num - 2)/sumTemp);
        }
    }

    private static int caseType(int num, int n) {
        int sum = 0;
        while (num != 0) {
            int temp = num % n;
            num /= n;
            sum += temp;
        }

        return sum;
    }
}