package g58399.dev1.javl.examen;

import java.util.Scanner;

/**
 *
 * @author alecw
 */
public class LuciferGame {

    /**
     *
     * @return un tableau de 21 booléens initialisés à true pour représenter
     * l'état du jeu.
     */
    public static boolean[] initialiserJeu() {
        boolean[] etatAllumettes = new boolean[21];
        for (int i = 0; i < etatAllumettes.length; i++) {
            etatAllumettes[i] = true;
        }
        return etatAllumettes;
    }

    /**
     * Afficher le plateau du jeu
     *
     * @param jeu le plateau
     */
    public static void afficherJeu(boolean[] jeu) {
        for (int i = 0; i < 9; i++) {
            System.out.print(i + 1 + "  ");
        }
        for (int i = 0; i < 12; i++) {
            System.out.print(i + 10 + " ");
        }
        System.out.println();

        for (int i = 0; i < jeu.length; i++) {
            if (jeu[i] == true) {
                System.out.print("|  ");
            } else {
                System.out.print("   ");
            }
        }
        System.out.println();

    }

    /**
     * Cette methode va compter combien d'allumette il y a sur le plateau de
     * jeu.
     *
     * @param jeu Le tableau d'etat de jeu qui dit si il y a une allumette il y
     * a true et inversement.
     * @return Le nombre d'allumette qui reste.
     */
    public static int nombreAllumettesRestantes(boolean[] jeu) {
        int compteur = 0;
        // nous parcouront tout le tableau d'état jeu
        for (int i = 0; i < jeu.length; i++) {
            if (jeu[i] == true) { //Si a la pos i du tab la valeur est true;
                compteur++; // alors on ajoute 1 au compteur;
            }
        }
        return compteur;
    }

    /**
     * Ici cette methode va demander le nombre d'allumette que veut jouer le
     * joueur actuel
     *
     * @param message "Entrez votre choix (1,2 ou 3 allumettes)"
     * @param jeu Le tableau d'etat de jeu qui dit si il y a une allumette il y
     * a true et inversement.
     * @return un nombre entre 1 et 3 qui est le nombre d'allumette que
     * l'utilisateur veut prendre.
     */
    public static int choisirNombreAllumettes(String message, boolean[] jeu) {
        int nbreAllumettes = demandeLecture(message);
        int nombresAllumettesRestantes = nombreAllumettesRestantes(jeu);
        switch (nombresAllumettesRestantes) {
            case 1:
                System.out.println("Il ne reste plus qu'une allumette");
                break;
            case 2:
                System.out.println("Il ne reste plus que deux allumettes");
                break;
            case 3:
                System.out.println("il ne reste plus qu'une allumette");
                break;
            default:
                break;
        }
        while (nbreAllumettes > 3 || nbreAllumettes < 1 || nombresAllumettesRestantes < nbreAllumettes) {
            System.out.println("Choix refusé !");
            nbreAllumettes = demandeLecture(message);
        }

        return nbreAllumettes;

    }

    /**
     *
     * @param message
     * @return L'entier introduit au clavier de facon robuste.
     */
    public static int demandeLecture(String message) {
        Scanner clavier = new Scanner(System.in);
        System.out.println(message);
        while (!clavier.hasNextInt()) { // si l'entrée n'est pas saisie n'est pas un entier. 
            clavier.next();// on n'en fais rien, on attend une nouvelle entrez
            System.out.println("Choix refusé !");
            System.out.println(message);
        }
        return clavier.nextInt();
    }

    /**
     * Va faire une demande robuste pour choisir la position d'une allumette
     * dans le tableau du jeux selon certaine condition
     *
     * @param message "Selectionner une allumette : "
     * @param jeu Le plateau qui est le tableau d'etat des allumettes.
     * @return La position de l'allumette en question.
     */
    public static int sélectionnerPositionAllumette(String message, boolean[] jeu) {
        int positionDemandée = demandeLecture(message);
        positionDemandée -= 1;
        while (positionDemandée > 20 || positionDemandée < 0 || jeu[positionDemandée] == false) {
            System.out.println("Allumette non disponible!");
            positionDemandée = demandeLecture(message);
            positionDemandée -= 1;
        }

        return positionDemandée;
    }

    /**
     * Cette methode va nous permettre 3 choses 1 selectionner plusieur
     * allumettre en fonction du nombre d'allumette choisis 2 va afficher l'etat
     * du jeu 3 va mettre a jour l'etat du jeux en mettant false a l'allumette
     * choisis la retirant du jeux.
     *
     * @param message "Sélectionner une allumette : "
     * @param jeu Le plateau qui est le tableau d'etat des allumettes.
     * @param nombreAllumettes nombre d'allumette choisis par l'utilisateur.
     */
    public static void sélectionnerAllumettes(String message, boolean[] jeu, int nombreAllumettes) {
        for (int i = 0; i < nombreAllumettes; i++) {
            int position = sélectionnerPositionAllumette(message, jeu);
            jeu[position] = false;
            afficherJeu(jeu);

        }
    }

    /**
     *
     * @param jeu Le plateau qui est le tableau d'etat des allumettes.
     * @return true si il n'y as plus d'allumette c-à-d que le tableau est
     * remplie de false et false dans le cas contraire;
     */
    public static boolean finDuJeu(boolean[] jeu) {
        return nombreAllumettesRestantes(jeu) == 0;

    }

    /**
     *
     * @param joueurCourant Le numero du joueur actuel.
     * @return Le numero du joueur suivant. Si le numero du joueur actuel n'est
     * pas 1 ou 2 il lance une exception.
     */
    public static int joueurSuivant(int joueurCourant) {

        switch (joueurCourant) {
            case 1:
                return 2;
            case 2:
                return 1;
            default:
                throw new IllegalArgumentException("Il ne peut y avoir plus de deux joueurs ou moins d'un joueur " + joueurCourant);
        }
    }

    /**
     * ici est fusionner le controlleur ainsi que le main de la partie Cette
     * methode va nous permettre d'initialiser tout la vue le model du jeu et
     * lancer une partie.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("                          Hello World!");
        System.out.println("               Bienvenue dans le jeu des allumettes !!");
        System.out.println();
        boolean[] jeu = initialiserJeu();
        int joueurCourant = 2;

        do { // fais sa d'abord et puis refais le tant que la condition n'est pas remplie.
            joueurCourant = joueurSuivant(joueurCourant);
            System.out.println("joueur " + joueurCourant);
            int nombresAllumettes = nombreAllumettesRestantes(jeu);
            System.out.println("Il reste : " + nombresAllumettes);
            afficherJeu(jeu);
            int nombresAllumettesSelectionnée = choisirNombreAllumettes("Entrez votre choix (1,2 ou 3 allumettes) ", jeu);
            sélectionnerAllumettes("Sélectionner une allumette: ", jeu, nombresAllumettesSelectionnée);

        } while (!finDuJeu(jeu));
        // fais sa d'abord et puis refais le tant que la condition n'est pas remplie.
        System.out.println("Félécitation joueur gagnant : " + joueurSuivant(joueurCourant));
        System.out.println("Merci d'avoir jouer au jeux << Comment ne pas mettre le feu à ton examen en enlevant toute les allumettes ;) >>");

    }

}
