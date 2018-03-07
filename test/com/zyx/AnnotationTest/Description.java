/**
 *
 * <p>
 * Title: Description.java
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
 * @date 2018年3月6日
 *
 * @version 1.0
 *
 */

package com.zyx.AnnotationTest;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author KEN
 *
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    //public String value();// 只有一个参数的时候，必须为value 
    public String attr();
    public String name();
}
