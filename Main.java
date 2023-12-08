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

        List<ObjetEnJeu> Inventaire = new ArrayList<>();

        List<String>lstEnnemi = new ArrayList<String>();
        lstEnnemi.add("Minautore");
        lstEnnemi.add("Gobelin");
        lstEnnemi.add("Gnome");
        lstEnnemi.add("Satyr");
        lstEnnemi.add("Troll");
        lstEnnemi.add("Orc");

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
        boolean game = true;
        boolean boutique = false;
        boolean combat = false;

        Ennemi mob = null;
        ArrayList potions = new ArrayList<>();
        ArrayList invDefaut = new ArrayList<>();
        invDefaut.add(new Potion("Health",1,20));
        invDefaut.add(new Potion("Poison",1,-20));


        Scanner sc = new Scanner(System.in);
        System.out.println("***** Creation de personnage *****");
        System.out.println("Donne toi un nom");
        String name = sc.nextLine();
        System.out.println("d'accord ton nom est : " + name);
        System.out.println("Tu as 100 point de disponible à répartir entre tes pv et ta puissance. \nCombien de pointveux tu mettre dans tes pv ?");
        int pointsPv = Integer.parseInt(sc.nextLine());
        int pointsP = point-pointsPv;
        Joueur j = new Joueur(name, pointsPv, pointsP,listeArmes.get(0));
        j.setInventaire(invDefaut);
        System.out.println("Ton personnage a " + j.getPv() + "pv et " + j.getPuissance() + " de puissance");

        System.out.println("Menu du jeu");
        System.out.println("1 - Boutique");
        System.out.println("2 - Combattre");
        System.out.println("3 - Inventaire");
        String answer = sc.nextLine();

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
        if (Objects.equals(answer, "1")) {
            boutique = true;
        }
        if (Objects.equals(answer, "2")) {
            Random ran = new Random();
            int pvEnnemi = ran.nextInt(50)+25;
            int indexAleatoire = ran.nextInt(lstEnnemi.size());
            String ennemiAleatoire = lstEnnemi.get(indexAleatoire);
            Arme armeChoisie = choisirSelonRarete(listeArmes);

            mob = new Ennemi(ennemiAleatoire, pvEnnemi, 100-pvEnnemi,armeChoisie);
            System.out.println(mob.getMonArme().getNom());
            combat = true;
            System.out.println("###### Vous êtes en combat #######");

        }
        if (Objects.equals(answer, "3")) {
        }
        while (boutique){
            System.out.println("voici la boutique d'objets");
            System.out.println("\n 1 - Potion de poison \n 2 - Potion de vie \n 3 - Jambieres \n 4 - Epées \n 5 - Armures \n 6 - Arc \n 7 - Plastrons \n 8 - WaterGun");
            answer = sc.nextLine();
            if (Objects.equals(answer, "1")) {
            }if (Objects.equals(answer, "2")) {
            }if (Objects.equals(answer, "3")) {
            }if (Objects.equals(answer, "4")) {
            }if (Objects.equals(answer, "5")) {
            }if (Objects.equals(answer, "6")) {
            }if (Objects.equals(answer, "7")) {
            }if (Objects.equals(answer, "8")) {
            }if (Objects.equals(answer, "0")) {
                boutique = false;
            }
        }
        while (combat){
            System.out.println("\n 1 - Attaquer \n 2 - Potions\n");
            answer = sc.nextLine();
            System.out.println("\nles pv du joueur sont de : "+j.getPv());
            System.out.println("les pv du mob sont de : "+mob.getPv()+"\n");
            if (Objects.equals(answer, "1")) {
                j.attaquer(mob);
            }if (Objects.equals(answer, "2")) {
                if (j.getInventaire()==null){
                    System.out.println("Votre inventaire est vide");
                }else {
                    System.out.println("Quelle potion voulez vous utiliser ?\n");
                    int counter = 1;
                    int intAnswer;
                    Personnage ciblepotion;
                    Object PotionUsed;
                    ArrayList<ObjetEnJeu> UsablePotion = new ArrayList<>();
                    for (ObjetEnJeu elmt : j.getInventaire()){
                        if (elmt instanceof Potion){
                            UsablePotion.add(elmt);
                            System.out.println(counter + " " + elmt.getNom()+"\n");
                            counter+=1;
                        }
                    }
                    answer = sc.nextLine();
                    intAnswer = Integer.parseInt(answer);
                    PotionUsed = UsablePotion.get(intAnswer+1);
                    System.out.println("Sur qui voulez vous l'utiliser ?\n1 Vous\n2 Votre adversaire\n");
                    answer = sc.nextLine();
                    if (Objects.equals(answer, "1")) {
                        ((Potion) PotionUsed).utiliser(j);
                    }if (Objects.equals(answer, "2")) {
                        ((Potion)PotionUsed).utiliser(mob);
                    }
                    j.setInventaire(j.getInventaire());
                }
            }
            System.out.println("les pv de" + mob.getNom() + " sont descendu à "+mob.getPv()+"pv.\n");
            if (mob.getPv() <= 0 || j.getPv() <= 0){
                combat=false;
                break;
            }
            mob.attaquer(j);
            System.out.println("Vos pv sont descendu à "+j.getPv()+"pv.");
            if (mob.getPv() <= 0 || j.getPv() <= 0){
                combat=false;
            }
        }
    }
}