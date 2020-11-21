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
public class Grille {
    Cellule [][] Cellules = new Cellule [6][7];//On génére la grille
    public Grille(){//On initialise chaque case 
       for (int i=0; i<6; i++){
           for (int j=0; j<7; j++){
               Cellules[i][j]=new Cellule();
           }
       }
       
    }
public boolean ajouterJetonDansColonne(Joueur JoueurCourant, int colonne){//Ici on ajoute un jeton dans la colonne
    if(colonneRemplie(colonne)==true) {//Si la colonne est remplie on ne fait rien
        return false;
    }
    else{//Si la colonne n'est pas pleine
    int i=5;
    while(Cellules[i][colonne].JetonCourant!=null){//On cherche la ligne la plus basse libre
        i--;
    }
    Jeton unJeton=JoueurCourant.retirerJeton();//Ici on décrémente le nombre de jeton
    Cellules[i][colonne].JetonCourant=unJeton;//On place le jeton
    if(Cellules[i][colonne].presenceDesintegrateur()){//On regarde si il y a un désintegrateur
        Cellules[i][colonne].recupererDesintegrateur();//On le supprime
        JoueurCourant.obtenirDesintegrateur();//On le récupère
        
    }
    if(Cellules[i][colonne].presenceTrouNoir()){//On regarde si il y a un trou noir
        Cellules[i][colonne].activerTrouNoir();//On l'active
        
    }
    return true;
    }
}
    public boolean colonneRemplie(int indColonne){//On regrade si la colonne est remplie
        return(Cellules[0][indColonne].recupererJeton()!=null);
    }
    public boolean etreRemplie(){//On regarde si la grille est pleine
    for (int i=0;i<6;i++){
        for (int j=0;j<7;j++){
            if (Cellules[i][j].JetonCourant==null){
                return false;
            }
        }
    }
        return true;
    }
public void viderGrille(){//Ici on nettoie la grille de : 
    for (int i=0;i<6;i++){
        for (int j=0;j<7;j++){
            
            Cellules[i][j].JetonCourant=null;//Ces jetons,
            if (Cellules[i][j].presenceTrouNoir()==true){//Ces trous noir,
                Cellules[i][j].trouNoir=false;
            }
            if (Cellules[i][j].presenceDesintegrateur()==true){//Ces désintégrateur.
                Cellules[i][j].desintegrateur=false;
            } 
        }
    }
}
    public void afficherGrilleSurConsole(){//On affiche la grille sur la console
        for (int i =0;i<6;i++){
            for (int j =0;j<7;j++){
                if (Cellules[i][j].trouNoir==true){//On affiche les trou noir
                    System.out.print(" T");
                    }
                else if (Cellules[i][j].desintegrateur==true){//On affiche les désintégrateur
                    System.out.print(" D");
                }
                else if (Cellules[i][j].JetonCourant==null){//On affiche les case vides
                    System.out.print(" N");   
                }
                else if (Cellules[i][j].JetonCourant!=null){//On affiche les jetons des joueurs
                    if(Cellules[i][j].JetonCourant.Couleur=="Rouge"){
                        System.out.print(" R"); 
                    }
                    else{
                        System.out.print(" J"); 
                    }
                }
            }
            System.out.println(" ");
        }
    }
    public boolean celluleOccupee(int ligne, int colonne ){//Indique si une cellule est occupée
        if (Cellules[ligne][colonne]!=null){//Ici elle est occupée on renvoie true
            return true;
        }
        return false;//Sinon on renvoie false
    }
    public String lireCouleurDuJeton(int ligne, int colonne){//On renvoie la couleur du jeton qui occupe la cellule
       return Cellules[ligne][colonne].lireCouleurDuJeton();
        
    }
public boolean etreGagnantePourJoueur(Joueur nom){//On indique les conditions de victoire
     
    String recup_couleur=nom.Couleur;   
    for (int i=0;i<3;i++){//On vérifie les colonnes
        for (int j=0;j<7;j++){
            if((Cellules[i][j].lireCouleurDuJeton()).equals(Cellules[i+1][j].lireCouleurDuJeton()) && (Cellules[i+1][j].lireCouleurDuJeton()).equals(Cellules[i+2][j].lireCouleurDuJeton()) && (Cellules[i+2][j].lireCouleurDuJeton()).equals(Cellules[i+3][j].lireCouleurDuJeton())&& Cellules[i+1][j].lireCouleurDuJeton().equals(recup_couleur)){
                return true;
            }
        }
    }
    for (int i=0;i<6;i++){//On vérifie les lignes
        for (int j=0;j<4;j++){
            if((Cellules[i][j].lireCouleurDuJeton()).equals(Cellules[i][j+1].lireCouleurDuJeton()) && (Cellules[i][j+1].lireCouleurDuJeton()).equals(Cellules[i][j+2].lireCouleurDuJeton()) && (Cellules[i][j+2].lireCouleurDuJeton()).equals(Cellules[i][j+3].lireCouleurDuJeton()) && Cellules[i][j+2].lireCouleurDuJeton().equals(recup_couleur) ){
                return true;
            }
        }
    }
    for (int i=0;i<3;i++){//On vérifie les diagonales
        for (int j=0;j<4;j++){
            if((Cellules[i][j].lireCouleurDuJeton()).equals(Cellules[i+1][j+1].lireCouleurDuJeton()) && (Cellules[i+1][j+1].lireCouleurDuJeton()).equals(Cellules[i+2][j+2].lireCouleurDuJeton()) && (Cellules[i+2][j+2].lireCouleurDuJeton()).equals(Cellules[i+3][j+3].lireCouleurDuJeton())&& Cellules[i+2][j+2].lireCouleurDuJeton().equals(recup_couleur)){
                return true;
            }
        }
    }
    for (int i=0;i<3;i++){//On vérifie les autres diagonales
        for (int j=6;j>3;j--){
            if((Cellules[i][j].lireCouleurDuJeton()).equals(Cellules[i+1][j-1].lireCouleurDuJeton()) && (Cellules[i+1][j-1].lireCouleurDuJeton()).equals(Cellules[i+2][j-2].lireCouleurDuJeton()) && (Cellules[i+2][j-2].lireCouleurDuJeton()).equals(Cellules[i+3][j-3].lireCouleurDuJeton())&&Cellules[i][j].lireCouleurDuJeton().equals(recup_couleur)){
                return true;
            } 
        }
    }
    return false;
}   
    public void tasserGrille(int ligne,int colonne){//On tasse la grille
     while (ligne>0){//On baisse les jetons à partir du supprimer
        Cellules[ligne][colonne].JetonCourant=Cellules[ligne-1][colonne].JetonCourant;
        ligne=ligne-1;
         
    }
    Cellules[0][colonne].JetonCourant=null;//On remplace le sommet de la colonne par une case vide
    }
 
   public boolean placerTrouNoir(int ligne, int colonne){//On place un trou noir 
       if(Cellules[ligne][colonne].presenceTrouNoir()==false){//On vérifie qu'il n'y en ai pas déjà un
           Cellules[ligne][colonne].placerTrouNoir();//On le place et on renvoie true
           return true;
       }
       return false;//Sinon on renvoie false
}
      public boolean placerDesintegrateur(int ligne, int colonne){//On polace un désintégrateur
       if(Cellules[ligne][colonne].presenceDesintegrateur()==false){//On vérifie qu'il n'y en a pas
           Cellules[ligne][colonne].placerDesintegrateur();//On le place et renvoie true
           return true;
        }
       return false;//Sinon on renvoie false
}
    public boolean supprimerJeton(int ligne, int colonne){//Ici on supprime un jeton
       if(Cellules[ligne][colonne].JetonCourant!=null){//Si la case n'est pas vide 
           Cellules[ligne][colonne].supprimerJeton();//On supprime le jeton et renvoie true
           return true;
       }
       return false;//Sinon on renvoie false  
}     
    public Jeton recupererJeton(int ligne, int colonne){//Ici on récupère un jeton
        return Cellules[ligne][colonne].recupererJeton();
    }
}
