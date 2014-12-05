import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * Created by Yoann on 05/12/2014.
 */
public class BilletterieApplication extends Application {

    public BilletterieApplication(Context context){
        super(context);
    }

    @Override
    public Restlet createInboundRoot()
    {
        Router router = new Router(getContext());
        router.attach("/trajet", BilletterieServer.class);
        router.attach("/trajet/{trajet}", BilletterieServer.class);
        router.attach("/trajet/{trainID}/{trajet}/{nbPlace}", BilletterieServer.class);
        return router;
    }

}
