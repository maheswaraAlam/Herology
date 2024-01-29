/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import Main.Keyboard;
import Main.Panel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author m.farrelmaheswaraalam
 */
public class Hero extends Human{
   
    Keyboard keyboard;
    public final int screenX, screenY;
    public String[] quizAnswer = new String[4]; 
    public boolean[] quizValid = new boolean[4];
    int question = 0;
    
    public Hero(Panel panel, Keyboard keyboard){
        
        super(panel);
        
        this.panel = panel;
        this.keyboard = keyboard;
        
        screenX = panel.screenWidth/2 - (13*panel.pixelSize/2);
        screenY = panel.screenHeight/2 - (7*panel.pixelSize/2);
        
        // Collision Area
        solidArea = new Rectangle();
        solidArea.x = 20;
        solidArea.y = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 40;
        solidArea.height = 40;
        // Collision Area
        
        type = hero_type;
        
        setDefaultValues();
        getImage();
    }
    
    public void setDefaultValues() {
        
        worldX = panel.pixelSize * 1;
        worldY = panel.pixelSize * 1;
        speed = 4;
        direction = "down";
        maxHealth = 3;
        healthpoint = 3;
        coin = 0;
        
    }
    
    public void update() {
        
        if (keyboard.upKey == true || keyboard.downKey == true || keyboard.leftKey == true || keyboard.rightKey == true){
            if(keyboard.upKey == true) {
                direction = "up";
            }
            if(keyboard.downKey == true) {
                direction = "down";
            }
            if(keyboard.leftKey == true) {
                direction = "left";
            }
            if(keyboard.rightKey == true) {
                direction = "right";
            }
            
        contact = false;
        panel.contact.checkPixel(this);
        int NPCindex = panel.contact.checkEntity(this, panel.npc);
        interact(NPCindex);
        
        if (contact == false) {
            switch(direction) {
                case "up" -> worldY -= speed; 
                case "down" -> worldY += speed;
                case "left" -> worldX -= speed;
                case "right" -> worldX += speed;
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
        }
        if(healthpoint <= 0) {
            panel.gamestate = panel.gameoverstate;
        }
        if(question >= 10){
            for(int j = 0; j < panel.npc.length; j++){
                panel.npc[j] = null;
            }
            panel.compositor.setObjects();
            question = 0;
        }
    }
    
    public void interact(int NPCindex) {
        if(NPCindex != 999 && panel.keyboard.interactKey == true) {
            if(panel.npc[NPCindex].type == 1) {
                panel.gamestate = panel.tradingstate;
                panel.npc[NPCindex].talk();
            } else if(panel.npc[NPCindex].type == 2 && panel.npc[NPCindex].ask == false){
                panel.stopMusic();
                panel.playMusic(1);
                panel.inface.randomcounter = new Random().nextInt(panel.DBcon.getQuestions().size());
                panel.inface.currentAnswer = (String) panel.DBcon.getAnswers().get(panel.inface.randomcounter);
                
                String invalidAnswer1 = Integer.toString(Integer.parseInt(panel.inface.currentAnswer) + 1);
                String invalidAnswer2 = Integer.toString(Integer.parseInt(panel.inface.currentAnswer) - 1);
                String invalidAnswer3 = Integer.toString(Integer.parseInt(panel.inface.currentAnswer) + 2);
                
                quizAnswer[0] = panel.inface.currentAnswer;
                quizAnswer[1] = invalidAnswer1;
                quizAnswer[2] = invalidAnswer2;
                quizAnswer[3] = invalidAnswer3;
                
                quizValid[0] = true; 
                quizValid[1] = false; 
                quizValid[2] = false; 
                quizValid[3] = false;
                
                //Shuffle
                for(int i = 0; i < quizAnswer.length; i++) {
                    int rand = new Random().nextInt(quizAnswer.length);
                    String tempAnswer = quizAnswer[rand];
                    quizAnswer[rand] = quizAnswer[i];
                    quizAnswer[i] = tempAnswer;
                    boolean tempValid = quizValid[rand];
                    quizValid[rand] = quizValid[i];
                    quizValid[i] = tempValid;
                }
                
                panel.gamestate = panel.triviastate;
                panel.npc[NPCindex].ask = true;
                question += 1;
            } else if(panel.npc[NPCindex].type == 2 && panel.npc[NPCindex].ask == true){
                panel.npc[NPCindex].talk();
                panel.gamestate = panel.dialoguestate;
            }
        }
    }
    
    public void getImage(){
        
        stand_up = setRender("stand_up", panel.pixelSize, panel.pixelSize);
        stand_down = setRender("stand_down", panel.pixelSize, panel.pixelSize);
        stand_left = setRender("stand_left", panel.pixelSize, panel.pixelSize);
        stand_right = setRender("stand_right", panel.pixelSize, panel.pixelSize);
        walk_up_1 = setRender("walk_up_1", panel.pixelSize, panel.pixelSize);
        walk_down_1 = setRender("walk_down_1", panel.pixelSize, panel.pixelSize);
        walk_left_1 = setRender("walk_left_1", panel.pixelSize, panel.pixelSize);
        walk_right_1 = setRender("walk_right_1", panel.pixelSize, panel.pixelSize);
        walk_up_2 = setRender("walk_up_2", panel.pixelSize, panel.pixelSize);
        walk_down_2 = setRender("walk_down_2", panel.pixelSize, panel.pixelSize);
        walk_left_2 = setRender("walk_left_2", panel.pixelSize, panel.pixelSize);
        walk_right_2 = setRender("walk_right_2", panel.pixelSize, panel.pixelSize);
        
    }
    
    public void paint(Graphics2D g2, Panel panel, int width, int height) {
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
                
        g2.drawImage(image, tempScreenX, tempScreenY, width, height, null);
                
        }
}
    

