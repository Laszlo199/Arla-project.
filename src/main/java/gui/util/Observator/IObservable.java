package gui.util.Observator;

import be.Screen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 */
public interface IObservable {
    //by default its public and abstract
    void notifyManyObservers(List<Screen> added, List<Screen> deleted, List<Screen> modified);
    void notifySingleObservers(List<Screen> modified);
}