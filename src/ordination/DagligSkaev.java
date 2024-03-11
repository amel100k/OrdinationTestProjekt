package ordination;

import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev {
    // TODO
    private ArrayList<Dosis> doser = new ArrayList<>();


    public void opretDosis(LocalTime tid, double antal) {
        // TODO
        doser.add(new Dosis(tid, antal));
    }

    public ArrayList<Dosis> getDoser() {
        return doser;
    }
}
