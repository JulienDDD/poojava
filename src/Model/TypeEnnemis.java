package src.Model;

public class TypeEnnemis extends Personnage {
    Boolean cac;

    public Boolean getCac() {
        return cac;
    }

    public void setCac(Boolean cac) {
        this.cac = cac;
    }

    public TypeEnnemis(String nom, int pv, int puissance, Boolean cac) {
        super(nom, pv, puissance);
        this.cac = cac;
    }
}
