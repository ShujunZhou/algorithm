package jingdong;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int sizeOne = sc.nextInt();
        int sizeTwo = sc.nextInt();
        TreeSet<Integer> nums = new TreeSet<Integer>();

        for (int i = 0; i < sizeOne; ++i) {
            nums.add(sc.nextInt());
        }

        for (int i = 0; i < sizeTwo; ++i) {
            nums.add(sc.nextInt());
        }

        int i = 0;
        for (Iterator<Integer> it = nums.iterator(); it.hasNext(); i++) {
            if (i == nums.size() - 1) {
                System.out.print(it.next());
            } else {
                System.out.print(it.next() + " ");
            }
        }
    }
}
