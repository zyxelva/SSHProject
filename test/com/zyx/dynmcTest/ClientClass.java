/**
 * Title: ClientClass.java Description: Copyright: Copyright (c) 2017 Company:
 * zyx@taeyeon.cn
 *
 * @author KEN
 * @date 2018年3月21日
 * @version 1.0
 */

package com.zyx.dynmcTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author KEN
 */
/*
 * 这个是客户端类，在hibernate中，如果延迟加载被设置了，我们获取的对象只是代理对象，就是对应这个类的 该类会通过jdk
 * 的Proxy类的getInstance方法获取一个代理类，该代理类会自动帮你实现真实类的所有接口对应方法
 */
public class ClientClass {
    // 该属性是真实类
    Object realClassInterface = null;

    // 在构造代理类时初始化该类
    public ClientClass(Object realClassInterface) {
        this.realClassInterface = realClassInterface;
    }

    // 获取代理实例方法，该方法用于获取代理实例

    public static void main(String[] args) {
        InvocationHandler handler = new ProxyClass(new RealClass());
        IRealClass realClass = (IRealClass) Proxy.newProxyInstance(RealClass.class.getClassLoader(), RealClass.class.getInterfaces(), handler);
        realClass.method1("动态代理的方法");

        // 打印发现realClass的真实类是一个jre运行时生成的一个代理类
        System.out.println(realClass.getClass().getName());

    }
}
