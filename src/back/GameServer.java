package back;

import spaces.World;

public class GameServer {
    private static GameServer instance;
    private static GameConfig config;
    private World serverWorld;
    private int serverTicks;

    public static void updateServer(GameServer server){
        server.serverTicks++;
        World.updateWorld(server.serverWorld, config.getDifficulty());
    }

    public GameServer(World serverWorld, int serverTicks, int savePeriod, long updatePeriod, int difficulty, int port, String ip) {
        instance = this;
        config = new GameConfig(ip, port, difficulty, updatePeriod, savePeriod);

        this.serverWorld = serverWorld;
        this.serverTicks = serverTicks;
    }

    public GameServer(World serverWorld, int serverTicks, int savePeriod, long updatePeriod, int difficulty, int port) {
        instance = this;
        config = new GameConfig(port, difficulty, updatePeriod, savePeriod);

        this.serverWorld = serverWorld;
        this.serverTicks = serverTicks;
    }

    public GameServer(World serverWorld, int serverTicks, int savePeriod, long updatePeriod, int difficulty) {
        instance = this;
        config = new GameConfig(difficulty, updatePeriod, savePeriod);

        this.serverWorld = serverWorld;
        this.serverTicks = serverTicks;
    }

    public GameServer(World serverWorld, int serverTicks, int savePeriod, long updatePeriod) {
        instance = this;
        config = new GameConfig(updatePeriod, savePeriod);

        this.serverWorld = serverWorld;
        this.serverTicks = serverTicks;
    }

    public GameServer(World serverWorld, int serverTicks, int savePeriod) {
        instance = this;
        config = new GameConfig(savePeriod);

        this.serverWorld = serverWorld;
        this.serverTicks = serverTicks;
    }

    public GameServer(World serverWorld, int serverTicks) {
        instance = this;
        config = new GameConfig();

        this.serverWorld = serverWorld;
        this.serverTicks = serverTicks;
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

    //создает новый объект класса GameServer используя шаблон инстанцирования и выводит в его в консоль
    //после чего в цикле на 30(или больше если хотите) итераций раз в секунду вызывает обновление сервера
}