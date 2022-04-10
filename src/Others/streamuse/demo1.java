package Others.streamuse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class demo1 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","",
                "jkl");
//        List<String> filtered = strings.stream().filter(string->!string.isEmpty()).collect(Collectors.toList());
        List<String> filtered = strings.stream().filter(string->string.length()>0).collect(Collectors.toList());//效果同上
        System.out.println(filtered.toString());
    }
}
