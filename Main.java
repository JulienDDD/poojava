import src.Model.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Objects;
import java.io.*;

public class Main {

     /*
       Permet de choisir une arme parmi une liste selon leur coefficient de rarete
       :param liste : La liste d'instances des armes

     */
    public static Arme choisirSelonRarete(List<Arme> liste) {
        Random random = new Random();
        int r = random.nextInt(4) + 1;

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

        List<Armure> listeArmures = new ArrayList<>();

        listeArmures.add(new Armure("Casque",1,2,"iron"));
        listeArmures.add(new Armure("Jambiere",1,3,"iron"));
        listeArmures.add(new Armure("Plastron",1,5,"iron"));

        int point = 100;
        boolean game = true;
        boolean boutique = false;
        boolean combat = false;
        boolean OpenInv = false;
        int intAnswer;

        Ennemi mob = null;
        int counter;
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

        while (game){
            System.out.println("\n##### Menu du jeu #####\n");
            System.out.println("1 - Boutique");
            System.out.println("2 - Combattre");
            System.out.println("3 - Inventaire\n");
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

            // Partie Boutique
            if (Objects.equals(answer, "1")) {
                boutique = true;
            }

            // Partie Combat
            if (Objects.equals(answer, "2")) {
                Random ran = new Random();
                int pvEnnemi = ran.nextInt(50)+25;
                int indexAleatoire = ran.nextInt(lstEnnemi.size());
                String ennemiAleatoire = lstEnnemi.get(indexAleatoire);
                Arme armeChoisie = choisirSelonRarete(listeArmes);

                mob = new Ennemi(ennemiAleatoire, pvEnnemi, 100-pvEnnemi,armeChoisie);
                combat = true;
                System.out.println("\n###### Vous êtes en combat #######\n");

            }

            //Partie Inventaire
            if (Objects.equals(answer, "3")) {
                System.out.println("\nVous avez "+j.getPv()+" points de vie.\n" +
                                   "Votre puissance est de "+j.getPuissance()+".\n"+
                                   "votre Arme est une "+j.getMonArme().getNom()+" et elle inflige "+j.getMonArme().getDegats()+" dégats.\n");
                OpenInv = true;
            }


            // Partie Boutique
            while (boutique){
                System.out.println("voici la boutique d'objets que vous pouvez acheter.");
                System.out.println("Vous avez actuellement "+j.getConis()+" coins en votre possession.");
                System.out.println("\n 1 - Potion de poison (20 coins) \n 2 - Potion de vie (20 coins) \n 3 - Jambieres (30 coins) \n 4 - Epées (10 coins) \n 5 - Arc (15 coins) \n 5 - Plastrons (45 coins) \n 0 - Revenir au menu");
                answer = sc.nextLine();
                if (Objects.equals(answer, "1")) {
                    if (j.getConis()<20){
                        System.out.println("Vous n'avez pas assez de coins pour cette potion");
                    }else{
                        j.setConis(j.getConis()-20);
                        j.getInventaire().add(new Potion("Poison",1,-20));
                        System.out.println("Vous avez fait l'acquisition d'une potion de poison.");
                    }
                }if (Objects.equals(answer, "2")) {
                    if (j.getConis()<20){
                        System.out.println("Vous n'avez pas assez de coins pour cette potion");
                    }else{
                        j.setConis(j.getConis()-20);
                        j.getInventaire().add(new Potion("Health",1,20));
                        System.out.println("Vous avez fait l'acquisition d'une potion de vie.");
                    }
                }if (Objects.equals(answer, "3")) {
                    if (j.getConis()<30){
                        System.out.println("Vous n'avez pas assez de coins pour cette armure");
                    }else{
                        j.setConis(j.getConis()-30);
                        j.getInventaire().add(listeArmures.get(1));
                        System.out.println("Vous avez fait l'acquisition de jambiere.");
                    }
                }if (Objects.equals(answer, "4")) {
                    if (j.getConis()<10){
                        System.out.println("Vous n'avez pas assez de coins pour cette armure");
                    }else {
                        j.setConis(j.getConis() - 10);
                        listeArmes.get(0);
                        System.out.println("Vous avez fait l'acquisition d'une épée.");
                    }
                }if (Objects.equals(answer, "5")) {
                    if (j.getConis()<15){
                        System.out.println("Vous n'avez pas assez de coins pour cette armure");
                    }else{
                        j.setConis(j.getConis()-15);
                        listeArmes.get(6);
                        System.out.println("Vous avez fait l'acquisition d'un arc.");
                    }
                }if (Objects.equals(answer, "6")) {
                        if (j.getConis()<45){
                            System.out.println("Vous n'avez pas assez de coins pour cette armure");
                        }else{
                            j.setConis(j.getConis()-45);
                            j.getInventaire().add(listeArmures.get(2));
                            System.out.println("Vous avez fait l'acquisition d'un plastron.");
                        }
                }if (Objects.equals(answer, "0")) {
                    boutique = false;
                }
            }

            // Partie Combat
            while (combat){
                if (mob.getMonArme() != null) {
                    System.out.println("Vous combatez un " + mob.getNom() + " maniant une " + mob.getMonArme().getNom() + ".");
                }
                System.out.println("\nles pv du joueur sont de : "+j.getPv());
                System.out.println("les pv du mob sont de : "+mob.getPv());
                System.out.println("\n 1 - Attaquer \n 2 - Potions\n");
                answer = sc.nextLine();
                if (Objects.equals(answer, "1")) {
                    j.attaquer(mob);
                    System.out.println("\nles pv de" + mob.getNom() + " sont descendu à "+mob.getPv()+"pv.\n");
                }if (Objects.equals(answer, "2")) {
                    if (j.getInventaire()==null){
                        System.out.println("Votre inventaire est vide");
                    }else {
                        System.out.println("Quelle potion voulez vous utiliser ?\n");
                        Personnage ciblepotion;
                        Object PotionUsed;
                        ArrayList<ObjetEnJeu> UsablePotion = new ArrayList<>();
                        counter = 1;
                        for (ObjetEnJeu elmt : j.getInventaire()){
                            if (elmt instanceof Potion){
                                UsablePotion.add(elmt);
                                System.out.println(counter + " " + elmt.getNom()+"\n");
                                counter+=1;
                            }
                        }
                        answer = sc.nextLine();
                        intAnswer = Integer.parseInt(answer);
                        PotionUsed = UsablePotion.get(intAnswer-1);
                        System.out.println("Sur qui voulez vous l'utiliser ?\n1 Vous\n2 Votre adversaire\n");
                        answer = sc.nextLine();
                        if (Objects.equals(answer, "1")) {
                            ((Potion) PotionUsed).utiliser(j);
                        }if (Objects.equals(answer, "2")) {
                            ((Potion)PotionUsed).utiliser(mob);
                        }
                    }
                }
                if (mob.getPv() <= 0 || j.getPv() <= 0){
                    combat=false;
                    if (j.getPv() <= 0){
                        game=false;
                        System.out.println("Vous êtes mort.");
                    }
                    else {
                        j.setConis(j.getConis()+20);
                        j.getInventaire().add(mob.getMonArme());
                        System.out.println(mob.getNom()+" est mort.");
                        System.out.println("En dépouillant le cadavre de votre adversaire vous récupérez son arme :"+mob.getMonArme().getNom());
                    }
                    mob = null;
                    break;
                }
                mob.attaquer(j);
                if (mob.getPv() <= 0 || j.getPv() <= 0){
                    combat=false;
                    if (j.getPv() <= 0){
                        game=false;
                        System.out.println("Vous êtes mort.");
                    }else {
                        j.setConis(j.getConis()+20);
                        j.getInventaire().add(mob.getMonArme());
                        System.out.println(mob.getNom()+" est mort.");
                        System.out.println("\nVous avez gagné 20 coins !!!");
                        System.out.println("En dépouillant le cadavre de votre adversaire vous récupérez son arme :"+mob.getMonArme().getNom());
                    }
                    mob = null;
                }else {
                    System.out.println("Vos pv sont descendu à "+j.getPv()+"pv.");
                }
            }
            while (OpenInv){
                ArrayList<ObjetEnJeu> Usable_elmt = new ArrayList<>();
                ObjetEnJeu ElmtUsed;
                counter = 1;
                System.out.println("Que voulez vous utiliser?\n");
                for (ObjetEnJeu elmt : j.getInventaire()) {
                    Usable_elmt.add(elmt);
                    System.out.println(counter + " " + elmt.getNom() + "\n");
                    counter += 1;
                }
                System.out.println("0 Quitter l'inventaire\n");
                answer = sc.nextLine();
                intAnswer = Integer.parseInt(answer);
                if (Objects.equals(answer, "0")) {
                    OpenInv=false;
                }else {
                    ElmtUsed = Usable_elmt.get(intAnswer-1);
                    ((ObjetEnJeu) ElmtUsed).utiliser(j);
                    System.out.println("Vous avez utilisé "+ElmtUsed.getNom());
                }
            }
        }
    }
}