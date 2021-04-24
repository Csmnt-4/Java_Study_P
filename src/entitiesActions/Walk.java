package entitiesActions;

import entities.Entity;
import spaces.World;

public class Walk {
    public static void walk (Entity walker) {
        if ((walker.getWalkingX()!= 0) && (walker.getWalkingZ() != 0) && (walker.getIndicator() == 1)) {
            if (walker.getWalkingX() > walker.getPosX()) {
                walker.setPosX(walker.getPosX() + walker.getSpeed() / 30);
            } else if (walker.getWalkingX() < walker.getPosX()) {
                walker.setPosX(walker.getPosX() - walker.getSpeed() / 30);
            }
            if (walker.getWalkingZ() > walker.getPosZ()) {
                walker.setPosZ(walker.getPosZ() + walker.getSpeed() / 30);
            } else if (walker.getWalkingZ() < walker.getPosZ()) {
                walker.setPosZ(walker.getPosZ() - walker.getSpeed() / 30);
            }

            if (Math.sqrt(Math.pow((walker.getPosX() - walker.getWalkingX()), 2)
                        + Math.pow((walker.getPosZ() - walker.getWalkingZ()), 2))
                    <= 3 && walker.getIndicator() == 1) {
                walker.setIndicator(2);
                for (Entity p : World.getAllEntities()) {
                    if (p.getId() == walker.getAttackedCreatureId()) {
                        System.out.println("    " + walker.getName() + " is ready to attack " + p.getName());
                    }
                }
            } else {
                System.out.printf("    " + walker.getName() + " is walking...\n    Its coordinates are: x= %.2f, y=%.2f\n", walker.getPosX(), walker.getPosZ());
            }
        }
    }
}
