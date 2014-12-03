import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Yoann on 03/12/2014.
 */
public class Voyageur extends Thread {

    private String name;
    List<Gare> listeGare;
    Gare gareAchat;
    Gare gareDepart;
    Gare gareArrive;

    public Voyageur(String name, List<Gare> listeGare){
        this.name = name;
        this.listeGare = listeGare;
    }

    @Override
    public void run(){
        Collections.shuffle(listeGare);
        gareAchat = listeGare.get(1);
        gareAchat.acheterBillet(this);




    }

}
