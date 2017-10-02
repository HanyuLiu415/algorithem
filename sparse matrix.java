//a sparse matrix or sparse array is a matrix in which most of the elements are zero
//assume that A's column number is equal to B's row number.

 public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null) {
            return null;
        }
        int m = A.length;
        int n = A[0].length;
        int nB = B[0].length;
        List[] rowA = new ArrayList[m];// a sparse matrix can be represented as a sequence of rows,each row is a number of pairs(col, val) of nonzero values in the row;
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    row.add(j);//construction of pairs;
                    row.add(A[i][j]);
                }
            }
            rowA[i] = row;
        }
        int[][] res = new int[m][nB];
        for (int i = 0; i < m; i++) {
            List<Integer> list = rowA[i];
            for (int j = 0; j < list.size(); j += 2) {
                int col = list.get(j);//nonzero
                int val = list.get(j + 1);
                for (int k = 0; k < nB; k++) {
                    if (B[col][k] != 0) {
                        res[i][k] += val * B[col][k];
                    }
                }
            }
        }
        return res;  
    }