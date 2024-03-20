package ordination;

import controller.Controller;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DagligSkaevTest {

    @Test
    void samletDosisTC1() {
        Laegemiddel l1 = new Laegemiddel("Fucidin", 1, 1.5, 2, "Ml");
        DagligSkaev ds = new DagligSkaev(LocalDate.of(2024,2,21),LocalDate.of(2024,2,23),l1);
        ds.opretDosis(LocalTime.of(13,30),4);
        ds.opretDosis(LocalTime.of(14,30),4);

        double expected = 24;
        double actual = ds.samletDosis();
        assertEquals(expected,actual);
    }
    @Test
    void samletDosisTC2() {
        Laegemiddel l1 = new Laegemiddel("Fucidin", 1, 1.5, 2, "Ml");
        DagligSkaev ds = new DagligSkaev(LocalDate.of(2024,2,21),LocalDate.of(2024,2,23),l1);
        ds.opretDosis(LocalTime.of(13,30),4);

        double expected = 12;
        double actual = ds.samletDosis();
        assertEquals(expected,actual);
    }
    @Test
    void samletDosisTC3() {
        Laegemiddel l1 = new Laegemiddel("Fucidin", 1, 1.5, 2, "Ml");
        DagligSkaev ds = new DagligSkaev(LocalDate.of(2024,2,21),LocalDate.of(2024,2,23),l1);

        double expected = 0;
        double actual = ds.samletDosis();
        assertEquals(expected,actual);
    }

    @Test
    void doegnDosisTC1() {
        Laegemiddel l1 = new Laegemiddel("Fucidin", 1, 1.5, 2, "Ml");
        DagligSkaev ds = new DagligSkaev(LocalDate.of(2024,2,21),LocalDate.of(2024,2,23),l1);
        ds.opretDosis(LocalTime.of(13,30),4);
        ds.opretDosis(LocalTime.of(14,30),4);

        double expected = 8;
        double actual = ds.doegnDosis();
        assertEquals(expected,actual);
    }
    @Test
    void doegnDosisTC2() {
        Laegemiddel l1 = new Laegemiddel("Fucidin", 1, 1.5, 2, "Ml");
        DagligSkaev ds = new DagligSkaev(LocalDate.of(2024,2,21),LocalDate.of(2024,2,23),l1);
        ds.opretDosis(LocalTime.of(13,30),4);

        double expected = 4;
        double actual = ds.doegnDosis();
        assertEquals(expected,actual);
    }
    @Test
    void doegnDosisTC3() {
        Laegemiddel l1 = new Laegemiddel("Fucidin", 1, 1.5, 2, "Ml");
        DagligSkaev ds = new DagligSkaev(LocalDate.of(2024,2,21),LocalDate.of(2024,2,23),l1);

        double expected = 0;
        double actual = ds.doegnDosis();
        assertEquals(expected,actual);
    }
}