/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import Main.Panel;

/**
 *
 * @author m.farrelmaheswaraalam
 */
public class Coin extends Human{
    
    public Coin(Panel panel) {
        super(panel);
        
        icon = setRender("Coin", panel.pixelSize, panel.pixelSize);
    }
    
}
