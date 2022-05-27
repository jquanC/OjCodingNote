package ACMmodel.ByteDance.re;

import java.util.*;

class Book{
    int start;
    int end;
    public Book(int start,int end){
        this.start = start;
        this.end = end;
    }
}
public class BD01Meetingroom {
    static ArrayList<Book> [] rooms;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        sc.nextLine();
        List<Boolean> ans = new ArrayList<>();
        rooms = new ArrayList[N];
        for(int i=0;i<N;i++){
            rooms[i] =  new ArrayList<Book>();
        }
        for(int i=0;i<T;i++){
            Book one = new Book(sc.nextInt(),sc.nextInt());
            boolean addRes = bookOne(one);
            ans.add(addRes);
            sc.nextLine();
        }
        for(boolean e : ans){
            System.out.print(e+" ");
        }

    }
    public static boolean bookOne(Book insetMeet){
        for(int i=0;i< rooms.length;i++){ //便利全部会议室
            //取当前会议室
            ArrayList<Book> room = rooms[i];
            if(room.size()==0){
                room.add(insetMeet);
                return true;
            }
            Comparator<Book> comp = new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.start-o2.start;
                }
            };
            room.sort(comp);

            int j=0;
            boolean thisRoomCan = true;
            for(;j<room.size();j++){
                Book cur = room.get(j);//get(j) 不是get(i)
                if(insetMeet.end < cur.start){
                    room.add(insetMeet);
                    return true;
                }else if( insetMeet.start<cur.end){
//                    return false; 还要看其他会议室
                    thisRoomCan = false;
                    break;
                }
            }
            if(j==room.size() && thisRoomCan){
                room.add(insetMeet);
                return true;
            }

        }
        return false;
    }
}
