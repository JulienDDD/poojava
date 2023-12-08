package src.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Personnage implements Interactuable {
    private double coef = 0.2;
    private int pv;
    private String nom;
    private int resistance;
    private int puissance;

    public Personnage(String nom, int pv, int resistance, int puissance) {
        this.pv = pv;
        this.nom = nom;
        this.resistance = resistance;
        this.puissance = puissance;
    }
    public Personnage(String nom, int pv, int puissance) {
        this.pv = pv;
        this.nom = nom;
        this.resistance = 1;
        this.puissance = puissance;
    }

    public void defendre(){
        System.out.println("le personnage se defend");
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

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    @Override
    public void Rename(Personnage personnage, String interaction) {
        /**
         cette méthode permet de rennomer le joueur
         **/
        System.out.println("Entrez le nouveau nom  :");
        this.nom= new Scanner(System.in).nextLine();
        System.out.println("le nouveau nom du joueur est " + this.nom);
    }

    public Arme getMonArme() {return null;}

    public void setMonArme(Arme MonArme) {}

    public void retirerObjet(ObjetEnJeu objet) {}

    /*
    Fonction permettant d'infliger des degats à un autre personnage
    :param victime : Instance du personnage (ennemi ou joueur) quoi recoit l'attaque
     */
    public void attaquer(Personnage victime){
        int Damage = (int)(((float)this.getPuissance()*(float)coef + this.getMonArme().getDegats()) / (1+victime.getResistance()/10));
        System.out.println(getNom() + " inflige des dégats à " + victime.getNom() );
        victime.removePv(Damage, victime);
    }

    /*
    Fonction de supression des pv du personnage victime
     */
    public void removePv(int pvAmount, Personnage victime){
        int startPv = victime.getPv();
        int endPv = startPv - pvAmount;
        victime.setPv(endPv);
    }
}
