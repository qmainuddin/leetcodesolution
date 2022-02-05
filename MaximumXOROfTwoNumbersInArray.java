package leetcode;

import java.util.Arrays;

public class MaximumXOROfTwoNumbersInArray {

    public static void main(String[] args) {
        int[] a1 = getTest1();
        Arrays.sort(a1);
        printArray(a1);
        printBinaryString(a1);
        System.out.println(findMaximumXOR(getTest1()));

    }

    public static int findMaximumXOR(int[] nums) {
        int max = 0;
        int firstMax = 0;
        int secondMax = 0;

        for (int i =0; i<nums.length; i++) {
            for (int j = i+1; j< nums.length; j++) {
                int xorValue = nums[i] ^ nums[j];
                if (xorValue > max) {
                    max = xorValue;
                    firstMax = nums[i];
                    secondMax = nums[j];
                }
            }
        }

        System.out.println("( " + firstMax + ", " + secondMax + " ) => " + max);
        return max;
    }

    public static int[] getTest1() {
        return new int[] {4, 9, 27, 36, 33, 30};
    }

    public static void printArray(int[] a) {
        Arrays.stream(a).forEach(i -> System.out.printf(i + ","));
        System.out.println();
    }

    public static void printBinaryString(int[] a) {
        Arrays.stream(a).forEach(i -> {
            System.out.printf(Integer.toBinaryString(i) + ", ");
        });
        System.out.println();
    }
}
/*
*   101
* 11001
*
* */