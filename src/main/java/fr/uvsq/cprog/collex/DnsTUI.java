package fr.uvsq.cprog.collex;

public class DnsTUI {

    public static Commande nextCommande(String entree) throws IllegalArgumentException {
        try {
            String[] parsed = entree.split(" ");
            switch (parsed[0]) {
                case "add":
                    return new CommandAdd(parsed[1], parsed[2]);
                case "ls":
                    return new CommandSearchByDomainName(parsed[1]);
                case "exit":
                    return new CommandExit();
                default:
                    if (AdresseIP.isValidIP(parsed[0])) {
                        return new CommandSearchByIP(parsed[0]);
                    } else if (NomMachine.isValidNomMachine(parsed[0])) {
                        return new CommandSearchByMachineName(parsed[0]);
                    } else {
                        throw new IllegalArgumentException("commande non reconnue");
                    }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Entree invalide");
        }
    }
}
