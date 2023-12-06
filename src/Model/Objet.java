package src.Model;

public class Objet {
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getRarete() {
        return rarete;
    }

    public void setRarete(int rarete) {
        this.rarete = rarete;
    }

    String nom;
    int rarete;

    public Objet(String nom, int rarete) {
        this.nom = nom;
        this.rarete = rarete;
    }
}
