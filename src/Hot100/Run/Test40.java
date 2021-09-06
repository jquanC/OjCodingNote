package Hot100.Run;

import Hot100.Medium.So40GrayCode;

import java.util.List;

public class Test40 {
    public static void main(String args[]){
        So40GrayCode so = new So40GrayCode();
        List<Integer> res =  so.grayCode(3);
        System.out.println(res.toString());
    }
}
