package 面试题10_II.青蛙跳台阶问题;

class Solution {
    public int numWays(int n) {
        int first = 0;
        int second = 1;
        for (int i = 0; i < n; i++) {
            int temp = (first + second) % 1000000007;
            first = second;
            second = temp;

        }
        return second;
    }
}