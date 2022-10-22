package queue.example;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {
    public static void main(String[] args) {

        int counter = 0;
        int matrix[][] = {};
        int row = matrix.length;
        int col = matrix[0].length;
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if(!visited.contains(i+"_"+j) && matrix[i][j] ==1){
                    bfs(matrix, i, j);
                    counter++;
                }

            }

        }
    }



    static void bfs(int matrix[][], int i, int j){

    }
}
