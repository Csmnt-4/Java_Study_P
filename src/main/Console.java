package main;

import entities.Entity;
import entities.PlayerEntity;

public class Console
{
    public static void main(String[] args) {
        GameServer server = new GameServer("129-122-001", 5);

        server.getServerWorld().getAllEntities().addFirst(new Entity(server.getServerWorld(),
                "Steven the Duck", 12.5, 93.9, true, 10,999, 10));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "Goodwin the Wizard", 10, 85, false, 45, 45, 199));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "Just a Garden Wall of Roses", 7, 80.0, false, 0,9999, 1));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "Boris the Duck", 10, 84.9, true, 10,999, 10));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "The Beast From The Night'o'sphere", 30, 100.1, true, 20,400, 99));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "Beasty Boy", 17, 90.1, false, 20,400, 183));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "Dragon's Breath", 13, 85.7, false, 20,500, 900));

        server.getServerWorld().getAllEntities().addFirst(new Entity(server.getServerWorld(),
                "Steven the Duck 2", 15, 90.9, true, 10,999, 10));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "Goodwin the Wizard 2", 13, 80, false, 45, 45, 199));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "Boris the Duck 2", 9, 80.9, true, 10,999, 10));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "The Beast From The Night'o'sphere 2", 30, 100.1, true, 20,400, 99));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "Beasty Boy 2", 16, 91, false, 20,400, 183));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "Dragon's Breath 2", 9, 87, true, 20,500, 900));

        server.getServerWorld().getAllEntities().addLast(new PlayerEntity(server.getServerWorld(),
                "Lena S 3go Pod'ezda", "Lenka", 16, 90, 45, 500, 107));
        server.getServerWorld().getAllEntities().addFirst(new PlayerEntity(server.getServerWorld(),
                "The Nord Lord", "Vasya Pup", 15.3, 87, 60, 200, 50));

        for (int i=1; i< 30; i++){
            System.out.println(" ");
            System.out.println("Iteration № " + server.getServerTicks());
            GameServer.updateServer(server);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();                    // Задержка обновления сервера
            }

        }
    }
}
