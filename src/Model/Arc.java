package src.Model;

public class Arc extends Arme{
    int fleche;
    public Arc(String nom, int rarete, int degats, int fleche) {
        super(nom, rarete, degats);
        this.fleche = fleche;

    }

    public int getFleche() {
        return fleche;
    }

    public void setFleche(int fleche) {
        this.fleche = fleche;
    }
}
