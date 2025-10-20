package fr.uvsq.cprog.collex;

public class CommandSearchByIP implements Commande{

    String ip;

    CommandSearchByIP(String ip) {
        this.ip = ip;
    }

    @Override
    public void execute(Dns dns) {
        try {
            String res = dns.getItem(new AdresseIP(this.ip)).toString();
            System.out.println(res);
        } catch (IllegalArgumentException e) {
            System.out.println("ERREUR : cette adresse IP n'existe pas dans la BD");
        }
    }
}
