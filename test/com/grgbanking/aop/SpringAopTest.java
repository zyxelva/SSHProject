/**

* <p>Title: ffd.java</p>

* <p>Description: </p>

* <p>Copyright: Copyright (c) 2017</p>

* <p>Company: zyx@taeyeon.cn</p>

* @author KEN

* @date 2018年2月11日

* @version 1.0

*/

package com.grgbanking.aop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author KEN
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/applicationContext.xml" })
public class SpringAopTest extends AbstractJUnit4SpringContextTests {
    @Resource(name = "helloWorldService")
    private IHelloWorldService helloWorldService;

    @Test
    public void testHelloWord() throws Exception {
        helloWorldService.SayHelloWorld();
    }
}