package spaces;

import entities.Entity;

import java.util.LinkedList;

public class World {
    private String ip;
    private String worldName;
    static LinkedList<Entity> allEntities = new LinkedList<>();

    public World(String ip, String worldName) {
        this.ip = ip;
        this.worldName = worldName;
    }

    @Override
    public String toString() {
        return "World{" +
                "ip='" + ip + '\'' +
                ", worldName='" + worldName + '\'' +
                '}';
    }



    public static void updateWorld(World world, int diff) {
        for(Entity e : getAllEntities()){
            e.update(diff);
        }
        getAllEntities().removeIf(entity -> entity.getHealth() <=0);
        getAllEntities().removeIf(entity -> entity.getHealth() ==0);
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

    public static void setAllEntities(LinkedList<Entity> allEntities) {
        World.allEntities = allEntities;
    }
}
