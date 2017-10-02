/* Spriral Matrix */



class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        }
        int[][] res = new int[n][n];
        int[][] dir = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int i = 0;
        int j = 0;
        int k = 0;
        int num = 1;
        int up = 0;
        int left = 0;
        int right = n - 1;
        int down = n - 1;
        while (num <= n * n) {
            res[i][j] = num;
            if (k == 0 && i == up && j == right) {
                up++;
                k = 1;
            } else if (k == 1 && i == down && j == right) {
                right--;
                k = 2;
            } else if (k == 2 && i == down && j == left) {
                down--;
                k = 3;
            } else if (k == 3 && i == up && j == left) {
                left++;
                k = 0;
            }
            i += dir[k][0];
            j += dir[k][1];
            num++;
        }
        return res;
    }
}






class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;
        int i = 0;
        int j = 0;
        int k = 0;
        while (res.size() < m * n) {
            res.add(matrix[i][j]);
            if (k == 0 && i == up && j == right) {
                up++;
                k = 1;
            } else if (k == 1 && i == down && j == right) {
                right--;
                k = 2;
            } else if (k == 2 && i == down && j == left) {
                down--;
                k = 3;
            } else if (k == 3 && i == up && j == left) {
                left++;
                k = 0;
            }
            i += dir[k][0];
            j += dir[k][1];
        }
        return res;
    }
}