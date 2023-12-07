package src.Model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Personnage implements Interactuable {
    private int pv;
    public String nom;
    private int puissance;
    public void attaquer(Personnage victime){
        System.out.println("le personnage attaque");
    }

    public void defendre() {
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

    @Override
    public void Rename(Personnage personnage, String interaction) {
        try {
            System.out.println("Entrez le nouveau nom  :");
            this.nom = new Scanner(System.in).nextLine();
            System.out.println("le nouveau nom du joueur est " + this.nom);
        } catch (Exception e) {
            System.err.println("Erreur lors de la saisie du nom : " + e.getMessage());
        }

    }

    public void removePv(int pvAmount){
        System.out.println(pvAmount + " ont été retirés");
    }
}
