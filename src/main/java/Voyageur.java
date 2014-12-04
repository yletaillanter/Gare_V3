import java.util.Collections;
import java.util.List;

/**
 * Created by Yoann on 03/12/2014.
 */
public class Voyageur extends Thread {

    private String name;
    List<Gare> listeGare;
    Gare gareAchat;
    Trajet trajet;
    boolean aUnGuichet = false;
    boolean ticketValide;

    public Voyageur(String name, List<Gare> listeGare){
        this.name = name;
        this.listeGare = listeGare;
        aUnGuichet = false;
    }
    //test

    @Override
    public void run(){
        Collections.shuffle(listeGare);
        gareAchat = listeGare.get(1);
        System.out.println("voyageur "+name+" "+toStringGareAchat());
        setTrajet(gareAchat.acheterBillet(this));
        System.out.println(name + " fais " + this.getTrajet().toString());
        if(trajet.getGareDepart().entrerGare().accederAuTrain(this));
    }

    public boolean isaUnGuichet() {
        return aUnGuichet;
    }

    public void setaUnGuichet(boolean aUnGuichet) {
        this.aUnGuichet = aUnGuichet;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    public boolean isTicketValide() {
        return ticketValide;
    }

    public void setTicketValide(boolean ticketValide) {
        this.ticketValide = ticketValide;
    }

    public String toStringGareAchat(){
        return "Gare achat:"+ gareAchat.getName();
    }

    public String getNom() {
        return name;
    }
}
