package src.Model;

public class Arme extends ObjetEnJeu {
    /*
    Variable stockant le nombre de PV qui seront enlevé au <<Personnage>> Victime
     */
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

    /*
        Fonction permettant au personnage de changer d'arme
        :param cible: Personnage qui doit etre equipé de l'arme
    */

    public void utiliser(Personnage cible){
        cible.setMonArme(this);
        cible.retirerObjet(this);
    }
    @Override
    public void interagir(Personnage personnage, String interaction) {

    }
}
