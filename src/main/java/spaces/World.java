package spaces;

import entities.Entity;
import java.io.Serializable;
import java.util.LinkedList;

import static entitiesActions.Sort.sort;

public class World implements Serializable {
    private String ip = "192.10.1.1";
    private String worldName = "Standard";
    static LinkedList<Entity> allEntities = new LinkedList<>();

    public World(String ip, String worldName) {
        this.ip = ip;
        this.worldName = worldName;
    }

    public World(String ip) {
        this.ip = ip;
    }

    public World() {
    }

    @Override
    public String toString() {
        return "World{" +
                "ip='" + ip + '\'' +
                ", worldName='" + worldName + '\'' +
                '}';
    }

    public static LinkedList<Entity> getEntitiesInRegion (int x, int y, double  range) {
        return sort(x,y,range);
    }

    public static LinkedList<Entity> getEntitiesNearEntity (Entity entity, double  range) {
        double x = entity.getPosX();
        double y = entity.getPosZ();
        return sort(x,y,range);
    }

    public static void updateWorld(World world, int diff) {
        for(Entity e : getAllEntities()){
            e.update(diff);
        }
        getAllEntities().removeIf(entity -> entity.getHealth() <=0);
        getAllEntities().removeIf(entity -> entity.getHealth() ==0); // Так захотелось.
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    public static LinkedList<Entity> getAllEntities() {
        return allEntities;
    }

    public static void setAllEntities(LinkedList<Entity> allE) {
        allEntities = allE;
    }
}
