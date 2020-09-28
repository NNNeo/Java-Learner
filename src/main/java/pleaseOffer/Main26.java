package pleaseOffer;

import java.util.concurrent.ConcurrentHashMap;

public class Main26{
    public static void main(String[] args) throws InterruptedException {
        String content = "A";
        new Thread(new ThA(content)).start();
        new Thread(new ThB(content)).start();
        new Thread(new ThC(content)).start();

        Thread.sleep(10000000);
    }
}

class ThA implements Runnable {
    String content;
    public ThA(String c) {
        content = c;
    }

    public void run() {
        for(;;) {
            synchronized(content) {
                if(! content.equals("A")) {
                    try {
                        content.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print("A");
                content = "B";
                content.notify();
            }
        }
    }
}

class ThB implements Runnable {
    String content;

    public ThB(String c) {
        content = c;
    }

    public void run() {
        for(;;) {
            synchronized(content) {
                if(! content.equals("B")) {
                    try {
                        content.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print("B");
                content = "C";
                content.notify();
            }
        }
    }
}

class ThC implements Runnable {
    String content;

    public ThC(String c) {
        content = c;
    }

    public void run() {
        for(;;) {
            synchronized(content) {
                if(! content.equals("C")) {
                    try {
                        content.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print("C");
                content = "A";
                content.notify();
            }
        }
    }
}

