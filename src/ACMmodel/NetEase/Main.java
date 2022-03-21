package ACMmodel.NetEase;


import java.lang.reflect.Array;
import java.util.*;

/**
 * 3 个行bool rowUsed[][] 3 个列bool colUsed[][]
 * 宫：给出一个坐标，要找到它所属宫：1个宫含有 一个set-存坐标,一个used[] 数组
 * 写一个check函数：
 * 贪心填数即可：
 */
public class Main {
    static class Gong {
        public HashSet<String> xySet;
        public boolean[] used;

        public Gong() {
            xySet = new HashSet<>();
//           boolean[] used = new boolean[3];
            used = new boolean[3];
        }
    }
    static class Point{
        private int x;
        private int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Point compare = (Point)obj;
            return this.x == compare.x && this.y == compare.y;
        }
    }
    ////为什么不在这里分配空间? 因为rowUsed colUsed 是全局变量，第二轮，它们就不全是默认初始化为false 了
    static boolean[][] rowUsed;
    static boolean[][] colUsed;
//    static boolean[][] needWrite = new boolean[3][3];
    static Gong[] gongArr = new Gong[3];
    static int ansCou = 0;
//    static boolean canDo = true;
    static List<String> oneGridAns;


    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int T = in.nextInt();//每组6行
        in.nextLine();
        char[][][] quesIn = new char[T][3][3];
        String[][][] gongIn = new String[T][3][3];


        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 3; j++) {
                String line = in.nextLine();
                for (int t = 0; t < 3; t++) {
                    quesIn[i][j][t] = line.charAt(t);
                }
            }
            for (int j = 0; j < 3; j++) {
                for (int t = 0; t < 3; t++) {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    String thisPos = String.valueOf(x) + y;
                    gongIn[i][j][t] = thisPos;
                }
                in.nextLine();
            }
        }
        //数据读入完毕

        for (int i = 0; i < T; i++) {
            write(gongIn[i], quesIn[i]); //空
        }


    }

    public static void write(String[][] gongGrid, char[][] grid) {

        ArrayList<Point> needFillPoint = new ArrayList<>();
        //每次求解一个数独问题再初始化
        rowUsed = new boolean[3][3];
        colUsed = new boolean[3][3];
        //每轮，初始化Gong
        for (int i = 0; i < 3; i++) {
            gongArr[i] = new Gong(); //越界
            for (int j = 0; j < 3; j++) {
                gongArr[i].xySet.add(gongGrid[i][j]);
            }
        }
        //每轮，初始化 Gong\row\col used 情况；为什么分开？因为用到了locateGong方法
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i][j]=='*'){
                    Point point = new Point(i,j);
                    needFillPoint.add(point);
                }else{
                    rowUsed[i][grid[i][j]-'0'-1] = true;
                    colUsed[j][grid[i][j]-'0'-1] = true;
                    int gongIndex = locateGong(i,j);
                    gongArr[gongIndex].used[grid[i][j]-'0'-1] = true;
                }
            }
        }

        ansCou = 0;
//        canDo = true;
        oneGridAns = new ArrayList<>();
//        dfs(0, 0,  grid,-1,0);
        doFill(0,needFillPoint,grid);
        if (ansCou == 0) System.out.println("No");
        if (ansCou == 1) {
            System.out.println("Unique");
            for (int i = 0; i < 3; i++) {
                System.out.println(oneGridAns.get(i));
            }
        }
        if (ansCou > 1) {
            System.out.println("Multiple");
        }

    }
    public static void doFill(int doCou, ArrayList<Point> needFillPoint,char[][]grid){
        //递归结束
        if(doCou>=needFillPoint.size()){
            ansCou++;
            if(ansCou>=2) return;
            for(int i=0;i<3;i++){
                String ans = "";
                for(int j=0;j<3;j++){
                    ans+=grid[i][j];
                }
                oneGridAns.add(ans);
            }
            return ;
        }
        Point curPoint = needFillPoint.get(doCou);
        int x_ = curPoint.getX();
        int y_ = curPoint.getY();

        boolean shouldAndDo = false;
        for(int v=1;v<=3;v++){
            if(check(x_,y_,v)){
                shouldAndDo = true;
                rowUsed[x_][v-1] = true;
                colUsed[y_][v-1] = true;
                int gongIndex  = locateGong(x_,y_);
                gongArr[gongIndex].used[v-1] = true;
                grid[x_][y_] = (char)('0'+v);
                doFill(doCou+1,needFillPoint,grid);
                grid[x_][y_] = '*';
                gongArr[gongIndex].used[v-1] = false;
                colUsed[y_][v-1] = false;
                rowUsed[x_][v-1] = false;
            }
        }
        if(!shouldAndDo) return;

    }

    public static boolean check(int x, int y, int value) {
        String xyPos = String.valueOf(x) + y;

        boolean used = false;
        //先校验 行列
        used = rowUsed[x][value - 1] || colUsed[y][value - 1];

        if (used) {
            return false; //value已用, 返回false
        }
        //校验宫
        int gongIndex = locateGong(x,y);
        if(gongArr[gongIndex].used[value-1]){
            return false;
        }
       return true;
    }
    public static int locateGong(int x,int y){
        String str = String.valueOf(x)+y;
        for(int i=0;i<3;i++){
            if(gongArr[i].xySet.contains(str)){
                return i;
            }
        }
        return  -1;
    }

}
