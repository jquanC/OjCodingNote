package Others.DesignModel.Factory.abstractFactory;


import Others.DesignModel.Factory.IPhone;
import Others.DesignModel.Factory.PC;
import Others.DesignModel.Factory.Phone;

public class AppleFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new IPhone();
    }

    @Override
    public PC makePC() {
        return null;
    }
}
