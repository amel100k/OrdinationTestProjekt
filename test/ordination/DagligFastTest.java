package ordination;

import controller.Controller;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DagligFastTest {

    @Test
    void addMorgenDosis() {
        //arrange
        int expected = 1;
        Laegemiddel l1 = new Laegemiddel("Paracetamol", 1,
                1.5, 2, "MI");
        DagligFast dagligFast = new DagligFast(LocalDate.of(2024,8,2), LocalDate.of(2024,8,4), l1);
        dagligFast.addMorgenDosis(1);
        assertEquals(expected, dagligFast.getDoser()[0].getAntal());
    }


    @Test
    void addMiddagnDosis() {
        int expected = 1;
        Laegemiddel l1 = new Laegemiddel("Paracetamol", 1,
                1.5, 2, "MI");
        DagligFast dagligFast = new DagligFast(LocalDate.of(2024,8,2), LocalDate.of(2024,8,4), l1);
        dagligFast.addMiddagnDosis(1);
        assertEquals(expected, dagligFast.getDoser()[1].getAntal());
    }

    @Test
    void addAftenDosis() {
        int expected = 1;
        Laegemiddel l1 = new Laegemiddel("Paracetamol", 1,
                1.5, 2, "MI");
        DagligFast dagligFast = new DagligFast(LocalDate.of(2024,8,2), LocalDate.of(2024,8,4), l1);
        dagligFast.addAftenDosis(1);
        assertEquals(expected, dagligFast.getDoser()[2].getAntal());
    }

    @Test
    void addNatDosis() {
        int expected = 1;
        Laegemiddel l1 = new Laegemiddel("Paracetamol", 1,
                1.5, 2, "MI");
        DagligFast dagligFast = new DagligFast(LocalDate.of(2024,8,2), LocalDate.of(2024,8,4), l1);
        dagligFast.addNatDosis(1);
        assertEquals(expected, dagligFast.getDoser()[3].getAntal());
    }
}