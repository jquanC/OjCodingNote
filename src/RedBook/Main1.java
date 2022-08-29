package RedBook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int id = sc.nextInt();
        sc.nextLine();
        Person[] arr = new Person[n];
        for (int i = 0; i < n; i++) {
            int score  = 0;
            for (int j = 0; j < m; j++) {
                score += sc.nextInt();
            }
            arr[i] = new Person(i+1,score);
            sc.nextLine();
        }
        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.score == o2.score){
                    return o1.id-o2.id;
                }else{
                    return o2.score-o1.score;
                }
            }
        });
        for(int i=0;i<arr.length;i++){
            if(arr[i].id == id){
                System.out.println(i+1);
            }
        }


    }

}
class Person{
    int id;
    int score;
    public Person(int id,int score){
        this.id = id;
        this.score = score;
    }
}
