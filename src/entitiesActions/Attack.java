package entitiesActions;

import main.GameServer;
import entities.Entity;
import entities.PlayerEntity;
import spaces.World;

public class Attack
{
    public static void attack (Entity attacker) {
        if (attacker.getIndicator() == 2){
            for (Entity p : World.getAllEntities()) {

    //  Атака

                if (p.getId() == attacker.getAttackedCreatureId()) {
                    if (p instanceof PlayerEntity) {
                        attackPlayerEntity(attacker, p, GameServer.getDifficulty());
                    } else {
                        attackEntity(attacker, p, GameServer.getDifficulty());
                    }

    //  Проверка на HP атакуемого

                    if (p.getHealth()<=0){
                        if (p instanceof PlayerEntity)
                            System.out.println("Player " + p.getName() + " was slain by " + p.getName() + "!");
                        else
                            System.out.println(p.getName() + " was slain by " + p.getName() + "!");
                        attacker.setAggressive(false);
                        attacker.setIndicator(3);
                        attacker.setWalkingZ(0);
                        attacker.setWalkingX(0);
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(" ");
                    }

    //  Проверка на HP атакующего

                    if (attacker.getHealth() <= 0){
                        System.out.println(attacker.getName() + " was slain by player " + p.getName() + "!");
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        attacker.setAggressive(false);
                        attacker.setIndicator(3);
                        attacker.setWalkingZ(0);
                        attacker.setWalkingX(0);
                        System.out.println(" ");
                    }
                }
            }
        }
    }

    public static void attackEntity(Entity attacker, Entity attacked, int difficulty){
        attacked.setHealth(attacked.getHealth() - attacker.getAttackDamage() + 0.5 * difficulty);
        System.out.println(attacker.getName() + " hit " + attacked.getName() + " for " + (attacker.getAttackDamage() + 0.5 * difficulty) + " HP;");
        System.out.println(attacked.getName() + ": " + attacked.getHealth() + "/" + attacked.getMaxHealth() + " HP;");
        if (attacked.getHealth() > 0) {
            System.out.println(" ");
        }
    }

    public static void attackPlayerEntity(Entity attacker, Entity attacked, int difficulty){
        attacked.setHealth(attacked.getHealth() - attacker.getAttackDamage() + 0.5 * difficulty);
        System.out.println(attacker.getName() + " hit " + attacked.getName() + " for " + (attacker.getAttackDamage() + 0.5 * difficulty) + " HP;");
        System.out.println(attacked.getName() + ": " + attacked.getHealth() + "/" + attacked.getMaxHealth() + " HP;");
        if (attacked.getHealth() > 0) {
            attacker.setHealth(attacker.getHealth() - attacked.getAttackDamage() + 0.5 * difficulty);
            System.out.println(attacked.getName() + " hit " + attacker.getName() + " for " + (attacked.getAttackDamage() + 0.5 * difficulty) + " HP;");
            System.out.println(attacker.getName() + ": " + attacker.getHealth() + "/" + attacker.getMaxHealth() + " HP;");
        }
    }
}
