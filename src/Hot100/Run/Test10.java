package Hot100.Run;

import Hot100.Medium.SoGeneParenthesis10;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Test10 {
    public static void main(String args[]){
        SoGeneParenthesis10 so10 = new SoGeneParenthesis10();
        List<String> res = so10.SoGenerateParenthesis(3);
        System.out.println(Arrays.toString(res.toArray()));

        List<String> res2 = so10.SoGenerateParenthesisDp(3);
        System.out.println(Arrays.toString(res2.toArray()));

        List<String> res3 = so10.DpRecur(3);
        System.out.println(Arrays.toString(res3.toArray()));

    }
}
