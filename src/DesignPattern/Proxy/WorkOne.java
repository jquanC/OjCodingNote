package DesignPattern.Proxy;

public class WorkOne implements RecordLog{
    public void work(){
        System.out.println("execute work one");
    }
    @Override
    public void print(){
        System.out.println("origin print");
    }
}
