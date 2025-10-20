package fr.uvsq.cprog.collex;

import java.io.IOException;
import java.util.Scanner;

/**
 * DnsApp
 *
 * @author uvsq22200538
 * @version oct. 2025
 */

public class DnsApp
{
    public static void main( String[] args ) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Dns dns = new Dns();
        while (true) {
            System.out.print("> ");
            try {
                Commande commande = DnsTUI.nextCommande(scanner.nextLine());
                commande.execute(dns);
            } catch (Exception e) {
                System.out.println("La commande n'a pas pu être executée");
            }
        }
    }
}
