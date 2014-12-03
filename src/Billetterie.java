import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yoann on 03/12/2014.
 */
public class Billetterie {
    Map<Trajet,Integer> placeDisponible;

    public Billetterie(List<Trajet> listeTrajet){
        placeDisponible = new HashMap<Trajet, Integer>();
        for(Trajet t : listeTrajet){
            placeDisponible.put(t,0);
        }
    }

}
