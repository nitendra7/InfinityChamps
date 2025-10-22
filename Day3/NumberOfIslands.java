class Solution {

    static boolean isValid(int nr,int nc,int r,int c,boolean[][] visited,char[][] grid){
        return nr>=0&&nc>=0&&nr<r&&nc<c&&!visited[nr][nc]&&grid[nr][nc]=='1';
    }
    static void bfs(char[][] grid,int sr,int sc,boolean[][] visited){
        int r=grid.length,c=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        visited[sr][sc]=true;
        q.add(new int[]{sr,sc});
        int[] dr={1,0,-1,0};
        int[] dc={0,1,0,-1};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int cr=curr[0],cc=curr[1];
            for(int i=0;i<4;i++){
                int nr=cr+dr[i],nc=cc+dc[i];
                if(isValid(nr,nc,r,c,visited,grid)){
                    visited[nr][nc]=true;
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int rows=grid.length,cols=grid[0].length,count=0;
        boolean[][] visited=new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    bfs(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
}