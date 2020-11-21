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
    //On génére différentes variables utilisées par la suite
    String Nom;
    String Couleur;
    int  nombreDesintegrateurs = 0;
    int nombreJetonsRestants;
    Jeton [] ListeJetons = new Jeton [21];
    
    public Joueur(String Lenom){//On initialise le nom du joueur
        Nom = Lenom;
    }
    public void affecterCouleur(String Lacouleur){//Affecte une couleur à chaque joueurs
        Couleur = Lacouleur;
    }
    
    public boolean ajouterJeton(Jeton UnJeton){//Ajoute le jeton passé en paramètre à la liste des jetons si on possède moins de 21 jetons
    if (nombreJetonsRestants >=21){//Ici on limite à 21 jetons
        return false;
    }
    else{//Ici on ajoute un jeton car on a moins de 21 jetons
        ListeJetons[nombreJetonsRestants]=UnJeton ;
        nombreJetonsRestants++;
        return true;
    }
    }
    
    public void obtenirDesintegrateur(){//Incrémente le nombre de désintégrateurs du joueur
       nombreDesintegrateurs= nombreDesintegrateurs+1;
    } 
    public boolean utiliserDesintegrateur(){//Ici on utilise les désintégrateurs
        if (nombreDesintegrateurs==0){//Ici on empêche d'utiliser un désingrateurs si on en a pas
            return false;
        }
        else {//Ici on décrémente le désintégrateurs 
            nombreDesintegrateurs = nombreDesintegrateurs-1;
            return true;
        }
    }
    public Jeton retirerJeton(){//Ici on décrémente le nombre de jetons
        nombreJetonsRestants=nombreJetonsRestants-1;
        return ListeJetons[nombreJetonsRestants];
    }
}
