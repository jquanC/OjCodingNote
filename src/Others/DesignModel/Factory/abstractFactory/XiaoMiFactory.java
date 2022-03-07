package Others.DesignModel.Factory.abstractFactory;


import Others.DesignModel.Factory.MiPC;
import Others.DesignModel.Factory.MiPhone;
import Others.DesignModel.Factory.PC;
import Others.DesignModel.Factory.Phone;

public class XiaoMiFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }

    @Override
    public PC makePC() {
        return new MiPC();
    }
}
