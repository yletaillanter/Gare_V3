/**
 * Created by Yoann on 03/12/2014.
 */
public class Trajet {
    private GareImpl gareDepart;
    private GareImpl gareFin;

    public Trajet(GareImpl debut, GareImpl fin){
        this.gareDepart = debut;
        this.gareFin = fin;
    }

    public GareImpl getGareDepart() {
        return gareDepart;
    }

    public void setGareDepart(GareImpl gareDepart) {
        this.gareDepart = gareDepart;
    }

    public GareImpl getGareFin() {
        return gareFin;
    }

    public void setGareFin(GareImpl gareFin) {
        this.gareFin = gareFin;
    }

    @Override
    public String toString() {
        return "Trajet : "+gareDepart.getName()+" à "+gareFin.getName();
    }
}
