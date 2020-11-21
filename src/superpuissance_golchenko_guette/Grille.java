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
     Cellule [][] Cellules = new Cellule [6][7];
    public Grille(){
       for (int i=0; i<6; i++){
           for (int j=0; j<7; j++){
               Cellules[i][j]=new Cellule();
           }
       }
       
    }
public boolean ajouterJetonDansColonne(Joueur JoueurCourant, int colonne){
    if(colonneRemplie(colonne)==true) {//si la colonne est remplie on ne peut pas rajouter de jeton
        return false;
    }
    int i=5;// on ajoute le jeton dans la colonne ciblee sur la cellule vide la plus basse
    while(Cellules[i][colonne].JetonCourant!=null){
        i--;
    }
    Jeton unJeton=JoueurCourant.retirerJeton();
    Cellules[i][colonne].JetonCourant=unJeton;
    if(Cellules[i][colonne].presenceDesintegrateur()){
        Cellules[i][colonne].recupererDesintegrateur();
        JoueurCourant.obtenirDesintegrateur();// si le jeton se retrouve sur la cellule d'un desintegrateur, le jour le recupere
        
    }
    if(Cellules[i][colonne].presenceTrouNoir()){
        Cellules[i][colonne].activerTrouNoir();// si le jeton se retrouve sur la case d'un trou noir il disparait et la cellule devient basique
        
    }
    return true;
}
    public boolean colonneRemplie(int indColonne){
        return(Cellules[0][indColonne].recupererJeton()!=null);
    }
    public boolean etreRemplie(){
    for (int i=0;i<6;i++){
        for (int j=0;j<7;j++){
            if (Cellules[i][j].JetonCourant==null){
                return false;
            }
        }
    }
        return true;
    }
public void viderGrille(){
    for (int i=0;i<6;i++){
        for (int j=0;j<7;j++){
            
            Cellules[i][j].JetonCourant=null;// supprime les jetons
            if (Cellules[i][j].presenceTrouNoir()==true){// supprime ls trous noirs
                Cellules[i][j].trouNoir=false;
            }
            if (Cellules[i][j].presenceDesintegrateur()==true){// supprime les desintegrateurs
                Cellules[i][j].desintegrateur=false;
            } 
        }
    }
}
    public void afficherGrilleSurConsole(){
        for (int i =0;i<6;i++){
            for (int j =0;j<7;j++){
                if (Cellules[i][j].trouNoir==true){
                    System.out.print(" T");
                    }
                else if (Cellules[i][j].desintegrateur==true){
                    System.out.print(" D");
                }
                else if (Cellules[i][j].JetonCourant==null){
                    System.out.print(" N");   
                }
                else if (Cellules[i][j].JetonCourant!=null){
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
    public boolean celluleOccupee(int ligne, int colonne ){
        if (Cellules[ligne][colonne]!=null){
            return true;
        }
        return false;
    }
    public String lireCouleurDuJeton(int ligne, int colonne){
       return Cellules[ligne][colonne].lireCouleurDuJeton();
        
    }
public boolean etreGagnantePourJoueur(Joueur nom){
     
    String recup_couleur=nom.Couleur;   
    for (int i=0;i<3;i++){// 4 jetons de la meme couleur sur la meme ligne
        for (int j=0;j<7;j++){
            if((Cellules[i][j].lireCouleurDuJeton()).equals(Cellules[i+1][j].lireCouleurDuJeton()) && (Cellules[i+1][j].lireCouleurDuJeton()).equals(Cellules[i+2][j].lireCouleurDuJeton()) && (Cellules[i+2][j].lireCouleurDuJeton()).equals(Cellules[i+3][j].lireCouleurDuJeton())&& Cellules[i+1][j].lireCouleurDuJeton().equals(recup_couleur)){
                return true;
            }
        }
    }
    for (int i=0;i<6;i++){// 4 jetons de la meme couleur sur la meme colonne
        for (int j=0;j<4;j++){
            if((Cellules[i][j].lireCouleurDuJeton()).equals(Cellules[i][j+1].lireCouleurDuJeton()) && (Cellules[i][j+1].lireCouleurDuJeton()).equals(Cellules[i][j+2].lireCouleurDuJeton()) && (Cellules[i][j+2].lireCouleurDuJeton()).equals(Cellules[i][j+3].lireCouleurDuJeton()) && Cellules[i][j+2].lireCouleurDuJeton().equals(recup_couleur) ){
                return true;
            }
        }
    }
    for (int i=0;i<3;i++){// 4 jetons de la meme couleur en diagonal 
        for (int j=0;j<4;j++){
            if((Cellules[i][j].lireCouleurDuJeton()).equals(Cellules[i+1][j+1].lireCouleurDuJeton()) && (Cellules[i+1][j+1].lireCouleurDuJeton()).equals(Cellules[i+2][j+2].lireCouleurDuJeton()) && (Cellules[i+2][j+2].lireCouleurDuJeton()).equals(Cellules[i+3][j+3].lireCouleurDuJeton())&& Cellules[i+2][j+2].lireCouleurDuJeton().equals(recup_couleur)){
                return true;
            }
        }
    }
    for (int i=0;i<3;i++){// 4 jetons de la meme couleur en diagonal
        for (int j=6;j>3;j--){
            if((Cellules[i][j].lireCouleurDuJeton()).equals(Cellules[i+1][j-1].lireCouleurDuJeton()) && (Cellules[i+1][j-1].lireCouleurDuJeton()).equals(Cellules[i+2][j-2].lireCouleurDuJeton()) && (Cellules[i+2][j-2].lireCouleurDuJeton()).equals(Cellules[i+3][j-3].lireCouleurDuJeton())&&Cellules[i][j].lireCouleurDuJeton().equals(recup_couleur)){
                return true;
            } 
        }
    }
    return false;
}   
    public void tasserGrille(int ligne,int colonne){
     while (ligne>0){
        Cellules[ligne][colonne].JetonCourant=Cellules[ligne-1][colonne].JetonCourant;
        ligne=ligne-1;
         
    }
    Cellules[0][colonne].JetonCourant=null;
    }
 
   public boolean placerTrouNoir(int ligne, int colonne){
       if(Cellules[ligne][colonne].presenceTrouNoir()==false){
           Cellules[ligne][colonne].placerTrouNoir();
           return true;
       }
       return false;    
}
      public boolean placerDesintegrateur(int ligne, int colonne){
       if(Cellules[ligne][colonne].presenceDesintegrateur()==false){
           Cellules[ligne][colonne].placerDesintegrateur();
           return true;
        }
       return false;    
}
    public boolean supprimerJeton(int ligne, int colonne){
       if(Cellules[ligne][colonne].JetonCourant!=null){
           Cellules[ligne][colonne].supprimerJeton();
           return true;
       }
       return false;    
}     
    public Jeton recupererJeton(int ligne, int colonne){
        return Cellules[ligne][colonne].recupererJeton();
    }
}
