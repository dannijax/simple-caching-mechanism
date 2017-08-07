package com.danijax.cache;

/**
 * Created by danijax on 8/1/17.
 */
public class Ping extends Thread {

    private long sleepTime;
    private Pingable target;

    public Ping(Pingable target, long sleepTime) {
        this.sleepTime = sleepTime;
        this.target = target;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            target.ping();
        }
    }
}
