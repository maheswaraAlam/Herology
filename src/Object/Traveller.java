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
public class Traveller extends Human{
    
    public Traveller(Panel panel) {
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
        type = traveller_type;
        ask = false;
        
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
        panel.inface.currentDialogue = dialogue[0];
    }
    
    public void setDialogue() {
        
        dialogue[0] = "You already bet me your life, Hero";
        
    }
    
    public void getImage(){
        
        stand_up = setRender("npc2_stand_up", panel.pixelSize, panel.pixelSize);
        stand_down = setRender("npc2_stand_down", panel.pixelSize, panel.pixelSize);
        stand_left = setRender("npc2_stand_left", panel.pixelSize, panel.pixelSize);
        stand_right = setRender("npc2_stand_right", panel.pixelSize, panel.pixelSize);
        walk_up_1 = setRender("npc2_walk_up_1", panel.pixelSize, panel.pixelSize);
        walk_down_1 = setRender("npc2_walk_down_1", panel.pixelSize, panel.pixelSize);
        walk_left_1 = setRender("npc2_walk_left_1", panel.pixelSize, panel.pixelSize);
        walk_right_1 = setRender("npc2_walk_right_1", panel.pixelSize, panel.pixelSize);
        walk_up_2 = setRender("npc2_walk_up_2", panel.pixelSize, panel.pixelSize);
        walk_down_2 = setRender("npc2_walk_down_2", panel.pixelSize, panel.pixelSize);
        walk_left_2 = setRender("npc2_walk_left_2", panel.pixelSize, panel.pixelSize);
        walk_right_2 = setRender("npc2_walk_right_2", panel.pixelSize, panel.pixelSize);
        
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
