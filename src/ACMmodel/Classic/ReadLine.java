package ACMmodel.Classic;

public class ReadLine {

    static int count = 0;
    static int outStart =0;
    static int outEnd = 0;

    static StringBuilder sbBuff = new StringBuilder();


    private String recv() {

        switch (++count) {

            case 1: return "123\n45\n6789";

            case 2: return "abc";

            case 3: return "de";

            case 4: return "f\ng\n";

        }

        return "\n";

    }

    //recv() 返回字符串含\n 需要分隔作为多段
    //123\n45\n6789 abc de f\ng\n
    //123 45 6789 abcdef ...所读也要贪心的读

    public String read(){

        //每次调用read 至少调用 recv 一次
        String line = recv();
        sbBuff.append(line);
        //因为有可能 \n 的数量调用read 的数量，后面输出控制就不对了，所以每次读
        while(!line.contains("\n")){
            line = recv();
            sbBuff.append(line);
        }

        int outEnd = sbBuff.indexOf("\n",outStart);//返回指定子串的第一次出现的字符串中的索引，从指定的索引开始

        String ansStr =  sbBuff.substring(outStart,outEnd);
        outStart = outEnd+2;

        return ansStr;

    }


    /**

     * 请观察以上已知函数recv，每次调用时返回一段字符，其中有零、一或多个换行符。

     * 请写出下面的read()函数，要求每次调用时返回一行字符。

     * 在这个范例程序里，要求打印出来四行：

     * 123

     * 45

     * 6789abcdef

     * g

     */

    public static void main(String[] args){

        ReadLine t = new ReadLine();

        System.out.print(t.read());

        System.out.print(t.read());

        System.out.print(t.read());

        System.out.print(t.read());

    }

}