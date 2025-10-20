package fr.uvsq.cprog.collex;

public class CommandExit implements Commande{
    @Override
    public void execute(Dns dns) {
        System.out.println("Quitte l'application");
        System.exit(0);
    }
}
