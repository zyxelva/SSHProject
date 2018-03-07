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

/**
 * @author KEN
 *
 */
@Description(name = "person",attr="")
public class Person {
    private String name;
    private String attr;
    @Description(attr = "dddd", name = "")
    public String getAttr() {
        return attr;
    }
    public void setAttr(String attr) {
        this.attr = attr;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Description(name = "哈哈哈哈哈", attr = "")
    public String getName(){
        return this.name;
    }
}
