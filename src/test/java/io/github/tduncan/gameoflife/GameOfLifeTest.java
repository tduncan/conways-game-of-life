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

    @Test
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
    void liveCellWithFourLiveNeighborsDiesInNextGeneration() {
        var grid = new int[][] {
                {1,1,0},
                {0,1,0},
                {0,1,1}
        };

        var game = new GameOfLife();
        var nextGeneration = game.nextGeneration(grid);

        var expectedNextGeneration = new int[][] {
                {1,1,0},
                {0,0,0},
                {0,1,1}
        };
        assertArrayEquals(expectedNextGeneration, nextGeneration);
    }

    @Test
    void deadCellWithFourLiveNeighborsDiesInNextGeneration() {
        var grid = new int[][] {
                {0,1,0},
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

    // deal cell with two live neighbors, should remain dead
    // dead cell with four live neighbors, should be dead
}
