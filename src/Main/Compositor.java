/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Object.Survivor;
import Object.Traveller;
import java.util.Random;

/**
 *
 * @author m.farrelmaheswaraalam
 */
public class Compositor {
    Panel panel;
    
    public Compositor(Panel panel) {
        this.panel = panel;
    }
    
    public void setObjects(){
        for(int i = 0; i < 5; i++) {
            int randomx = (new Random().nextInt(20)*2) + 1;
            int randomy = (new Random().nextInt(20)*2) + 1;
            panel.npc[i] = new Survivor(panel);
            panel.npc[i].worldX = randomx * panel.pixelSize;
            panel.npc[i].worldY = randomy * panel.pixelSize;
        }
        
        for(int i = 5; i < 25; i++) {
            int randomx = (new Random().nextInt(20)*2) + 1;
            int randomy = (new Random().nextInt(20)*2) + 1;
            panel.npc[i] = new Traveller(panel);
            panel.npc[i].worldX = randomx * panel.pixelSize;
            panel.npc[i].worldY = randomy * panel.pixelSize;
        }
    }
}
