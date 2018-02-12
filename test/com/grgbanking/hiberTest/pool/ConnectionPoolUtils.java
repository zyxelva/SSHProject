package com.grgbanking.hiberTest.pool;

/* 连接池工具类，返回唯一的一个数据库连接池对象,单例模式 */
public class ConnectionPoolUtils {
    private ConnectionPoolUtils() {
    };// 私有静态方法

    private static ConnectionPool poolInstance = null;

    public static ConnectionPool GetPoolInstance() {
        if (poolInstance == null) {
            poolInstance = new ConnectionPool("com.mysql.jdbc.Driver",
                    "jdbc:mysql://10.1.231.86:3306/feel?useUnicode=true&characterEncoding=utf-8", "feel", "feel");
            try {
                poolInstance.createPool();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return poolInstance;
    }
}
