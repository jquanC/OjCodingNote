package test.TestExample;

public class Test00708 {
    public static void main(String[] args) {
        System.out.println("开心");
        String str = "开心吗";
        System.out.println(str.length());
        System.out.println(str);
        char c = '吃';
        char d = '严';//java 内部 使用 UTF-16， 统一采用两个字节表示一个字符 ， char 类型 2个字节
        System.out.println(c==d);
        String str1 = "开心吗";
        String str2 = "开心吗";
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
        String s1 = "asf";
        String s2 = "asf";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        /**
         *
         * 1.一定不要使用==运算符检测两个字符串是否相等！这个运算符只能够确定两个字符串是否放置在同一个位置上。当然，如果字符串放置在同一个位置上，它们必然相等。但是，完全有可能将内容相同的多个字符串的拷贝放置在不同的位置上。2.如果虚拟机始终将相同的字符串共享，就可以使用==运算符检测是否相等。但实际上只有字符串常量是共享的，而+或substring等操作产生的结果并不是共享的。
         *
         * 作者：clover
         * 链接：https://www.zhihu.com/question/53217817/answer/134086515
         * 来源：知乎
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         * */
        String s = "吃饭了";
        String ss1 = s.substring(2,2);
        String ss2 = s.substring(2,3);
        System.out.println(ss1);
        System.out.println(ss2);


    }


}
