package com.bawangbai.util;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "reidsson",name = "enable",havingValue = "true")
public class RedissonUtil {

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 加锁
     * @param lockKey
     */
    public void lock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock();
    }

    /**
     * 解锁
     * @param lockKey
     */
    public void unlock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.unlock();
    }

    /**
     * 秒级时间锁
     * @param lockKey
     * @param leaseTime
     */
    public void lock(String lockKey, int leaseTime) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(leaseTime, TimeUnit.SECONDS);
    }

    /**
     * 自定义时间锁
     * @param lockKey
     * @param timeout
     * @param unit
     */
    public void lock(String lockKey, int timeout, TimeUnit unit) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(timeout, unit);
    }

    /**
     * 尝试锁
     * @param lockKey
     * @return
     */
    public boolean tryLock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        return lock.tryLock();
    }

    /**
     * 尝试锁
     * @param lockKey
     * @param waitTime 尝试等待时间
     * @param leaseTime 上锁时间
     * @param unit 尝试等待单位
     * @return
     * @throws InterruptedException
     */
    public boolean tryLock(String lockKey, long waitTime, long leaseTime, TimeUnit unit) throws InterruptedException {
        RLock lock = redissonClient.getLock(lockKey);
        return lock.tryLock(waitTime, leaseTime, unit);
    }

    /**
     * 公平锁
     * @param lockKey
     */
    public void fairLock(String lockKey){
        RLock fairLock = redissonClient.getFairLock(lockKey);
        fairLock.lock();
    }

    /**
     * 锁查询
     * @param lockKey
     * @return
     */
    public boolean isLocked(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        return lock.isLocked();
    }

    /**
     * 写锁
     * @param lockKey
     */
    public void writeLock(String lockKey){
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(lockKey);
        readWriteLock.writeLock();
    }

    /**
     * 读锁
     * @param lockKey
     */
    public void readLock(String lockKey){
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(lockKey);
        readWriteLock.readLock();
    }

    /**
     * 闭锁
     * @param lockKey
     * @param count 闭锁数量
     */
    public void countDownLatchLock(String lockKey,int count) throws InterruptedException {
        RCountDownLatch countDownLatch = redissonClient.getCountDownLatch(lockKey);
        countDownLatch.trySetCount(count);
        countDownLatch.await();
    }

    /**
     * 闭锁计数-1
     * @param lockKey
     */
    public void releaseCountDownLatchLock(String lockKey){
        RCountDownLatch countDownLatch = redissonClient.getCountDownLatch(lockKey);
        countDownLatch.countDown();
    }

    /**
     * 信号量锁
     * @param lockKey 锁名称
     */
    public void semaphoreLock(String lockKey) throws InterruptedException {
        RSemaphore semaphore = redissonClient.getSemaphore(lockKey);
        semaphore.acquire();
    }

    /**
     * 信号量加锁
     * @param lockKey 锁名称
     * @param acquire 信号量数量
     */
    public void semaphoreLock(String lockKey,int acquire) throws InterruptedException {
        RSemaphore semaphore = redissonClient.getSemaphore(lockKey);
        semaphore.acquire(acquire);
        semaphore.release();
    }

    /**
     * 信号量释放锁
     * @param lockKey
     */
    public void releaseLock(String lockKey){
        RSemaphore semaphore = redissonClient.getSemaphore(lockKey);
        semaphore.release();
    }

    /**
     * 信号量释放锁
     * @param lockKey
     */
    public void releaseLock(String lockKey,int permits){
        RSemaphore semaphore = redissonClient.getSemaphore(lockKey);
        semaphore.release(permits);
    }


}
