package SwordOf.dynamicPro;

public class IsMatch {

    public boolean isMatch(String s, String p) {
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        return matchSup(sArr, pArr, sArr.length - 1, pArr.length - 1);
    }

    public boolean matchSup(char[] sArr, char[] pArr, int sIndex, int pIndex) {
        //全部匹配完
        if (sIndex == -1 && pIndex == -1) return true;
        if (sIndex >= 0 && pIndex < 0) return false;
        if (sIndex < 0 && pIndex >= 0) {
            if (pArr[pIndex] == '*' && pIndex>=1)
                return matchSup(sArr, pArr, sIndex, pIndex - 2);
            else return false;
        }
        //匹配状态转移方程
        if (pArr[pIndex] == '*') {
            boolean state1 = false, state2 = false;
            if (isMatchChar(sArr[sIndex], pArr[pIndex - 1]))
                state1 = matchSup(sArr, pArr, sIndex - 1, pIndex - 2) || matchSup(sArr, pArr, sIndex - 1, pIndex)||matchSup(sArr, pArr, sIndex, pIndex-2);
            else state2 = matchSup(sArr, pArr, sIndex, pIndex - 2);

            return state1 || state2;
            //简化代码可以这么写
//            return matchSup(sArr,pArr,sIndex-1,pIndex-2)||matchSup(sArr,pArr,sIndex-1,pIndex)matchSup(sArr,pArr,sIndex,pIndex-2);

        } else {
            if (isMatchChar(sArr[sIndex], pArr[pIndex])) return matchSup(sArr, pArr, sIndex - 1, pIndex - 1);
            else return false;
        }


    }

    public boolean isMatchChar(char sch, char pch) {
        if (pch == '.') return true;
        if (pch == sch) return true;
        else return false;
    }
}
