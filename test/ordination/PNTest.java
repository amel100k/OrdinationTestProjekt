package ordination;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PNTest {

    @Test
    void givDosis() {
        //assert
        Laegemiddel l1 = new Laegemiddel("Paracetamol", 1,
                1.5, 2, "MI");
        PN pn = new PN(LocalDate.of(2024,2,1), LocalDate.of(2024,2,10), l1, 5);
        //act
        pn.givDosis(LocalDate.of(2024,2,2));
        //assert
        assertTrue(pn.givDosis(LocalDate.of(2024,2,2)));
        assertEquals(pn.getDatoer().getLast(), LocalDate.of(2024,2,2));
        //assert
        assertFalse(pn.givDosis(LocalDate.of(2024,1,20)));
        }

    @Test
    void samletDosis() {
        //assert
        int expected = 10;
        Laegemiddel l1 = new Laegemiddel("Paracetamol", 1,
                1.5, 2, "MI");
        PN pn = new PN(LocalDate.of(2024,2,20), LocalDate.of(2024,2,22), l1, 5);
        pn.givDosis(LocalDate.of(2024,2,21));
        pn.givDosis(LocalDate.of(2024,2,20));
        assertEquals(expected, pn.samletDosis());
    }

    @Test
    void doegnDosis() {
        Laegemiddel l1 = new Laegemiddel("Paracetamol", 1,
                1.5, 2, "MI");
        PN pn = new PN(LocalDate.of(2024,2,1), LocalDate.of(2024,2,10), l1, 5);
        pn.givDosis(LocalDate.of(2024,2,2));
        pn.givDosis(LocalDate.of(2024,2,8));
        double expected = 1.43;
        double actual = pn.doegnDosis();
        assertEquals(expected, actual, 0.008);
    }
}