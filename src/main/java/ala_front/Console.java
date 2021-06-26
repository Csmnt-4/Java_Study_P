package ala_front;

import back.GameServer;
import com.esotericsoftware.kryo.Kryo;
import entities.Entity;
import entities.PlayerEntity;
import spaces.World;

public class Console
{
    public static void main(String[] args) {
        Kryo kryo = new Kryo();
        kryo.register(World.class);
        kryo.register(Entity.class);
        kryo.register(PlayerEntity.class);

        GameServer server = new GameServer();

        for (int i=1; i< 30; i++){
            System.out.println(" ");
            System.out.println("Iteration № " + server.getServerTicks());
            GameServer.updateServer(server);

            try {
                Thread.sleep(server.getConfig().getSavePeriod());  // Задержка обновления сервера
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
//
//    //  "Обычные" сущности
//        server.getServerWorld().getAllEntities().addFirst(new Entity(server.getServerWorld(),
//                "Steven the Duck", 12.5, 13.9, true, 10,999, 10));
//        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
//                "Goodwin the Wizard", 10, 5, false, 45, 45, 199));
//        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
//                "Just a Garden Wall of Roses", 7, 0, false, 0,9999, 1));
//        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
//                "Boris the Duck", 10, 4.9, true, 10,999, 10));
//        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
//                "The Beast From The Night o' sphere", 30, 20.1, true, 20,400, 99));
//        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
//                "Beastly Boy", 17, 10.1, false, 20,400, 183));
//        server.getServerWorld().getAllEntities().addLast(new Entity(server.getServerWorld(),
//                "Dragon's Breath", 13, 5.7, false, 20,500, 900));
//
//// Сущности "игроков"
//        server.getServerWorld().getAllEntities().addLast(new PlayerEntity(server.getServerWorld(),
//                "Lena S", "Lenka", 16, 10, 45, 500, 107));
//        server.getServerWorld().getAllEntities().addFirst(new PlayerEntity(server.getServerWorld(),
//                "The Nordic Lord", "Vanya Pup", 15.3, 7, 60, 200, 50));
//
//        try {
//            FileUtils.saveConfig(server.getConfig(), server.getConfigSaveFile());
//            FileUtils.saveWorld(server.getServerWorld(), server.getWorldSaveFile());
//            FileUtils.saveEnt(server.getServerWorld().getAllEntities(), server.getEntitiesSaveFile());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


// Testing defaults
//    public static void main(String[] args) throws FileNotFoundException {
//        Kryo k = new Kryo();
//        k.register(World.class);
//        k.register(LinkedList.class);
//        k.register(Entity.class);
//        k.register(PlayerEntity.class);
//
//        File ft = new File("c:\\Server\\data\\test.bin");
//        World gc = new World();
//        gc.getAllEntities().addLast(new Entity(gc,"Dragon's Breath", 13, 5.7, false, 20,0, 900));
//        gc.getAllEntities().addLast(new PlayerEntity(gc,"Exit", "Biggie",13, 5.7, 20,0, 900));
//
//        Output o = new Output(new FileOutputStream(ft));
//        k.writeObject(o, gc.getAllEntities());
//        System.out.println(gc.getAllEntities());
//        o.close();
//
//        gc.getAllEntities().removeIf(entity -> entity.getHealth() ==0);
//        System.out.println(gc.getAllEntities());
//
//        Input i = new Input(new FileInputStream(ft));
//
//        gc.setAllEntities(k.readObject(i, LinkedList.class));
//        System.out.println(gc.getAllEntities());
//        i.close();
//    }

