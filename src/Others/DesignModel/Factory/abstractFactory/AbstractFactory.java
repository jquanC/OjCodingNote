package Others.DesignModel.Factory.abstractFactory;

import Others.DesignModel.Factory.PC;
import Others.DesignModel.Factory.Phone;

public interface AbstractFactory {
        Phone makePhone();
        PC makePC();
}
