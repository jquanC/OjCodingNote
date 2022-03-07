package Others.DesignModel.Factory.simpleFactoryMethod;

import Others.DesignModel.Factory.MiPhone;
import Others.DesignModel.Factory.Phone;

public class XiaoMiFactory  implements AbstractFactory{
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }
}
