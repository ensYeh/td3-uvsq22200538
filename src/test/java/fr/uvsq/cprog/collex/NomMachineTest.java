package fr.uvsq.cprog.collex;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * NomMachineTest
 *
 * @author uvsq22200538
 * @version oct. 2025
 */

public class NomMachineTest {

    @Test
    public void testNomValide() {
        NomMachine nom = new NomMachine("ecampus.uvsq.fr");
        assertEquals("ecampus.uvsq.fr", nom.toString());
    }

    @Test
    public void testIgnoreCase() {
        NomMachine nom = new NomMachine("EcAmpUs.UVSQ.fR");
        assertEquals("ecampus.uvsq.fr", nom.toString());
    }

    @Test
    public void nonAlphabeticThrowsError() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new NomMachine("3campu5.uv5q.fr");
                });
    }

    @Test
    public void nameTooShortThrowsError() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new NomMachine("uvsq.fr");
                });
    }

    @Test
    public void nameTooLongThrowsError() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new NomMachine("persee.prism.uvsq.fr");
                });
    }

}
