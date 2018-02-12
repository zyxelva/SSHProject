package com.grgbanking.core;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author KEN
 *
 */
@Transactional
@Repository("baseDao")
public class BaseDao implements IBaseDao {
    @Autowired
    private SessionFactory sessionFactory;

    /** 日志对象 */
    public Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Object add(Object obj) {
        this.getSession().save(obj);
        return obj;
    }

    @Override
    public void delete(Object obj) {
        getSession().delete(obj);
    }

    protected Session getSession() {
        Session session = null;
        try {
            if (sessionFactory != null) {
                session = sessionFactory.getCurrentSession();
                if (session == null) {
                    logger.warn("BaseDao sessionFactory open new session !!!!!!");
                    session = sessionFactory.openSession();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("BaseDao  getSession error !");
        }
        Transaction tx = session.getTransaction();
        if (tx == null || tx.isActive() == false) {
            session.beginTransaction();
        }
        return session;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public List<?> list(String hql) {
        return this.list(hql, null);
    }

    @Override
    public List<?> list(String hql, Object arg) {
        return this.list(hql, new Object[] { arg });
    }

    @Override
    public List<?> list(String hql, Object[] args) {
        return this.list(hql, args, null);
    }

    @Override
    public List<?> list(String hql, Object[] args, Map<String, Object> alias) {
        Query query = getSession().createQuery(hql);
        setAliasParameter(query, alias);
        setParameter(query, args);
        return query.list();
    }

    @Override
    public List<?> listByAlias(String hql, Map<String, Object> alias) {
        return this.list(hql, null, alias);
    }

    @Override
    public List<?> listByAliasSql(String sql, Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
        return this.listBySql(sql, null, alias, clz, hasEntity);
    }

    @Override
    public List<?> listBySql(String sql) {
        return listBySql(sql, null);
    }

    @Override
    public List<?> listBySql(String sql, Class<?> clz, boolean hasEntity) {
        return this.listBySql(sql, null, clz, hasEntity);
    }

    @Override
    public List<?> listBySql(String sql, Object arg, Class<?> clz, boolean hasEntity) {
        return this.listBySql(sql, new Object[] { arg }, clz, hasEntity);
    }

    @Override
    public List<?> listBySql(String sql, Object[] args) {
        SQLQuery sq = getSession().createSQLQuery(sql);
        if (args != null) {
            setParameter(sq, args);
        }
        return sq.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }

    @Override
    public List<?> listBySql(String sql, Object[] args, Class<?> clz, boolean hasEntity) {
        return this.listBySql(sql, args, null, clz, hasEntity);
    }

    @Override
    public List<?> listBySql(String sql, Object[] args, Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
        SQLQuery sq = getSession().createSQLQuery(sql);
        setAliasParameter(sq, alias);
        setParameter(sq, args);
        if (hasEntity) {
            sq.addEntity(clz);
        } else {
            sq.setResultTransformer(Transformers.aliasToBean(clz));
        }
        return sq.list();
    }

    @Override
    public Object queryObject(String hql) {
        return queryObject(hql, null, null);
    }

    @Override
    public Object queryObject(String hql, Object arg) {
        return this.queryObject(hql, new Object[] { arg });
    }

    @Override
    public Object queryObject(String hql, Object[] args) {
        return this.queryObject(hql, args, null);
    }

    @Override
    public Object queryObject(String hql, Object[] args, Map<String, Object> alias) {
        Query query = getSession().createQuery(hql);
        setAliasParameter(query, alias);
        setParameter(query, args);
        return query.uniqueResult();
    }

    @Override
    public Object queryObjectByAlias(String hql, Map<String, Object> alias) {
        return this.queryObject(hql, null, alias);
    }

    @SuppressWarnings("rawtypes")
    private void setAliasParameter(Query query, Map<String, Object> alias) {
        if (alias != null) {
            Set<String> keys = alias.keySet();
            for (String key : keys) {
                Object val = alias.get(key);
                if (val instanceof Collection) {
                    // 查询条件是列表
                    query.setParameterList(key, (Collection) val);
                } else {
                    query.setParameter(key, val);
                }
            }
        }
    }

    private void setParameter(Query query, Object[] args) {
        if (args != null && args.length > 0) {
            int index = 0;
            for (Object arg : args) {
                query.setParameter(index++, arg);
            }
        }
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void update(Object obj) {
        getSession().update(obj);
    }

}
