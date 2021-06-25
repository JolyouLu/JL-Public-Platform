package top.jolyoulu.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
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
     * <key,value>方式 缓存基本的对象
     * @param key 缓存的键
     * @param value 缓存的值
     */
    public <T> void setCacheObj(final String key,final T value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * <key,value>方式
     * 获取缓存基本的对象
     * @param key 缓存的键
     * @return 缓存的值
     */
    public <T> T getCacheObj(final String key){
        return (T) redisTemplate.opsForValue().get(key);
    }

    /**
     * <key,value>方式
     * 监测缓存是否存在指定key
     * @param key 缓存的键
     * @return
     */
    public boolean existsCacheObj(final String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * <key,value>方式
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
     * <key,value>方式
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

    /**
     * <key,value>方式
     * 删除指定缓存对象
     * @param key 缓存的键
     * @return true/false
     */
    public <T> boolean deleteCache(final String key){
        return redisTemplate.delete(key);
    }

    /**
     * <key,Map<key,value>>方式
     * 往缓存map中保存对象
     * @param mapName map名称
     * @param key 缓存的键
     * @param value 缓存的值
     * @param <T>
     */
    public <T> void putCacheMap(final String mapName,final String key,final T value){
        redisTemplate.opsForHash().put(mapName,key,value);
    }

    /**
     * <key,Map<key,value>>方式
     * 获取缓存Map中的对象
     * @param mapName map名称
     * @param key 缓存的键
     * @param <T>
     * @return
     */
    public <T> T getCacheMap(final String mapName,final String key){
        return (T) redisTemplate.opsForHash().get(mapName,key);
    }

    /**
     * <key,Map<key,value>>方式
     * 删除缓存Map中的对象
     * @param mapName map名称
     * @param key 缓存的键
     * @param <T>
     */
    public <T> void deleteExCacheMap(final String mapName,final String... key){
        redisTemplate.opsForHash().delete(mapName,key);
    }
}
