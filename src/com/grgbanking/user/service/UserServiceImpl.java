/**

* <p>Title: UserServiceImpl.java</p>

* <p>Description: </p>

* <p>Copyright: Copyright (c) 2017</p>

* <p>Company: zyx@taeyeon.cn</p>

* @author KEN

* @date 2018年2月12日

* @version 1.0

*/

package com.grgbanking.user.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.grgbanking.entity.SysOrg;
import com.grgbanking.test.SpringTestCase;
import com.grgbanking.user.dao.IUserDao;

/**
 * @author KEN
 *
 */
public class UserServiceImpl extends SpringTestCase{
    private  IUserDao iUserDao;

    @Resource
    public void setUserDao(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    @Test
    public  void myTest() {
        List<SysOrg> orgList=new ArrayList<SysOrg>();
        orgList=(List<SysOrg>) iUserDao.queryUser("From SysOrg");
        System.out.println("This is coming From Test!");
        for (SysOrg user : orgList) {
          System.out.println("2---"+user.getName()+"++++"+user.getCode());
      }

    }
}
