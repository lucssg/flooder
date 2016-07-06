package com.seb.tooling.flooder;

import com.seb.tooling.flooder.constant.FlooderConstants;
import com.seb.tooling.flooder.thread.FlooderThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by caskdor on 03/07/16.
 */
public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        LOG.info("Flooder rocks !!");

        for (int i = 0; i < FlooderConstants.POOL_SIZE; ++i) {
            LOG.info("Création du Thread {}{}", FlooderConstants.THREAD_NAME, i);
            FlooderThread thread = new FlooderThread(FlooderConstants.THREAD_NAME + i, FlooderConstants.URL, FlooderConstants.LOOP);
            thread.start();
            try {
                Thread.sleep(FlooderConstants.THREAD_START_SLEEPING);
            } catch (InterruptedException e) {
                LOG.error("Erreur de la mise en attente", e);
                // do nothing
                // POC style
            }
        }

    }

}
