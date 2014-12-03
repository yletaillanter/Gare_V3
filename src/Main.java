import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yoann on 03/12/2014.
 */
public class Main {


    public static void main(String[] args){

        final int NB_VOYAGEUR = 200;
        final int NB_TRAIN = 10;

        List<Trajet> listeTrajet = new ArrayList<Trajet>();
        listeTrajet.add(new Trajet("A","B"));
        listeTrajet.add(new Trajet("B","A"));
        listeTrajet.add(new Trajet("B","C"));
        listeTrajet.add(new Trajet("C","B"));
        listeTrajet.add(new Trajet("A","C"));
        listeTrajet.add(new Trajet("C","A"));

        List<Gare> listeGare = new ArrayList<Gare>();
        listeGare.add(new Gare("A",listeTrajet));
        listeGare.add(new Gare("B",listeTrajet));
        listeGare.add(new Gare("C",listeTrajet));

        for(int i = 0; i< NB_VOYAGEUR ; i++){
            new Voyageur("i",listeGare).start();
        }

        for(int i = 0; i< NB_VOYAGEUR ; i++){
            new Train("i",listeTrajet).start();
        }


    }
}
