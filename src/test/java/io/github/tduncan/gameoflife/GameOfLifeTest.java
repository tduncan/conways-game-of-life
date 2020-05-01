package io.github.tduncan.gameoflife;

import org.junit.jupiter.api.Test;

class GameOfLifeTest {
    @Test
    void gridWithAllDeadCellsResultsInAllCellsRemainingDead() {
        var grid = new int[][] {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };

        var game = new GameOfLife();
    }

    // all cells are alive
    // live cell with zero live neighbors should die
    // live cell with one live neighbor, should die
    // live cell with two live neighbors, should live
    // live cell with three live neighbors, should live
    // live cell with four live neighbors, should die
    // dead cell with one live neighbor, should remain dead
    // deal cell with two live neighbors, should remain dead
    // dead cell with three live neighbors, should be alive
    // dead cell with four live neighbors, should be dead
}
