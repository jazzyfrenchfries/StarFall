package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import entities.Player;
import world.Map;
import entities.NPC;
public class GamePanel extends JPanel implements KeyListener{
    
    private Player player;
    private Map map;
    private NPC professor;

    private int cameraX;
    private int cameraY;

    private boolean showingDialogue = false;

    public GamePanel(){
        setPreferredSize(new Dimension(800, 600));
        
        setFocusable(true);
        addKeyListener(this);

        player = new Player(100, 100);
        map = new Map();
        professor = new NPC(300, 300, "Welcome to Starfall Academy!");
    }
    private boolean nearProfessor(){
        int dx  = player.getX() - professor.getX();
        int dy = player.getY() - professor.getY();

        double distance = Math.sqrt(dx *dx+dy *dy);
        return distance < 50;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        cameraX = player.getX() - getWidth() / 2;
        cameraY = player.getY() - getHeight() / 2;
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        map.draw(g2,cameraX,cameraY);
        professor.draw(g2, cameraX, cameraY);
        player.draw(g2,cameraX,cameraY);

        if(showingDialogue){
            g2.fillRect(
                50,
                450,
                700,
                100
            );
            g2.setColor(Color.WHITE);
            g2.drawString(
                professor.getDialogue(),
                70,
                500
            );
        }
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
        if(k.getKeyCode() == KeyEvent.VK_E){
            if(nearProfessor()){
                showingDialogue = ! showingDialogue;
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent k){

    }
}
