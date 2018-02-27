/**

* <p>Title: dddd.java</p>

* <p>Description: </p>

* <p>Copyright: Copyright (c) 2017</p>

* <p>Company: zyx@taeyeon.cn</p>

* @author KEN

* @date 2018年2月12日

* @version 1.0

*/

package com.grgbanking.db;

/**
 * @author KEN
 *
 */
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 设置切换数据库数据源
 */
public class MultipleDataSource extends AbstractRoutingDataSource {
    public static final String MASTER_DATA_SOURCE= "masterDataSource";
    public static final String SLAVE_DATA_SOURCE= "slaveDataSource";

    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }

    public static void removeDataSourceKey(){
        dataSourceKey.remove();
    }
}
