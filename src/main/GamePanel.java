package main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import entities.Player;
import world.Map;
public class GamePanel extends JPanel implements KeyListener{
    
    private Player player;
    private Map map;

    private int cameraX;
    private int cameraY;

    public GamePanel(){
        setPreferredSize(new Dimension(800, 600));
        
        setFocusable(true);
        addKeyListener(this);

        player = new Player(100, 100);
        map = new Map();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        cameraX = player.getX() - getWidth() / 2;
        cameraY = player.getY() - getHeight() / 2;
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        map.draw(g2,cameraX,cameraY);
        player.draw(g2,cameraX,cameraY);
    }
    
    @Override
    public void keyTyped(KeyEvent k){

    }
    @Override
    public void keyPressed(KeyEvent k){
        if(k.getKeyCode() == KeyEvent.VK_W){
            player.moveUp(map);
            repaint();
        }
        if(k.getKeyCode() == KeyEvent.VK_A){
            player.moveLeft(map);
            repaint();
        }
        if(k.getKeyCode() == KeyEvent.VK_S){
            player.moveDown(map);
            repaint();
        }
        if(k.getKeyCode() == KeyEvent.VK_D){
            player.moveRight(map);
            repaint();
        }
    }
    @Override
    public void keyReleased(KeyEvent k){

    }
}
