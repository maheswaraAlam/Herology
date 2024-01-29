/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import javax.swing.JFrame;

/**
 *
 * @author m.farrelmaheswaraalam
 */
public class Window {
    
    public static JFrame window;
    
    public void run() {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Herology");
        
        Panel panel = new Panel();
        window.add(panel);
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        
        window.setVisible(true);
        panel.setup();
        panel.startThread();
    }

    
}
