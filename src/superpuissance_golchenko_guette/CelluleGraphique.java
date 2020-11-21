/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superpuissance_golchenko_guette;

import javax.swing.JButton;

/**
 *
 * @author dagou
 */
public class CelluleGraphique extends JButton{
    Cellule celluleAssocie;
    public CelluleGraphique (Cellule uneCellule) {
        celluleAssocie=uneCellule;  
    } 
}
