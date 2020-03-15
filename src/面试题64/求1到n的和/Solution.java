package 面试题64.求1到n的和;

/*
不用加减乘除做加法的方法是使用按位异或和按位与运算。
计算a + b等价于计算(a ^ b) + ((a & b) << 1)，
其中((a & b) << 1)表示进位。
因此令a等于(a & b) << 1，令b等于a ^ b，直到a变成0，然后返回b。
 */
class Solution {
    public int add(int a, int b) {
        while (a != 0) {
            int temp = a ^ b;
            a = (a & b) << 1;
            b = temp;
        }
        return b;
    }
}
