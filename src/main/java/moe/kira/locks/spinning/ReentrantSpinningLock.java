package moe.kira.locks.spinning;

import java.util.concurrent.atomic.AtomicInteger;

public class ReentrantSpinningLock {
    private final AtomicInteger singleLock = new AtomicInteger(0);
    private long heldThreadId = 0;
    private int reentrantLocks = 0;

    public final void lock() {
        long currentThreadId = Thread.currentThread().getId();
        if (heldThreadId == currentThreadId) {
            reentrantLocks++;
            return;
        }
        
        while (!singleLock.compareAndSet(0, 1)) ; // In case acquire one lock concurrently
        heldThreadId = currentThreadId;
    }
    
    /*
     * This method is fairly lock-free, since we guarantee that only one thread on one lock.
     */
    public final void unlock() {
        if (reentrantLocks == 0) {
            heldThreadId = 0;
            // release the lock after reset the id to ensure safety
            singleLock.set(0);
            return;
        }
        
        reentrantLocks--;
    }
    
    public static ReentrantSpinningLock acquire() {
        return new ReentrantSpinningLock();
    }
}
