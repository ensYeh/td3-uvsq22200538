package fr.uvsq.cprog.collex;

/**
 * DnsItem
 *
 * @author uvsq22200538
 * @version oct. 2025
 */

public class DnsItem {

    NomMachine nom;
    AdresseIP ip;

    DnsItem(String nom, String ip) {
        this.nom = new NomMachine(nom);
        this.ip = new AdresseIP(ip);

    }
}
