package io.github.tduncan.gameoflife;

class GameOfLife {
    int[][] nextGeneration(int[][] grid) {
        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[x].length; y++) {

                int aliveNeighbors = 0;
                // Pivot around the cell at x,y, keeping track of how many live neighboring cells are found
                for(int nx = x - 1; nx < x + 2; nx++) {
                    for(int ny = y - 1; ny < y + 2; ny++) {
                        if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[x].length) {
                            if(nx == x && ny == y) {  // Don't count the pivot point
                                continue;
                            }
                            aliveNeighbors += grid[nx][ny];
                        }
                    }
                }

                if(aliveNeighbors != 2) {
                    grid[x][y] = 0;
                }
            }
        }
        return grid;
    }
}

