package 手撕01.多线程交替打印.Volatile手动实现信号量;

public class Main {
    static Object lockA = 0;
    static Object lockB = 0;
    static Object lockC = 0;
    static volatile int i = 0;

    static class A extends Thread {
        public void run() {
            while (true) {
//                synchronized (lockA) {
                while (i % 3 == 0) {
                    System.out.print("a");
                    i++;
                }
//                }
            }
        }
    }

    static class B extends Thread {
        public void run() {
            while (true) {
//                synchronized (lockA) {
                while (i % 3 == 1) {
                    System.out.print("b");
                    i++;
                }
//                }
            }
        }
    }

    static class C extends Thread {
        public void run() {
            while (true) {
//                synchronized (lockA) {
                while (i % 3 == 2) {
                    System.out.println("c");
                    i++;
                }
//                }
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread a = new A();
        a.start();
        Thread.sleep(10);
        Thread b = new B();
        b.start();
        Thread c = new C();
        c.start();
    }
}
