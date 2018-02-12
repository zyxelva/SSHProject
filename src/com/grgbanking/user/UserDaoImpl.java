package com.grgbanking.user;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.entity.HEmp;

@Repository
@Transactional
public class UserDaoImpl {
    private static Session session;

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Test
    public  void myTest(String[] args) {
        session = new UserDaoImpl().getSession();
        Query query = session.createQuery("from HEmp");
        List<HEmp> list = query.list();
        for (HEmp user : list) {
            System.out.println("1---" + user.getEname());
        }
    }

}
