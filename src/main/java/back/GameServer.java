package back;

import spaces.World;

import java.io.File;
import java.io.IOException;

//  Создает новый объект класса GameServer используя шаблон инстанцирования и выводит в его в консоль
//  после чего в цикле на 30(или больше если хотите) итераций раз в секунду вызывает обновление сервера

public class GameServer {
    private static GameServer instance;
    private static GameConfig config;
    private static final File configSaveFile = new File("c:\\Server\\data\\config.txt");
    private static final File worldSaveFile = new File("c:\\Server\\data\\world.bin");
    private static final File entitiesSaveFile = new File("c:\\Server\\data\\ent.bin");
    private World serverWorld;
    private int serverTicks = 0;
    private int saveIndicator = 0;

    public static void updateServer(GameServer server) {
        server.serverTicks++;
        server.saveIndicator++;
        if (server.saveIndicator == server.getConfig().getSavePeriod())  {
            try {
                FileUtils.saveWorld(server.getServerWorld(), worldSaveFile);
                FileUtils.saveEnt(server.getServerWorld().getAllEntities(), entitiesSaveFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            server.saveIndicator = 0;
        }
        World.updateWorld(server.serverWorld, config.getDifficulty());
    }

    public GameServer(World serverWorld, int serverTicks, int savePeriod, long updatePeriod, int difficulty, int port, String ip) {
        config = new GameConfig(ip, port, difficulty, updatePeriod, savePeriod);

        this.serverWorld = serverWorld;
        this.serverTicks = serverTicks;

        instance = this;
    }

    public GameServer(World serverWorld, int serverTicks, int savePeriod, long updatePeriod, int difficulty, int port) {
        config = new GameConfig(port, difficulty, updatePeriod, savePeriod);

        this.serverWorld = serverWorld;
        this.serverTicks = serverTicks;

        instance = this;
    }

    public GameServer(World serverWorld, int serverTicks, int savePeriod, long updatePeriod, int difficulty) {
        config = new GameConfig(difficulty, updatePeriod, savePeriod);

        this.serverWorld = serverWorld;
        this.serverTicks = serverTicks;

        instance = this;
    }

    public GameServer(World serverWorld, int serverTicks, int savePeriod, long updatePeriod) {
        config = new GameConfig(updatePeriod, savePeriod);

        this.serverWorld = serverWorld;
        this.serverTicks = serverTicks;

        instance = this;
    }

    public GameServer(World serverWorld, int serverTicks, int savePeriod) {
        config = new GameConfig(savePeriod);

        this.serverWorld = serverWorld;
        this.serverTicks = serverTicks;

        instance = this;
    }

    public GameServer(World serverWorld, int serverTicks) {
        try {
            config = FileUtils.loadConfig(configSaveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.serverWorld = serverWorld;
        this.serverTicks = serverTicks;

        instance = this;
    }

    public GameServer(World serverWorld) {
        try {
            configLoad();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.serverWorld = serverWorld;

        instance = this;

    }

    public GameServer() {
        try {
            configLoad();
            worldLoad();
        } catch (IOException e) {
            e.printStackTrace();
        }

        instance = this;
    }

    @Override
    public String toString() {
        return "GameServer{" +
                "serverWorld=" + serverWorld +
                ", serverTicks=" + serverTicks +
                '}';
    }

    public static GameServer getInstance() {
        return instance;
    }

    public static void setInstance(GameServer instance) {
        GameServer.instance = instance;
    }

    public int getServerTicks() {
        return serverTicks;
    }

    public void setServerTicks(int serverTicks) {
        this.serverTicks = serverTicks;
    }

    public World getServerWorld() {
        return serverWorld;
    }

    public void setServerWorld(World serverWorld) {
        this.serverWorld = serverWorld;
    }

    public static GameConfig getConfig() {
        return config;
    }

    public static void setConfig(GameConfig config) {
        GameServer.config = config;
    }

    public static File getConfigSaveFile() {
        return configSaveFile;
    }

    public static File getWorldSaveFile() {
        return worldSaveFile;
    }

    public int getSaveIndicator() {
        return saveIndicator;
    }

    public void setSaveIndicator(int saveIndicator) {
        this.saveIndicator = saveIndicator;
    }


    private void configLoad() throws IOException {
//        Забрать файл из FileUtils.loadConfig(), а если
//        configSaveFile не существует, то создать новый дефолтный
        if (configSaveFile.isFile()) {
            config = FileUtils.loadConfig(configSaveFile);
        } else {
            config = new GameConfig();
        }
    }

    private void worldLoad() throws IOException {
//        Забрать файл из FileUtils.loadWorld(), а если
//        worldSaveFile не существует, то создать новый де-фолт-ный
        if (worldSaveFile.isFile()) {
            serverWorld = FileUtils.loadWorld(worldSaveFile);
            serverWorld.setAllEntities(FileUtils.loadEnt(entitiesSaveFile));
        } else {
            serverWorld = new World();
        }

    }
}