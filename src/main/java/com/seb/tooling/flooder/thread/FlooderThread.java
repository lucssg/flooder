package com.seb.tooling.flooder.thread;

import com.seb.tooling.flooder.constant.FlooderConstants;
import com.seb.tooling.flooder.http.HttpRequester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by caskdor on 03/07/16.
 */
public class FlooderThread extends Thread {

    private static final Logger LOG = LoggerFactory.getLogger(FlooderThread.class);

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
    public void run() {
        LOG.info("{} runs !!", getName());
        super.run();
        int count = 0;
        while (count < loop)  {
            LOG.info("Loop: {} - {}", getName(), count);
            ++count;
            String response = requester.request(url);
            LOG.info(response);
            try {
                Thread.sleep(FlooderConstants.SLEEPING);
            } catch (InterruptedException e) {
                LOG.error("Sleeping Failed !!", e);
                // Do nothing
                // POC style
            }
        }
    }
}
