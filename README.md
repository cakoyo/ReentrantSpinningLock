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

## Maven
Repository:
```
<repository>
    <id>akarin-repo</id>
    <url>https://raw.githubusercontent.com/Akarin-project/akarin-repo/master/repository</url>
</repository>
```

Dependency:
```
<dependency>
    <groupId>moe.kira.locks.spinning</groupId>
    <artifactId>reentrant-spinning-lock</artifactId>
    <version>1.0</version>
</dependency>
```
