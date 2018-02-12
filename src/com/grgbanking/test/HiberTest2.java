package com.grgbanking.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grgbanking.core.BaseDao;
import com.grgbanking.core.IBaseDao;
import com.grgbanking.entity.HEmp;
import com.grgbanking.entity.SysUser;

/**
 * @author KEN
 *
 */
public class HiberTest2 extends SpringTestCase {

    private static IBaseDao iBaseDao;

    @Resource
    public void setbaseDao(IBaseDao iBaseDao) {
        HiberTest2.iBaseDao = iBaseDao;
    }

    //public static void main(String[] args) {
//        Session session=HibernateSessionFactory.getSession();
//        Query query=session.createQuery("from TUser");//使用Query缓存结果集
//        List<HEmp> list=query.list();
//        for (HEmp user : list) {
//            System.out.println("1---"+user.getEname());
//        }
//
//            //另外开启一个事务
//        session=HibernateSessionFactory.getSession();
//        query=session.createQuery("from TUser");
//        query.setCacheable(true);//必须设置
//        list=query.list();
//        for (HEmp user : list) {
//            System.out.println("2---"+user.getEname());
//        }

//}
    @Test
    public  void myTest() {
        //BaseDao bd=new BaseDao();
        List<HEmp> listUser=new ArrayList<HEmp>();
        listUser=(List<HEmp>) iBaseDao.list("From HEmp");
        System.out.println("This is coming From Test!");
        for (HEmp user : listUser) {
          System.out.println("2---"+user.getEname()+"++++"+user.getAge()+"++++"+user.getId());
      }

    }

