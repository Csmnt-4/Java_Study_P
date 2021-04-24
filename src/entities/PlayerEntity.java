package entities;

import java.util.LinkedList;

public class PlayerEntity extends Entity {

    private final String nickname;
    private static int easyCount;

    public PlayerEntity(String name, String nickname, double posX, double posZ, double speed, int maxHealth, int attackDamage) {
        //сначала вызывает родительскую реализацию

        super(name, posX, posZ, false, speed, maxHealth, attackDamage);

        //передает в родительский конструктор aggressive = false

        this.nickname = nickname;
        easyCount = 0;
    }

    public void update(LinkedList<Entity> entities, LinkedList<PlayerEntity> players, int difficulty) {
        super.update(difficulty);
        easyCount++;
        if (easyCount % 2 == 0 && this.health < this.maxHealth){
            this.health++;
        }
    }

    public String getNickname() {
        return nickname;
    }

    public int getEasyCount() {
        return easyCount;
    }

    public void setEasyCount(int easyCount) {
        PlayerEntity.easyCount = easyCount;
    }

    //и раз в 2 обновлений серверва, если health < maxHealth регенирует себе 1 хп (реализация, счетчик обновлений уже за вами)
}
