package main;

import entities.Entity;
import entities.PlayerEntity;
import spaces.World;

public class Console
{
    public static void main(String[] args) {
        GameServer server = new GameServer("129-122-001", 5);

        World.getAllEntities().addFirst(new Entity(
                "Steven the Duck", 12.5, 93.9, true, 10,999, 10));
        World.getAllEntities().addLast(new Entity(
                "Goodwin the Wizard", 10, 85, false, 45, 45, 199));
        World.getAllEntities().addLast(new Entity(
                "Just a Garden Wall of Roses", 7, 80.0, false, 0,9999, 1));
        World.getAllEntities().addLast(new Entity(
                "Boris the Duck", 10, 84.9, true, 10,999, 10));
        World.getAllEntities().addLast(new Entity(
                "The Beast From The Night'o'sphere", 30, 100.1, true, 20,400, 99));

        World.getAllEntities().addLast(new PlayerEntity(
                "Lena S 3go Pod'ezda", "Lenka", 23.7, 99.9, 45, 500, 107));
        World.getAllEntities().addFirst(new PlayerEntity(
                "The Nord Lord", "Vasya Pup", 15.3, 87, 60, 200, 50));

        for (int i=1; i< 30; i++){
            System.out.println("    Iteration № " + server.getServerTicks());
            GameServer.updateServer(server);
            try {
                Thread.sleep(1700);
            } catch (InterruptedException e) {
                e.printStackTrace();                    // Задержка обновления сервера
            }

        }
    }
}
