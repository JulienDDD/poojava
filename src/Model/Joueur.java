package src.Model;

public class Joueur extends Personnage{
    int id;

    public int getId() {
        return id;
    }

    public Joueur(String nom, int pv, int puissance, int id) {
        super(nom, pv, puissance);
        this.id = id;
    }
}
