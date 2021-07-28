package Hot100.Run;

import Hot100.Medium.So29SimplifyLinuxPath;

public class Test29 {
    public static void main(String args[]){
        So29SimplifyLinuxPath so = new So29SimplifyLinuxPath();
        String linuxPath = "/a/./b/../../c/";
       System.out.println(so.simplifyPath(linuxPath));
    }
}
