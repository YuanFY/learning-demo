package com.yuanfy.demo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author maple.yuan
 * @date 2020-03-08 09:52
 */
public class TwinsLock implements Lock {

    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer {
        Sync(int count) {
            if (count < 0) {
                throw new IllegalArgumentException("count must large than zero.");
            }
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int reduceCount) {
            for (;;) {
                int state = getState();
                int newState = state - reduceCount;
                if (newState < 0 || compareAndSetState(state, newState)) {
                    return newState;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int count) {
            for (;;) {
                int state = getState();
                int newState = state + count;
                if (compareAndSetState(state, newState)) {
                    return true;
                }
            }
        }

        Condition newCondition() { return new ConditionObject(); }
    }

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        int state = sync.tryAcquireShared(1);
        return state >= 0;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
       return sync.tryAcquireSharedNanos(1, time);
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
