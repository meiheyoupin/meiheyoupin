package com.meiheyoupin.common.utils;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils<K, V> {

    private RedisTemplate<K, V> redisTemplate;

    @Resource
    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 需要调用RedisTemplate底层方法（此RedisUtil未封装方法）时
     * 使用此方法获取RedisTemplate对象，手动调用底层方法
     *
     * @return RedisTemplate<K, V>
     */
    public RedisTemplate<K, V> getRedisTemplate() {
        return this.redisTemplate;
    }

    public Boolean hasKey(K key) {
        return redisTemplate.hasKey(key);
    }

    public void deleteKey(K key) {
        redisTemplate.delete(key);
    }

    public Boolean expire(K key, long timeout, TimeUnit timeUnit) {
        return redisTemplate.expire(key, timeout, timeUnit);
    }

    public void setValue(K key, V value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setValue(K key, V value, long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    public V getValue(K key) {
        return redisTemplate.opsForValue().get(key);
    }

    public <HK, HV> void putHashValue(K key, HK hashKey, HV hashValue) {
        redisTemplate.opsForHash().put(key, hashKey, hashValue);
    }

    /**
     * @return true若设置成功，否则false
     */
    public <HK, HV> Boolean putHashValueIfAbsent(K key, HK hashKey, HV hashValue) {
        return redisTemplate.opsForHash().putIfAbsent(key, hashKey, hashValue);
    }

    @SuppressWarnings("unchecked")
    public <HK, HV> HV getHashValue(K key, HK hashKey) {
        return (HV) redisTemplate.opsForHash().get(key, hashKey);
    }
}
