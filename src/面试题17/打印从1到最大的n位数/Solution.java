package 面试题17.打印从1到最大的n位数;

class Solution {
    public int[] printNumbers(int n) {
        int num = (int) Math.pow(10, n);
        int nums[] = new int[num - 1];
        for (int i = 1; i < num; i++) {
            nums[i - 1] = i;
        }
        return nums;
    }
}