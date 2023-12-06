package src.Model;

import java.util.ArrayList;
public class Personnage {
    private int pv;
    public String nom;
    private int puissance;
    public void attaquer(){
        System.out.println("le personnage attaque");
    }
    public void defendre(){
        System.out.println("le personnage se defend");
    }

    public Personnage(String nom, int pv, int puissance) {
        this.pv = pv;
        this.nom = nom;
        this.puissance = puissance;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

}
