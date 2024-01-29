/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Home.Login;
import static Main.Window.window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author m.farrelmaheswaraalam
 */
public class Keyboard implements KeyListener{
    
    Panel panel;
    
    public Keyboard(Panel panel) {
        this.panel = panel;
    }
    public boolean upKey, downKey, leftKey, rightKey, interactKey, enterKey, ingame = false;

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        if(panel.gamestate == panel.playstate){
            playstate(code);
        } else if(panel.gamestate == panel.titlestate){
            titlestate(code);
        } else if (panel.gamestate == panel.pausestate){
            pausestate(code);
        } else if (panel.gamestate == panel.tradingstate){
            tradingstate(code);
        } else if (panel.gamestate == panel.dialoguestate){
            dialoguestate(code);
        } else if (panel.gamestate == panel.triviastate){
            triviastate(code);
        } else if(panel.gamestate == panel.gameoverstate){
            gameoverstate(code);
        }
    }
    
    public void titlestate(int code) {
        if(code == KeyEvent.VK_W) {
            panel.inface.commandcounter--;
                if(panel.inface.commandcounter < 0){
                    panel.inface.commandcounter = 1;
                }
            }
            if(code == KeyEvent.VK_S) {
            panel.inface.commandcounter++;
                if(panel.inface.commandcounter > 1){
                    panel.inface.commandcounter = 0;
                }
            }
        if(code == KeyEvent.VK_SPACE || code == KeyEvent.VK_ENTER) {
            if(panel.inface.commandcounter == 0) {
                panel.gamestate = panel.playstate;
                ingame = true;
                panel.inface.commandcounter = 0;
            }
            if(panel.inface.commandcounter == 1) {
                new Login().setVisible(true);
                window.dispose();
                panel.stopMusic();
                panel.inface.commandcounter = 0;
            }
        } 
    }
    
    public void playstate(int code) {
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                upKey = true;
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                downKey = true;
            }
            if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
                leftKey = true;
            }
            if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
                rightKey = true;
            }
            if(code == KeyEvent.VK_ENTER) {
                enterKey = true;
            }
            if(code == KeyEvent.VK_SPACE) {
                interactKey = true;
            }
            if(code == KeyEvent.VK_P) {
                panel.gamestate = panel.pausestate;
                panel.stopMusic(); 
            }
    }
    
    public void pausestate(int code) {
        if(code == KeyEvent.VK_P) {
                panel.gamestate = panel.playstate;
                panel.playMusic(0); 
            }
        if(code == KeyEvent.VK_W) {
            panel.inface.commandcounter--;
                if(panel.inface.commandcounter < 0){
                    panel.inface.commandcounter = 1;
                }
            }
            if(code == KeyEvent.VK_S) {
            panel.inface.commandcounter++;
                if(panel.inface.commandcounter > 1){
                    panel.inface.commandcounter = 0;
                }
            }
        if(code == KeyEvent.VK_SPACE || code == KeyEvent.VK_ENTER) {
            if(panel.inface.commandcounter == 0) {
                panel.gamestate = panel.playstate;
                panel.playMusic(0); 
                panel.inface.commandcounter = 0;
            }
            if(panel.inface.commandcounter == 1) {
                panel.gamestate = panel.titlestate;
                ingame = false;
                panel.playMusic(0); 
                panel.inface.commandcounter = 0;
                panel.inface.commandcounter = 0;
            }
        } 
    }
    
    public void dialoguestate(int code) {
        if(code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE) {
            panel.gamestate = panel.playstate;
        }
    }
    
    public void tradingstate(int code) {
        if(code == KeyEvent.VK_W) {
            panel.inface.commandcounter--;
                if(panel.inface.commandcounter < 0){
                    panel.inface.commandcounter = 1;
                }
            }
            if(code == KeyEvent.VK_S) {
            panel.inface.commandcounter++;
                if(panel.inface.commandcounter > 1){
                    panel.inface.commandcounter = 0;
                }
            }
        if(code == KeyEvent.VK_SPACE) {
            interactKey = true;
        } 
        if(code == KeyEvent.VK_ENTER) {
            enterKey = true;
        }
    }
    
    public void triviastate(int code) {
        if(code == KeyEvent.VK_A) {
            panel.inface.commandcounter--;
                if(panel.inface.commandcounter < 0){
                    panel.inface.commandcounter = 3;
                }
            }
            if(code == KeyEvent.VK_D) {
            panel.inface.commandcounter++;
                if(panel.inface.commandcounter > 3){
                    panel.inface.commandcounter = 0;
                }
            }
        if(code == KeyEvent.VK_ENTER) {
            if(panel.hero.quizValid[panel.inface.commandcounter] == true) {
                panel.hero.coin++;
                panel.inface.setmessage("Coin +1");
                panel.stopMusic();
                panel.playMusic(0);
                panel.gamestate = panel.playstate;
            } else if (panel.hero.quizValid[panel.inface.commandcounter] == false) {
                panel.hero.healthpoint--;
                panel.inface.setmessage("Healthpoint -1");
                panel.stopMusic();
                panel.playMusic(0);
                panel.gamestate = panel.playstate;
            }
        }
    }
    
    public void gameoverstate(int code){
        if(code == KeyEvent.VK_W) {
            panel.inface.commandcounter--;
                if(panel.inface.commandcounter < 0){
                    panel.inface.commandcounter = 1;
                }
            }
            if(code == KeyEvent.VK_S) {
            panel.inface.commandcounter++;
                if(panel.inface.commandcounter > 1){
                    panel.inface.commandcounter = 0;
                }
            }
        if(code == KeyEvent.VK_SPACE || code == KeyEvent.VK_ENTER) {
            if(panel.inface.commandcounter == 0) {
                panel.reset();
                panel.gamestate = panel.playstate;
                panel.inface.commandcounter = 0;
            }
            if(panel.inface.commandcounter == 1) {
                panel.gamestate = panel.titlestate;
                ingame = false;
                panel.playMusic(0); 
                panel.inface.commandcounter = 0;
                panel.inface.commandcounter = 0;
            }
        } 
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            upKey = false;
            panel.hero.spriteNum = 0;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            downKey = false;
            panel.hero.spriteNum = 0;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            leftKey = false;
            panel.hero.spriteNum = 0;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            rightKey = false;
            panel.hero.spriteNum = 0;
        }
        if(code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE) {
            interactKey = false;
            enterKey = false;
            panel.hero.spriteNum = 0;
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}
