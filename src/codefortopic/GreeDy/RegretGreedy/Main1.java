package codefortopic.GreeDy.RegretGreedy;

import java.util.*;

//可反悔贪心：字节双月模拟0621 N5
/*
1
6 3 50
10 5
15 9
20 13
25 17
30 21
35 25
* */
class Node {
    int x;
    int y;
    int diff;

    public Node(int x, int y, int diff) {
        this.x = x;
        this.y = y;
        this.diff = diff;
    }
}

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> ans = new ArrayList();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int M = sc.nextInt();
            sc.nextLine();
            int[] x = new int[N];
            int[] y = new int[N];
            int[] diff = new int[N];
            Node[] nodes = new Node[N];
            for (int j = 0; j < N; j++) {
                x[j] = sc.nextInt();
                y[j] = sc.nextInt();
                diff[j] = x[j] - y[j];
                nodes[j] = new Node(x[j], y[j], diff[j]);
            }
            sc.nextLine();
            ans.add(cal(nodes, x, y, diff, M, K));
        }
        for (Integer e : ans) System.out.println(e);
    }

    public static int cal(Node[] nodes, int[] x, int[] y, int[] diff, int M, int k) {
        int len = x.length;
        PriorityQueue<Node> que = new PriorityQueue(new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return o1.diff - o2.diff;
            }
        });
        int cou = 0;
        //贪心考虑价格低的物品，先排序
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.y - o2.y;
            }
        });

        for (int i = 0; i < k; i++) {
            if (M >= nodes[i].y) {
                M -= nodes[i].y;
                que.offer(nodes[i]);
                cou++;
            } else { //最便宜的k个券后都买不起，可以提前结束了;
                return cou;
            }
        }
        //可反悔贪心部分，用一个list来保存剩下的
        ArrayList<Node> resNodes = new ArrayList();

        for (int i = k; i < len; i++) {
            resNodes.add(nodes[i]);
        }
        resNodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.x - o2.x;
            }
        });

        while(M>0){
            //不适用优惠券
            int minCost = resNodes.get(0).x;
            //使用优惠券，需要反悔一个
            int minCostUsed = 0x3f3f3f3f;
            int id = -1;
            for (int i = 0; i < resNodes.size(); i++) {
                if (resNodes.get(i).y + que.peek().diff < minCostUsed){
                    minCostUsed = Math.min(minCostUsed, resNodes.get(i).y + que.peek().diff);
                    id = i;
                }

            }
            if (minCostUsed < minCost)  {
                que.poll();
                que.offer(resNodes.get(id));
                resNodes.remove(id);
                if(M>=minCostUsed) {
                    M-=minCostUsed;
                    cou++;
                }else{
                    break;
                }

            }else{
                if(M>=minCost) {
                    M-=minCost;
                    cou++;
                }else{
                    break;
                }
            }

        }
       return  cou;

    }
}
