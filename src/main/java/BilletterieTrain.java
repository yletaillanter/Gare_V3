import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

/**
 * Created by Yoann on 05/12/2014.
 */
public class BilletterieTrain extends ServerResource {

    private Billetterie billetterie;
    private Train train;

    public BilletterieTrain(){
        super();
        billetterie = (Billetterie) getApplication().getContext().getAttributes().get("billetterie");
    }

    @Override
    protected void doInit() throws ResourceException {
        String nomTrain = (String) getRequest().getAttributes().get("nom");

    }

    @Put("Json")
    public void ajoutPlaceTrain() throws Exception {



    }






}
