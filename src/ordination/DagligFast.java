package ordination;

import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination{

    // TODO
    private Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
    }

    public Dosis[] getDoser() {
        return doser;
    }

    @Override
    public double samletDosis() {
        double sum = 0;
        for (Dosis d : doser) {
            sum += d.getAntal();
        }
        return sum;
    }

    @Override
    public double doegnDosis() {
        return samletDosis() / antalDage();
    }

    @Override
    public String getType() {
        return "Daglig Fast";
    }
    public Dosis addMorgenDosis(double antal){
        Dosis dosis = new Dosis(LocalTime.of(6,00), antal);
        doser[0]=dosis;
        return dosis;
    }
    public Dosis addMiddagnDosis(double antal){
        Dosis dosis = new Dosis(LocalTime.of(12,00), antal);
        doser[1]=dosis;
        return dosis;}
    public Dosis addAftenDosis(double antal){
        Dosis dosis = new Dosis(LocalTime.of(20,00), antal);
        doser[2]=dosis;
        return dosis;}
    public Dosis addNatDosis(double antal){
        Dosis dosis = new Dosis(LocalTime.of(2,00), antal);
        doser[3]=dosis;
        return dosis;}
}
