/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author m.farrelmaheswaraalam
 */
public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];
    FloatControl floatC;
    int volumeScale = 3;
    float volume;
    
    public Sound() {
        
        soundURL[0] = getClass().getResource("resource/Idle.wav");
        soundURL[1] = getClass().getResource("resource/Fight.wav");
        
    }
    
    public void setAudio(int i) {
        
        try {
            AudioInputStream audioIS = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(audioIS);
            floatC = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            checkVolume(); 
            
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            
        }
        
    }
    
    public void start() {clip.start();}
    
    public void loop() {clip.loop(Clip.LOOP_CONTINUOUSLY);}
    
    public void stop() {clip.stop();}
    
    public void checkVolume() {
        switch(volumeScale) {
            case 0 -> {volume = -80f;}
            case 1 -> {volume = -30f;}
            case 2 -> {volume = -15f;}
            case 3 -> {volume = 0f;}
            case 4 -> {volume = 3f;}
            case 5 -> {volume = 5f;}
        }
        floatC.setValue(volume);
    }
}
