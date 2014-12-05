import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Context;
import org.restlet.data.Protocol;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yoann on 03/12/2014.
 */
public class Main {

    /** Hide constructor. */
    private Main()
    {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception
    {

        final int NB_VOYAGEUR = 100;
        final int NB_TRAIN = 5;

        GareImpl A = new GareImpl("A");
        GareImpl B = new GareImpl("B");
        GareImpl C = new GareImpl("C");

        List<Trajet> listeTrajet = new ArrayList<Trajet>();
        listeTrajet.add(new Trajet(A,B));
        listeTrajet.add(new Trajet(B,A));
        listeTrajet.add(new Trajet(B,C));
        listeTrajet.add(new Trajet(C,B));
        listeTrajet.add(new Trajet(A,C));
        listeTrajet.add(new Trajet(C,A));



        // ############################### REST SERVER ###########################

        // Create a component
        Component component = new Component();
        Context context = component.getContext().createChildContext();
        component.getServers().add(Protocol.HTTP, 8125);

        // Create an application
        Application application = new BilletterieApplication(context);

        //Add the billetterie to the context
        Billetterie billetterie = new Billetterie(listeTrajet);
        context.getAttributes().put("billetterie", billetterie);
        component.getDefaultHost().attach(application);

        // Start the component
        component.start();

        // ################################# FIN SERVER REST ~#####################

        EspaceVente espaceVenteA = new EspaceVente();
        EspaceVente espaceVenteB = new EspaceVente();
        EspaceVente espaceVenteC = new EspaceVente();

        EspaceQuai espaceQuaiA = new EspaceQuai(espaceVenteA,billetterie);
        EspaceQuai espaceQuaiB = new EspaceQuai(espaceVenteB,billetterie);
        EspaceQuai espaceQuaiC = new EspaceQuai(espaceVenteC,billetterie);

        A.setEspaceQuai(espaceQuaiA);
        B.setEspaceQuai(espaceQuaiB);
        C.setEspaceQuai(espaceQuaiC);

        espaceVenteA.setEspaceQuai(espaceQuaiA);
        espaceVenteB.setEspaceQuai(espaceQuaiB);
        espaceVenteC.setEspaceQuai(espaceQuaiC);

        List<GareImpl> listeGare = new ArrayList<GareImpl>();
        listeGare.add(A);
        listeGare.add(B);
        listeGare.add(C);

        //billetterie.setListeTrajet(listeTrajet);

        A.setListeTrajet(listeTrajet);
        B.setListeTrajet(listeTrajet);
        C.setListeTrajet(listeTrajet);

        espaceVenteA.setListeTrajet(listeTrajet);
        espaceVenteB.setListeTrajet(listeTrajet);
        espaceVenteC.setListeTrajet(listeTrajet);

        for(int j = 0; j< NB_TRAIN ; j++){
            new Train("train N°"+j,listeTrajet).start();
        }

        for(int i = 0; i< NB_VOYAGEUR ; i++){
            new Voyageur("voyageur N°"+i,listeGare).start();
        }


    }
}
