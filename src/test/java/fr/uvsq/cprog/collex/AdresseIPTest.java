package fr.uvsq.cprog.collex;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * AdresseIPTest
 *
 * @author uvsq22200538
 * @version oct. 2025
 */

public class AdresseIPTest {

    @Test
    public void testMinAdr() {
        AdresseIP adr = new AdresseIP("0.0.0.0");
        assertEquals("0.0.0.0", adr.toString());
    }

    @Test
    public void testMaxAdr() {
        AdresseIP adr = new AdresseIP("255.255.255.255");
        assertEquals("255.255.255.255", adr.toString());
    }

    @Test
    public void threeBytesThrowsError() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new AdresseIP("100.100.100");
                });
    }

    @Test
    public void fiveBytesThrowsError() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new AdresseIP("100.100.100.100.100");
                });
    }

    @Test
    public void nullThrowsError() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new AdresseIP(null);
                });
    }

    @Test
    public void emptyIPThrowsError() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new AdresseIP("...");
                });
    }

    @Test
    public void superiorTo255ThrowsError() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new AdresseIP("255.255.255.256");
                });
    }

    @Test
    public void inferiorTo0ThrowsError() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new AdresseIP("-1.255.255.255");
                });
    }
}
