class Solution {
    public void islandsAndTreasure(int[][] grid) {
       int m = grid.length;
       int n = grid[0].length;
       int INF =  2147483647;

       Deque<int[]> queue = new ArrayDeque<>();
       for(int i = 0 ; i < m; i++){
        for(int j = 0; j < n; j++){
            if(grid[i][j]==0){
                queue.offer(new int[]{i, j});
            }
        }
       }

       int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};

       while(!queue.isEmpty()){
        int[] cell = queue.poll();
        int row = cell[0];
        int col = cell[1];

        for(int[] dir: dirs){

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow < 0 || newRow >= m || newCol < 0 || newCol >=n){
                continue;
            }

            if(grid[newRow][newCol] != INF){
                continue;
            }

            grid[newRow][newCol] = grid[row][col] + 1;

            queue.offer(new int[]{newRow,newCol});
        }
       }
    }
}
