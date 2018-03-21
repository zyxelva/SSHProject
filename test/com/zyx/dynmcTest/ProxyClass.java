/**
 * Title: ProxyClass.java Description: Copyright: Copyright (c) 2017 Company:
 * zyx@taeyeon.cn
 *
 * @author KEN
 * @date 2018年3月21日
 * @version 1.0
 */

package com.zyx.dynmcTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author KEN
 */
/*
 * 代理类，用于给jdk代理类Proxy进行委托，该类需要实现一个接口InvocationHandler，该接口只有一个方法invoke
 */
class ProxyClass implements InvocationHandler {
    /*
     * 参数说明：
     * @param proxy: 代理对象，该对象用于查询代理对象的其他信息，更具体作用可以参考这篇博客：http://blog.csdn.net/bu2_int/article/details/60150319；
     * @param method：真实对象所对应的方法
     * @param args: 执行上面method所需要的参数 有需要该方法可以选择返回值
     */
    // 真实对象，invoke方法中需要用到
    Object realClass = null;

    public ProxyClass(Object realClass) {
        this.realClass = realClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在invoke方法体内部执行织入的代码
        System.out.println("这个是RealClass method1执行+++++前++++++要执行的代码");
        method.invoke(realClass, args);
        System.out.println("这个是RealClass method1执行+++++后++++++要执行的代码");
        System.out.println("proxy: "+proxy.getClass().getName());
        return null;
    }

}
