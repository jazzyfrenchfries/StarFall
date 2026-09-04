package world;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.Graphics2D;

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
    private BufferedImage grass;
    private BufferedImage wall;
    private final int TILE_SIZE = 32;


    public Map(){
        File grassFile = new File("assets/grass.png");
        File wallFile = new File("assets/wall.png");
        try{
            grass = ImageIO.read(grassFile);
            wall = ImageIO.read(wallFile);
        }       
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2, int cameraX, int cameraY){
        for(int row = 0; row < map.length; row++){
            for( int col = 0; col< map[row].length; col++){
                char tile = map[row][col];
                if(tile == '#'){
                    g2.drawImage(
                        wall,
                        col * TILE_SIZE - cameraX,
                        row * TILE_SIZE - cameraY,
                        TILE_SIZE,
                        TILE_SIZE,
                        null
                        );
                }
                if(tile == '.'){
                    g2.drawImage(
                        grass,
                        col * TILE_SIZE - cameraX,
                        row * TILE_SIZE - cameraY,
                        TILE_SIZE,
                        TILE_SIZE,
                        null
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
