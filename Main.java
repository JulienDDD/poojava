import src.Model.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Objects;
import java.io.*;

public class Main {

    public static Arme choisirSelonRarete(List<Arme> liste) {
        Random random = new Random();
        int r = random.nextInt(3) + 1;

        List<Arme> filtres = new ArrayList<>();
        for (Arme arme : liste) {
            if (arme.getRarete() % r == 0) {
                filtres.add(arme);
            }
        }

        if (!filtres.isEmpty()) {
            int indexChoisi = random.nextInt(filtres.size());
            return filtres.get(indexChoisi);
        }

        return null;
    }

    public static void main(String[] args) {

        List<Arme> listeArmes = new ArrayList<>();

        listeArmes.add(new Arme("Epee", 1, 10));
        listeArmes.add(new Arme("Hache", 1, 15));
        listeArmes.add(new Arme("Dague", 1, 6));
        listeArmes.add(new Arme("Machette", 1, 10));
        listeArmes.add(new Arme("Masse", 2, 18));
        listeArmes.add(new Arme("Gode", 3, 99));
        listeArmes.add(new Arme("Arc", 2, 12));
        listeArmes.add(new Arme("Ciseaux", 2, 5));
        listeArmes.add(new Arme("Bombe", 2, 20));
        listeArmes.add(new Arme("Pistolet à eau", 1, 1));
        listeArmes.add(new Arme("Lance", 1, 15));



        int point = 100;
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu du jeu");
        System.out.println("1 - Crée un nouveau personnage");
        System.out.println("2 - Acheter des objets");
        System.out.println("3 - Combattre");
        String answer = sc.nextLine();
        if (Objects.equals(answer, "1")) {
            System.out.println("***** Creation de personnage *****");
            System.out.println("Donne toi un nom");
            String name = sc.nextLine();
            System.out.println("d'accord ton nom est : " + name);
            System.out.println("Tu as 100 point de disponible à répartir dans tes pv et ta puissance. \nCombien de pointveux tu mettre dans tes pv ?");
            int pointsPv = Integer.parseInt(sc.nextLine());
            int pointsP = point-pointsPv;
            Joueur j = new Joueur(name, pointsPv, pointsP, 1);
            System.out.println("Ton personnage a " + j.getPv() + "pv et " + j.getPuissance() + " de puissance");

            // Création d'un fileWriter pour écrire dans un fichier
            /**FileWriter fileWriter = new FileWriter("/Users/batai/IdeaProjects/poojava/config", false);

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
            reader.close();**/
        }
        else if (Objects.equals(answer, "2")) {

            System.out.println("voici la boutique d'objets");
            System.out.println("\n 1 - Potion de poison \n 2 - Potion de vie \n 3 - Jambieres \n 4 - Epées \n 5 - Armures \n 6 - Arc \n 7 - Plastrons \n 8 - WaterGun");
        }
        else if (Objects.equals(answer, "3")) {
            List<String>lstEnnemi = new ArrayList<String>();
            lstEnnemi.add("Minautore");
            lstEnnemi.add("Gobelin");
            lstEnnemi.add("Gnome");
            lstEnnemi.add("Satyr");
            lstEnnemi.add("Troll");
            lstEnnemi.add("Orc");
            Random ran = new Random();
            int pvEnnemi = ran.nextInt();
            int indexAleatoire = ran.nextInt(lstEnnemi.size());
            String ennemiAleatoire = lstEnnemi.get(indexAleatoire);
            Arme armeChoisie = choisirSelonRarete(listeArmes);

            Ennemi E = new Ennemi(ennemiAleatoire, pvEnnemi, 100-pvEnnemi,armeChoisie);
            System.out.println(E.getMonArme().getNom());






        }

    }
}