package src.Model;

public class Potion extends Objet{
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
}
