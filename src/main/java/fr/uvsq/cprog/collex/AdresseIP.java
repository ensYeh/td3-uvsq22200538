package fr.uvsq.cprog.collex;

import java.util.Objects;

/**
 * AdresseIP
 *
 * @author uvsq22200538
 * @version oct. 2025
 */

public class AdresseIP {

    String adresseIP;

    AdresseIP(String adresseIP) {
        if (adresseIP == null || !isValidIP(adresseIP)) {
            throw new IllegalArgumentException(adresseIP + " n'est pas une adresse IP valide.");
        }
        this.adresseIP = adresseIP;
    }

    public static boolean isValidIP(String adresseIP) {
        String[] parsed = adresseIP.split("\\.");
        if (parsed.length != 4) {
            return false;
        }
        for (String strNumber : parsed) {
            try {
                int number = Integer.parseInt(strNumber);
                if (number > 255 || number < 0) {
                    return false;
                }
            } catch(Exception e) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return this.adresseIP;
    }
}
