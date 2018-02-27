package com.grgbanking.core;

import java.util.List;
import java.util.Map;

public interface IBaseDao {

    List<?> list(String hql);

    List<?> list(String hql, Object arg);

    List<?> list(String hql, Object[] args);

    List<?> list(String hql, Object[] args, Map<String, Object> alias);

    List<?> listByAlias(String hql, Map<String, Object> alias);

    Object add(Object obj);

    void update(Object obj);

    void delete(Object obj);

    List<?> listBySql(String sql, Object[] args);

    List<?> listBySql(String sql);

    List<?> listBySql(String sql, Class<?> clz, boolean hasEntity);

    List<?> listBySql(String sql, Object[] args, Class<?> clz, boolean hasEntity);

    List<?> listBySql(String sql, Object arg, Class<?> clz, boolean hasEntity);

    List<?> listByAliasSql(String sql, Map<String, Object> alias, Class<?> clz, boolean hasEntity);

    List<?> listBySql(String sql, Object[] args, Map<String, Object> alias, Class<?> clz, boolean hasEntity);

    /**


     * <p>Title: queryObject</p>


     * <p>Description: </p>


     * @param hql
     * @return


     */

    Object queryObject(String hql);

    /**


     * <p>Title: queryObject</p>


     * <p>Description: </p>


     * @param hql
     * @param arg
     * @return


     */

    Object queryObject(String hql, Object arg);

    /**


     * <p>Title: queryObject</p>


     * <p>Description: </p>


     * @param hql
     * @param args
     * @return


     */

    Object queryObject(String hql, Object[] args);

    /**


     * <p>Title: queryObject</p>


     * <p>Description: </p>


     * @param hql
     * @param args
     * @param alias
     * @return


     */

    Object queryObject(String hql, Object[] args, Map<String, Object> alias);

    /**


     * <p>Title: queryObjectByAlias</p>


     * <p>Description: </p>


     * @param hql
     * @param alias
     * @return


     */

    Object queryObjectByAlias(String hql, Map<String, Object> alias);

}
