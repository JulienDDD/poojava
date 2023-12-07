package src.Model;

public class Armure extends ObjetEnJeu {

    int protectionRate;
    String materialType;


    public Armure(String nom, int rarete, int protectionRate, String materialType) {
        super(nom, rarete);
        this.protectionRate = protectionRate;
        this.materialType = materialType;
    }



    @Override
    public void interagir(Personnage personnage, String interaction) {

    }
}
