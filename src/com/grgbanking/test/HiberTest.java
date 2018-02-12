package com.grgbanking.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grgbanking.core.BaseDao;
import com.grgbanking.entity.HEmp;

public class HiberTest extends SpringTestCase {
    private ApplicationContext ctx = null;

    @Test
    public void testDataSource() throws SQLException {
        // 检查spring配置
        ctx = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
        ctx.getBean(DataSource.class);

        // System.out.println(dataSource.getConnection().toString());
        // 检查hibernate配置
        SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
        System.out.println(sessionFactory);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        // 测试数据库
        HEmp hemp = new HEmp();
        hemp.setAge("22");
        hemp.setEname("ggggggzzzzzzzzYZ");

        session.save(hemp);
        tx.commit();
        session.close();

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
        BaseDao bd=new BaseDao();
        List<HEmp> listUser=new ArrayList<HEmp>();
        listUser=(List<HEmp>) bd.list("From HEmp");
        for (HEmp user : listUser) {
          System.out.println("2---"+user.getEname());
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
}
