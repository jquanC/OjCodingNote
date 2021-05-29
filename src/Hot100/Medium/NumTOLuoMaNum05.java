package Hot100.Medium;

/*
* 罗马数字包含以下七种字符： I-1， V-5， X-10， L-50，C-100，D-500 和 M-1000。
* */
public class NumTOLuoMaNum05 {
    public String intToRoman(int num){
        int[] calNUmTable = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] calRomanSign = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder builderRoman = new StringBuilder();
        int cou=0;
        for(int i=0;i<13;i++){
            cou = num/calNUmTable[i];
            num %= calNUmTable[i];

            while(cou!=0){
                builderRoman.append(calRomanSign[i]);
                cou--;
            }
        }
        return builderRoman.toString();

    }

}
