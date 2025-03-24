package org.example.core;

import org.example.constants.GameCon;

public class GameLoop {

    public Double gameLoop(Double nextDrawTime) {

        try {

            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime / 1000000; // ->  //converto in millisSecond per il meto .sleep() -> accetta millisecondi

            if (remainingTime < 0) {
                remainingTime = 0;
            }

            Thread.sleep((long) remainingTime);

            return nextDrawTime + GameCon.drawInterval;

        } catch (InterruptedException e) {

            System.out.println("Eccezione nel gameLoop");
            throw new RuntimeException(e);

        }
    }

}
