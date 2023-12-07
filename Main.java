import src.Model.*;

public class Main {
    public static void main(String[] args) {
    Personnage monperso =  new Joueur("Gerard", 200, 50, 1);
        Personnage monperso2 =  new Joueur("Claude", 200, 50, 2);


        monperso.attaquer(monperso2);

    }
}