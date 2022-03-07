package Others.DesignModel.Factory;


import Others.DesignModel.Factory.abstractFactory.AbstractFactory;
import Others.DesignModel.Factory.abstractFactory.AppleFactory;
import Others.DesignModel.Factory.abstractFactory.XiaoMiFactory;

public class Demo {
    public static void main(String[] args) {
        //简单工厂模式
      /*  PhoneFactory factory = new PhoneFactory();
        Phone miPhone = factory.makePhone("MiPhone");
        Phone iPhone = factory.makePhone("iPhone");*/

        //工厂方法模式
       /* AbstractFactory miFac = new XiaoMiFactory();
        AbstractFactory appleFac = new AppleFactory();
        miFac.makePhone();
        appleFac.makePhone();*/

        // 抽象工厂模式-本质同2，只是工厂的抽象程度更高，可以生产不同的工厂
        //** 注意 **导的包和上面不同
        AbstractFactory miFactory = new XiaoMiFactory();
        AbstractFactory appleFactory = new AppleFactory();
        miFactory.makePhone();            // make xiaomi phone!
        miFactory.makePC();            // make xiaomi PC!
        appleFactory.makePhone();        // make iphone!
        appleFactory.makePC();            // make MAC!

    }
}
