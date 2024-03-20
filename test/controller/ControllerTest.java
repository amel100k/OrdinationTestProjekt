package controller;
import ordination.Laegemiddel;
import ordination.Ordination;
import ordination.PN;
import ordination.Patient;
import org.junit.jupiter.api.DisplayName;
import storage.Storage;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @org.junit.jupiter.api.Test
    void opretDagligFastOrdination() {
    }

    @org.junit.jupiter.api.Test
    void opretDagligSkaevOrdination() {
    }

    @org.junit.jupiter.api.Test
    void ordinationPNAnvendt() {
        Controller.getController().opretLaegemiddel("Fucidin", 1,1.5,2,"MI");
        Controller.getController().opretPatient("121256-0512","Jane Jensen",63.4);
        PN pn = Controller.getController().opretPNOrdination(LocalDate.of(2021,1,1),LocalDate.of(2021,1,12),Controller.getController().getAllPatienter().getFirst(),Controller.getController().getAllLaegemidler().getFirst(),123);
        assertTrue(pn.givDosis(LocalDate.of(2021,1,2)));
        assertThrows(IllegalArgumentException.class, () -> Controller.getController().ordinationPNAnvendt(pn, LocalDate.of(2021,1,13)));
        assertThrows(IllegalArgumentException.class,() -> Controller.getController().ordinationPNAnvendt(pn,LocalDate.of(2020,12,12)));
    }
    @org.junit.jupiter.api.Test
    void anbefaletDosisPrDoegn() {
    }

    @org.junit.jupiter.api.Test
    @DisplayName("AntalOrdinationerPrVægtPrLægemiddel")
    void antalOrdinationerPrVægtPrLægemiddel() {
        Controller.getController().opretLaegemiddel("Fucidin",1,1.5,2,"MI");
        Controller.getController().opretPatient("121256-0512","Jane Jensen",63.4);
        Controller.getController().opretPNOrdination(LocalDate.of(2021,1,1),LocalDate.of(2021,1,12),Controller.getController().getAllPatienter().getFirst(),Controller.getController().getAllLaegemidler().getFirst(),123);
        Controller.getController().opretPatient("121256-0512","Lene Jensen",163.4);
        Controller.getController().opretPNOrdination(LocalDate.of(2021,1,1),LocalDate.of(2021,1,12),Controller.getController().getAllPatienter().get(1),Controller.getController().getAllLaegemidler().getFirst(),123);
        assertEquals(1,Controller.getController().antalOrdinationerPrVægtPrLægemiddel(50,100,Controller.getController().getAllLaegemidler().getFirst()));
        assertEquals(0,Controller.getController().antalOrdinationerPrVægtPrLægemiddel(120,100, Controller.getController().getAllLaegemidler().getFirst()));
    }
}