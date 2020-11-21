/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superpuissance_golchenko_guette;

/**
 *
 * @author dagou
 */
public class Jeton {
    String Couleur;//On crée une variable couleur
    public Jeton(String uneCouleur){ //On initialise la couleur du jeton avec le paramètre
        Couleur=uneCouleur;
        
        
    }
    public String lireCouleur(){//Renvoie la couleur du jeton
      return Couleur;
    }
    @Override
    public String toString(){//On remplace la couleur par l'initial et la couleur d'affichage associé
        if("Rouge".equals(Couleur)){
            return " R"+"\u001B[31m 0 ";
        }
        return " J"+"\u001B[33m 0 ";
    }
}
