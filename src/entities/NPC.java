package entities;

import java.awt.Graphics2D;

public class NPC {
    private int x; 
    private int y;
    
    private String dialogue;
    public NPC(int x,int y, String dialogue){
        this.x = x;
        this.y = y;
        this.dialogue = dialogue;
    }   

    public void draw(Graphics2D g2, int cameraX, int cameraY){
        g2.fillRect(
            x - cameraX,
            y - cameraY,
            32,
            32
        );
    }
    public String getDialogue(){
        return dialogue;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
