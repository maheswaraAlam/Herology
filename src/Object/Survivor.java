/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import Main.Panel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author m.farrelmaheswaraalam
 */
public class Survivor extends Human{
    
    public Survivor(Panel panel) {
        super(panel);
        
        // Collision Area
        solidArea = new Rectangle();
        solidArea.x = 20;
        solidArea.y = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 40;
        solidArea.height = 40;
        // Collision Area
        
        speed = 3;
        direction = "down";
        type = survivor_type;
        
        getImage();
        setDialogue();
    }
    
    @Override
    public void action() {
        actionCounter++;
        Random random = new Random();
        int limit = 120;
        if(actionCounter == limit) {
            int i = random.nextInt(5);
            if("down".equals(direction)) {
                switch (i % 3) {
                    case 1 -> direction = "up";
                    case 2 -> direction = "left";
                    case 0 -> direction = "right";
                }
            } else if("up".equals(direction)) {
               switch (i % 3) {
                    case 1 -> direction = "down";
                    case 2 -> direction = "left";
                    case 0 -> direction = "right";
                } 
            } else if("left".equals(direction)) {
               switch (i % 3) {
                    case 1 -> direction = "down";
                    case 2 -> direction = "up";
                    case 0 -> direction = "right";
                } 
            } else if("right".equals(direction)) {
               switch (i % 3) {
                    case 1 -> direction = "down";
                    case 2 -> direction = "left";
                    case 0 -> direction = "up";
                } 
            }
            limit = random.nextInt(60, 120);
            actionCounter = 0;
        }
    }
    
    @Override
    public void talk() {
        panel.inface.currentDialogue = dialogue[new Random().nextInt(3)];
    }
    
    public void setDialogue() {
        
        dialogue[0] = "I got this potion from old masters. Would you like too buy it for 3 coins?";
        dialogue[1] = "Seems like you need this potion. How about 3 coins?";
        dialogue[2] = "I need money to buy some needs. Want to trade with this potion for 3 coins?";
        
    }
    
    public void getImage(){
        
        stand_up = setRender("npc1_stand_up", panel.pixelSize, panel.pixelSize);
        stand_down = setRender("npc1_stand_down", panel.pixelSize, panel.pixelSize);
        stand_left = setRender("npc1_stand_left", panel.pixelSize, panel.pixelSize);
        stand_right = setRender("npc1_stand_right", panel.pixelSize, panel.pixelSize);
        walk_up_1 = setRender("npc1_walk_up_1", panel.pixelSize, panel.pixelSize);
        walk_down_1 = setRender("npc1_walk_down_1", panel.pixelSize, panel.pixelSize);
        walk_left_1 = setRender("npc1_walk_left_1", panel.pixelSize, panel.pixelSize);
        walk_right_1 = setRender("npc1_walk_right_1", panel.pixelSize, panel.pixelSize);
        walk_up_2 = setRender("npc1_walk_up_2", panel.pixelSize, panel.pixelSize);
        walk_down_2 = setRender("npc1_walk_down_2", panel.pixelSize, panel.pixelSize);
        walk_left_2 = setRender("npc1_walk_left_2", panel.pixelSize, panel.pixelSize);
        walk_right_2 = setRender("npc1_walk_right_2", panel.pixelSize, panel.pixelSize);
        
    }
    
    public void paint(Graphics2D g2, Panel panel, int width, int height) {
        BufferedImage image = null;
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
        g2.drawImage(image,worldX,worldY, width, height, null);
    }
    
}
