import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Yoann on 03/12/2014.
 */
public class Billetterie extends ServerResource {
    private Map<Trajet,Integer> mapPlaceDisponible;
    private List<Trajet> listeTrajet;

    public Billetterie(){
        mapPlaceDisponible = new HashMap<Trajet, Integer>();

    }

    synchronized public void addPlaceDisponible(Trajet trajet, int place){
        int placeDispo = mapPlaceDisponible.get(trajet);
        placeDispo+=place;
        mapPlaceDisponible.put(trajet, placeDispo);
    }

    synchronized public void removePlaceDisponible(Trajet trajet, int place){
        int placeDispo = mapPlaceDisponible.get(trajet);
        placeDispo-=place;
        mapPlaceDisponible.put(trajet, placeDispo);
    }


    synchronized public int getNbPlaceDispo(Trajet trajet){
        return mapPlaceDisponible.get(trajet);
    }

    synchronized public void majNbPlaceDispo(Trajet trajet){
        int placeDispo = mapPlaceDisponible.get(trajet);
        placeDispo--;
        mapPlaceDisponible.put(trajet, placeDispo);
    }

    public void setListeTrajet(List<Trajet> listeTrajet) {
        this.listeTrajet = listeTrajet;
        setUpTrajetMap(listeTrajet);
    }

    private void setUpTrajetMap(List<Trajet> listeTrajet){
        for(Trajet t : listeTrajet){
            mapPlaceDisponible.put(t, 0);
        }
    }

    @Get("json")
    public Representation getTrajet() throws JSONException {
        JSONObject trajets = new JSONObject();



        JsonRepresentation result = new JsonRepresentation(trajets);
        return result;

    }



}
