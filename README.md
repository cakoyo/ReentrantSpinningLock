# ReentrantSpinningLock
A faster and simpler version of ReentrantLock.

## Feature
* Faster than ReentrantLock, under any circumstance and best in high concurrency environment.

## Usage
```java
ReentrantSpinningLock lock = ReentrantSpinningLock.acquire();
lock.lock();
// do something

lock.lock(); // reentrant
// do something
lock.unlock();

// do something
lock.unlock();
```
