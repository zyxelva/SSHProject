/**

* <p>Title: IUserDao.java</p>

* <p>Description: </p>

* <p>Copyright: Copyright (c) 2017</p>

* <p>Company: zyx@taeyeon.cn</p>

* @author KEN

* @date 2018年2月12日

* @version 1.0

*/

package com.grgbanking.user.dao;

import java.util.List;

/**
 * @author KEN
 *
 */
public interface IUserDao {
    public List<?> queryUser(String hql);
}
