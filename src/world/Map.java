package world;

import java.awt.Graphics2D;
import java.awt.font.GraphicAttribute;

public class Map {
    private char[][] map = {
    "##############################".toCharArray(),
    "#............................#".toCharArray(),
    "#............................#".toCharArray(),
    "#............................#".toCharArray(),
    "#............................#".toCharArray(),
    "#.............######.........#".toCharArray(),
    "#.............#....#.........#".toCharArray(),
    "#.............#....#.........#".toCharArray(),
    "#.............######.........#".toCharArray(),
    "#............................#".toCharArray(),
    "#............................#".toCharArray(),
    "#............................#".toCharArray(),
    "#............................#".toCharArray(),
    "#............................#".toCharArray(),
    "#............................#".toCharArray(),
    "#............................#".toCharArray(),
    "#............................#".toCharArray(),
    "#............................#".toCharArray(),
    "#............................#".toCharArray(),
    "##############################".toCharArray()
};
    private final int TILE_SIZE = 32;

    public void draw(Graphics2D g2, int cameraX, int cameraY){
        for(int row = 0; row < map.length; row++){
            for( int col = 0; col< map[row].length; col++){
                char title = map[row][col];
                if(title == '#'){
                    g2.fillRect(
                        col * TILE_SIZE - cameraX, 
                        row * TILE_SIZE - cameraY,
                        TILE_SIZE,
                        TILE_SIZE
                    );
                }
            }
        }
    }
    
    public boolean isWalkable(int row, int col){
        if(row < 0 || row >= map.length|| 
            col < 0 || col >= map[row].length){
            return false;
        }
        return map[row][col] != '#';
    }
}
