package com.jacob.hookandroid.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * Created by jacob on 2018/4/20.
 */

public class Client {

    public static void visit() {
        ProxySubject proxy = new ProxySubject(new RealSubject());
        proxy.visit("yes");
    }

    public static void dynamicVisit() {
        RealSubject realSubject = new RealSubject();
        Subject subject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),
                new Class[]{Subject.class}, new DynamicProxy(realSubject));
        subject.visit("fuck");
    }

}
