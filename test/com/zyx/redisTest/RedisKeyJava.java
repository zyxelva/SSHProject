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

import java.util.Set;

/**
 * @author KEN
 *
 */
import redis.clients.jedis.Jedis;

public class RedisKeyJava {
   public static void main(String[] args) {
      //Connecting to Redis server on localhost
      Jedis jedis = new Jedis("10.1.231.83");
      System.out.println("Connection to server sucessfully");
      //store data in redis list
      // Get the stored data and print it
      Set<String> sets = jedis.keys("*");

      for (String value:sets) {
          System.out.println("Stored string in redis:: "+value);
      }
   }
}

