import java.util.List;

/**
 * Created by Yoann on 03/12/2014.
 */
public class Gare {

    private String name;
    private List<Trajet> ListeTrajet;
    EspaceQuai espaceQuai;

    public Gare (String name,EspaceQuai espaceQuai){
        this.name = name;
        this.espaceQuai = espaceQuai;
    }

    synchronized public Trajet acheterBillet(Voyageur voyageur){

        espaceQuai.getEspaceVente().getGuichet(voyageur);
        return espaceQuai.getEspaceVente().getBillet(voyageur);
    }

    synchronized public EspaceQuai entrerGare(){
        return espaceQuai;
    }

    public void setListeTrajet(List<Trajet> listeTrajet) {
        ListeTrajet = listeTrajet;
    }

    public String getName() {
        return name;
    }
}
