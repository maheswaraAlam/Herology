/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Object.Hero;
import Object.Human;
import Stage.Pixelets;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author m.farrelmaheswaraalam
 */
public class Panel extends JPanel implements Runnable{

    // Resolution or Screen 
    public final int bit = 16; // Bit size
    public final int scale = 5; // Pixel size
    public final int pixelSize = bit * scale; // 80 bit per pixel
    public final int maxScreenColumn = 30;
    public final int maxScreenRow = 17;
    public final int screenWidth = maxScreenColumn * pixelSize;
    public final int screenHeight = maxScreenRow * pixelSize;
    // Resolution or Screen
    
    // Virtual World
    public final int maxWorldColumn = 41;
    public final int maxWorldRow = 41;
    // Virtual World
    
    // Modules
    Thread thread;
    public DBConnect DBcon = new DBConnect(this);
    public Interface inface = new Interface(this);
    public Compositor compositor = new Compositor(this);
    public Keyboard keyboard = new Keyboard(this);
    public Hero hero = new Hero(this, keyboard);
    public Pixelets pixel = new Pixelets(this);
    public Contacts contact = new Contacts(this);
    public Sound sound = new Sound();
    public Human[] npc = new Human[41];
    
    // Game State
    public int gamestate;
    public final int titlestate = 0,
                     introstate = 1,
                     rolestate = 2,
                     playstate = 3,
                     pausestate = 4,
                     dialoguestate = 5,
                     knowledgestate = 6,
                     tradingstate = 7,
                     triviastate = 8, 
                     gameoverstate = 9;
    public Panel() {
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(55, 175, 15));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyboard);
        this.setFocusable(true);
        
    }
    
    public void setup() {
        compositor.setObjects();
        gamestate = titlestate;
        playMusic(0);
    }
    
    public void reset() {
        for(int j = 0; j < npc.length; j++){
            npc[j] = null;
        }
        compositor.setObjects();
        hero.setDefaultValues();
    }
    
    public void startThread() {
        
        thread = new Thread(this);
        thread.start();
        
    }
    
    @Override
    public void run() {
        double interval = 1000000000/60, delta = 0;
        long lastTime = System.nanoTime(), currentTime;
        
        while(thread != null) {
            
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / interval;
            lastTime = currentTime;
            
            if (delta >= 1) {
            
                //Update Game System
                update();
                
                /*
                * Redrawing the images
                * repaint() & paintComponent() are built-in Java module
                */
                repaint();
                
                delta--;
            }
        }
    }
    
    public void update() {
        if(gamestate == playstate) {
            hero.update();
            for (Human npc1 : npc) {
                if(npc1 != null){
                    npc1.update();
                }
            }
        } else if(gamestate == pausestate){
            
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        switch (gamestate) {
            case introstate -> inface.paint(g2);
            case titlestate -> inface.paint(g2);
            default -> {
                pixel.paint(g2);
                hero.paint(g2, this, pixelSize, pixelSize);
                for (Human npc1 : npc) {
                    if(npc1 != null){
                        npc1.paint(g2, this);
                    }
                }   inface.paint(g2);
                g2.dispose();
            }

        }
        
    }
    
    public void playMusic(int i){
        sound.setAudio(i);
        sound.start();
        sound.loop();
    }
    
    public void stopMusic(){
        sound.stop();
    }
    
    public void SFX(int i) {
        sound.setAudio(i);
        sound.start();
    }
    
}
