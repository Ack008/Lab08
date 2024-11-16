package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberStdoutView implements DrawNumberView {
    private static final String FRAME_NAME = "Draw Number App";
    private static final String QUIT = "Quit";
    private static final String RESET = "Reset";
    private static final String GO = "Go";
    private static final String NEW_GAME = ": a new game starts!";
    private DrawNumberController controller; 
    @Override
    public void setController(final DrawNumberController observer) {
        this.controller = observer;
    }

    @Override
    public void start() {
    }

    @Override
    public void result(DrawResult res) {
        switch (res) {
            case YOURS_HIGH, YOURS_LOW -> System.out.println(res.getDescription());
            case YOU_WON -> System.out.println(res.getDescription() + NEW_GAME);
            case YOU_LOST -> System.out.println(res.getDescription() + NEW_GAME + "Lost");
            default -> throw new IllegalStateException("Unknown game state");
        }
    }
    
}
