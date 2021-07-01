package com.csu.yuelugame.biz.chinesechess;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

class PlayerTest {

    @Test
    public void testTimer() throws InterruptedException {
        Player player = new Player(0);
        new CountDownLatch(3).await();
    }
}
