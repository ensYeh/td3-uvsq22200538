package fr.uvsq.cprog.collex;

public class CommandSearchByDomainName implements Commande{

    String domainName;

    CommandSearchByDomainName(String domainName) {
        this.domainName = domainName;
    }

    @Override
    public void execute(Dns dns) {
        for (DnsItem item : dns.getItems(this.domainName)) {
            System.out.println(item.toString());
        }
    }
}
