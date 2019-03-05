## ReentrantSpinningLock
A faster and simpler version of ReentrantLock.

### Usage
```java
ReentrantSpinningLock lock = ReentrantSpinningLock.acquire();
lock.lock();
// do something
lock.unlock();
```
