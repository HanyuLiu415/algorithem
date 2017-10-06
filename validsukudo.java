validsukudo

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
       
        for (int i = 0; i < 9; i++) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j] - '0')) {
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i] - '0')) {
                    return false;
                }
                int index = (i / 3) * 3 + (j / 3);
                Set<Integer> cube = map.getOrDefault(index, new HashSet<Integer>());
                if (board[i][j] != '.' && !cube.add(board[i][j] - '0')) {
                    return false;
                }
                map.put(index, cube);
            }
        }
        return true;
    }
}