package src.Model;

public class Armure extends ObjetEnJeu {

    int protectionRate;
    String materialType;


    public Armure(String nom, int rarete, int protectionRate, String materialType) {
        super(nom, rarete);
        this.protectionRate = protectionRate;
        this.materialType = materialType;
    }

    public Armure(int protectionRate, String materialType) {
        super(materialType, protectionRate);
    }

    @Override
    public void interagir(Personnage personnage, String interaction) {

    }
}
