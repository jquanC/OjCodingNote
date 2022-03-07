package Others.DesignModel.Factory.simpleFactoryMethod;

import Others.DesignModel.Factory.IPhone;
import Others.DesignModel.Factory.Phone;

public class AppleFactory implements AbstractFactory{
    @Override
    public Phone makePhone() {
        return new IPhone();
    }
}
