package 手撕01.多线程交替打印.Lock显式加锁解锁打印ABC;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static Lock lock = new ReentrantLock();
    static Integer i = new Integer(3);

    static class A extends Thread {
        public void run() {
            while (true) {
                lock.lock();
                while (i % 3 == 0) {
                    System.out.print("a");
                    i++;
                }
                lock.unlock();
            }
        }
    }

    static class B extends Thread {
        public void run() {
            while (true) {
                lock.lock();
                while (i % 3 == 1) {
                    System.out.print("b");
                    i++;
                }
                lock.unlock();
            }
        }
    }

    static class C extends Thread {
        public void run() {
            while (true) {
                lock.lock();
                while (i % 3 == 2) {
                    System.out.println("c");
                    i++;
                }
                lock.unlock();
            }
        }
    }

    public static void main(String args[]) {
        Thread threadA = new A();
        threadA.start();
        Thread threadB = new B();
        threadB.start();
        Thread threadC = new C();
        threadC.start();
    }
}

