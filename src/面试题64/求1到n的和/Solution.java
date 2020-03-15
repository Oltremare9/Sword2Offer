package 面试题64.求1到n的和;

class Solution {
    public int sumNums(int n) {
        int sum = n;
        boolean b = (n > 0) && (sum += sumNums(n - 1)) > 0;
        return sum;
    }
}