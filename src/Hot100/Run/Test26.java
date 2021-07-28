package Hot100.Run;

import Hot100.Medium.So26DiffPath;

public class Test26 {
    public static void main(String[] args){
        So26DiffPath so = new So26DiffPath();
        int ans = so.uniquePaths(3,7);
        System.out.println(ans);
    }
}
