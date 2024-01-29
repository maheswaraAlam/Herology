/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Object.Human;

/**
 *
 * @author m.farrelmaheswaraalam
 */
public class Contacts {
    
    Panel panel;
    
    public Contacts(Panel panel) {
        
        this.panel = panel;
        
    }
    
    public void checkPixel(Human entity) {
        
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width - (panel.pixelSize/12);
        int entityTopWorldY = entity.worldY + entity.solidArea.y; 
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height - (panel.pixelSize/6);
        
        int entityLeftColumn = (entityLeftWorldX)/panel.pixelSize;
        int entityRightColumn = (entityRightWorldX)/panel.pixelSize;
        int entityTopRow = (entityTopWorldY)/panel.pixelSize;
        int entityBottomRow = (entityBottomWorldY)/panel.pixelSize;
        
        int tileNum1, tileNum2;
        
        // Temporal Direction for knockback
        String direction = entity.direction;
        
        switch(direction) {
            case "up" -> {
                entityTopRow = (entityTopWorldY - entity.speed)/panel.pixelSize;
                tileNum1 = panel.pixel.pixelStage[entityTopRow][entityLeftColumn];
                tileNum2 = panel.pixel.pixelStage[entityTopRow][entityRightColumn];
                if (panel.pixel.pixel[tileNum1].collision == true || panel.pixel.pixel[tileNum2].collision == true) {
                    entity.contact = true;
                    entity.spriteNum = 0;
                    entity.spriteCounter = 10;
                }
            }
            case "down" -> {
                entityBottomRow = (entityBottomWorldY + entity.speed)/panel.pixelSize;
                tileNum1 = panel.pixel.pixelStage[entityBottomRow][entityLeftColumn];
                tileNum2 = panel.pixel.pixelStage[entityBottomRow][entityRightColumn];
                if (panel.pixel.pixel[tileNum1].collision == true || panel.pixel.pixel[tileNum2].collision == true) {
                    entity.contact = true;
                }
            }
            case "left" -> {
                entityLeftColumn = (entityLeftWorldX - entity.speed)/panel.pixelSize;
                tileNum1 = panel.pixel.pixelStage[entityTopRow][entityLeftColumn];
                tileNum2 = panel.pixel.pixelStage[entityBottomRow][entityLeftColumn];
                if (panel.pixel.pixel[tileNum1].collision == true || panel.pixel.pixel[tileNum2].collision == true) {
                    entity.contact = true;
                }
            }
            case "right" -> {
                entityRightColumn = (entityRightWorldX + entity.speed)/panel.pixelSize;
                tileNum1 = panel.pixel.pixelStage[entityTopRow][entityRightColumn];
                tileNum2 = panel.pixel.pixelStage[entityBottomRow][entityRightColumn];
                if (panel.pixel.pixel[tileNum1].collision == true || panel.pixel.pixel[tileNum2].collision == true) {
                    entity.contact = true;
                }
            }
        }
    }
    
    public int checkEntity(Human entity, Human[] target) {
        
        int index = 999;
        
        String direction = entity.direction;
        
        for(int i = 0; i < target.length; i++){
            
            if(target[i] != null) {
                
                // Entity solid area
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                
                // Object solid area
                target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
                target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;
                
                switch(direction) {
                    case "up" -> {entity.solidArea.y -= entity.speed;}
                    case "down" -> {entity.solidArea.y += entity.speed;}
                    case "left" -> {entity.solidArea.x -= entity.speed;}
                    case "right" -> {entity.solidArea.x += entity.speed;}
                }
                
                if(entity.solidArea.intersects(target[i].solidArea)) {
                    if(target[i] != entity) {
                        entity.meet = true;
                        index = i;
                    }
                }
                
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
            
        }
        
        return index;
        
    }
}
