/**

* <p>Title: ddd.java</p>

* <p>Description: </p>

* <p>Copyright: Copyright (c) 2017</p>

* <p>Company: zyx@taeyeon.cn</p>

* @author KEN

* @date 2018年2月28日

* @version 1.0

*/

package com.zyx.redisTest;

import java.util.List;

/**
 * @author KEN
 *
 */
import redis.clients.jedis.Jedis;

public class RedisListJava {
   public static void main(String[] args) {
      //Connecting to Redis server on localhost
      Jedis jedis = new Jedis("10.1.231.83");
      System.out.println("Connection to server sucessfully");

      //store data in redis list
      jedis.lpush("tutorial-list", "Redis");
      jedis.lpush("tutorial-list", "Mongodb");
      jedis.lpush("tutorial-list", "Mysql");
      // Get the stored data and print it
      List<String> list = jedis.lrange("tutorial-list", 0 ,5);

      for(int i = 0; i<list.size(); i++) {
         System.out.println("Stored string in redis:: "+list.get(i));
      }
   }
}