package g58399.dev1.javl.examen;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alecw
 */
public class JeuDesAllumettesTest {

    public JeuDesAllumettesTest() {
    }

    /**
     * Test of nombreAllumettesRestantes method, of class JeuDesAllumettes.
     */
    @Test
    public void testNombreAllumettesRestantesEstEgaleZero() {
        System.out.println("nombreAllumettesRestantes");
        boolean[] etatAllumettes = new boolean[21];
        for (int i = 0; i < etatAllumettes.length; i++) {
            etatAllumettes[i] = false;
        }

        int expResult = 0;
        int result = JeuDesAllumettes.nombreAllumettesRestantes(etatAllumettes);
        assertEquals(expResult, result);

    }

    /**
     * Test of nombreAllumettesRestantes method, of class JeuDesAllumettes.
     */
    @Test
    public void testNombreAllumettesRestantesEstEgale1() {
        System.out.println("nombreAllumettesRestantes");
        boolean[] etatAllumettes = new boolean[21];
        for (int i = 0; i < etatAllumettes.length; i++) {
            etatAllumettes[i] = true;
        }
        for (int i = 0; i < etatAllumettes.length - 1; i++) {
            etatAllumettes[i] = false;
        }
        int expResult = 1;
        int result = JeuDesAllumettes.nombreAllumettesRestantes(etatAllumettes);
        assertEquals(expResult, result);

    }

    /**
     * Test of nombreAllumettesRestantes method, of class JeuDesAllumettes.
     */
    @Test
    public void testNombreAllumettesRestantesEstEgaleTroie() {
        System.out.println("nombreAllumettesRestantes");
        boolean[] etatAllumettes = new boolean[21];
        for (int i = 0; i < etatAllumettes.length; i++) {
            etatAllumettes[i] = true;
        }
        for (int i = 0; i < etatAllumettes.length - 3; i++) {
            etatAllumettes[i] = false;
        }
        int expResult = 3;
        int result = JeuDesAllumettes.nombreAllumettesRestantes(etatAllumettes);
        assertEquals(expResult, result);

    }

}
