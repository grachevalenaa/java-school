package ru.croc.task11;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AuctionLot {
    private static int currentPrice;

    private static String currentBidder;

    private final LocalDateTime ENDINGTIME;

    private final Lock lock = new ReentrantLock();

    private final Condition timePassed = lock.newCondition();

    AuctionLot() {
        ENDINGTIME = LocalDateTime.of(2022, 11, 22, 0, 0);
    }

    public void toBidAtAuction(int newPrice, String newBidder) {
        lock.lock();
        try {
            if (LocalDateTime.now().isBefore(ENDINGTIME) && newPrice > currentPrice) {
                currentPrice = newPrice;
                currentBidder = newBidder;
            } else if (LocalDateTime.now().isAfter(ENDINGTIME)) {
                timePassed.signal();
            }
        } finally {
            lock.unlock();
        }

    }

    public String getFinalBidder() throws InterruptedException {
        lock.lock();
        try {
            while (LocalDateTime.now().isBefore(ENDINGTIME)) {
                timePassed.await();
            }
        } finally {
            lock.unlock();
        }
        return currentBidder;
    }
}
