import java.util.List;

/**
 * Created by Yoann on 05/12/2014.
 */
public interface Gare {
    void setEspaceQuai(EspaceQuai espaceQuai);
    Trajet acheterBillet(Voyageur voyageur);
    EspaceQuai entrerGare();
    void setListeTrajet(List<Trajet> listeTrajet);
    String getName();
}
