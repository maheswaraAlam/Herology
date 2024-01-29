/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;


import Object.Coin;
import Object.Health;
import Object.Human;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author m.farrelmaheswaraalam
 */
public class Interface {
    Panel panel;
    Graphics2D g2;
    Font pixeloidSans;
    BufferedImage health, coin;
    public String currentDialogue = "", currentAnswer = "";
    public int commandcounter = 0, randomcounter = 0;
    ArrayList<String> message = new ArrayList<>();
    ArrayList<Integer> messageCounter = new ArrayList<>();
    
    public Interface(Panel panel){
        this.panel = panel;
        InputStream inputS = getClass().getResourceAsStream("resource/PixeloidSans.ttf");
        try {
            pixeloidSans = Font.createFont(Font.TRUETYPE_FONT, inputS);
        } catch (FontFormatException | IOException e) {
            // Throwable exceptions are unused
        }
        
        Human healthicon = new Health(panel);
        Human coinicon = new Coin(panel);
        health = healthicon.icon;
        coin = coinicon.icon;
    }
    
    public void paint(Graphics2D g2) {
        
        this.g2 = g2;
        
        g2.setFont(pixeloidSans);
        g2.setColor(Color.white);
        
        if(panel.gamestate == panel.titlestate) {
            painttitlestate();
        }
        if(panel.gamestate == panel.pausestate) {
            paintpausestate();
        }
        if(panel.gamestate == panel.playstate) {
            paintcoin();
            painthealthpoint();
            paintplaystate();
        }
        if(panel.gamestate == panel.tradingstate) {
            painttradingstate();
        }
        if(panel.gamestate == panel.dialoguestate) {
            paintdialoguestate();
        }
        if(panel.gamestate == panel.triviastate) {
            painttriviastate();
        }
        if(panel.gamestate == panel.gameoverstate) {
            paintgameoverstate();
        }
    }
    
    public void setmessage(String text) {
        
        message.add(text);
        messageCounter.add(0);
        
    }
    
