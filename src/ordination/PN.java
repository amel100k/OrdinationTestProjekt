package ordination;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PN extends Ordination{

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
        if (givesDen.isAfter(super.getStartDen()) && givesDen.isBefore(super.getSlutDen())){
            datoer.add(givesDen);
            return true;}
        else return false;
    }

    public double doegnDosis() {
        return samletDosis()/(super.antalDage());
    }

    @Override
    public String getType() {
        return "PN";
    }


    public double samletDosis() {
        return datoer.size()*antalEnheder;
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

}
