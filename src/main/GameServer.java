package main;

import spaces.World;

public class GameServer {
    private static GameServer instance;
    private String ip;
    private static int difficulty;
    private World serverWorld;
    private int serverTicks;

    public static void updateServer(GameServer server){
        server.serverTicks++;
        World.updateWorld(server.serverWorld, difficulty);
    }

    public GameServer(String ip, int difficulty) {
        instance = this;

        this.serverTicks = 0;
        this.ip = ip;
        GameServer.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "GameServer{" +
                "ip='" + ip + '\'' +
                ", serverTicks=" + serverTicks +
                ", serverWorld=" + serverWorld +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public static int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        GameServer.difficulty = difficulty;
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
