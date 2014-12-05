import java.util.List;

/**
 * Created by Yoann on 03/12/2014.
 */
public class GareImpl implements Gare {

    private String name;
    private List<Trajet> ListeTrajet;
    EspaceQuai espaceQuai;

    public GareImpl(String name){
        this.name = name;

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

    @Override
    public void setEspaceQuai(EspaceQuai espaceQuai) {
        this.espaceQuai = espaceQuai;
    }
}
