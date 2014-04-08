package com.ctrip.study.nosql.redis;

import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.SortingParams;

import com.ctrip.SpringContextTestCase;
import com.ctrip.study.nosql.redis.JedisTemplate.JedisAction;

public class JedisTemplateTest extends SpringContextTestCase{

	private static JedisTemplate template;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("初始化");
		 JedisPoolConfig config = JedisUtils.createPoolConfig(5, 40);
		 JedisPool pool = new JedisPool(config, "localhost", 6379);  
		 template = new JedisTemplate(pool);
	}
	
	@Test
	public void testSet() {
		//添加
		template.set("name", "wangao1");
		String name = template.get("name");
		System.out.println(name);
		//原有key上追加
		template.getJedisPool().getResource().append("name", "wangao");
		name = template.get("name");
		System.out.println(name);
	}
	
	
	@Test
	public void testDel(){
		// 删除key对应的记录  
		template.del("name");
		String name = template.get("name");
		assertNull(name);
	}
	
	@Test
	public void testList(){
		template.del("messages");  
		template.lpush("messages", "Hello how are you?");  
		template.lpush("messages", "Fine thanks. I'm having fun with redis.");  
		template.lpush("messages", "I should look into this NOSQL thing ASAP");
		List<String> messages = template.execute(new JedisAction<List<String>>() {
			@Override
			public List<String> action(Jedis jedis) {
				return jedis.lrange("messages", 0, -1);
			}
		});
		for (String message : messages) {
			System.out.println(message);
		}
        template.flushDB();
        template.lpush("lists", "Vector");  
        template.lpush("lists", "ArrayList");  
        template.lpush("lists", "LinkedList");  
        
        System.out.println(template.llen("lists"));
        List<String> listNames = template.execute(new JedisAction<List<String>>() {
			@Override
			public List<String> action(Jedis jedis) {
				return jedis.sort("lists", new SortingParams().desc());
			}
		});
        for (String listName : listNames) {
			System.out.println(listName);
		}
	}

}
