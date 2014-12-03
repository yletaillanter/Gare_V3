/**
 * Created by Yoann on 03/12/2014.
 */
public class Trajet {
    private String debut;
    private String fin;

    public Trajet(String debut, String fin){
        this.debut = debut;
        this.fin = fin;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
}
