package back;

import entities.Entity;
import entities.PlayerEntity;
import spaces.World;

public class Console
{
    public static void main(String[] args) {
        World world1 = new World("192.10.0.1", "TEST");
        GameServer server = new GameServer(world1,0, 10,1700, 3,5,"192.206.1.0");

        server.getServerWorld().getAllEntities().addFirst(new Entity(server.getServerWorld(),
                "Steven the Duck", 12.5, 13.9, true, 10,999, 10));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "Goodwin the Wizard", 10, 5, false, 45, 45, 199));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "Just a Garden Wall of Roses", 7, 0, false, 0,9999, 1));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "Boris the Duck", 10, 4.9, true, 10,999, 10));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "The Beast From The Night o' sphere", 30, 20.1, true, 20,400, 99));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "Beastly Boy", 17, 10.1, false, 20,400, 183));
        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
                "Dragon's Breath", 13, 5.7, false, 20,500, 900));

        server.getServerWorld().getAllEntities().addLast(new PlayerEntity(server.getServerWorld(),
                "Lena S", "Lenka", 16, 10, 45, 500, 107));
        server.getServerWorld().getAllEntities().addFirst(new PlayerEntity(server.getServerWorld(),
                "The Nordic Lord", "Vanya Pup", 15.3, 7, 60, 200, 50));

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