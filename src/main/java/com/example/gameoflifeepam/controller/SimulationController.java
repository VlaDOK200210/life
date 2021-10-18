package com.example.gameoflifeepam.controller;

import com.example.gameoflifeepam.model.Grid;
import com.example.gameoflifeepam.view.MainView;

import java.util.concurrent.CyclicBarrier;

public class SimulationController implements Simulator{

    private final Thread creatorThread;
    private final Thread killerThread;

    public SimulationController(Grid grid, int epochs, int timeOfFrame, MainView mainView) {
        Renderer renderer = new Renderer(grid, mainView, timeOfFrame);
        CyclicBarrier barrier = new CyclicBarrier(2, renderer);
        Creator creator = new Creator(grid, epochs, barrier);
        Killer killer = new Killer(grid, epochs, barrier, mainView);
        creatorThread = new Thread(creator);
        killerThread = new Thread(killer);
    }

    public void run() {
        try {
            control();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void control() throws InterruptedException {
        killerThread.start();
        creatorThread.start();
    }

    public void stop() {
        killerThread.interrupt();
        creatorThread.interrupt();
    }
}
