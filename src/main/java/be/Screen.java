package be;

import java.util.ArrayList;
import java.util.List;

public class Screen {

    private int id;
    private String name;
    private int refreshTime;
    private List<Integer> userIDs; //it wont be included in hashcode
    private List<ScreenElement> screenElementList;
    private boolean refreshNow = false;

    {
        screenElementList = new ArrayList<>();
    }

    public boolean isRefreshNow() {
        return refreshNow;
    }

    /**
     * after refreshing we need to set it back to false
     * @param refreshNow
     */
    public void setRefreshNow(boolean refreshNow) {
        this.refreshNow = refreshNow;
    }

    public Screen(String name) {
        this.name = name;
    }

    public void addListElement(ScreenElement screenElement) {
        screenElementList.add(screenElement);
    }

    public List<ScreenElement> getScreenElementList() {
        return screenElementList;
    }

    /**
     * initially this constructor will be used.
     *
     * @param id
     * @param name
     * @param screenElementList
     */
    public Screen(int id, String name, List<ScreenElement> screenElementList) {
        this.id = id;
        this.name = name;
        this.screenElementList = screenElementList;
    }


    public Screen(int id, String name, int refreshTime) {
        this.id = id;
        this.name = name;
        this.refreshTime = refreshTime;
    }


    public Screen() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(int refreshTime) {
        this.refreshTime = refreshTime;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Screen screen = (Screen) o;

        if (id != screen.id) return false;
        if (refreshTime != screen.refreshTime) return false;
        if (refreshNow != screen.refreshNow) return false;
        if (!name.equals(screen.name)) return false;
        if (userIDs != null ? !userIDs.equals(screen.userIDs) : screen.userIDs != null) return false;
        return screenElementList.equals(screen.screenElementList);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + refreshTime;
        result = 31 * result + (userIDs != null ? userIDs.hashCode() : 0);
        result = 31 * result + screenElementList.hashCode();
        result = 31 * result + (refreshNow ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", refreshTime=" + refreshTime +
                ", userIDs=" + userIDs +
                ", screenElementList=" + screenElementList +
                ", refreshNow=" + refreshNow +
                '}';
    }

 */
}
