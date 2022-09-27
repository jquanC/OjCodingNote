package DesignPattern.Proxy.DynamicProxy;

import DesignPattern.Proxy.MoneyPrint;
import DesignPattern.Proxy.RecordLog;
import DesignPattern.Proxy.WorkOne;
import com.sun.deploy.net.proxy.ProxyType;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        WorkOne workOne = new WorkOne();
        MoneyPrint ad = new MoneyPrint();
        RecordLog adProxy = (RecordLog) Proxy.newProxyInstance(workOne.getClass().getClassLoader(), workOne.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object res =  method.invoke(workOne,args);
                ad.adprint();
                return res;
            }
        });
        adProxy.print();
    }
}
