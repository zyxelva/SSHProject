/**

* <p>Title: RedisJava.java</p>

* <p>Description: </p>

* <p>Copyright: Copyright (c) 2017</p>

* <p>Company: zyx@taeyeon.cn</p>

* @author KEN

* @date 2018年2月28日

* @version 1.0

*/

package com.zyx.redisTest;

/**
 * @author KEN
 *
 */
import redis.clients.jedis.Jedis;

public class RedisJava {
   public static void main(String[] args) {
      //Connecting to Redis server on localhost
      Jedis jedis = new Jedis("10.1.231.83");
      System.out.println("Connection to server sucessfully");
      //check whether server is running or not
      System.out.println("Server is running: "+jedis.ping());

      jedis.set("tutorial-name", "Redis tutorial");
      // Get the stored data and print it
      System.out.println("Stored string in redis: "+ jedis.get("tutorial-name"));
   }
}

