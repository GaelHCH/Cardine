package Main;

import GameWindow.Scene;

public class Main {

    public static void main(String[] args) {
        //Testing scene creation
        Scene tstScene = new Scene("Basic Frame", 600,600);
        //Add ./ at front (not really needed, on both platforms)
        tstScene.addBackground("res/back_copy.png");
    }
}
