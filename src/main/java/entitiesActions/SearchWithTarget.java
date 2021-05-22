package entitiesActions;

import entities.Entity;
import spaces.World;

import java.util.Comparator;
import java.util.LinkedList;

public class SearchWithTarget {
    public static void target (Entity searcher) {

        //  Поиск неагрессивных сущностей поблизости и установка "цели", куда идти

        if (searcher.getAttackedCreatureId() > 0) {
            System.out.println("\n\tIt's " + searcher.getName() + " turn.\n\tIt's target is " + searcher.getAttackedCreatureId());
        } else {
            System.out.println("\n\t" + searcher.getName() + " seems AFK.");
        }
        if (searcher.isAggressive() && searcher.getWalkingX() == 0 && searcher.getWalkingZ() == 0 && searcher.getIndicator() == 0) {
            LinkedList<Destination> entityDestination = new LinkedList<>();
            for (Entity al : World.getAllEntities()) {
                if (!al.isAggressive()) {
                    if (20 >= Math.sqrt(Math.pow((searcher.getPosX() - al.getPosX()), 2) + Math.pow((searcher.getPosZ() - al.getPosZ()), 2))) {
                        double a = al.getPosX();
                        double b = al.getPosZ();
                        double c = Math.sqrt(Math.pow((searcher.getPosX() - al.getPosX()), 2) + Math.pow((searcher.getWalkingZ() - al.getPosZ()), 2));
                        entityDestination.addFirst(new Destination(a, b, c, al.getId()));
                        System.out.println("*New destination discovered by " + searcher.getName() + "*");
                    }
                }
            }

        //  Сортировка сущностей в радиусе по близости

            entityDestination.sort(Comparator.comparing(Destination::getLength));
            searcher.setAttackedCreatureId(entityDestination.getFirst().getId());
            searcher.setWalkingX(entityDestination.getFirst().getX());
            searcher.setWalkingZ(entityDestination.getFirst().getZ());

            System.out.println("    The new destination of " + searcher.getName() + " is: id = " + searcher.getAttackedCreatureId() + ", (" + searcher.getWalkingX() + ", " + searcher.getWalkingZ() + ")");

            searcher.setWalkingX(searcher.getWalkingX() - 1);
            searcher.setWalkingZ(searcher.getWalkingZ() - 1);
            searcher.setIndicator(1);
        }
    }
}
