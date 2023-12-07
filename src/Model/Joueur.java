package src.Model;
import java.util.ArrayList;

public class Joueur extends Personnage{
    int id;
    ArrayList<ObjetEnJeu> inventaire = new ArrayList<>();
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<ObjetEnJeu> getInventaire() {
        return inventaire;
    }

    public void setInventaire(ArrayList<ObjetEnJeu> inventaire) {
        this.inventaire = inventaire;
    }

    public Joueur(String nom, int pv, int puissance, int id) {
        super(nom, pv, puissance);
        this.id = id;
    }

    public void setIdJoueur(int id) {
        this.id = id;
    }

    public ArrayList<ObjetEnJeu> getInventaireJoueur() {
        return inventaire;
    }

    public void setInventaireJoueur(ArrayList<ObjetEnJeu> inventaire) {
        this.inventaire = inventaire;
    }

    public void attaquer(Personnage victime){

        System.out.println(nom + " attaque " + victime.getNom() );
        victime.removePv(12);

    }
    public void defendre(){
        System.out.println(nom + "se defend");
    }
}
