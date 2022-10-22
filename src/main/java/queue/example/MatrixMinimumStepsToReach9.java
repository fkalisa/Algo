package queue.example;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MatrixMinimumStepsToReach9 {

    /*
    Amazon interview
    4 directions
    visited

     */
    public static void main(String[] args) {
        int[][] matrix ={
                {1, 1, 0, 0},
                {1, 1, 0, 1},
                {1, 0, 0, 0},
                {1, 1, 9, 0}};

        int row = matrix.length;
        int col = matrix[0].length;
        int dir[][] ={{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        Queue<int []> q= new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(new int[]{0, 0, 0});
        visited.add("0_0");
        int ans = -1;
        while (!q.isEmpty()){
            int current[] = q.remove();
            int currentI = current[0];
            int currentJ = current[1];
            int currentLevel = current[2];

            if(matrix[currentI][currentJ] == 9 ){
                System.out.println("currentLevel: " + matrix[currentI][currentJ]);
                ans = currentLevel;
                break;
            }



            System.out.println("--");
            for (int i = 0; i < dir.length; i++) {

                int nextI =currentI + dir[i][0];
                int nextJ =currentJ+ dir[i][1];

                if(nextI >= 0 && nextJ>= 0 && nextI< row && nextJ < col && matrix[nextI][nextJ] !=0 && !visited.contains(nextI+"_"+nextJ)){
                    visited.add(nextI+"_"+nextI);
                    q.add(new int []{nextI, nextJ, currentLevel+1});

                }
            }

        }

        System.out.println(ans);
    }

}
