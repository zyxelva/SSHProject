/**

* <p>Title: AnnotationTest.java</p>

* <p>Description: </p>

* <p>Copyright: Copyright (c) 2017</p>

* <p>Company: zyx@taeyeon.cn</p>

* @author KEN

* @date 2018年3月6日

* @version 1.0

*/

package com.zyx.AnnotationTest;

import java.lang.reflect.Method;

/**
 * @author KEN
 *
 */
@Description(name = "fffff", attr = "")
public class Coder extends Person{
    private String name;
    private String attr;
    @Override
    public String getAttr() {
        return attr;
    }

    @Override
    public void setAttr(String attr) {
        this.attr = attr;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    @Description(name = "dddddddddddd", attr = "")
    public String getName(){
        return this.name;
    }

    public static void main(String[] args) {
        //1.使用类加载器加载类
        try {
            Class c=Class.forName("com.zyx.AnnotationTest.Person");
            //2.找到类加载器上面的注解
            boolean isExist=c.isAnnotationPresent(Description.class);
            if(isExist){
                //3 拿到注解实例
                Description d=(Description) c.getAnnotation(Description.class);
                System.out.println("++++++++实例注解d.name+++++++"+d.name()+"+++++++++++++++++++++");
            }
            //4.找到方法上的注解
            Method[] ms=c.getMethods();
            for(Method m:ms){
                boolean isMExist =m.isAnnotationPresent(Description.class);
                if(isMExist){
                    Description d=m.getAnnotation(Description.class);
                    System.out.println("++++++++方法注解d.name：+++++++"+d.name()+"+++++++++++++++++++++");
                    System.out.println("++++++++方法注解d.attr：+++++++"+d.attr()+"+++++++++++++++++++++");
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
