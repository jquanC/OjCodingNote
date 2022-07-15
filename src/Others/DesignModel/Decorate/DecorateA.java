package Others.DesignModel.Decorate;

import Hot100.Medium.DP.CanPartition;
import org.junit.Test;

public class DecorateA implements Compent {
    public Compent objectA;
    public DecorateA(Compent objectForDecorate){
        objectA = objectForDecorate;
    }
    public DecorateA(){}

    @Override
    public void buildA() {
        objectA.buildA();
    }

    @Override
    public void buildB() {
        System.out.println("DecorateA:change method:BuildB()");

    }
    public void buildC(){
        System.out.println("DecorateA:add method:BuildC()");
    }


    public static void main(String[] args) {
        DecorateA decorateA = new DecorateA(new CompentA());
        decorateA.buildA();
        decorateA.buildB();
        decorateA.buildC();
    }
}