    public void paintmessage() {
        int messageX = panel.pixelSize;
        int messageY = 5*panel.pixelSize;
        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT, 24F));
        
        for(int i = 0; i < message.size(); i++) {
            if(message.get(i) != null) {
                
                g2.setColor(Color.black);
                g2.drawString(message.get(i), messageX+3, messageY+3);
                g2.setColor(Color.white);
                g2.drawString(message.get(i), messageX, messageY);
                
                int counter = messageCounter.get(i) + 1;
                messageCounter.set(i, counter);
                messageY += 36;
                
                if(messageCounter.get(i) > 180) {
                    message.remove(i);
                    messageCounter.remove(i);
                }
                
            }
        }
    }
    
    public void painttitlestate() {
        // Background
        g2.setColor(new Color(55, 174, 15));
        g2.fillRect(0, 0, panel.screenWidth, panel.screenHeight);
        
        // Title
        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT, 96F));
        String text = "Herology";
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = setcenterx(text),
            y = panel.pixelSize * 9/5;
        
        // Shadow
        g2.setColor(new Color(73, 73, 73, 150));
        g2.drawString(text, x+5, y+5);
        
        // Main Color
        g2.setColor(Color.black);
        g2.drawString(text, x, y);
        
        // Menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
        
        text = "PLAY GAME";
        x = setcenterx(text);
        y += 3*(panel.pixelSize);
        g2.drawString(text, x, y);
        if (commandcounter == 0) {
            g2.drawString(">>", x - panel.pixelSize, y);
        }
            
        text = "QUIT";
        x = setcenterx(text);
        y += panel.pixelSize;
        g2.drawString(text, x, y);
        if (commandcounter == 1) {
            g2.drawString(">>", x - panel.pixelSize, y);
        }
        
    }

    public void paintpausestate() {
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0, 0, panel.screenWidth, panel.screenHeight);
        
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT, 72F));
        
        String text = "PAUSE";
        int y = panel.screenHeight/3;
        
        g2.drawString(text, setcenterx(text), y);
        
        y += panel.pixelSize;
        
        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT, 32F));
        
        text = "Continue";
        g2.drawString(text, setcenterx(text), y);
        if (commandcounter == 0) {
            g2.drawString(">>", setcenterx(text) - panel.pixelSize, y);
        }
        y += panel.pixelSize * 3/5;
        
        text = "Exit";
        g2.drawString(text, setcenterx(text), y);
        if (commandcounter == 1) {
            g2.drawString(">>", setcenterx(text) - panel.pixelSize, y);
        }
    }

    public void paintplaystate() {
        paintmessage();
    }
    
    public void painthealthpoint() {
        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT, 40F));
        int x = panel.pixelSize/2;
        int y = panel.pixelSize/2;
        g2.drawImage(health, x, y, null);
        x += 5*panel.pixelSize/4;
        y += 3*panel.pixelSize/4;
        g2.drawString(Integer.toString(panel.hero.healthpoint), x, y);
    }
    
    public void paintcoin() {
        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT, 40F));
        int x = panel.pixelSize/2;
        int y = 2*panel.pixelSize;
        g2.drawImage(coin, x, y, null);
        x += 5*panel.pixelSize/4;
        y += 3*panel.pixelSize/4; 
        g2.drawString(Integer.toString(panel.hero.coin), x, y);
    }
    
    public void paintdialoguestate() {
        int x = panel.pixelSize, 
            y = panel.pixelSize/2,
            width = panel.screenWidth/2 + (3*panel.pixelSize/2),
            height = panel.pixelSize*3;
        
        paintsubwindow(x, y, width, height);
        
        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT, 30F));
        
        x += panel.pixelSize;
        y += 3*panel.pixelSize/4;
        
        for(String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 28;
        }
    }
    
    public void painttradingstate() {
        paintdialoguestate();
        int x = panel.pixelSize, 
            y = panel.pixelSize*7/2, 
            width = panel.pixelSize * 4, 
            height = (int)(panel.pixelSize * 2.5);
        paintsubwindow(x, y, width, height);
        
        String text = "";

        x += panel.pixelSize;
        y += panel.pixelSize;
        g2.drawString("Buy", x, y);
        if(commandcounter == 0) {
            g2.drawString(">", x - 24, y);
            if(panel.keyboard.enterKey == true && (panel.hero.coin-3 >= 0)) {
                panel.hero.healthpoint++;
                panel.hero.coin-=3;
                currentDialogue = "My the light of knowledge be with you, Hero.";
                panel.gamestate = panel.dialoguestate;
                panel.inface.setmessage("Healthpoint +1");
                panel.inface.setmessage("Coin -3");
                commandcounter = 0;
            } else if(panel.keyboard.enterKey == true && (panel.hero.coin-3 < 0)) {
                
                currentDialogue = "You need 3 coins to heal, Hero.";
                panel.gamestate = panel.dialoguestate;
                panel.inface.setmessage("No Healthpoint Obtained");
                commandcounter = 0;
            }
        }
        
        y += 3*panel.pixelSize/4;
        g2.drawString("Leave", x, y);
        if(commandcounter == 1) {
            g2.drawString(">", x - 24, y);
            if(panel.keyboard.enterKey == true) {
                currentDialogue = "Have a great day, Hero.";
                panel.gamestate = panel.dialoguestate;
                commandcounter = 0;
            }
        }
    }
    
    public void painttriviastate() {
        // Background
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0, 0, panel.screenWidth, panel.screenHeight);
        
        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT, 30F));
        
        int x = panel.pixelSize, 
            y = panel.pixelSize/2,
            width = panel.screenWidth/2 + (3*panel.pixelSize/2),
            height = panel.pixelSize*3;
        
        paintsubwindow(x, y, width, height);
        
        currentDialogue = (String) panel.DBcon.getQuestions().get(randomcounter);
        
        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT, 30F));
        
        x += panel.pixelSize;
        y += 3*panel.pixelSize/4;
        
        for(String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 32;
        }
        
        y += 3 * panel.pixelSize;
        String text = panel.hero.quizAnswer[0];
        g2.drawString(text, x, y);
        if(commandcounter == 0) {
            g2.drawString(">>", x - panel.pixelSize, y);
        }
        
        x += 4 * panel.pixelSize;
        text = panel.hero.quizAnswer[1];
        g2.drawString(text, x, y);
        if(commandcounter == 1) {
            g2.drawString(">>", x - panel.pixelSize, y);
        }
        
        x += 4 * panel.pixelSize;
        text = panel.hero.quizAnswer[2];
        g2.drawString(text, x, y);
        if(commandcounter == 2) {
            g2.drawString(">>", x - panel.pixelSize, y);
        }
        
        x += 4 * panel.pixelSize;
        text = panel.hero.quizAnswer[3];
        g2.drawString(text, x, y);
        if(commandcounter == 3) {
            g2.drawString(">>", x - panel.pixelSize, y);
        }
    }
    
    public void paintgameoverstate() {
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0, 0, panel.screenWidth, panel.screenHeight);
        
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT, 72F));
        
        String text = "GAME OVER";
        int y = panel.screenHeight/3;
        
        g2.drawString(text, setcenterx(text), y);
        
        y += panel.pixelSize;
        
        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT, 32F));
        
        text = "Try Again";
        g2.drawString(text, setcenterx(text), y);
        if (commandcounter == 0) {
            g2.drawString(">>", setcenterx(text) - panel.pixelSize, y);
        }
        y += panel.pixelSize * 3/5;
        
        text = "Exit";
        g2.drawString(text, setcenterx(text), y);
        if (commandcounter == 1) {
            g2.drawString(">>", setcenterx(text) - panel.pixelSize, y);
        }
    }
    
    public void paintsubwindow(int x, int y, int width, int height) {
        
        Color color = new Color(0,0,0, 200);
        g2.setColor(color);
        g2.fillRoundRect(x, y, width, height, 45, 45);
        
        color = new Color(255,255,255);
        g2.setColor(color);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 35, 35);
        

    }
  
    public int setcenterx (String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = 25*panel.screenWidth/84 - length/2;
        return x;
    }
    
    public int setrightx (String text, int tailX) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = tailX - length;
        return x;
    }
    
    
}
