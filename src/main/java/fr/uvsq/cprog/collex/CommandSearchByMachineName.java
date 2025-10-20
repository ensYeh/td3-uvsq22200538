package fr.uvsq.cprog.collex;

public class CommandSearchByMachineName implements Commande{
    String machineName;

    CommandSearchByMachineName(String machineName) {
        this.machineName = machineName;
    }

    @Override
    public void execute(Dns dns) {
        try {
            String res = dns.getItem(new NomMachine(this.machineName)).toString();
            System.out.println(res);
        } catch (IllegalArgumentException e) {
            System.out.println("ERREUR : ce nom de machine n'existe pas dans la BD");
        }
    }
}
