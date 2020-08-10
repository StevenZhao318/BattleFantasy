package game;

import java.util.Observable;
import java.util.Observer;

public class MonsterUpdater implements Observer {


    // REQUIRES: valid
    // EFFECT:
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg.toString() + " Loaded to Bestiary");
    }
}
