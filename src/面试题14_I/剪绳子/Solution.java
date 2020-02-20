package 面试题14_I.剪绳子;

class Solution {
    //贪婪分为多个3
    public int cuttingRope(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        if (n == 4)
            return 4;
        int res = 3;
        n -= 3;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        res *= n;
        return res;
    }

}