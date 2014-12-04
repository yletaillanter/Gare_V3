/**
 * Created by Yoann on 03/12/2014.
 */
public class Trajet {
    private Gare gareDepart;
    private Gare gareFin;

    public Trajet(Gare debut, Gare fin){
        this.gareDepart = debut;
        this.gareFin = fin;
    }

    public Gare getGareDepart() {
        return gareDepart;
    }

    public void setGareDepart(Gare gareDepart) {
        this.gareDepart = gareDepart;
    }

    public Gare getGareFin() {
        return gareFin;
    }

    public void setGareFin(Gare gareFin) {
        this.gareFin = gareFin;
    }

    @Override
    public String toString() {
        return "Trajet : "+gareDepart.getName()+" à "+gareFin.getName();
    }
}
