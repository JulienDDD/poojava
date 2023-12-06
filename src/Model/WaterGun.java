package src.Model;

public class WaterGun extends Arme{
    String potion;

    public String getPotion() {
        return potion;
    }

    public void setPotion(String potion) {
        this.potion = potion;
    }

    public WaterGun(String nom, int rarete, int degats, String potion) {
        super(nom, rarete, degats);
        this.potion=potion;
    }
}
