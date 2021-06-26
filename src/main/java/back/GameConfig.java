package back;

public class GameConfig {
    private String ip = "127.0.1.0";
    private int port = 25655;
    private int difficulty = 2;
    private long updatePeriod = 1000;
    private int savePeriod = 5;

    public GameConfig(String ip, int port, int difficulty, long updatePeriod, int savePeriod) {
        this.ip = ip;
        this.port = port;

        if (difficulty>=3)
            this.difficulty = 3;
        else if (difficulty<=1)
            this.difficulty = 1;
        this.updatePeriod = updatePeriod;
        this.savePeriod = savePeriod;
    }

    public GameConfig(int port, int difficulty, long updatePeriod, int savePeriod) {
        this.port = port;
        this.difficulty = difficulty;
        this.updatePeriod = updatePeriod;
        this.savePeriod = savePeriod;
    }

    public GameConfig(int difficulty, long updatePeriod, int savePeriod) {
        this.difficulty = difficulty;
        this.updatePeriod = updatePeriod;
        this.savePeriod = savePeriod;
    }

    public GameConfig(long updatePeriod, int savePeriod) {
        this.updatePeriod = updatePeriod;
        this.savePeriod = savePeriod;
    }

    public GameConfig(int savePeriod) {
        this.savePeriod = savePeriod;
    }

    public GameConfig() {
    }

    @Override
    public String toString() {
        return "GameConfig{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", difficulty=" + difficulty +
                ", updatePeriod=" + updatePeriod +
                ", savePeriod=" + savePeriod +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public long getUpdatePeriod() {
        return updatePeriod;
    }

    public void setUpdatePeriod(long updatePeriod) {
        this.updatePeriod = updatePeriod;
    }

    public int getSavePeriod() {
        return savePeriod;
    }

    public void setSavePeriod(int savePeriod) {
        this.savePeriod = savePeriod;
    }
}