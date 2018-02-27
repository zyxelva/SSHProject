/**

* <p>Title: dddd.java</p>

* <p>Description: </p>

* <p>Copyright: Copyright (c) 2017</p>

* <p>Company: zyx@taeyeon.cn</p>

* @author KEN

* @date 2018年2月12日

* @version 1.0

*/

package com.grgbanking.db;

/**
 * @author KEN
 *
 */
import java.lang.reflect.Proxy;

import org.apache.commons.lang.ClassUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 数据源切换AOP
 *
 */
@Component
@Aspect
public class MultipleDataSourceInterceptor {
    /**
     * 拦截器对所有的业务实现类请求之前进行数据源切换
     * 特别注意,由于用到了多数据源,Mapper的调用最好只在*ServiceImpl,不然调用到非默认数据源的表时,会报表不存在的异常
     * @param joinPoint
     * @throws Throwable
     */
    @Before( "execution(* xxx.xxx.xxx..*.*ServiceImpl.*(..))")
    public void setDataSoruce(JoinPoint joinPoint) throws Throwable {
        Class<?> clazz = joinPoint.getTarget().getClass();
        String className = clazz.getName();
        if (ClassUtils.isAssignable(clazz, Proxy.class)) {
            className = joinPoint.getSignature().getDeclaringTypeName();
        }
        //对类名含有business的设置为app数据源,否则默认为后台的数据源
        if(className.contains(".business.")){
            MultipleDataSource.setDataSourceKey(MultipleDataSource.MASTER_DATA_SOURCE);
        }else{
            MultipleDataSource.setDataSourceKey(MultipleDataSource.SLAVE_DATA_SOURCE);
        }
    }
    /**
     * 当操作完成时,释放当前的数据源
     * 如果不释放,频繁点击时会发生数据源冲突,本是另一个数据源的表,结果跑到另外一个数据源去,报表不存在
     * @param joinPoint
     * @throws Throwable
     */
    @After( "execution(* xxx.xxx.xxx..*.*ServiceImpl.*(..))")
    public void removeDataSoruce(JoinPoint joinPoint) throws Throwable {
        MultipleDataSource.removeDataSourceKey();
    }
}

