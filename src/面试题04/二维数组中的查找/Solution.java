package 面试题04.二维数组中的查找;

class Solution {
    static int t;
    static int x;
    static int y;

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        t = target;
        if (matrix.length > 0) {
            x = matrix.length;
            y = matrix[0].length;
            return findNum(matrix, 0, 0, x - 1, y - 1);
        } else return false;
    }

    private static boolean findNum(int[][] matrix, int x1, int y1, int x2, int y2) {
        int centerX = (x1 + x2) / 2;
        int centerY = (y1 + y2) / 2;
        if (x2 < x1 || y2 < y1 || x2 >= x || y2 >= y || x1 < 0 || y1 < 0)
            return false;
        else if (matrix[centerX][centerY] == t)
            return true;
        else if (matrix[centerX][centerY] < t) {//右下 右上 左下
            return findNum(matrix, centerX + 1, centerY + 1, x2, y2) ||//右下
                    findNum(matrix, x1, centerY + 1, centerX, y2) ||//右上
                    findNum(matrix, centerX + 1, y1, x2, centerY);//左下

        } else {
            return findNum(matrix, x1, y1, centerX - 1, centerY - 1) ||//左上
                    findNum(matrix, centerX, y1, x2, centerY - 1) ||//左下
                    findNum(matrix, x1, centerY, centerX - 1, y2);//右上
        }
    }

    public static void main(String args[]) {
        int[][] matrix;
        matrix = new int[][]{{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(matrix, 5));
    }
}