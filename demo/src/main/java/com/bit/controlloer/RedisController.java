package com.bit.controlloer;

import com.bit.util.SpringManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private  final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/getvalue")
    public String getValueByKey(String key) {
        StringRedisTemplate stringRedisTemplate = SpringManager.getBean("stringRedisTemplate", StringRedisTemplate.class);
        return stringRedisTemplate.opsForValue().get(key);
    }

    @RequestMapping("/{key}/{value}")
    public String getOrderList(@PathVariable("key") String key, @PathVariable("value") String value){
        logger.info("key:{},value:{}", key,value);

        stringRedisTemplate.opsForValue().set(key, value);
        //redisTemplate.opsForValue().set(key, value);
        //String valueInRedis = redisTemplate.opsForValue().get(key).toString();
        return "ok";
    }

    @RequestMapping("/del/{key}")
    public Boolean remove(@PathVariable("key") String key){
        return redisTemplate.delete(key);
    }
}
