package com.rk;

import java.util.*;

public class Perc_SynchronizedThread {

    private ArrayList<String> messageList;
    private ThreadA ta;
    private ThreadB tb;

    public Perc_SynchronizedThread() {
        messageList = new ArrayList<String>();
        ta = new ThreadA();
        tb = new ThreadB();
    }

    class ThreadA implements Runnable {

        Thread th = new Thread(this);

        public ThreadA() {
            th.start();
        }

        @Override
        public void run() {
            int i = 0;

            while (i < 100) {
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e);
                }

                messageList.add("Hi " + i);
                System.out.println("adding message : Hi" + i);
                i++;
            }
        }
    }

    class ThreadB implements Runnable {

        Thread th = new Thread(this);

        public ThreadB() {
            th.start();
        }

        @Override
        public void run() {
            int i = 0;

            while (i < 50) {
                try {
                    Thread.sleep(40);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e);
                }

                for (int j = 0; j < messageList.size(); j++) {
                    System.out.println(messageList.get(j));
                }
            }
        }
    }

    public static void main(String[] args) {
        new Perc_SynchronizedThread();
    }

}
