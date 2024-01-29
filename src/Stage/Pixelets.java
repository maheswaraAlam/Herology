/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stage;

import Framework.Rendering;
import Main.Panel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author m.farrelmaheswaraalam
 */
public class Pixelets {
    Panel panel;
    public Pixel[] pixel;
    public int pixelStage[][];
    
    public Pixelets(Panel panel) {
        this.panel = panel;
        pixel = new Pixel[10];
        pixelStage = new int[panel.maxWorldRow][panel.maxWorldColumn];
        
        generateMap();
        getImage();
        loadMap();
    }
    
    public void getImage() {
        setRender(0, "Grass", false);
        setRender(1, "Tree", true);
    }
    
    public void loadMap() {
        
        try {
            
            
            BufferedReader reader = new BufferedReader(new FileReader("MapTile.txt"));
        
            int column = 0, row = 0;
        
            while(column < panel.maxWorldColumn && row < panel.maxWorldRow) {
            
                String line = reader.readLine();
                
                while(column < panel.maxWorldColumn) {
                    
                    String nums[] = line.split(" ");
                    int num = Integer.parseInt(nums[column]);
                    pixelStage[row][column] = num;
                    column++;
                            
                }
                
                if (column == panel.maxWorldColumn){
                    
                    column = 0; row++;
                    
                }
            
            }
            reader.close();
            
        } catch (IOException e) {
            
        } 
        
    }
    
    public void generateMap() {
        
        String[][] rawMap = new String[41][41];
        
        for(int i = 0; i < 41; i++) {
                for(int j = 0; j < 41; j++) {
                    if(i == 0 || i == 40 || j == 0 || j == 40) {
                        rawMap[i][j] = "1 ";
                    } else {
                        rawMap[i][j] = "0 "; 
                    }
                }
            }
        
        for(int i = 0; i < 41; i++) {
            for(int j = 0; j < 41; j++) {
                if (i >= 2 && i <= 38 && i%2 == 0 && j >= 2 && j <= 38 && j%2 == 0) {
                    rawMap[i][j] = "1 ";
                    int random = new Random().nextInt(4);
                    switch (random) {
                        case 0 -> {
                            rawMap[i - 1][j] = "1 ";
                        }
                        case 1 -> {
                            rawMap[i][j - 1] = "1 ";
                        }
                        case 2 -> {
                            rawMap[i + 1][j] = "1 ";
                        }
                        case 3 -> {
                            rawMap[i][j + 1] = "1 ";
                        }
                    }
                }
            }
        }
        
                
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("MapTile.txt")); 
                for(int i = 0; i < 41; i++) {
                    for(int j = 0; j < 41; j++) {
                        writer.write(rawMap[i][j]);
                    }
                    writer.newLine();
                }
                writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setRender(int index, String imagePath, boolean collision) {
        
        Rendering render = new Rendering();
        
        try {
            
            pixel[index] = new Pixel();
            pixel[index].image = ImageIO.read(getClass().getResourceAsStream("resource/" + imagePath + ".png"));
            pixel[index].image = render.scaleImage(pixel[index].image, panel.pixelSize, panel.pixelSize);
            pixel[index].collision = collision;
            
        } catch (IOException e) {}
        
    }
    
    public void paint(Graphics2D g2) {
        
        int worldColumn = 0, worldRow = 0;
        
        while(worldColumn < panel.maxWorldColumn && worldRow < panel.maxWorldRow) {
            
            int pixelNum = pixelStage[worldRow][worldColumn];
            
            int worldX = worldColumn * panel.pixelSize;
            int worldY = worldRow * panel.pixelSize;
            int screenX = worldX - panel.hero.worldX + panel.hero.screenX;
            int screenY = worldY - panel.hero.worldY + panel.hero.screenY;
            
            if( worldX + panel.pixelSize > panel.hero.worldX - panel.hero.screenX &&
                worldX - panel.pixelSize < panel.hero.worldX + panel.hero.screenX &&
                worldY + panel.pixelSize > panel.hero.worldY - panel.hero.screenY &&
                worldY - panel.pixelSize < panel.hero.worldY + panel.hero.screenY) {
                
                g2.drawImage(pixel[pixelNum].image, screenX, screenY, null);
                
            }
            
            worldColumn++;
            
            if(worldColumn == panel.maxWorldColumn) {
                worldColumn = 0;
                worldRow++;
            }
            
        }
    }
}
