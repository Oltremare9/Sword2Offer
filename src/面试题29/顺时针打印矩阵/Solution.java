package 面试题29.顺时针打印矩阵;

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length < 1)
            return new int[0];
        if (matrix.length == 1 && matrix[0].length == 1) {
            int res[] = {matrix[0][0]};
            return res;
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        int x = matrix.length;
        int y = matrix[0].length;
        int i = 0;
        int j = 0;
        while (i >= 0 && i < x && j >= 0 && j < y && !flag[i][j]) {
            while (j < y && !flag[i][j]) {
                res[index++] = matrix[i][j];
                flag[i][j] = true;
                j++;
            }
            j--;
            i++;
            while (i < x && !flag[i][j]) {
                res[index++] = matrix[i][j];
                flag[i][j] = true;
                i++;
            }
            i--;
            j--;
            while (j >= 0 && !flag[i][j]) {
                res[index++] = matrix[i][j];
                flag[i][j] = true;
                j--;
            }
            j++;
            i--;
            while (i >= 0 && !flag[i][j]) {
                res[index++] = matrix[i][j];
                flag[i][j] = true;
                i--;
            }
            i++;
            j++;
        }
        return res;

    }
}