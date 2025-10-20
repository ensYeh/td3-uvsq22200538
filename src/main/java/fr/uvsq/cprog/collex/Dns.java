package fr.uvsq.cprog.collex;
import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.*;

public class Dns {

    private Properties properties = new Properties();
    String dnsFilePath;
    List<DnsItem> items = new ArrayList<>();

    public Dns() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.dnsFilePath = System.getProperty("user.home") + "/" + properties.getProperty("dns.file.path");
    }


    public static void main(String[] args) {
        Dns dns = new Dns();
        System.out.println(dns.dnsFilePath);


        try (FileWriter writer = new FileWriter(dns.dnsFilePath);){
            writer.write("test");
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
