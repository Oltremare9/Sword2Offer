package 面试题16.数值的整数次方;

class Solution {
    public static double myPow(double x, int n) {
        long temp = n;
        boolean isNeg = false;
        double res;
        if (x == 0 || x == 1)
            return 1;
        else if (temp == 0)
            return 1;
        else if (temp < 0) {
            temp = -temp;
            isNeg = true;
        }
        if (isNeg)
            return 1 / pow(x, temp);
        else
            return pow(x, temp);
    }

    private static double pow(double x, long n) {
        double res;
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n % 2 == 0)
            res = pow(x * x, n >>> 1);
        else
            res = pow(x * x, n >>> 1) * x;
        return res;
    }

    public static void main(String args[]) {
        System.out.println(myPow(0.00001, 2147483647));
    }
}