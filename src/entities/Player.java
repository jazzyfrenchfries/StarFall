package entities;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;


public class Player {
    private int x;
    private int y;
    
    public Player(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2) {
        g2.fillRect(x, y, 32,32);
    }
    public void moveUp(){
        y -= 5;
    }
    public void moveDown(){
        y+= 5;
    }
    public void moveLeft(){
        x-= 5;
    }
    public void moveRight(){
        x += 5;
    }
}
