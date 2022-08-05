package EeacDay;

public class M0730 {
    public static void main(String[] args) {
        M0730 so = new M0730();
        String s1 = "1.01";
        String s2 = "1.001";
        int ans = so.compareVersion(s1, s2);
        System.out.println(ans);
        String ss1 = "126";
        String ss2 = "121";
        System.out.println(ss1.compareTo(ss2));
        System.out.println(Integer.parseInt("-000808",10));
        System.out.println(Integer.valueOf("-000808",10));

    }

    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");

        int len1 = strs1.length;
        int len2 = strs2.length;

        int p1 = 0;
        int p2 = 0;
        while (p1 < len1 && p2 < len2) {
            String s1 = deletePreZoro(strs1[p1]);
            String s2 = deletePreZoro(strs2[p2]);
            if (s1.equals(s2)) {
                p1++;
                p2++;
                continue;
            }
//            if(s1.compareTo(s2)>0) return 1;//不能按字典序比较 1.2 和 1.10 ， 10应该比2大，看作10而不是1
//            else return -1;
            if(s2.equals("")) return 1;
            if(s1.equals("")) return -1;

            int num1 = Integer.valueOf(s1);
            int num2 = Integer.valueOf(s2);
            if(num1>num2) return 1;
            else return  -1;
        }

        while (p1<len1){
            String s1 = deletePreZoro(strs1[p1]);
            if(s1.equals("")){
                p1++;
                continue;
            }
            else return 1;
        }
        while (p2<len2){
            String s2 = deletePreZoro(strs2[p2]);
            if(s2.equals("")){
                p2++;
                continue;
            }
            else return -1;
        }

        return 0;


    }

    public String deletePreZoro(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }
        return str.substring(i);
    }
}
