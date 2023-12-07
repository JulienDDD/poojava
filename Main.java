import src.Model.*;
import java.util.Scanner;
import java.util.Objects;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            int point = 100;
            Scanner sc = new Scanner(System.in);
            System.out.println("Menu du jeu");
            System.out.println("1 - Crée un nouveau personnage");
            System.out.println("2 - Acheter des objets");
            String answer = sc.nextLine();
            if (Objects.equals(answer, "1")) {
                System.out.println("***** Creation de personnage *****");
                System.out.println("Donne toi un nom");
                String name = sc.nextLine();
                System.out.println("d'accord ton nom est : " + name);
                System.out.println("Tu as 100 point de disponible pour les mettre dans tes stats \n combien de point dans pv ?");
                String pointsPv = sc.nextLine();
                point -= Integer.parseInt(pointsPv);
                System.out.println("il te reste " + point + " point de disponible pour les mettre dans tes stats \n combien de point dans ta puissance ?");
                String pointsP = sc.nextLine();
                Joueur j = new Joueur(name, Integer.parseInt(pointsPv), Integer.parseInt(pointsP), 1);
                System.out.println("Ton personnage a " + j.getPv() + "pv et " + j.getPuissance() + " de puissance");
                // Création d'un fileWriter pour écrire dans un fichier
                FileWriter fileWriter = new FileWriter("/Users/batai/IdeaProjects/poojava/config", false);

                // Création d'un bufferedWriter qui utilise le fileWriter
                BufferedWriter writer = new BufferedWriter(fileWriter);

                // ajout d'un texte à notre fichier
                writer.write("Nom : " + j.getNom() +" Pv : " + j.getPv() + " Puissance : " + j.getPuissance());

                // Retour à la ligne
                writer.newLine();

                writer.close();

                // Création d'un fileReader pour lire le fichier
                FileReader fileReader = new FileReader("/Users/batai/IdeaProjects/poojava/config");

                // Création d'un bufferedReader qui utilise le fileReader
                BufferedReader reader = new BufferedReader(fileReader);

                // une fonction à essayer pouvant générer une erreur
                String line = reader.readLine();

                while (line != null) {
                    // affichage de la ligne
                    System.out.println(line);
                    // lecture de la prochaine ligne
                    line = reader.readLine();
                }
                reader.close();
            }
            else if (Objects.equals(answer, "2")) {

                System.out.println("voici la boutique d'objets");
                System.out.println("\n 1 - Potion de poison \n 2 - Potion de vie \n 3 - Jambieres \n 4 - Epées \n 5 - Armures \n 6 - Arc \n 7 - Plastrons \n 8 - WaterGun");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}