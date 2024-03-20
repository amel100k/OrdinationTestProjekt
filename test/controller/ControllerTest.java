package controller;
import ordination.Laegemiddel;
import ordination.Ordination;
import ordination.PN;
import ordination.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import storage.Storage;

import java.time.LocalDate;

import ordination.Dosis;
import ordination.Laegemiddel;
import ordination.Patient;

import java.time.LocalDate;
import java.time.LocalTime;

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
        int arraySize = p1.getOrdinationer().size();
        Controller.getController().opretDagligFastOrdination(LocalDate.of(2024, 8, 14), LocalDate.of(2024, 8, 21), p1, l1, 1, 2, 1, 1);
        //assert
        assertEquals("Startdato er efter slutdato", exception.getMessage());
        assertEquals(arraySize+1, p1.getOrdinationer().size());
        assertEquals(l1, p1.getOrdinationer().getLast().getLaegemiddel());
        //assertEquals(p1.getOrdinationer().getLast().g);
    }

    @org.junit.jupiter.api.Test
    void opretDagligSkaevOrdination() {
        Laegemiddel l1 = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        Patient p1 = new Patient("121256-0512", "Jane Jensen", 24.0);

        Exception exception = assertThrows(RuntimeException.class, () -> {Controller.getController().opretDagligSkaevOrdination(LocalDate.of(2024,8,25),LocalDate.of(2024,8,21),p1,l1, new LocalTime[]{LocalTime.of(13, 5)},new double[]{3});
        });

        int arraySize = p1.getOrdinationer().size();
        Controller.getController().opretDagligSkaevOrdination(LocalDate.of(2024,8,14),LocalDate.of(2024,8,21),p1,l1,new LocalTime[]{LocalTime.of(13,5),LocalTime.of(16,15)},new double[]{2,2});


        //assert
        assertEquals(exception.getMessage(), "Startdato er efter slutdato");
        assertEquals(p1.getOrdinationer().size(),arraySize + 1);
        assertEquals(p1.getOrdinationer().getLast().getLaegemiddel(),l1);
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
        Patient p1 = new Patient("121256-0512","Jane Jensen",24);
        Patient p2 = new Patient("121256-0516", "Bane Larsen", 25.0);
        Patient p3 = new Patient("121256-0513", "Janne Petersen", 120.0);
        Patient p4 = new Patient("121256-0515", "Lena Caspersen", 121.0);
        Laegemiddel l1 = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");

        double expected1 = 24;
        double actual1 = Controller.getController().anbefaletDosisPrDoegn(p1,l1);
        assertEquals(expected1,actual1);

        double expected2 = 37.5;
        double actual2 = Controller.getController().anbefaletDosisPrDoegn(p2,l1);
        assertEquals(expected2,actual2);

        double expected3 = 180;
        double actual3 = Controller.getController().anbefaletDosisPrDoegn(p3,l1);
        assertEquals(expected3,actual3);

        double expected4 = 242;
        double actual4 = Controller.getController().anbefaletDosisPrDoegn(p4,l1);
        assertEquals(expected4,actual4);

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

    @Test
    void opretPNOrdination() {
        Patient p1 = new Patient("121256-0512","Jane Jensen",24.0);
        Laegemiddel l1 = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        assertThrows(IllegalArgumentException.class,() -> Controller.getController().opretPNOrdination(LocalDate.of(2021,1,1),LocalDate.of(2020,12,12),p1,l1,5));

        int arraySize = p1.getOrdinationer().size();
        Controller.getController().opretPNOrdination(LocalDate.of(2021,1,1),LocalDate.of(2021,1,12),p1,l1,5);

        //assert
        assertEquals(p1.getOrdinationer().size(),arraySize + 1);
        assertEquals(p1.getOrdinationer().getLast().getLaegemiddel(),l1);

    }
}