package ordination;

import storage.Storage;

import java.time.LocalDate;

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
}
