package controller;

import ordination.Laegemiddel;
import ordination.Patient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @org.junit.jupiter.api.Test
    void opretDagligFastOrdination() {
        //arrange
        Laegemiddel l1 = new Laegemiddel("Paracetamol", 1,
                1.5, 2, "MI");
        Patient p1 = new Patient("121256-0512", "Jane Jensen", 24.0);
        //act
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Controller.getController().opretDagligFastOrdination(LocalDate.of(2024, 8, 25), LocalDate.of(2024, 8, 21), p1, l1, 1, 2, 1, 1);
        });
        int i = 3;
        //fastOrdination = Controller.getController().opretDagligFastOrdination(LocalDate.of(2024, 8, 14), LocalDate.of(2024, 8, 21), p1, l1, 1, 2, 1, 1);
        //assert
        assertEquals(exception.getMessage(), "Startdato er efter slutdato");
        assertEquals(p1.getOrdinationer().contains());
    }

    @org.junit.jupiter.api.Test
    void opretDagligSkaevOrdination() {
    }

    @org.junit.jupiter.api.Test
    void ordinationPNAnvendt() {
    }

    @org.junit.jupiter.api.Test
    void anbefaletDosisPrDoegn() {
    }

    @org.junit.jupiter.api.Test
    void antalOrdinationerPrVægtPrLægemiddel() {
    }
}