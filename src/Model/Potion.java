package src.Model;

public class Potion extends ObjetEnJeu{
    private int HDAmount;
    public Potion(String nom, int rarete, int HDAmount) {
        super(nom, rarete);
        this.HDAmount = HDAmount;
    }

    public int getHDAmount() {
        return HDAmount;
    }

    public void setHDAmount(int HDAmount) {
        HDAmount = HDAmount;
    }

    @Override
    public void interagir(Personnage personnage, String interaction) {
    }

    public void utiliser(Personnage cible){
        cible.setPv(cible.getPv()+this.getHDAmount());
        cible.retirerObjet(this);
    }
}
