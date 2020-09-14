package leetcode.swordToOffer;

public class FindSeqInMatrix {

    public static void main(String[] args) {
//        new FindSeqInMatrix().exist(new char[][] {
//                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C'}
//        })
    }
    private int[][] dir = new int[][] {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; ++ i) {
            for(int j = 0; j < cols; ++ j) {
                visited[i][j] = true;
                StringBuilder sb = new StringBuilder();
                sb.append(board[i][j]);
                if(dfs(i, j, board, visited, sb, word)) {
                    return true;
                }
                visited[i][j] = false;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, boolean[][] visited, StringBuilder cur, String word) {
        System.out.println(cur.toString());
        if(cur.toString().equals(word)) {
            return true;
        }

        for(int ii = 0; ii < 4; ++ ii) {
            int ni = i + dir[ii][0];
            int nj = j + dir[ii][1];
            if(ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length && !visited[ni][nj]) {
                visited[ni][nj] = true;
                cur.append(board[i][j]);
                if(dfs(ni, nj, board, visited, cur, word)){
                    return true;
                }
                cur.deleteCharAt(cur.length() - 1);
                visited[ni][nj] = false;
            }

        }
        return false;


    }
}