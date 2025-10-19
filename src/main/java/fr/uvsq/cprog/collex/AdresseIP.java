package fr.uvsq.cprog.collex;

public class AdresseIP {

    int o1;
    int o2;
    int o3;
    int o4;

    AdresseIP(int octet1, int octet2, int octet3, int octet4) {
        for (int o : new int[]{octet1, octet2, octet3, octet4}) {
            if (o < 0 || o > 255) {
                throw new IllegalArgumentException("Un octet doit avoir une valeur comprise entre 0 et 255");
            }
        }
        this.o1 = octet1;
        this.o2 = octet2;
        this.o3 = octet3;
        this.o4 = octet4;
    }


    @Override
    public String toString() {
        return String.format("%d.%d.%d.%d", this.o1, this.o2, this.o3, this.o4);
    }
}
