# 多线程

## 进程和线程

**进程**：在计算机中，我们把一个任务称为一个进程

**线程**：某些进程内部还需要同时执行多个子任务，我们把子任务称为线程

一个进程可以包含一个或多个线程

## 线程的创建和调用

1. 继承Thread，然后重写Runnable()  
```java
public class Main {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start(); // 启动新线程
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}
```
2. 实现Runnable接口
```java
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start(); // 启动新线程
    }
}
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}
```
## 线程的状态  
* New：新创建的线程，尚未执行；
* Runnable：运行中的线程，正在执行run()方法的Java代码；
* Blocked：运行中的线程，因为某些操作被阻塞而挂起；
* Waiting：运行中的线程，因为某些操作在等待中；
* Timed Waiting：运行中的线程，因为执行sleep()方法正在计时等待；
* Terminated：线程已终止，因为run()方法执行完毕。  

