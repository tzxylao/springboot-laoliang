package com.laoliang.springboot.thread;

import org.junit.jupiter.api.Test;

/**
 * @author laoliangliang
 * @date 2019/11/5 16:10
 */
public class NotifyTest {
    private Object obj = new Object();
    @Test
    public void notifyTest(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    int i = 1;
                    for (; ; i++) {
                        System.out.println("t1 线程 ：" + i);
                        if (i % 5 == 0) {
                            try {
                                this.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    int i = 1;
                    for (; ; i++) {
                        System.out.println("t2 线程 ：" + i);
                        if (i % 5 == 0) {
                            try {
                                this.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    int i = 1;
                    for (; ; i++) {
                        System.out.println("t3 线程 ：" + i);
                        if (i % 10 == 0) {
                            this.notify();
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
