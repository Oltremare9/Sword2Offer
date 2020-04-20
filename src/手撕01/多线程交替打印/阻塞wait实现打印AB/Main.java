package 手撕01.多线程交替打印.阻塞wait实现打印AB;

public class Main {
    static Object lockA = 0;

    static class A extends Thread {
        public void run() {
            while (true) {
                synchronized (lockA) {
                    System.out.print("A");
                    lockA.notify();
                    try {
                        lockA.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class B extends Thread {
        public void run() {
            while (true) {
                synchronized (lockA) {
                    System.out.println("B");
                    lockA.notify();
                    try {
                        lockA.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread a = new A();
        a.start();
        Thread.sleep(10);
        Thread b = new B();
        b.start();
    }
}
