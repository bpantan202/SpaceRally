package GUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RenderableHolder {
    private static ArrayList<Renderable> objects;
    private Comparator<Renderable> comparator;

    //singleton method
    private static final RenderableHolder instance = new RenderableHolder();

    //constructor
    public RenderableHolder() {
        //init
        objects = new ArrayList<Renderable>();
        //adjust comparator
        comparator = (Renderable o1, Renderable o2) -> {
            if (o1.getZ() > o2.getZ()) {
                return 1;
            }
            return -1;
        };
    }

    //add entity to array and sort with z
    public void add(Renderable object) {
        objects.add(object);
        Collections.sort(objects,comparator);
    }

    //singleton method
    public static RenderableHolder getInstance() {
        return instance;
    }


    //getter
    public ArrayList<Renderable> getObjects() {
        return objects;
    }


    //fetch
    public void removeThis(Renderable x) {
        objects.remove(x);
    }

}
