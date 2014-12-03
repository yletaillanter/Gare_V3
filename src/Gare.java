import java.util.List;

/**
 * Created by Yoann on 03/12/2014.
 */
public class Gare {

    private String name;
    private List<Trajet> ListeTrajet;

    public Gare (String name, List<Trajet> ListeTrajet){
        this.name = name;
        this.ListeTrajet = ListeTrajet;

    }

    synchronized public void acheterBillet(Voyageur voyageur){


    }

}
