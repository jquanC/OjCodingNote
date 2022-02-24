package Others.ClassAttributrTest;

import Others.ClassAttributrTest.Father;

public class Son extends Father {



    public void eat(){
        System.out.println("son eat");
    }
    public void eat(int a){
        System.out.println("son eat"+a);
    }


    public void play(){
        System.out.println("son play");
    }
}
