import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by 14007427 on 18/11/14.
 */
public class EspaceQuai {

    private final int NB_VOIES = 3;
    private int voiesDispo;
    private int trainsEnQuai;
    private ArrayList<Train> listeTrainQuai;
    private Billetterie billetterie;

    public EspaceVente espaceVente;

    public EspaceQuai(EspaceVente espaceVente, Billetterie billetterie){
        voiesDispo = NB_VOIES;
        trainsEnQuai = 0;
        listeTrainQuai = new ArrayList<Train>();
        this.espaceVente = espaceVente;
        this.billetterie = billetterie;
    }

    synchronized public Billetterie getBilletterie() {
        return billetterie;
    }

    synchronized public void entrerVoie(Train train){

        while(voiesDispo == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        voiesDispo--;

        listeTrainQuai.add(train);
        train.setVenteOuverte(true);
        billetterie.addPlaceDisponible(train.getTrajet(),train.getPlaceDispo());

        synchronized (espaceVente){
            espaceVente.notifyAll();
        }

        System.out.println("Train en gare : " + train.getNom());
    }

    synchronized public void quitterVoie(Train train){
        //train.setVenteOuverte(false);
        //if(train.listeVoyageurIsEmpty()){
        listeTrainQuai.remove(train);
        billetterie.removePlaceDisponible(train.getTrajet(),(train.getNbPlaceTotal()-train.getPlaceDispo()));
        System.out.println( train.getNom() +" quitte gare");
        voiesDispo++;
        // Pour les trains en attente d'un quai libre.
        notifyAll();
    }

    synchronized public boolean accederAuTrain (Voyageur voyageur) {
        Iterator<Train> iteratrain = listeTrainQuai.iterator();

        while (iteratrain.hasNext()) {
            Train trainListe = iteratrain.next();

            if (trainListe.getTrajet().equals(voyageur.getTrajet())) {
                trainListe.embarquer(voyageur);
                trainListe.majPlaceDispo();
                System.out.println("Voyageur "+voyageur.getNom()+" j'accède au "+trainListe.getNom());
                return true;
            }
        }
        return false;
    }

    synchronized public EspaceVente getEspaceVente() {
        return espaceVente;
    }

    synchronized public ArrayList<Train> getListeTrainQuai(){
        return listeTrainQuai;
    }




}
