package RedBook;
/**
 * 某公司正在组织新员工团建，其中一项活动是两两配对进行石头剪刀布。
 *
 * 因为新员工来自不同的学校和专业，他们许多人之间并不熟悉，但他们之间的朋友关系形成了一棵树。即若将朋友关系描述为一张无向图，则这张无向图中任意两点
 * 之间有且仅有一条路径。为了避免尴尬，组织者希望互为朋友的配对数量尽可能多。现在他希望你求出互为朋友的配对数量最多能有多少。
 *
 * 第一行有一个偶数n(2<=n<=1000)，代表有n个新员工。
 *
 * 第二行有n-1个空格隔开的数，第i个数ai代表编号为i+1的新员工与编号为ai的员工互为朋友。
 *
 * 输入保证新员工之间的朋友关系形成了一棵树
 *
 * 输出在所有可能的配对方案中，互为朋友的配对数量最多是多少。
 *
 * in:
 * 6
 * 1 2 2 3 3
 * ou:
 * 2
 * 如样例中，一共有6个新员工，朋友关系有以下五个(1,2),(2,3),(2,4),(3,5),(3,6)。
 *
 * 可以证明无论如何匹配这6个人， 最多只能有两对是互为朋友的，因此输出2。
 * 通过 91%
 * */
import java.util.*;

public class Main3 {
    //第二行有n-1个空格隔开的数，
    // 第i个数ai代表编号为i+1的新员工与编号为ai的员工互为朋友。
    // 第1个数1代表编号为2的新员工与编号为1的员工互为朋友
    //每个节点用list记录自己的朋友编号,list的size是节点的度--转无向图
    //贪心先安排度小的
    //用一个bool vis[] 记录每个人是否分配
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Per[] prr = new Per[n];
        prr[0] = new Per(1);
        for(int i=1;i<n;i++){
            int cid = i+1;
            int fid = sc.nextInt();
            if(prr[cid-1]==null)  prr[i] = new Per(cid);
            //转无向图
            if(prr[fid-1]==null) prr[fid-1] = new Per(fid);

            prr[i].frique.offer(prr[fid-1]);
            prr[fid-1].frique.add(prr[i]);
        }
        sc.nextLine();
        Arrays.sort(prr, new Comparator<Per>() {
            @Override
            public int compare(Per o1, Per o2) {
                return o1.frique.size()-o2.frique.size();
            }
        });
        boolean[] allocated = new boolean[n+1];
        int ans = 0;
        for(int i=0;i<n;i++){
            if(allocated[prr[i].id]) continue;
            PriorityQueue<Per> curFs = prr[i].frique;
            for(Per e:curFs){
                if(!allocated[e.id] && !allocated[prr[i].id]){//别忘了自己要也标记使用
                    allocated[e.id] = true;
                    allocated[prr[i].id] = true;//别忘了自己要也标记使用
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);


    }
}
class Per{
    int id;
//    ArrayList<Integer> friList;//树保证了不需要去重
    PriorityQueue<Per> frique;
    public Per(int id){
        this.id = id;
//        friList = new ArrayList();
        frique = new PriorityQueue<>(new Comparator<Per>() {
            @Override
            public int compare(Per o1, Per o2) {
                return o1.frique.size()-o2.frique.size();
            }
        });
    }
}
