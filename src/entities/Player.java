package entities;
import java.awt.Graphics2D;


import world.Map;


public class Player {
    private int x;
    private int y;
    private final int TILE_SIZE = 32;
    
    public Player(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2,int cameraX, int cameraY) {
        g2.fillRect(x - cameraX, y - cameraY, 32,32);
    }
    public void moveUp(Map map){
        int newY = y -5;
        int row = newY / TILE_SIZE;
        int col = x/ TILE_SIZE;
        if(map.isWalkable(row, col)){
            y = newY;
        }
    }
    public void moveDown(Map map){
        int newY = y + 5;
        int row = newY / TILE_SIZE;
        int col = x / TILE_SIZE;
        if(map.isWalkable(row,col)){
            y = newY;
        }
    }
    public void moveLeft(Map map){
        int newX = x - 5;
        int row = y / TILE_SIZE;
        int col = newX / TILE_SIZE;
        if(map.isWalkable(row, col)){
            x= newX;
        }
    }
    public void moveRight(Map map){
        int newX = x +5;
        int row = y / TILE_SIZE;
        int col = newX / TILE_SIZE;
        if(map.isWalkable(row, col)){
            x = newX;
        }
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
