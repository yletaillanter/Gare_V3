import java.util.*;

/**
 * Created by 14007427 on 18/11/14.
 */
public class EspaceVente {


    private final int TEMPS_IMPRESSION_TICKET = 5;
    private int nbGuichet = 4;
    private int nbGuichetDispo;
    private EspaceQuai espaceQuai;
    private List<Trajet> listeTrajet;


    public EspaceVente() {
        nbGuichetDispo = nbGuichet;
    }

    public void setListeTrajet(List<Trajet> listeTrajet) {
        this.listeTrajet = listeTrajet;
    }

    synchronized public EspaceQuai getEspaceQuai() {
        return espaceQuai;
    }

    synchronized public void setEspaceQuai(EspaceQuai espaceQuai) {
        this.espaceQuai = espaceQuai;
    }

    synchronized void getGuichet(Voyageur voyageur) {

        while (nbGuichetDispo == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nbGuichetDispo--;
        voyageur.setaUnGuichet(true);
    }

    synchronized public Trajet getBillet(Voyageur voyageur){

        while(true){
            Collections.shuffle(listeTrajet);

            Iterator<Trajet> iteratrajet = listeTrajet.iterator();

            while(iteratrajet.hasNext()){
                Trajet trajetCourant = iteratrajet.next();

                if(espaceQuai.getBilletterie().getNbPlaceDispo(trajetCourant)>0){

                    //voyageur.setTrajet(trajetCourant);
                    espaceQuai.getBilletterie().getNbPlaceDispo(trajetCourant);
                    voyageur.setTicketValide(true);

                    try {
                        Thread.sleep(TEMPS_IMPRESSION_TICKET);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //test

                    nbGuichetDispo++;
                    notifyAll();
                    return trajetCourant;
                }
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

/*
        //getGuichet(voyageur);

        ArrayList<Train> listeTrain = espaceQuai.getListeTrainQuai();

        while(true){
            Collections.shuffle(listeTrain);
            Iterator<Train> iteratrain = listeTrain.iterator();

            while(iteratrain.hasNext()){
                Train train = iteratrain.next();

                if (train.getPlaceDisponible() > 0 && train.venteIsOuverte()) {

                    train.majNbPlaceDispo(); // place --
                    train.addVoyageur(voyageur);

                    voyageur.setTrain(train);
                    voyageur.setTicketValide(true);

                    System.out.println(train.getNomTrain() + train.getPlaceDisponible());

                    try {
                        Thread.sleep(TEMPS_IMPRESSION_TICKET);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    nbGuichetDispo++;
                    notifyAll();
                    return train;
                }
            }

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    */