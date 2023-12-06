package src.Model;
import java.util.Scanner;


public abstract class ObjetEnJeu implements Interactuable {
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getRarete() {
        return rarete;
    }

    public void setRarete(int rarete) {
        this.rarete = rarete;
    }

    String nom;
    int rarete;

    public ObjetEnJeu(String nom, int rarete) {
        this.nom = nom;
        this.rarete = rarete;
    }

    @Override
    public void Rename(Personnage personnage, String interaction) {
        /**
         cette méthode permet de rennomer un objet
         **/
        System.out.println("Entrez le nouveau nom  :");
        this.nom= new Scanner(System.in).nextLine();
        System.out.println("le nouveau nom de l'objet est " + this.nom);
    }
}
