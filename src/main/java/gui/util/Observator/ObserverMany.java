package gui.util.Observator;

import be.Screen;

import java.util.List;

/**
 *
 */
public abstract class ObserverMany extends Observer {
    public abstract void update(List<Screen> addedScreens, List<Screen> deletedScreens, List<Screen> modifiedScreens);
}
