package io.github.tduncan.gameoflife;

class GameOfLife {
    int[][] nextGeneration(int[][] grid) {
        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[x].length; y++) {
                int aliveNeighbors = countAliveNeighbors(grid, x, y);
                if(aliveNeighbors != 2) {
                    grid[x][y] = 0;
                }
            }
        }
        return grid;
    }

    private int countAliveNeighbors(int[][] grid, int x, int y) {
        int aliveNeighbors = 0;
        // Pivot around the cell at x,y, keeping track of how many live neighboring cells are found
        for(int nx = x - 1; nx < x + 2; nx++) {
            aliveNeighbors += isAlive(grid, nx, y - 1) ? 1 : 0;
            if(nx != x) {
                aliveNeighbors += isAlive(grid, nx, y) ? 1 : 0;
            }
            aliveNeighbors += isAlive(grid, nx, y + 1) ? 1 : 0;
        }
        return aliveNeighbors;
    }

    private boolean isAlive(int [][] grid, int x, int y) {
        if(x >= 0 && x < grid.length && y >= 0 && y < grid[x].length) {
            return grid[x][y] == 1;
        }
        return false;
    }
}

