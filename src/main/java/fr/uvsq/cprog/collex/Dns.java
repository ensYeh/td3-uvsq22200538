package fr.uvsq.cprog.collex;
import java.util.ArrayList;
import java.util.Properties;
import java.io.*;

public class Dns {

    private Properties properties = new Properties();
    String dnsFilePath;
    ArrayList<DnsItem> items;

    public Dns() throws IOException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.dnsFilePath = System.getProperty("user.home") + "/" + properties.getProperty("dns.file.path");
        this.items = new ArrayList<DnsItem>();
        loadFile(this.dnsFilePath);
    }

    public void loadFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null){
            loadValueFromString(line);
        }
    }

    public void loadValueFromString(String line) {
        try {
            String[] pair = line.split(" ");
            if (pair.length != 2) {
                throw new IOException("Mauvaise valeur");
            }
            this.items.add(new DnsItem(pair[0], pair[1]));
        } catch (IllegalArgumentException e) {
            System.out.printf("\"%s\" : valeur non valide, n'a pas pu être chargé.\n", line);
        } catch (IOException e) {
            System.out.printf("\"%s\" : format non valide, n'a pas pu être chargé.\n", line);
        }
    }

    public void writeDnsItemToTxt(DnsItem item) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.dnsFilePath, true))) {
            writer.write(item.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ce DnsItem n'a pas pu être écrit dans le fichier dns.txt");
        }

    }

    public DnsItem getItem(AdresseIP ip) throws IllegalArgumentException {
        for (DnsItem item : this.items) {
            if (item.ip.adresseIP.equals(ip.adresseIP)) {
                return item;
            }
        }
        throw new IllegalArgumentException(ip.adresseIP + " n'existe pas dans la base de données");
    }

    public DnsItem getItem(NomMachine nom) throws IllegalArgumentException {
        for (DnsItem item : this.items) {
            if (item.nom.nom.equals(nom.nom)) {
                return item;
            }
        }
        throw new IllegalArgumentException(nom.nom + " n'existe pas dans la base de données");
    }

    public ArrayList<DnsItem> getItems(String nomDomaine) {
        ArrayList<DnsItem> res = new ArrayList<DnsItem>();
        for (DnsItem item : this.items) {
            if (item.nom.nom.substring(item.nom.nom.indexOf(".") +1).equals(nomDomaine)) {
                res.add(item);
            }
        }
        return res;
    }

    public void addItem(String nomMachine, String adresseIP) throws IllegalArgumentException{
        for (DnsItem item : this.items) {
            // On vérifie si on n'a pas de doublons
            if (item.nom.nom.equals(nomMachine) || item.ip.adresseIP.equals(adresseIP)) {
                throw new IllegalArgumentException("Ces valeurs sont déjà présentes dans la base de données");
            }
        }
        DnsItem newDns = new DnsItem(nomMachine, adresseIP);
        this.items.add(newDns);
        this.writeDnsItemToTxt(newDns);
    }

    public static void main(String[] args) throws IOException {
        Dns dns = new Dns();
        for (DnsItem item : dns.items) {
            System.out.println(item);
        }
        DnsItem i = new DnsItem("www.google.com", "222.111.83.23");
        dns.writeDnsItemToTxt(i);
    }


}
