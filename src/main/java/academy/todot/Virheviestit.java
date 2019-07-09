package academy.todot;

import java.util.Date;

public class Virheviestit {

    private String viesti;

    public Virheviestit() {
        this("Virhe");
    }

    public Virheviestit(String viesti) {
        this.viesti = viesti;
    }

    public String getViesti() {
        return viesti;
    }

    public void setViesti(String viesti) {
        this.viesti = viesti;
    }

}

