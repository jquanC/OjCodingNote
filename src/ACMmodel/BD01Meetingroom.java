package ACMmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *会议室：用一个容器表示，提供预定功能（方法）
 * 定义一个数据结构: 会议
 */

public class BD01Meetingroom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int T = in.nextInt();
        in.nextLine();
        int[][] books =  new int[T][3];
        MeetingRoom[] rooms = new MeetingRoom[N];
        //对象数组必须 显示实例化，只有基本数据类型才会默认实例化
        for(int j=0;j<N;j++){
            rooms[j] = new MeetingRoom();
        }
        boolean[] ans = new boolean[T];
        for(int i=0;i<T;i++){
            books[i][0] = in.nextInt();
            books[i][1] = in.nextInt();
            books[i][2] = in.nextInt();
            in.nextLine();
        }
        //开始预定，对于每个book 任务，生成一个 bookingTask,在全部N分room中尝试，由一个成功则记录 YES
        for(int i=0;i<T;i++){
            Meeting task = new Meeting(books[i][1],books[i][2]);
            for(int j=0;j<N;j++){
                if(rooms[j].book(task,books[i][0])){
                    ans[i] = true;
                    break;
                }
            }
        }
        for(boolean e:ans){
            if(e) System.out.println("YES");
            else System.out.println("NO");
        }



    }

    static class Meeting{
        public int begin;
        public int end;
        public Meeting(int begin,int end){
            this.begin = begin;
            this.end = end;
        }
    }
    static class MeetingRoom{


        public List<Meeting> arrange = new ArrayList<>();

        public boolean book(Meeting meeting,int curT){
            boolean res = true;
            Iterator<Meeting> iterator = arrange.iterator();

            //初始为0的情况
            if(arrange.size() == 0){
                arrange.add(meeting);
                return true;
            }

            int i=0;
            while(iterator.hasNext()){
                Meeting itMeeting = iterator.next();
                if(meeting.end<= itMeeting.begin){
                    arrange.add(i,meeting);
                    return true;
                }
                if(meeting.begin < itMeeting.end) return false;
                i++;

            }

            return true;
        }
    }
}
