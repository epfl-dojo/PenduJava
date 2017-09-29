package pendujava;

import java.util.*;

public class PenduJava {

    public static void main(String[] args) {

        String secret = definiSecret();

        String masque = creerMasque(secret);

        int nombre_de_tentatives = 5;

        while (!secret.equals(masque)) {

            char c = demanderLettreUtiliseur("Enter une lettre");
            System.out.println("Vous avez rentré la lettre " + c);
            String masque_tmp = masque;
            masque = testLettre(secret, masque, c);

            if (masque_tmp.equals(masque)) {
                // la lettre entrée n'existe pas dans le mot
                nombre_de_tentatives--;
            }
            System.out.println("Vous avez encore " + nombre_de_tentatives + " essais");

            if (nombre_de_tentatives == 0) {
                System.out.println("Vous avez perdu... LOOSSSEERRR");
                System.exit(0);
            }
            System.out.println(masque);
        }

        System.out.println("Bravo, le secret était " + secret);

    }

    public static String creerMasque(String secret) {
        String masque = "";
        // insert "_" à la place de chaque lettre du secret dans le masque
        for (int x = 0; x < secret.length(); x++) {
            masque += "_";
        }
        return masque;
    }

    public static String definiSecret() {
        return "dinosaure";
    }

    public static String testLettre(String secret, String masque, char c) {
        int index_de_la_lettre = secret.indexOf(c);
        // Si on a trouvé la lettre dans le secret
        if (index_de_la_lettre > -1) {
            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == c) {
                    masque = masque.substring(0, i) + c + masque.substring(i + 1);
                }
            }
        }
        return masque;
    }

    public static char demanderLettreUtiliseur(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        String lettre = input.nextLine();
        char c = lettre.charAt(0);
        return c;
    }
}

//faire tableau de strings choisis aléatoirement au lancement du programme
