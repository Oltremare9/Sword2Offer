package 面试题66.构建乘积数组;

class Solution {
    public int[] constructArr(int[] a) {
        if (a.length == 0)
            return a;
        int c[] = new int[a.length];
        int d[] = new int[a.length];
        c[0] = 1;
        d[a.length - 1] = 1;
        int i = 0;
        while (i < a.length) {
            if (i == 0) {
                c[i] = a[i];
                d[a.length - i - 1] = a[a.length - i - 1];
            } else {
                c[i] = c[i - 1] * a[i];
                d[a.length - 1 - i] = a[a.length - 1 - i] * d[a.length - i];
            }
            i++;
        }
        int res[] = new int[a.length];
        for (i = 0; i < a.length; i++) {
            if (i == 0)
                res[i] = d[i + 1];
            else if (i == a.length - 1)
                res[i] = c[i - 1];
            else
                res[i] = c[i - 1] * d[i + 1];
        }
        return res;
    }
}