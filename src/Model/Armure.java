package src.Model;

public class Armure extends ObjetEnJeu {

    int protectionRate;
    String materialType;


    public Armure(String nom, int rarete, int protectionRate, String materialType) {
        super(nom, rarete);
        this.protectionRate = protectionRate;
        this.materialType = materialType;
    }

    public void utiliser(Personnage cible){
        cible.setResistance(cible.getResistance()+this.getProtectionRate());
        cible.retirerObjet(this);
    }

    public int getProtectionRate() {
        return protectionRate;
    }

    public void setProtectionRate(int protectionRate) {
        this.protectionRate = protectionRate;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    @Override
    public void interagir(Personnage personnage, String interaction) {

    }
}
