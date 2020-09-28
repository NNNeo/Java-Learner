package designPattern.proxy;

import com.sun.deploy.net.proxy.ProxyHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy {

    public static void main(String[] args) {
        Business businessA = new BusinessA();
        InvocationHandler invocationHandler = new BusinessProxy(businessA);

        Business aProxy = (Business) Proxy.newProxyInstance(businessA.getClass().getClassLoader(),
                                                    businessA.getClass().getInterfaces(), invocationHandler);
        aProxy.doBusiness();
    }
}

interface Business {
    void doBusiness();
}

class BusinessA implements Business{
    @Override
    public void doBusiness() {
        System.out.println("do a business");
    }
}

class BusinessProxy implements InvocationHandler {

    private Business business;

    public BusinessProxy(Business business) {
        this.business = business;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy");
        method.invoke(business, args);
        return business;
    }
}
