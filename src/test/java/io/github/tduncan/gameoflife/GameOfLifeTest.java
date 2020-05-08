package io.github.tduncan.gameoflife;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class GameOfLifeTest {
    @Test
    void gridWithAllDeadCellsResultsInAllCellsRemainingDead() {
        var grid = new int[][] {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };

        var game = new GameOfLife();
        var nextGeneration = game.nextGeneration(grid);

        var allDead = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
        assertArrayEquals(allDead, nextGeneration);
    }

    @Test
    void largerGridWithAllDeadCellsResultsInAllCellsRemainingDead() {
        var grid = new int[][] {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };

        var game = new GameOfLife();
        var nextGeneration = game.nextGeneration(grid);

        var allDead = new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        assertArrayEquals(allDead, nextGeneration);
    }

    @Test
    void gridContainingAliveCellsAndRemainsTheSameInTheNextGeneration() {
        var grid = new int[][]{
                {1,1,0},
                {1,1,0},
                {0,0,0}
        };

        var game = new GameOfLife();
        var nextGeneration = game.nextGeneration(grid);

        assertArrayEquals(grid, nextGeneration);
    }

    @Test
    void gridWithOnlySingleLiveCellShouldDieOutEntirely() {
        var grid = new int[][] {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        var game = new GameOfLife();
        var nextGeneration = game.nextGeneration(grid);

        var allDead = new int[][]{
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        assertArrayEquals(allDead, nextGeneration);
    }

    @Test
    void anotherGridWithOnlySingleLiveCellShouldDieOutEntirely() {
        var grid = new int[][] {
                {0,1,0},
                {0,0,0},
                {0,0,0}
        };

        var game = new GameOfLife();
        var nextGeneration = game.nextGeneration(grid);

        var allDead = new int[][]{
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        assertArrayEquals(allDead, nextGeneration);
    }

    @Test
    void liveCellWithTwoLiveNeighborsShouldContinueLivingInNextGeneration() {
        var grid = new int[][] {
                {0,0,1},
                {0,1,0},
                {1,0,0}
        };

        var game = new GameOfLife();
        var nextGeneration = game.nextGeneration(grid);

        var expectedNextGeneration = new int[][] {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        assertArrayEquals(expectedNextGeneration, nextGeneration);
    }

    @Test
    void deadCellWithThreeLiveNeighborsShouldBecomeAliveInNextGeneration() {
        var grid = new int[][] {
                {0,1,0},
                {1,0,1},
                {0,0,0}
        };

        var game = new GameOfLife();
        var nextGeneration = game.nextGeneration(grid);

        var expectedNextGeneration = new int[][] {
                {0,1,0},
                {0,1,0},
                {0,0,0}
        };
        assertArrayEquals(expectedNextGeneration, nextGeneration);
    }

    // live cell with three live neighbors, should live
    // live cell with four live neighbors, should die
    // dead cell with one live neighbor, should remain dead
    // deal cell with two live neighbors, should remain dead
    // dead cell with four live neighbors, should be dead

    @Test
    @Disabled
    void liveCellWithSingleLiveNeighborsDiesInNextGeneration() {
        var grid = new int[][] {
                {1,1,0},
                {0,0,0},
                {0,0,0}
        };

        var game = new GameOfLife();
        var nextGeneration = game.nextGeneration(grid);

        var expectedNextGeneration = new int[][] {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        assertArrayEquals(expectedNextGeneration, nextGeneration);
    }

    @Test
    @Disabled
    void gridContainAllLiveCellsWillOnlyHaveCornersRemainingAlive() {
        var allAlive = new int[][]{
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };

        var game = new GameOfLife();
        var nextGeneration = game.nextGeneration(allAlive);

        var onlyCornersAlive = new int[][]{
                {1,0,1},
                {0,0,0},
                {1,0,1}
        };
        assertArrayEquals(onlyCornersAlive, nextGeneration);
    }
}
