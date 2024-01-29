/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import Main.Panel;
import Main.Rendering;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author m.farrelmaheswaraalam
 */
public class Human {
    
    Panel panel;
    
    // Humans' Atributes
    public int worldX, worldY,  
               spriteCounter, 
               spriteNum,
               actionCounter,
               solidAreaDefaultX, 
               solidAreaDefaultY,
               maxHealth, healthpoint,
               coin, speed, 
               type;
    public final int hero_type = 0, survivor_type = 1, traveller_type = 2;
    public String direction;
    public BufferedImage stand_up, stand_down, stand_right, stand_left, 
                  walk_up_1, walk_up_2, walk_down_1, walk_down_2,
                  walk_right_1, walk_right_2, walk_left_1, walk_left_2, icon;
    public Rectangle solidArea = new Rectangle(0, 0, 80,80);
    public boolean contact, meet, ask;
    String dialogue[] = new String[20];
    // Humans' Atributes
    
    public Human(Panel panel) {
        this.panel = panel;
    }
    
    public BufferedImage setRender(String imagePath, int width, int height) {
        
        Rendering render = new Rendering();
        BufferedImage scaledImage = null;
        
        try {
            
            scaledImage = ImageIO.read(getClass().getResourceAsStream("resource/" + imagePath + ".png"));
            scaledImage = render.scaleImage(scaledImage, width, height);
            
        } catch (IOException e) {
        }
        
        return scaledImage;
    }
    
    public void checkContacts() {
        contact = false;
        panel.contact.checkPixel(this);
    }
    
    public void action() {}
    public void talk() {}
    public void update() {
        action();
        checkContacts();
        
        if (contact == false) {
            switch(direction) {
                case "up" -> worldY -= speed; 
                case "down" -> worldY += speed;
                case "left" -> worldX -= speed;
                case "right" -> worldX += speed;
            }
        }
        
        spriteCounter++;
        if(spriteCounter > 10){
            switch (spriteNum) {
                case 0 -> spriteNum = 1;
                case 1 -> spriteNum = 2;
                case 2 -> spriteNum = 3;
                case 3 -> spriteNum = 4;
                case 4 -> spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
    
    public void paint(Graphics2D g2, Panel panel) {
        BufferedImage image = null;
        int screenX = worldX - panel.hero.worldX + panel.hero.screenX;
        int screenY = worldY - panel.hero.worldY + panel.hero.screenY;
        int tempScreenX = screenX, tempScreenY = screenY;

            
        if( worldX + panel.pixelSize > panel.hero.worldX - panel.hero.screenX &&
            worldX - panel.pixelSize < panel.hero.worldX + panel.hero.screenX &&
            worldY + panel.pixelSize > panel.hero.worldY - panel.hero.screenY &&
            worldY - panel.pixelSize < panel.hero.worldY + panel.hero.screenY) {
            
            switch(direction) {
            case "up" -> {
                    if (spriteNum == 0) {image = stand_up;}
                    if (spriteNum == 1) {image = walk_up_1;} 
                    if (spriteNum == 2) {image = walk_up_2;}
                    if (spriteNum == 3) {image = walk_up_1;}
                    if (spriteNum == 4) {image = walk_up_2;}
                    
            }
            case "down" -> {
                    if (spriteNum == 0) {image = stand_down;}
                    if (spriteNum == 1) {image = walk_down_1;} 
                    if (spriteNum == 2) {image = walk_down_2;}
                    if (spriteNum == 3) {image = walk_down_1;}
                    if (spriteNum == 4) {image = walk_down_2;}
            }
            case "left" -> {
                    if (spriteNum == 0) {image = stand_left;}
                    if (spriteNum == 1) {image = walk_left_1;} 
                    if (spriteNum == 2) {image = stand_left;}
                    if (spriteNum == 3) {image = walk_left_2;}
                    if (spriteNum == 4) {image = stand_left;}
            }
            case "right" -> {
                    if (spriteNum == 0) {image = stand_right;}
                    if (spriteNum == 1) {image = walk_right_1;} 
                    if (spriteNum == 2) {image = stand_right;}
                    if (spriteNum == 3) {image = walk_right_2;}
                    if (spriteNum == 4) {image = stand_right;}
                }
            }
        }
                
        g2.drawImage(image, tempScreenX, tempScreenY, null);
                
        }
}
