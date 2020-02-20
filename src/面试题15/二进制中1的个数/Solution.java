package 面试题15.二进制中1的个数;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count = count + (n & 1);
            n = n >>> 1;
        }
        return count;
    }
}