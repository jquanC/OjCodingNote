package Hot100.Medium;

public class SoZString03 {

    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        //由s，numRows 确定需要开辟的数组空间
        int p =  (int)Math.ceil((double)s.length()/(double)(2*numRows-2));//输入 numRows =2 ，p=0；肯定是不行的；数组列维度>=1;
        //照成这个的原因：s.length()/(2*numRows-2)的结果已经是0，0再向上取整还是0；ceil的输入需要是double类型
        char [][] arr = new char[numRows][numRows*p];

        int count=0;
        int i=0;
        int j=0;
        while(count < s.length()){
            //垂直方向填充
            while(i<numRows && count < s.length()){
                arr[i][j] = s.charAt(count);
                count++;
                i++;
            }
            i = i-2;
            j = j+1;

            //斜右上方向填充
            while(i>=0 && j<numRows*p && count < s.length()){
                arr[i][j] = s.charAt(count);
                count++;
                i--;
                j++;
            }
            i = i+2;
            j = j-1;
        }

        StringBuilder sb = new StringBuilder();
        for(int r = 0;r<numRows;r++){
            for(int c=0;c<numRows*p;c++){
                if(arr[r][c]!='\u0000') sb.append(arr[r][c]);
            }
        }
        return sb.toString();

    }

}
