package Hot100.Medium.DFS;

public class DFSGrid {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfsGrid(grid,i,j,m,n);
                }
            }
        }
        return res;
    }
    public void dfsGrid(char[][] grid,int x,int y,int m , int n){
        if(x==m || y==n) return;
        if(x==-1 || y==-1) return;

        if(grid[x][y]=='1'){
            grid[x][y]='0';
            dfsGrid(grid,x+1,y,m,n);
            dfsGrid(grid,x,y+1,m,n);
            dfsGrid(grid,x-1,y,m,n);
            dfsGrid(grid,x,y-1,m,n);
        }else return;
    }
}