    @Test
    public  void myTest2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
        BaseDao bd=ctx.getBean("BaseDao", BaseDao.class);
        List<HEmp> listUser=new ArrayList<HEmp>();
        listUser=(List<HEmp>) bd.list("From HEmp");
        for (HEmp user : listUser) {
          System.out.println("2---"+user.getEname());
      }
    }

    @SuppressWarnings("unchecked")
    @Test
    public  void myTest3() {
        List<HEmp> listUser=new ArrayList<HEmp>();
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("ename", "zzzzzzzzYZ");
        listUser=(List<HEmp>) iBaseDao.listByAlias("From HEmp where ename=:ename",map);
        System.out.println("This is coming From Test!");
        for (HEmp user : listUser) {
          System.out.println("2---"+user.getEname()+"++++"+user.getAge()+"++++"+user.getId());
      }

    }

    @Test
    public  void myTestAdd() {
        HEmp hemp=new HEmp();
        hemp.setAge("28");
        hemp.setEname("zyx");

        iBaseDao.add(hemp);

        System.out.println("This is coming From Test of Adding!");
        List<HEmp> listUser=new ArrayList<HEmp>();
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("ename", "zyx");
        listUser=(List<HEmp>) iBaseDao.listByAlias("From HEmp where ename=:ename",map);
        for (HEmp user : listUser) {
            System.out.println("name: "+user.getEname()+"\nAge: "+user.getAge()+"\nId: "+user.getId());
        }
    }

    @Test
    public  void myTestBatchAdd() {

        for(int i=0;i<10;i++){
            HEmp hemp=new HEmp();
            hemp.setAge("2"+i);
            hemp.setEname("xyz"+i);
            iBaseDao.add(hemp);
        }

        System.out.println("This is coming From Test of Adding!");
        List<HEmp> listUser=new ArrayList<HEmp>();
        listUser=(List<HEmp>) iBaseDao.list("From HEmp");
        for (HEmp user : listUser) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("name: "+user.getEname()+"\nAge: "+user.getAge()+"\nId: "+user.getId());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    @Test
    public  void myTestDelete() {

        System.out.println("This is coming From Test of Delete!");

        List<HEmp> listUser=new ArrayList<HEmp>();
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("ename", "zyx");
        listUser=(List<HEmp>) iBaseDao.listByAlias("From HEmp where ename=:ename",map);

        System.out.println("Before to delete........");
        for (HEmp user : listUser) {
            System.out.println("name: "+user.getEname()+"\nAge: "+user.getAge()+"\nId: "+user.getId());
        }

        System.out.println("Start to delete........");
        for (HEmp user : listUser) {
            iBaseDao.delete(user);
        }

        System.out.println("After  delete........");
        listUser=(List<HEmp>) iBaseDao.list("From HEmp");
        for (HEmp user : listUser) {
            System.out.println("name: "+user.getEname()+"\nAge: "+user.getAge()+"\nId: "+user.getId());
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    public  void myTestQueryBySql() {
        List<HEmp> listUser=new ArrayList<HEmp>();
        listUser=(List<HEmp>) iBaseDao.listBySql("select * from emp",HEmp.class,true );
        for (HEmp user : listUser) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("name: "+user.getEname()+"\nAge: "+user.getAge()+"\nId: "+user.getId());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    /**


     * <p>Title: myTestQueryBySqlWithParams</p>


     * <p>Description: </p>




     */
    @SuppressWarnings("unchecked")
    @Test
    public  void myTestQueryBySqlWithParams() {
        List<HEmp> listUser=new ArrayList<HEmp>();
        Map map=new HashMap();
        map.put("name", "zyx");
        listUser=iBaseDao.listByAliasSql("select * from emp where ename=:name ",map,HEmp.class,true );

        if(!listUser.isEmpty()){
            for (HEmp user : listUser) {
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("name: "+user.getEname()+"\nAge: "+user.getAge()+"\nId: "+user.getId());
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }
        }else{
            System.out.println("No Results Retured!");
        }
    }

    @Test
    public  void myTestQueryByHqlWithObject() {
       // HEmp hemp=new HEmp("Jay", "33");
        HEmp hemp=new HEmp("8a81aa926172dc37016172dc3caf0010","zyx", "29");

        HEmp obj=(HEmp) iBaseDao.queryObject("from HEmp t where t.ename=? and t.age=?", new Object[]{hemp.getEname(),hemp.getAge()});
        if(null!=obj){
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("name: "+obj.getEname()+"\nAge: "+obj.getAge()+"\nId: "+obj.getId());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }else{
            System.out.println("No Results Retured!");
        }
    }

    @Test
    public  void myTestUpdateByHqlWithObject() {
//Map map=new HashMap();
//map.put("name", "testUser8");

        SysUser user=(SysUser) iBaseDao.queryObject("from SysUser t where t.name=?  ", new Object[]{"testUser8"});
        if(null!=user){
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("name: "+user.getName()+"\nId: "+user.getId()+"\nId: "+user.getAccount_enabled());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }else{
            System.out.println("No Results Retured!");
        }

        user.setAccount("JayChowdddddddd");
        iBaseDao.update(user);
    }

    @SuppressWarnings("unchecked")
    @Test
    public  void myTestBatchAddSysUser() {

        for(int i=0;i<10;i++){
            SysUser user=new SysUser();
            user.setName("testUser"+i);
            user.setAccount_enabled("T");
            user.setAccount_locked("F");
            iBaseDao.add(user);
        }

        System.out.println("This is coming From Test of Adding!");
        List<SysUser> listUser=new ArrayList<SysUser>();
        listUser=(List<SysUser>) iBaseDao.list("From SysUser");
        for (SysUser user : listUser) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("name: "+user.getName());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
        BaseDao bd=ctx.getBean("BaseDao", BaseDao.class);
        List<HEmp> listUser=new ArrayList<HEmp>();
        listUser=(List<HEmp>) bd.list("From HEmp");

        System.out.println("This is coming From Main!");
        for (HEmp user : listUser) {
          System.out.println("2---"+user.getEname()+"++++"+user.getAge()+"++++"+user.getId());
      }
    }
}
