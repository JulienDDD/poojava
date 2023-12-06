package src.Model;
import java.utils.ArrayList;
public class Ennemi extends Personnage {
    String race;
    ArrayList<TypeEnnemis> inventaireEnnemi = new ArrayList<>();
    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Ennemi(String nom, int pv, int puissance, String race) {
        super(nom, pv, puissance);
        this.race = race;
    }
}
