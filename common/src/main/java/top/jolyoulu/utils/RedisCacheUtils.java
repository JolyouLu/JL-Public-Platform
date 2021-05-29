package top.jolyoulu.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: JolyouLu
 * @Date: 2021/4/30 14:35
 * @Version 1.0
 * Redis缓存工具类
 */
@Component
public class RedisCacheUtils {

    @Autowired
    public RedisTemplate redisTemplate;

    /**
     * 缓存基本的对象
     * @param key 缓存的键
     * @param value 缓存的值
     */
    public <T> void setCacheObj(final String key,final T value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 获取缓存基本的对象
     * @param key 缓存的键
     * @return 缓存的值
     */
    public <T> T getCacheObj(final String key){
        ValueOperations<String,T> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    /**
     * 监测缓存是否存在指定key
     * @param key 缓存的键
     * @return
     */
    public boolean existsCacheObj(final String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * 缓存一个基本对象并且设置过期时间
     * @param key 缓存的键
     * @param value 缓存的值
     * @param timeout 超时时间（默认秒）
     * @return true/false
     */
    public <T> boolean setExCacheObj(final String key,final T value,final long timeout){
        return redisTemplate.opsForValue().setIfAbsent(key,value,timeout,TimeUnit.SECONDS);
    }

    /**
     * 缓存一个基本对象并且设置过期时间
     * @param key 缓存的键
     * @param value 缓存的值
     * @param timeout 超时时间
     * @param unit 时间类型(时分秒)
     * @return true/false
     */
    public <T> boolean setExCacheObj(final String key,final T value,final long timeout,final TimeUnit unit){
        return redisTemplate.opsForValue().setIfAbsent(key,value,timeout,unit);
    }


}
