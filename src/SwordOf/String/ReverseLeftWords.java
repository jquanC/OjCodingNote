package SwordOf.String;

/**第 n-1个 应该在 s.length-n的位置处*/
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        char[] arr = new char[len];
        for(int i =0;i<len;i++){
            if(i<n){
                arr[i+(len-n)] = s.charAt(i);
            }else{
                arr[i-n]=s.charAt(i);
            }
        }
        return new String(arr);
    }
}
