package src.Model;

public class Arme extends ObjetEnJeu {
    int degats;

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public Arme(String nom, int rarete, int degats) {
        super(nom, rarete);
        this.degats = degats;
    }

    @Override
    public void interagir(Personnage personnage, String interaction) {

    }
}
