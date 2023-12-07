package src.Model;
import java.util.ArrayList;

public class Joueur extends Personnage{
    private double coef = 0.5;
    private int id;
    private int coins;
    private static Arme MonArme;
    private ArrayList<ObjetEnJeu> inventaire;

    // Constructeur avec tous les paramètres
    public Joueur(String nom, int pv, int puissance, Arme MonArme, int id, int coins, ArrayList<ObjetEnJeu> inventaire) {
        super(nom, pv, puissance);
        this.id = id;
        this.coins = coins;
        this.inventaire = inventaire;
    }

    // Constructeur avec des valeurs par défaut pour coins, id, MonArme, et inventaire
    public Joueur(String nom, int pv, int puissance, Arme MonArme) {
        super(nom, pv, puissance);
        this.MonArme = MonArme;
        this.id = 0; // Valeur par défaut pour id
        this.coins = 0; // Valeur par défaut pour coins
        this.inventaire = new ArrayList<>(); // Valeur par défaut pour inventaire
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConis() {
        return coins;
    }

    public void setConis(int conis) {
        this.coins = conis;
    }

    @Override
    public Arme getMonArme() {
        return MonArme;
    }

    public void setMonArme(Arme MonArme) {
        this.MonArme = MonArme;
    }

    public ArrayList<ObjetEnJeu> getInventaire() {
        return inventaire;
    }

    public void setInventaire(ArrayList<ObjetEnJeu> inventaire) {
        this.inventaire = inventaire;
    }

    @Override
    public int getPv() {
        return super.getPv();
    }
}
