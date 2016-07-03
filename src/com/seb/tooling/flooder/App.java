package com.seb.tooling.flooder;

import com.seb.tooling.flooder.constant.FlooderConstants;
import com.seb.tooling.flooder.http.HttpRequester;
import com.seb.tooling.flooder.thread.FlooderThread;

/**
 * Created by caskdor on 03/07/16.
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World !!");

        for (int i = 0; i < FlooderConstants.POOL_SIZE; ++i) {
            FlooderThread thread = new FlooderThread(FlooderConstants.THREAD_NAME + i, FlooderConstants.URL, FlooderConstants.LOOP);
            thread.start();
            try {
                Thread.sleep(FlooderConstants.LONG_SLEEPING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
