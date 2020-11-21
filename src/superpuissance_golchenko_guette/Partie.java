/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superpuissance_golchenko_guette;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dagou
 */
public class Partie {
    Joueur []  ListeJoueurs = new Joueur[2];
    Grille GrilleJeu=new Grille();
    Joueur JoueurCourant; 
    
    public void attribuerCouleursAuxJoueurs(){
        Random rand= new Random();
        boolean couleur;
        couleur=rand.nextBoolean();
        if (couleur==true){
            ListeJoueurs[0].Couleur="Rouge";
            ListeJoueurs[1].Couleur="Jaune";
        }
        else{
             ListeJoueurs[0].Couleur="Jaune";  
             ListeJoueurs[1].Couleur="Rouge";
        }
        
    }
    public Joueur prochainJoueur(Joueur UnJoueur){
        if (ListeJoueurs[0]==JoueurCourant){
            return ListeJoueurs[1];
        }
        return ListeJoueurs[0];
    }
    public void initialiserPartie(){
        GrilleJeu.viderGrille();
        Random rand= new Random();
        Scanner sc=new Scanner(System.in);
        System.out.println("Pseudo du premier joueur: ");
        Joueur J1=new Joueur(sc.nextLine());
        System.out.println("Pseudo du second joueur: ");
        Joueur J2=new Joueur(sc.nextLine());
        ListeJoueurs[0]=J1;
        ListeJoueurs[1]=J2;
        attribuerCouleursAuxJoueurs();
        System.out.println(J1.Couleur+" est attribué au joueur "+J1.Nom);
        System.out.println(J2.Couleur+" est attribué au joueur "+J2.Nom);
        boolean lePremier=rand.nextBoolean();
        if(lePremier==true){
            JoueurCourant=ListeJoueurs[0];
        }
        else{
            JoueurCourant=ListeJoueurs[1];
        }
        for(int i=0;i<21;i++){
            J1.ajouterJeton(new Jeton(J1.Couleur));
            J2.ajouterJeton(new Jeton(J2.Couleur));
        }
        for(int i=0;i<2;i++){
            int ligneTrouNoirDes=rand.nextInt(6);
            int colonneTrouNoirDes=rand.nextInt(7);
            GrilleJeu.placerDesintegrateur(ligneTrouNoirDes, colonneTrouNoirDes);
            GrilleJeu.placerTrouNoir(ligneTrouNoirDes, colonneTrouNoirDes);
            }
        for(int i=0;i<3;i++){
            int ligneTrouNoir=rand.nextInt(6);
            int colonneTrouNoir=rand.nextInt(7);
            if(GrilleJeu.Cellules[ligneTrouNoir][colonneTrouNoir].presenceDesintegrateur()==false){
            GrilleJeu.placerTrouNoir(ligneTrouNoir, colonneTrouNoir);   
            }
        }
        for(int i=0;i<3;i++){
            String DesPlace=new String();
            DesPlace="";
            while(DesPlace==""){
            int ligneDesintegrateur=rand.nextInt(6);
            int colonneDesintegrateur=rand.nextInt(7);
                if(GrilleJeu.Cellules[ligneDesintegrateur][colonneDesintegrateur].presenceDesintegrateur()==false){
                    if(GrilleJeu.Cellules[ligneDesintegrateur][colonneDesintegrateur].presenceTrouNoir()==false);
                        GrilleJeu.placerDesintegrateur(ligneDesintegrateur, colonneDesintegrateur);
                    DesPlace="ok";
                }
            }
        }
        GrilleJeu.afficherGrilleSurConsole();
        }
    public void debuterPartie(){
    initialiserPartie();
    int action;
    Scanner sc = new Scanner(System.in);
    do{
        System.out.println("");
        System.out.println(JoueurCourant.Nom+", c'est ton tour! "+"("+JoueurCourant.Couleur+")");
        System.out.println("");
        System.out.println("Il te reste "+JoueurCourant.nombreJetonsRestants+" jetons");
        System.out.println("");
        System.out.println("Tu as "+JoueurCourant.nombreDesintegrateurs+" désintégrateurs");
        System.out.println("");
        System.out.println("Que voulez vous faire?");
        System.out.println("1/ placer un jeton");
        System.out.println("2/ désintégrer un jeton");
        System.out.println("3/ récupérer un jeton ");
        action = sc.nextInt(); 
            switch (action) {
                case 1 :
                    if (JoueurCourant.nombreJetonsRestants==0){
                        System.out.println("Tu n'as plus de jeton!");
                        break;
                    }
                    System.out.println("Choisis la colonne ou tu veux ajouter le jeton.");
                    int colonne = sc.nextInt();
                    while (colonne<1||colonne>7){
                        System.out.println("Cette colonne n'existe pas!");
                        colonne = sc.nextInt();
                    }
                    while(GrilleJeu.colonneRemplie(colonne-1)){
                        System.out.println("Cette colonne est pleine!");
                        colonne = sc.nextInt();
                    }
                    GrilleJeu.ajouterJetonDansColonne(JoueurCourant,colonne-1);
                    System.out.println(JoueurCourant.nombreJetonsRestants);
                    GrilleJeu.afficherGrilleSurConsole();
                    if (JoueurCourant==ListeJoueurs[0]){
                        JoueurCourant=ListeJoueurs[1]; 
                    }
                    else{
                        JoueurCourant=ListeJoueurs[0];      
                    }
                    break;  
                case 2 :
                    if (JoueurCourant.utiliserDesintegrateur()==false){
                        System.out.println("Vous n'avez pas de désintégrateur!");
                        break;
                    }
                    System.out.println("Choisir la ligne du jeton que vous voulez désintégrer");
                    int lignedesintegration = sc.nextInt();
                    while (lignedesintegration<1||lignedesintegration>6){
                        System.out.println("Cette ligne n'existe pas!");
                        lignedesintegration = sc.nextInt();
                    }
                    System.out.println("Choisir la colonne du jeton que vous voulez désintégrer");
                    int colonnedesintegration = sc.nextInt();
                    while (colonnedesintegration<1||colonnedesintegration>7){
                        System.out.println("Cette colonne n'existe pas!");
                        colonnedesintegration = sc.nextInt();
                    }
                    JoueurCourant.utiliserDesintegrateur();
                    // le joueur ne peut desintegrer qu'un jeton de la couleur advrese
                    while (JoueurCourant.Couleur == GrilleJeu.lireCouleurDuJeton(lignedesintegration-1, colonnedesintegration-1)||GrilleJeu.supprimerJeton(6-lignedesintegration, colonnedesintegration-1)==false){
                        System.out.println("Choisir une cellule ou un jeton adverse est placé.");
                        System.out.println("Choisir la ligne du jeton que vous voulez désintégrer");
                        lignedesintegration = sc.nextInt();
                        while (lignedesintegration<1||lignedesintegration>6){
                            System.out.println("Cette ligne n'existe pas, veuillez saisir une ligne valide");
                            lignedesintegration = sc.nextInt();
                        }
                        System.out.println("Choisir la colonne du jeton que vous voulez désintégrer");
                        colonnedesintegration = sc.nextInt();
                        while (colonnedesintegration<1||colonnedesintegration>7){
                            System.out.println("Cette colonne n'existe pas, veuillez saisir une colonne valide");
                            colonnedesintegration = sc.nextInt();
                        }
                    }
                    GrilleJeu.supprimerJeton(6-lignedesintegration, colonnedesintegration-1);
                    GrilleJeu.tasserGrille(6-lignedesintegration,colonnedesintegration-1);
                    GrilleJeu.afficherGrilleSurConsole();
                    if (JoueurCourant==ListeJoueurs[0]){
                        JoueurCourant=ListeJoueurs[1];
                    }
                    else{
                        JoueurCourant=ListeJoueurs[0];
                    }
                    break;
                case 3 :
                    if (JoueurCourant.nombreJetonsRestants==21){
                        System.out.println("Vous avez tout vos jetons!");
                        break;
                    }
                    System.out.println("Choisir la ligne du jeton que vous voulez récupérer");
                    int lignerecupe = sc.nextInt();
                    while (lignerecupe<1||lignerecupe>6){
                        System.out.println("Cette ligne n'existe pas!");
                        lignerecupe = sc.nextInt();
                    }
                    System.out.println("Choisir la colonne du jeton que vous voulez récupérer");
                    int colonnerecupe = sc.nextInt();
                    while (colonnerecupe<1||colonnerecupe>7){
                        System.out.println("Cette colonne n'existe pas!");
                        colonnerecupe = sc.nextInt();
                    }
                    while (GrilleJeu.lireCouleurDuJeton(lignerecupe-1, colonnerecupe-1)!=JoueurCourant.Couleur||GrilleJeu.supprimerJeton(lignerecupe-1, colonnerecupe-1)==false){
                        System.out.println("Selectionner une cellule contenant un de vos jetons");
                        System.out.println("Choisir la ligne du jeton que vous voulez récupérer");
                        lignerecupe = sc.nextInt();
                        while (lignerecupe<1||lignerecupe>6){
                            System.out.println("Cette ligne n'existe pas!");
                            lignerecupe = sc.nextInt();
                        }
                        System.out.println("Choisir la colonne du jeton que vous voulez désintégrer");
                        colonnerecupe = sc.nextInt();
                        while (colonnerecupe<1||colonnerecupe>7){
                            System.out.println("Cette colonne n'existe pas!");
                            colonnerecupe = sc.nextInt();
                        }
                    }
                    Jeton jeton_a_recuperer=GrilleJeu.recupererJeton(lignerecupe-1, colonnerecupe-1);
                    GrilleJeu.supprimerJeton(lignerecupe-1, colonnerecupe-1);
                    GrilleJeu.tasserGrille(lignerecupe-1,colonnerecupe-1);
                    JoueurCourant.ajouterJeton(jeton_a_recuperer);
                    GrilleJeu.afficherGrilleSurConsole();
                    if (JoueurCourant==ListeJoueurs[0]){
                        JoueurCourant=ListeJoueurs[1];
                    }
                    else{
                        JoueurCourant=ListeJoueurs[0];
                    }   
                    break;
            }
    }while (GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[0])==false&&GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])==false&&GrilleJeu.etreRemplie()==false);
    if (GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])==true){
        System.out.println(ListeJoueurs[1].Nom+" a gagné!!!");
    }
    if (GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[0])==true){
        System.out.println(ListeJoueurs[0].Nom+" a gagné");
    }
}
}