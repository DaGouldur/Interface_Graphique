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
public class Joueur {
    String Nom;
    String Couleur;
    int  nombreDesintegrateurs = 0;
    int nombreJetonsRestants;
    Jeton [] ListeJetons = new Jeton [21];
    
    public Joueur(String Lenom){
        Nom = Lenom;
    }
    public void affecterCouleur(String Lacouleur){
        Couleur = Lacouleur;
    }
    
    public boolean ajouterJeton(Jeton UnJeton){
    if (nombreJetonsRestants >=21){// on ne peut pas posseder plus de 21 jetons
        return false;
    }
    else{// ajoute le jeton passé en parametre a la liste des jetons
        ListeJetons[nombreJetonsRestants]=UnJeton ;
        nombreJetonsRestants++;
        return true;
    }
    }
    
    public void obtenirDesintegrateur(){
       nombreDesintegrateurs= nombreDesintegrateurs+1;
    } 
    public boolean utiliserDesintegrateur(){
        if (nombreDesintegrateurs==0){
            return false;
        }
        else {
            nombreDesintegrateurs = nombreDesintegrateurs-1;
            return true;
        }
    }
    public Jeton retirerJeton(){
        nombreJetonsRestants=nombreJetonsRestants-1;
        return ListeJetons[nombreJetonsRestants];
    }
}
