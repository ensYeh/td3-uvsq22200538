package fr.uvsq.cprog.collex;

/**
 * NomMachine
 *
 * @author uvsq22200538
 * @version oct. 2025
 */

public class NomMachine {

    String nom;
    String domaine;

    NomMachine(String nom) {
        if (nom == null || !isValidNomMachine(nom)) {
            throw new IllegalArgumentException(nom + " n'est pas un nom de machine valide.");
        }
        this.nom = nom.toLowerCase();
        this.domaine = nom.substring(nom.indexOf('.')+1);
    }

    public static boolean isValidNomMachine(String nom) {
        try {
            String[] parsed = nom.split("\\.");
            if (parsed.length != 3) {
                return false;
            }
            for (String subStr : parsed) {
                if (!subStr.matches("[a-zA-Z]+")) {
                    return false;
                }
            }
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nom;
    }
}
