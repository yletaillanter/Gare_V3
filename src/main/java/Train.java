import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Yoann on 03/12/2014.
 */
public class Train extends Thread {

    final static int ATTENTE = 1000;
    final static int NB_PLACE_TOTAL = 20;


    List<Trajet> ListeTrajet;
    Trajet trajet;
    String nom;
    List<Voyageur> listeVoyageur;
    int placeDispo;
    boolean venteOuverte;

    public Train(String nom, List<Trajet> ListeTrajet){
        this.nom = nom;
        this.ListeTrajet = ListeTrajet;
        listeVoyageur = new ArrayList<Voyageur>();
        placeDispo = NB_PLACE_TOTAL;
        venteOuverte = false;
    }

    @Override
    public void run(){
        Collections.shuffle(ListeTrajet);
        trajet = ListeTrajet.get(0+(int)(Math.random()*2));
        System.out.println(getNom()+ " fait le " +trajet.toString());

        // GARE DE D2PART
        getTrajet().getGareDepart().entrerGare().entrerVoie(this);
        System.out.println(getNom()+ " arrivé en gare "+getTrajet().getGareDepart().getName());

        try {
            sleep(ATTENTE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getTrajet().getGareDepart().entrerGare().quitterVoie(this);
        System.out.println("Train: "+ getNom()+ "quitte gare: "+getTrajet().getGareDepart().getName());

        // TRAJET
        try {
            sleep(ATTENTE*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //GARE D'ARRIVEE
        getTrajet().getGareFin().entrerGare().entrerVoie(this);
        System.out.println("Train: "+ getNom()+ "arrivé en gare: "+getTrajet().getGareFin().getName());

        try {
            sleep(ATTENTE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getTrajet().getGareDepart().entrerGare().quitterVoie(this);
        System.out.println("Train : "+ getNom()+ "quitte gare: "+getTrajet().getGareFin().getName());
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    public void embarquer(Voyageur voyageur){
        listeVoyageur.add(voyageur);
    }

    synchronized public void majPlaceDispo(){
        placeDispo--;
    }

    public boolean isVenteOuverte() {
        return venteOuverte;
    }

    public void setVenteOuverte(boolean venteOuverte) {
        this.venteOuverte = venteOuverte;
    }

    public int getPlaceDispo() {
        return placeDispo;
    }

    public void setPlaceDispo(int placeDispo) {
        this.placeDispo = placeDispo;
    }

    public String getNom() {
        return nom;
    }

    public static int getNbPlaceTotal() {
        return NB_PLACE_TOTAL;
    }
}
