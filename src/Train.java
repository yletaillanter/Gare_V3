import java.util.Collections;
import java.util.List;

/**
 * Created by Yoann on 03/12/2014.
 */
public class Train extends Thread {

    List<Trajet> ListeTrajet;
    Trajet trajet;
    String nom;

    public Train(String nom, List<Trajet> ListeTrajet){
        this.nom = nom;
        this.ListeTrajet = ListeTrajet;
    }

    @Override
    public void run(){
        Collections.shuffle(ListeTrajet);
        trajet = ListeTrajet.get(1);



    }
}
