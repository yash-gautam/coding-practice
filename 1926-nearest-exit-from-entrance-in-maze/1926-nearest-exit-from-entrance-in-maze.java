class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length, m = maze[0].length;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int steps = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        
        int r = 0, c=0;
        
        while(!q.isEmpty()){
            int size = q.size();
            steps++;
            for(int i=0; i<size; i++){
                int[] temp = q.poll();  
                for(int j=0; j<4; j++){
                    r = temp[0] + dir[j][0];
                    c = temp[1] + dir[j][1];
                    
                    if(r<0 || c<0 || r>=n || c>=m || maze[r][c]=='+'){
                        continue;
                    }
                    
                    if(r==0 || c==0 || r==n-1 || c==m-1){
                        return steps;
                    }
                    
                    maze[r][c] = '+';
                    q.offer(new int[]{r, c});
                }
            }            
        }
        
        // System.out.println("r::c  "+r+"::"+c);
        
        return -1;
    }
}