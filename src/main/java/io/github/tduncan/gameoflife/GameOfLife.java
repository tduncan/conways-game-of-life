package io.github.tduncan.gameoflife;

class GameOfLife {
    int[][] nextGeneration(int[][] grid) {
        int xMiddle = grid.length / 2;
        int yMiddle = grid[0].length / 2;
        grid[xMiddle][yMiddle] = 0;
        return grid;
    }
}

