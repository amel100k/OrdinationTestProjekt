package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class PN extends Ordination {

    private double antalEnheder;
    private List datoer = new ArrayList();

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, double antalEnheder) {
        super(startDen, slutDen, laegemiddel);
        this.antalEnheder = antalEnheder;
    }

    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     *
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        if (!givesDen.isBefore(super.getStartDen()) && !givesDen.isAfter(super.getSlutDen())) {
            datoer.add(givesDen);
            return true;
        } else return false;
    }

    public double doegnDosis() {
        return samletDosis() / (ChronoUnit.DAYS.between(getFirstDay(), getLastDay()) + 1);
    }

    @Override
    public String getType() {
        return "PN";
    }


    public double samletDosis() {
        return datoer.size() * antalEnheder;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     *
     * @return
     */
    public int getAntalGangeGivet() {
        return datoer.size();
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    public List getDatoer() {
        return datoer;
    }

    public LocalDate getFirstDay() {
        LocalDate firstDay = (LocalDate) datoer.getFirst();
        for (int i = 0; i < datoer.size() - 1; i++) {
            if (firstDay.isBefore((LocalDate) datoer.get(i)))
                firstDay = (LocalDate) datoer.get(i);
        }
        return firstDay;
    }

    public LocalDate getLastDay() {
        LocalDate lastDay = (LocalDate) datoer.getLast();
        for (int i = 0; i < datoer.size() - 1; i++) {
            if (lastDay.isBefore((LocalDate) datoer.get(i)))
                lastDay = (LocalDate) datoer.get(i);
        }
        return lastDay;
    }
}
