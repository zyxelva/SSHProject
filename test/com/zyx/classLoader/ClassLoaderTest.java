/**
 *
 * <p>
 * Title: ClassLoaderTest.java
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2017
 * </p>
 *
 * <p>
 * Company: zyx@taeyeon.cn
 * </p>
 *
 * @author KEN
 *
 * @date 2018年3月7日
 *
 * @version 1.0
 *
 */

package com.zyx.classLoader;

import java.net.URL;

/**
 * @author KEN
 *
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderTest.class.getClassLoader(); // 获得加载ClassLoaderTest.class这个类的类加载器  
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent(); // 获得父类加载器的引用  
        }
        System.out.println(loader);
        System.out.println("+++++++++++++++++++++++++++++++++++");

        ClassLoaderTest clt = new ClassLoaderTest();
        clt.test();
    }

    public void test() {
        ClassLoader fatherLoader = this.getClass().getClassLoader();
        System.out.println("当前类的父加载器名称：" + fatherLoader.getClass().getName());

        //  这是因为AppClassLoader的父加载器虽然是ExtClassLoader，但是却是Bootstrap  
        //  加载的（所以它的.getClassLoader()返回为null）  
        //  Bootstrap、 ExtClassLoader、  AppClassLoader的关系很符合中国过去，可以这么描述：ExtClassLoader是AppClassLoader的爸爸，但是AppClassLoader确实他爷爷Bootstrap一把屎一把尿喂大的。  
        System.out.println("AppClassLoader的直接加载器是null吗：" + (fatherLoader.getClass().getClassLoader() == null));

        ClassLoader grandfatherLoader = fatherLoader.getParent();
        System.out.println("爷爷载器名称：" + grandfatherLoader.getClass().getName());

        System.out.println("++++++++++++++++++BootstrapClassPath+++++++++++++++++");
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }

//        System.out.println("++++++++++++++++++ExtClassLoaderPath+++++++++++++++++");
//        URL[] urls = new sun.misc.Launcher().new Ext;
//        for (int i = 0; i < urls.length; i++) {
//            System.out.println(urls[i].toExternalForm());
//        }
    }

}
