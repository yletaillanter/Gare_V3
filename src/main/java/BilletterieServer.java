import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Yoann on 05/12/2014.
 */
public class BilletterieServer extends ServerResource {

    private Billetterie billetterie;

    /**
     * Constructor
     */
    public BilletterieServer(){
        super();
        billetterie = (Billetterie) getApplication().getContext().getAttributes().get("billetterie");
    }

    /**
     *
     * @return les trajets +nb de placent dispo
     * @throws JSONException
     */
    @Get("json")
    public Representation getTrajet() throws JSONException {
        Collection<JSONObject> jsonTrajets = new ArrayList<JSONObject>();

        //for(Trajet trajet : listeTrajet){
        Iterator<Trajet> iteratrajet = billetterie.getListeTrajet().iterator();
        while(iteratrajet.hasNext()){
            JSONObject json = new JSONObject();
            Trajet trajet = iteratrajet.next();
            json.put("trajet", trajet.toString());
            json.put("place", billetterie.getMapPlaceDisponible().get(trajet));
            jsonTrajets.add(json);
        }

        JSONArray jsonArray = new JSONArray(jsonTrajets);
        JsonRepresentation result = new JsonRepresentation(jsonArray);
        return result;
    }

}
