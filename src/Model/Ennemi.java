package src.Model;
import java.util.ArrayList;
public class Ennemi extends Personnage {
    Arme monArme;

    public Arme getMonArme() {
        return monArme;
    }

    public void setMonArme(Arme monArme) {
        this.monArme = monArme;
    }

    public Ennemi(String nom, int pv, int puissance, Arme monArme) {
        super(nom, pv, puissance);
        this.monArme = monArme;
    }
}
