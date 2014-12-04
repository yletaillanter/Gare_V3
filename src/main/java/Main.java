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



        Billetterie billetterie = new Billetterie();

        EspaceVente espaceVenteA = new EspaceVente();
        EspaceVente espaceVenteB = new EspaceVente();
        EspaceVente espaceVenteC = new EspaceVente();

        EspaceQuai espaceQuaiA = new EspaceQuai(espaceVenteA,billetterie);
        EspaceQuai espaceQuaiB = new EspaceQuai(espaceVenteB,billetterie);
        EspaceQuai espaceQuaiC = new EspaceQuai(espaceVenteC,billetterie);

        espaceVenteA.setEspaceQuai(espaceQuaiA);
        espaceVenteB.setEspaceQuai(espaceQuaiB);
        espaceVenteC.setEspaceQuai(espaceQuaiC);

        Gare A = new Gare("A", espaceQuaiA);
        Gare B = new Gare("B",espaceQuaiB);
        Gare C = new Gare("C",espaceQuaiC);

        List<Trajet> listeTrajet = new ArrayList<Trajet>();
        listeTrajet.add(new Trajet(A,B));
        listeTrajet.add(new Trajet(B,A));
        listeTrajet.add(new Trajet(B,C));
        listeTrajet.add(new Trajet(C,B));
        listeTrajet.add(new Trajet(A,C));
        listeTrajet.add(new Trajet(C,A));

        List<Gare> listeGare = new ArrayList<Gare>();
        listeGare.add(A);
        listeGare.add(B);
        listeGare.add(C);

        billetterie.setListeTrajet(listeTrajet);

        A.setListeTrajet(listeTrajet);
        B.setListeTrajet(listeTrajet);
        C.setListeTrajet(listeTrajet);

        espaceVenteA.setListeTrajet(listeTrajet);
        espaceVenteB.setListeTrajet(listeTrajet);
        espaceVenteC.setListeTrajet(listeTrajet);

        for(int j = 0; j< NB_TRAIN ; j++){
            new Train("train :"+j,listeTrajet).start();
        }

        for(int i = 0; i< NB_VOYAGEUR ; i++){
            new Voyageur("voyageur N°"+i,listeGare).start();
        }
    }
}
