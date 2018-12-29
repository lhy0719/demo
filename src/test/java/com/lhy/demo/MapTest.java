/**
 * Company Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.lhy.demo;

import com.alibaba.fastjson.JSON;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import sun.misc.Unsafe;

/**
 *
 *
 * @author xuhaitao
 * @version v 1.0.0 
 * @since v 1.0.0 2018-08-24 16:24
 */
@RunWith(JUnit4.class)
public class MapTest {

  public static void main(String[] args) {
    final HashMap<String, String> map = new HashMap<String, String>(2);
    Thread t = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 10000; i++) {
          new Thread(new Runnable() {
            @Override
            public void run() {
              map.put(UUID.randomUUID().toString(), "");
            }
          }, "ftf" + i).start();
        }
      }
    }, "ftf");
    t.start();
    try {
      t.join();
      System.out.println("map.size="+map.size());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test(){
    String jsonStr = "{\"success\":\"sdaf\",\"_success\":\"sdaf\"}";
    Result result = JSON.parseObject(jsonStr, Result.class);
    System.out.println(result.success+"——"+result._success);
    for (int i=0;i<100;i++) {
      Result result1 = new Result();
      result1.set_success("1");
      result1.setSuccess("2");
      System.out.println(JSON.toJSONString(result1));
    }
  }
  @Test
  public void testUnsafe(){
    Field f;
    try {
      f = Unsafe.class.getDeclaredField("theUnsafe");
      f.setAccessible(true);
      Unsafe unsafe = (Unsafe) f.get(null);
      Player p = (Player) unsafe.allocateInstance(Player.class);
      System.out.println(p.getAge());

      p.setAge(45);
      System.out.println(p.getAge());

    } catch (NoSuchFieldException | IllegalAccessException | InstantiationException e) {
      e.printStackTrace();
    }
  }

  static final class Result {
    private String success;
    private String _success;

    public String getSuccess() {
      return success;
    }

    public void setSuccess(String success) {
      this.success = success;
    }

    public String get_success() {
      return _success;
    }

    public void set_success(String _success) {
      this._success = _success;
    }
  }

  class Player {
    private int age = 12;

    private Player() {
      this.age = 50;
    }

    public int getAge() {
      return this.age;
    }

    public void setAge(int age) {
      this.age = age;
    }
  }
}
