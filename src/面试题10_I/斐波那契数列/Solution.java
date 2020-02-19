package 面试题10_I.斐波那契数列;

class Solution {
    public int fib(int n) {
        if (n == 0)
            return 0;
        long res1 = 1;
        long res2 = 1;
        for (int i = 0; i < n - 2; i++) {
            long temp = (res1 + res2) % 1000000007;
            res1 = res2;
            res2 = temp;
        }
        return (int) res2;

    }
}