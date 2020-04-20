package 手撕01.多线程交替打印.Semaphore信号量实现打印AB;

import java.util.concurrent.Semaphore;

public class Main {
    static Semaphore a = new Semaphore(1);
    static Semaphore b = new Semaphore(0);

    static class A extends Thread {
        public void run() {
            while (true) {
                try {
                    a.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("a");
                b.release();
            }
        }
    }

    static class B extends Thread {
        public void run() {
            while (true) {
                try {
                    b.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("b");
                a.release();
            }
        }
    }

    public static void main(String args[]) {
        Thread threadA = new A();
        threadA.start();
        Thread threadB = new B();
        threadB.start();
    }
}
