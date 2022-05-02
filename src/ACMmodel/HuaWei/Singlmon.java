package ACMmodel.HuaWei;

public class Singlmon {

    private static volatile  Singlmon singlmon;//violatile指令重排
    private Singlmon(){

    }

    public Singlmon getSinglmon(){
        if(singlmon==null){
            synchronized (Singlmon.class){//  synchronized (singlmon){.. 也一样 因为singlmon 是静态对象，多线程会争夺类锁
                if(singlmon==null){
                    singlmon = new Singlmon();
                }
            }
        }
        return singlmon;
    }
}
