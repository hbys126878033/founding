package org.cl.member.web;

import org.cl.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;


@RestController
public class RedisHandler {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;
	
	@RequestMapping("/set/redis/key/value/remote")
	ResultEntity<String> setRedisKeyValueRemote(
			@RequestParam("key") String key, 
			@RequestParam("value") String value) {
		
		try {
			ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
			
			operations.set(key, value);
			
			return ResultEntity.successWithData(String.format("%s = %s ",key,value));
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResultEntity.failed(e.getMessage());
		}
		
	}
	
	@RequestMapping("/set/redis/key/value/remote/with/timeout")
	ResultEntity<String> setRedisKeyValueRemoteWithTimeout(
			@RequestParam("key") String key, 
			@RequestParam("value") String value,
			@RequestParam("time") long time,
			@RequestParam("timeUnit") TimeUnit timeUnit) {
		
		try {
			ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
			
			operations.set(key, value, time, timeUnit);
			
			return ResultEntity.successWithoutData();
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResultEntity.failed(e.getMessage());
		}
	}
	
	@RequestMapping("/get/redis/string/value/by/key")
	ResultEntity<String> getRedisStringValueByKeyRemote(@RequestParam("key") String key) {
		
		try {
			ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
			
			String value = operations.get(key);
			
			return ResultEntity.successWithData(value);
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResultEntity.failed(e.getMessage());
		}
		
	}

	@RequestMapping("/remove/redis/key/remote")
	ResultEntity<String> removeRedisKeyRemote(@RequestParam("key") String key) {
		try {

			stringRedisTemplate.delete(key);
			
			return ResultEntity.successWithoutData();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResultEntity.failed(e.getMessage());
		}
	}

	@RequestMapping(value="/redis/set")
	ResultEntity<String> setKey(@RequestParam("key") String key,@RequestBody Object value){
		try {
			ValueOperations valueOperations = redisTemplate.opsForValue();
			valueOperations.set(key,value);
			return ResultEntity.successWithoutData();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		}

	}

}
