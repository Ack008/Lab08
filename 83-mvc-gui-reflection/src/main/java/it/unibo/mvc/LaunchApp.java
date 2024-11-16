package it.unibo.mvc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
import it.unibo.mvc.view.DrawNumberStdoutView;
import it.unibo.mvc.view.DrawNumberSwingView;

/**
 * Application entry-point.
 */
public final class LaunchApp {
    private static final String classPackageName = "java.main.it.unibo.mvc";
    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main(final String... args) {
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);
        for(int i = 0; i < 3; i++){
            instantiateAndAddViewsWithReflection(app, "it.unibo.mvc.view.DrawNumberSwingView");
            instantiateAndAddViewsWithReflection(app, "it.unibo.mvc.view.DrawNumberStdoutView");
        }
    }

    private static void instantiateAndAddViewsWithReflection(final DrawNumberController app, String nome) {
        try {
            Class<?> stdOutdClass = Class.forName(nome);
            Constructor<?> stdOutConstructor = stdOutdClass.getConstructor();
            app.addView((DrawNumberView)stdOutConstructor.newInstance());
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                IllegalAccessException | InvocationTargetException e) {
            System.out.println("Class not found or instantiate this");
        }
    }
}
