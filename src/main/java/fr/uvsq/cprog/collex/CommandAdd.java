package fr.uvsq.cprog.collex;

public class CommandAdd implements Commande{

    String ip;
    String nomMachine;

    CommandAdd(String ip, String nomMachine) {
        this.ip = ip;
        this.nomMachine = nomMachine;
    }

    @Override
    public void execute(Dns dns) {
        try {
            dns.addItem(this.nomMachine, this.ip);
        } catch (IllegalArgumentException e) {
            System.out.println("ERREUR : Cette paire existe déjà dans la BD ou les valeurs rentrées sont invalides.");
        }
    }
}
