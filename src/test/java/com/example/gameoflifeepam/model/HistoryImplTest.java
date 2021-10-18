package com.example.gameoflifeepam.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoryImplTest {

    @Test
    void testAdd_whenHistoryIsEmpty() {
        HistoryImpl history = new HistoryImpl();
        GridServiceImpl gridService = new GridServiceImpl();

        assertTrue(history.getHistory().isEmpty());

        Grid grid = new Grid(10, 10);
        gridService.fillByRandom(grid);
        history.add(grid, 0);

        assertFalse(history.getHistory().isEmpty());
    }

    @Test
    void testAdd_whenHistoryIsFull() {
        HistoryImpl history = new HistoryImpl();
        GridServiceImpl gridService = new GridServiceImpl();

        assertTrue(history.getHistory().isEmpty());

        Grid grid0 = new Grid(10, 10);
        Grid grid1 = new Grid(10, 10);
        Grid grid2 = new Grid(10, 10);
        Grid grid3 = new Grid(10, 10);
        Grid grid4 = new Grid(10, 10);
        Grid grid5 = new Grid(10, 10);

        gridService.fillByRandom(grid0);
        gridService.fillByRandom(grid1);
        gridService.fillByRandom(grid2);
        gridService.fillByRandom(grid3);
        gridService.fillByRandom(grid4);
        gridService.fillByRandom(grid5);

        history.add(grid0, 0);
        history.add(grid1, 1);
        history.add(grid2, 2);
        history.add(grid3, 3);
        history.add(grid4, 4);
        history.add(grid5, 5);

        for (int i = 0; i < history.getHistory().size(); i++) {
            assertNotNull(history.getHistory().get(i));
        }
    }
}