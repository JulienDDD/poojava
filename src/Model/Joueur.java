package src.Model;
import java.util.ArrayList;
import java.util.Collections;
public class Joueur extends Personnage{
    int id;
    ArrayList<ObjetEnJeu> inventaire = new ArrayList<>();
    public int getId() {
        return id;
    }

    public Joueur(String nom, int pv, int puissance, int id) {
        super(nom, pv, puissance);
        this.id = id;
    }
}
