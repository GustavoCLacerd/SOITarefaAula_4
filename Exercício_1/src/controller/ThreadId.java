package controller;

public class ThreadId extends Thread {

    public ThreadId () {
        super ();
    }

    @Override
    public void run() {
        int tid = (int) threadId();
        System.out.println("#"+tid);
    }
}