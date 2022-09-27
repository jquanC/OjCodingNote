package DesignPattern.Proxy.StacicProxy;

import DesignPattern.Proxy.MoneyPrint;
import DesignPattern.Proxy.RecordLog;
import DesignPattern.Proxy.WorkOne;

public class SProxyOne implements RecordLog {
    WorkOne wone = new WorkOne();
    MoneyPrint ad = new MoneyPrint();
    @Override
    public void print(){
        wone.work();
        ad.adprint();

    }
}
