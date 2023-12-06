package src.Model;

public class Epee extends Arme{
    int Tranchant;
    public Epee(String nom, int rarete, int degats, int Tranchant) {
        super(nom, rarete, degats);
        this.Tranchant=Tranchant;
    }

    public int getTranchant() {
        return Tranchant;
    }

    public void setTranchant(int tranchant) {
        Tranchant = tranchant;
    }
}
