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
    boolean trouNoir;
    boolean desintegrateur;
    Jeton JetonCourant;
     
    public Cellule(){
        JetonCourant=null;
        trouNoir=false;
        desintegrateur=false;
    }   
    public boolean affecterJeton(Jeton LeJetonCourrant){
        if (JetonCourant==null){
            JetonCourant=LeJetonCourrant;
           return true;
        }
        return false;
    }
    public Jeton recupererJeton(){
       return JetonCourant;
    }
    public boolean supprimerJeton(){
       if (JetonCourant!=null){
           JetonCourant=null;
           return true;
       }
       return false;
    }
    public boolean placerTrouNoir(){
        if (trouNoir==true){
            return false;
        }
        else{
            trouNoir=true;
            return true;
        }
    }
    public boolean placerDesintegrateur(){
        if (desintegrateur==true){
            return false;
        }
        else{
            desintegrateur=true;
            return true;
        }
    }
    public boolean presenceDesintegrateur(){
       return desintegrateur;
    }
    public boolean presenceTrouNoir(){
        return trouNoir;
    }
    
    public String lireCouleurDuJeton(){
        if (JetonCourant==null){
            return "pas de jeton";
        }
        return JetonCourant.Couleur;
    }
    public boolean recupererDesintegrateur(){
        if (desintegrateur==true){
            desintegrateur=false;
            return true;
        }
        return false;
    }
    public boolean activerTrouNoir(){
        if (trouNoir==true){
            trouNoir=false;
            supprimerJeton();
            return true;
        }
        return false;
    }
}