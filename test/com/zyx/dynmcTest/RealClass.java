/**
* Title: RealClass.java
* Description:
* Copyright: Copyright (c) 2017
* Company: zyx@taeyeon.cn
* @author KEN
* @date 2018年3月21日
* @version 1.0
*/

package com.zyx.dynmcTest;

/**
 * @author KEN
 */
class RealClass implements IRealClass{
    @Override
    public void method1(String myName){
        System.out.println("Class Name: "+this.getClass().getName() +"\n"+ " method1Name:" + myName);
    }
}
