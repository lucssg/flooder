package com.seb.tooling.flooder.thread;

import com.seb.tooling.flooder.constant.FlooderConstants;
import com.seb.tooling.flooder.http.HttpRequester;

/**
 * Created by caskdor on 03/07/16.
 */
public class FlooderThread extends Thread {

    private String url;
    private int loop = 1;
    private HttpRequester requester;

    public FlooderThread(String name, String url, int loop) {
        super(name);
        this.url = url;
        this.loop = loop;
        requester = new HttpRequester();
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        super.run();
        int count = 0;
        while (count < loop)  {
            System.out.println(requester.request(url));
            try {
                Thread.sleep(FlooderConstants.SLEEPING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
