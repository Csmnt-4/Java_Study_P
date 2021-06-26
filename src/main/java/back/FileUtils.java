package back;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import entities.Entity;
import entities.PlayerEntity;
import spaces.World;

import java.io.*;
import java.util.LinkedList;

public class FileUtils {
    public static void saveWorld(World w, File f) throws IOException {
        Kryo k = new Kryo();
        k.register(spaces.World.class);
        k.register(Entity.class);
        k.register(PlayerEntity.class);
        k.register(LinkedList.class);

        Output o = new Output(new FileOutputStream(f));
        k.writeObject(o, w);

        o.close();
    }

    public static void saveEnt(LinkedList l, File f) throws IOException {
        Kryo k = new Kryo();
        k.register(spaces.World.class);
        k.register(Entity.class);
        k.register(PlayerEntity.class);
        k.register(LinkedList.class);

        Output o = new Output(new FileOutputStream(f));
        k.writeObject(o, l);

        o.close();
    }

    public static World loadWorld(File f) throws IOException {
        Kryo k = new Kryo();
        k.register(spaces.World.class);

        Input i = new Input(new FileInputStream(f));
        World w = k.readObject(i, World.class);

        i.close();

        return w;
    }

    public static LinkedList loadEnt(File f) throws IOException {
        Kryo k = new Kryo();
        k.register(spaces.World.class);

        Input i = new Input(new FileInputStream(f));
        LinkedList l = k.readObject(i, LinkedList.class);

        i.close();

        return l;
    }
    
    public static void saveConfig( GameConfig gc, File f) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))){
            bw.write("\tIp:\n");
            bw.write(gc.getIp() + "\n");

            bw.write("\tPort:\n");
            bw.write(gc.getPort() + "\n");

            bw.write("\tDifficulty (1-3):\n");
            bw.write(gc.getDifficulty() + "\n");

            bw.write("\tUpdate period (in ms):\n");
            bw.write(gc.getUpdatePeriod() + "\n");

            bw.write("\tSave period (once in X iterations):\n");
            bw.write(gc.getSavePeriod() + "\n");
        }
    }

    public static GameConfig loadConfig(File f) throws IOException {
        GameConfig gc = new GameConfig();
        BufferedReader br = new BufferedReader(new FileReader(f));
        String s;
        
        for (int i = 0; i < 10; i++) {
            s = br.readLine();
            switch (i) {
                case (1):
                    gc.setIp(s);
                    break;
                case (3):
                    gc.setPort(Integer.parseInt(s));
                    break;
                case (5):
                    gc.setDifficulty(Integer.parseInt(s));
                    break;
                case (7):
                    gc.setUpdatePeriod(Long.parseLong(s));
                    break;
                case (9):
                    gc.setSavePeriod(Integer.parseInt(s));
                    break;
                default:
                    break;
            }
        }
        
        return gc;
    }
}
