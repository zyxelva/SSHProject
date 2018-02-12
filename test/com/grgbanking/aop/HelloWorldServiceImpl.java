/**  

* <p>Title: ddd.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: zyx@taeyeon.cn</p>  

* @author KEN  

* @date 2018年2月11日  

* @version 1.0  

*/  

package com.grgbanking.aop;

/**
 * @author KEN
 *
 */
public class HelloWorldServiceImpl implements IHelloWorldService {
    @Override
    public String SayHelloWorld() {
        System.out.println("Hello World~");
        return "执行业务方法的返回值为:Hello World";
    }
}
