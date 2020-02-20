package 面试题13.机器人的运动范围;

class Solution {
    int x;
    int y;
    boolean hasGet[][];

    public int movingCount(int m, int n, int k) {
        this.x = m;
        this.y = n;
        hasGet = new boolean[m][n];
        int res = returnNeighbor(0, 0, k);
        return res;
    }

    private int returnNeighbor(int x1, int y1, int k) {
        if (x1 < 0 || x1 >= x || y1 < 0 || y1 >= y || hasGet[x1][y1] == true)
            return 0;
        else if (getNumCount(x1, y1) > k)
            return 0;
        else {
            hasGet[x1][y1] = true;
            return 1 + returnNeighbor(x1 + 1, y1, k) + returnNeighbor(x1, y1 + 1, k)
                    + returnNeighbor(x1, y1 - 1, k);
        }
    }

    private int getNumCount(int x, int y) {
        int sum = 0;
        int temp = x;
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        temp = y;
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum;
    }
}