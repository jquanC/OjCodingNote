package SwordOf.Search.Recurse;

public class MovingCount {

    public int movingCount(int m, int n, int k) {
        int finalCou = 0;
        boolean[][] visited = new boolean[m][n];
        boolean[][] canReach = new boolean[m][n];
        search(m,n,k,0,0,visited,canReach);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(canReach[i][j]==true) finalCou++;
            }
        }
        return finalCou;
    }
    public void search(int m ,int n , int k ,int row,int col,  boolean[][] visited,boolean[][] canReach){
        if(canReach[row][col]==false && checkReach(row,col,k)){
            visited[row][col] = true;
            canReach[row][col] = true;

            if(row>0 && visited[row-1][col]==false ) search(m,n,k,row-1,col,visited,canReach);
            if(row<m-1 && visited[row+1][col]==false ) search(m,n,k,row+1,col,visited,canReach);
            if(col>0 && visited[row][col-1]==false ) search(m,n,k,row,col-1,visited,canReach);
            if(col<n-1 && visited[row][col+1]==false ) search(m,n,k,row,col+1,visited,canReach);

            visited[row][col] = false;
        }

    }
    public boolean checkReach(int row,int col,int k){
        int x=0;
        while(row!=0 || col!=0){
            x+=row%10;
            x+=col%10;
            row/=10;
            col/=10;
        }
        if(x<=k) return true;
        else return false;

    }
}
