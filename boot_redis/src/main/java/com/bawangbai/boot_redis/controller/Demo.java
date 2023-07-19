package com.bawangbai.boot_redis.controller;

//import com.bawangbai.boot_redis.util.RedissonUtil;

//import com.bawangbai.boot_redis.util.RedissonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("demo")
public class Demo {

//    @Autowired
//    private RedissonUtil redissonUtil;

//    @GetMapping("test")
//    public void test(){
//        redissonUtil.lock("abc");
//        System.out.println("上锁了");
//        log.info("test info");
//    }
//
//    @GetMapping("initSemLock")
//    public void initSemLock(){
//        RSemaphore semlock = redissonClient.getSemaphore("semlock");
//        semlock.release(5);
//    }
//
//    @GetMapping("semLock")
//    public void semLock(){
//        RSemaphore semlock = redissonClient.getSemaphore("semlock");
//        semlock.release(1);
//    }
//
//    @GetMapping("acqsemLock")
//    public void acqSemLock() throws InterruptedException {
//        RSemaphore semlock = redissonClient.getSemaphore("semlock");
//        semlock.acquire(1);
//    }
//
//    @GetMapping("delSemLock")
//    public void delSemLock() throws InterruptedException {
//        RSemaphore semlock = redissonClient.getSemaphore("semlock");
//        semlock.delete();
//    }

}
