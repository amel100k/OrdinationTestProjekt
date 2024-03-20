package controller;

import ordination.Dosis;
import ordination.Laegemiddel;
import ordination.Patient;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @org.junit.jupiter.api.Test
    void opretDagligFastOrdination() {
    }

    @org.junit.jupiter.api.Test
    void opretDagligSkaevOrdination() {
        Laegemiddel l1 = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        Patient p1 = new Patient("121256-0512", "Jane Jensen", 24.0);

        Controller.getController().opretDagligSkaevOrdination(LocalDate.of(2024,8,25),LocalDate.of(2024,8,21),p1,l1, new LocalTime[]{LocalTime.of(13, 5)},new double[]{3});

    }

    @org.junit.jupiter.api.Test
    void ordinationPNAnvendt() {
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
    void antalOrdinationerPrVægtPrLægemiddel() {
    }
}