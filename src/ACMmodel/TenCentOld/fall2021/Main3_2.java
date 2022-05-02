package ACMmodel.TenCentOld.fall2021;


import java.util.Scanner;
import java.util.Stack;

class Node{
    int val;
    int times;
    public Node(int val,int times){
        this.val = val;
        this.times = times;
    }
}
public class Main3_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
       sc.nextLine();

        Stack<Node> stack = new Stack<>();
        long ans = 0;
        for(int i=0;i<n;i++){
            //正向遍历，以 arr[i]为最小值（此情型在右边），可以构成的有效序列 ，此时有解
            while(!stack.isEmpty() && stack.peek().val >arr[i]){
                Node node = stack.pop();
                ans+= node.times+ cn2(node.times);
            }
            if(!stack.isEmpty() && stack.peek().val == arr[i]){
               /* Node node = stack.pop();
                node.times++;
                stack.push(node);*/
                stack.peek().times++;
            }else{
                stack.push(new Node(arr[i],1));
            }
        }
        while (!stack.isEmpty()){
            ans+=cn2(stack.pop().times);
        }
//        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek().val>arr[i]){
                ans+=stack.pop().times;
            }
            if(!stack.isEmpty() && stack.peek().val==arr[i]){
                stack.peek().times++;
            }else{
                stack.push(new Node(arr[i],1));
            }
        }
        System.out.println(ans);
    }
    private static long cn2(long n){
        return (n*(n-1))/2;
    }
}
