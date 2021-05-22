package entitiesActions;

import entities.Entity;
import spaces.World;

import java.util.Comparator;
import java.util.LinkedList;

public class Sort {
    public static LinkedList<Entity> sort (double x, double y, double range) {
        LinkedList<Destination> ranged = new LinkedList<>();

        for (Entity e : World.getAllEntities()) {
            if (!e.isAggressive()) {
                if (range >= Math.sqrt(Math.pow((x - e.getPosX()), 2) + Math.pow((y - e.getPosZ()), 2))) {
                    double a = e.getPosX();
                    double b = e.getPosZ();
                    double c = Math.sqrt(Math.pow((x - e.getPosX()), 2) + Math.pow((y - e.getPosZ()), 2));
                    ranged.addFirst(new Destination(a, b, c, e.getId()));
                }
            }
        }

        //  Сортировка сущностей в радиусе по близости

        ranged.sort(Comparator.comparing(Destination::getLength));

        LinkedList<Entity> rangedEntities = new LinkedList<>();
        for (Destination d : ranged) {
            for (Entity e : World.getAllEntities()) {
                if (e.getId() == d.getId())
                {
                    rangedEntities.addLast(e);
                }
            }
        }

        return rangedEntities;
    }
}