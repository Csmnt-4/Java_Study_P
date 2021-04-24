package entities;


import static entitiesActions.Attack.attack;
import static entitiesActions.SearchWithTarget.target;
import static entitiesActions.Walk.walk;

public class Entity {
    private static int idCounter = 0;
    protected long id;      // приравнивается idCounter, после чего idCounter увеличивается на 1
    protected String name;  // имя сущности

    protected double posX;      // позиция по x
    protected double posZ;      // позиция по z
    protected double walkingX;  // куда сущность идёт по x
    protected double walkingZ;  // куда сущность идёт по z

    protected boolean aggressive;       // агрессивная/мирная ли сущность
    protected int indicator;            // индикатор действия
    protected int attackDamage;         // урон
    protected long attackedCreatureId = 0;    // id атакованной сущности

    protected double speed;     // скорость
    protected int maxHealth;    // максимально кол-во жизней
    protected double health;       // текущее кол-во жизней

    // Конструктор класса
    public Entity(String name, double posX, double posZ, boolean aggressive, double speed, int maxHealth, int attackDamage) {
        this.id = idCounter;
            idCounter++;
        this.name = name;
        this.posX = posX;
        this.posZ = posZ;
        this.walkingX = 0;
        this.walkingZ = 0;
        this.aggressive = aggressive;
        this.speed = speed;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attackDamage = attackDamage;
        this.indicator = 0;
    }

    public void update(int difficulty) {

        //если aggressive == true, то сущность ищет ближашую к себе не агрессивную Entity в раудиусе 20 ед. и движется к ней

        target(this);

        //  Ходьба до цели

        walk(this);

        //за 1 обновление сервера сущность может пройти 1 ед. по x и 1 ед. по z
        //если расстояние до атакуемой сущности <2 ед. то вызывается метод attack(entity)

        attack(this);

        //если entity не является игроком, то ей просто наносится урон ()
        //если entity это EntityPlayer, то после удада по игроку, если хп >0, он наносит ответный удар
        //урон наносится по формуле entity.attackDamage + 0.5 * difficulty (получаем через инстанцирование из объекта GameServer)
        //если после нанесения урона сущности ее хп <= 0 она удаляется из мира и в консоль выводится кто и кого убил
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Entity.idCounter = idCounter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosZ() {
        return posZ;
    }

    public void setPosZ(double posZ) {
        this.posZ = posZ;
    }

    public double getWalkingX() {
        return walkingX;
    }

    public void setWalkingX(double walkingX) {
        this.walkingX = walkingX;
    }

    public double getWalkingZ() {
        return walkingZ;
    }

    public void setWalkingZ(double walkingZ) {
        this.walkingZ = walkingZ;
    }

    public boolean isAggressive() {
        return aggressive;
    }

    public void setAggressive(boolean aggressive) {
        this.aggressive = aggressive;
    }

    public int getIndicator() {
        return indicator;
    }

    public void setIndicator(int indicator) {
        this.indicator = indicator;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public long getAttackedCreatureId() {
        return attackedCreatureId;
    }

    public void setAttackedCreatureId(long attackedCreatureId) {
        this.attackedCreatureId = attackedCreatureId;
    }
}

