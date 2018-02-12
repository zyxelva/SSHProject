package com.grgbanking.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.grgbanking.core.BaseDao;

@Repository("userDaoImpl")
public class UserDaoImpl extends BaseDao implements IUserDao{

    /* (non-Javadoc)
     * @see com.grgbanking.user.dao.IUserDao#queryUser(java.lang.String)
     */
    @Override
    public List<?> queryUser(String hql) {
        return  super.list(hql);
    }


}
