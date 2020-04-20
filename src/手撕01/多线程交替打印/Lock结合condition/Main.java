package 手撕01.多线程交替打印.Lock结合condition;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static Lock lock = new ReentrantLock();
    static Condition a = lock.newCondition();
    static Condition b = lock.newCondition();
    static Condition c = lock.newCondition();
    static Integer i = new Integer(0);

    static class A extends Thread {
        public void run() {
            while (true) {
                lock.lock();
                while (i % 3 != 0) {
                    try {
                        a.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i++;
                System.out.print("a");
                b.signal();
                lock.unlock();
            }
        }
    }

    static class B extends Thread {
        public void run() {
            while (true) {
                lock.lock();
                while (i % 3 != 1) {
                    try {
                        b.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i++;
                System.out.print("b");
                c.signal();
                lock.unlock();
            }
        }
    }

    static class C extends Thread {
        public void run() {
            while (true) {
                lock.lock();
                while (i % 3 != 2) {
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i++;
                System.out.println("c");
                a.signal();
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

