package me.syus.dictsearch.service;

import java.util.ArrayList;
import java.util.List;

public class DictSearch {
    TreeNode root;
    char[][] matrix;
    boolean[][] visited;
    int[][] dirs = {{0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}};
    public List<String> result;

    public DictSearch(String[] dict, char[][] matrix) {
        this.root = new TreeNode();
        this.matrix = matrix;
        this.result = new ArrayList<>();
        this.visited = new boolean[matrix.length][matrix[0].length];
        buildTree(dict);
    }

    private void buildTree(String[] dict) {
        for (String word : dict) {
            TreeNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'A';
                if (cur.children[index] == null) {
                    cur.children[index] = new TreeNode();
                }
                cur = cur.children[index];
                if (i == word.length() - 1) {
                    // last
                    cur.isLast = true;
                }
            }
        }
    }

    public List<String> solution() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                dfs(sb, i, j, root);
            }
        }
        return result;
    }

    private void dfs(StringBuilder sb, int x, int y, TreeNode root) {
        this.visited[x][y] = true;

        if (root.isLast) {
            result.add(sb.toString());
        }

        sb.append(matrix[x][y]);

        int index = matrix[x][y] - 'A';

        for (int i = 0; i < 8; ++i) {
            int newX = x + this.dirs[i][0];
            int newY = y + this.dirs[i][1];

            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length
                    && !this.visited[newX][newY] && root.children[index] != null) {
                dfs(sb, newX, newY, root.children[index]);
            }
        }
        this.visited[x][y] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

//    public static void main(String[] args) {
//        String[] dict = {"CAT", "DOG", "BYTE", "TUBE", "CAN", "ANT", "CAR", "TANK"};
//        char[][] matrix = {
//                {'C', 'J', 'Z', 'E'},
//                {'V', 'A', 'X', 'B'},
//                {'X', 'N', 'T', 'U'},
//                {'I', 'A', 'N', 'K'}
//        };
//
//        DictSearch d = new DictSearch(dict, matrix);
//        d.solution();
//
//        System.out.println(d.result);
//    }

}
