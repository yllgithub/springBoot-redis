package com.springboot.redis;

import com.springboot.redis.VO.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 常见的五大数据类型  String  List set hash Zset
     * String stringRedisTemplate.opsForValue()
     * List  stringRedisTemplate.opsForList()
     * set  stringRedisTemplate.opsForSet()
     * Zset stringRedisTemplate.opsForZSet()
     * hash stringRedisTemplate.opsForHash()
     */
    @Test
    public void contextLoads() {
        Integer yll = stringRedisTemplate.opsForValue().append("newss", "321");
        System.out.println(yll);
    }

    @Test
    public void Lists() {
        Long ll = stringRedisTemplate.opsForList().leftPush("aa", "9");
        System.out.println(ll);
    }

    @Test
    public void List_pop() {
        String ll = stringRedisTemplate.opsForList().leftPop("aa");
        System.out.println(ll);
    }

    @Test
    public void get() {
        String newss = stringRedisTemplate.opsForValue().get("newss");
        System.out.println(newss);
    }

    @Test
    public void save_Vo() {
        //默认保存对象，使用的是jdk序列化机制，序列化后保存到Redis中
        redisTemplate.opsForValue().set("cc", new Book("java手术室", "这个萨斯的撒"));
        // 1、将数据已json的方式保存
        // redisTemplate 默认的序列化 new JdkSerializationRedisSerializer(
    }

    @Test
    public void save_Vo1() {
        //默认保存对象，使用的是jdk序列化机制，序列化后保存到Redis中
        redisTemplate.opsForValue().set("ee", new Book("e22手术室", "e22这个萨斯的撒"),50 ,TimeUnit.SECONDS);
        // 1、将数据已json的方式保存
        // redisTemplate 默认的序列化 new JdkSerializationRedisSerializer(
    }

    @Test
    public void get_Vo() {
        //默认保存对象，使用的是jdk序列化机制，序列化后保存到Redis中
        Book cc =(Book) redisTemplate.opsForValue().get("ee");
        System.out.println(cc);
        // 1、将数据已json的方式保存
        // redisTemplate 默认的序列化 new JdkSerializationRedisSerializer(
    }
}
