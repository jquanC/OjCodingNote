package Others.DesignModel.Factory.staticFactory;

import Others.DesignModel.Factory.IPhone;
import Others.DesignModel.Factory.MiPhone;
import Others.DesignModel.Factory.Phone;

public class PhoneFactory {
    public Phone makePhone(String phoneTye){
        if(phoneTye.equalsIgnoreCase("MiPhone")){
            return new MiPhone();
        }
        if(phoneTye.equalsIgnoreCase("iPhone")){
            return new IPhone();
        }
        return null;
    }
}
