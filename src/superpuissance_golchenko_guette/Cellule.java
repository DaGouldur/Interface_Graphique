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
public class Cellule {
    //Ici on cré les variables que l'on vat utiliser 
    boolean trouNoir;
    boolean desintegrateur;
    Jeton JetonCourant;
     
    public Cellule(){//On initialise les variables avec des valeurs par défaut
        JetonCourant=null;
        trouNoir=false;
        desintegrateur=false;
    }   
    public boolean affecterJeton(Jeton LeJetonCourrant){//On ajoute le jeton en	paramètre à la	cellule
        if (JetonCourant==null){//Ici on renvoie true si l'ajout c'est bien passé
            JetonCourant=LeJetonCourrant;
           return true;
        }
        return false;// Renvoie false sinon
    }
    public Jeton recupererJeton(){//Renvoie la référence vers le jeton de la cellule
       return JetonCourant;
    }
    public boolean supprimerJeton(){//On supprime le jeton 
       if (JetonCourant!=null){//Ici on renvoie true si c'est possible
           JetonCourant=null;
           return true;
       }
       return false;//Sinon on renvoie false
    }
    public boolean placerTrouNoir(){//Ajoute un trou noir 
        if (trouNoir==true){//S'il y a déjà un trou noir renvoie false
            return false;
        }
        else{//Ici on place le trou noir et on renvoie true
            trouNoir=true;
            return true;
        }
    }
    public boolean placerDesintegrateur(){//Ajoute un désintégrateur
        if (desintegrateur==true){//S'il y a déjà un désintégrateur renvoie false
            return false;
        }
        else{//Ici on place le désintégrateur et on renvoie true
            desintegrateur=true;
            return true;
        }
    }
    public boolean presenceDesintegrateur(){//Renvoie true si il y a un désintégrateur
       return desintegrateur;
    }
    public boolean presenceTrouNoir(){//Renvoie true si il y a un trou noir
        return trouNoir;
    }
    
    public String lireCouleurDuJeton(){//Renvoie la couleur du jeton de la cellule
        if (JetonCourant==null){//Ici on traîte le cas si il n'y a pas de jeton
            return "pas de jeton";
        }
        return JetonCourant.Couleur;//Renvoie la couleur du jeton 
    }
    public boolean recupererDesintegrateur(){//Récupère un désintégrateur
        if (desintegrateur==true){//Si il y a un désintégrateur
            desintegrateur=false;//Il efface le désintégrateur
            return true;
        }
        return false;//Renvoi false sinon
    }
    public boolean activerTrouNoir(){//Active le trou noir
        if (trouNoir==true){//Si il en a un :
            trouNoir=false;//On l'efface
            supprimerJeton();//On supprime le jeton de la case
            return true;
        }
        return false;//Renvoie false si il n'y a pas de trou noir
    }
}