/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superpuissance_golchenko_guette;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author dagou
 */
public class CelluleGraphique extends JButton {

    Cellule celluleAssocie;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_desintegrateur = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_Jaune = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_Rouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_trouNoir = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));

    public CelluleGraphique(Cellule uneCellule) {
        celluleAssocie = uneCellule;
    }

    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        if (celluleAssocie.presenceTrouNoir() == true) {
            setIcon(img_trouNoir);
        } else if (celluleAssocie.presenceDesintegrateur() == true) {
            setIcon(img_desintegrateur);
        } else {
            String couleurJeton = celluleAssocie.lireCouleurDuJeton();
            switch (couleurJeton) {
                case "Jaune":
                    setIcon(img_Jaune);
                    break;
                case "Rouge":
                    setIcon(img_Rouge);
                    break;
                case "pas de jeton":
                    setIcon(img_vide);
                    break; 
            }
        }
    }
}
