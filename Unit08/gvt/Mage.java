package gvt;

import java.util.HashMap;
import java.util.Map;

public class Mage extends Goat {

    /**
     * Basic Goat attack
     */
    private static Ability basicAttack = Goat::basicAttack;

    /**
     * Mage chooses 4 targets at random
     * Does 9 damage to each target
     */
    private static Ability magicMissile = (enemies, party) -> {
        for (int i = 0; i < 4 && i < enemies.size(); i++) {
            Troll target = getRandomTarget(enemies);
            gvt.Attack attack = new Attack("", new int[]{9}, DamageType.MAGICAL);
            target.takeDamage(attack);
            removeVanquished(enemies, target);
        }
    };

    /**
     * Mage does 10 damage to every enemy
     * Heals entire party for 5 hp each
     */
    private static Ability holyNova = (enemies, party) -> {
        gvt.Attack attack = new Attack("", new int[]{10}, DamageType.HOLY);
        for (int i = 0; i < enemies.size(); i++) {
            Troll enemy = enemies.get(i);
            enemy.takeDamage(attack); 
            removeVanquished(enemies, enemy); 
        }

        for (int i = 0; i < party.size(); i++) {
            Goat ally = party.get(i);
            ally.heal(5);
        }
    };

    /**
     * Mage vanquishes any enemy under 16 hp
     * If there is noone under 16 hp, deal 20 damage to a random target
     */
    private static Ability smite = (enemies, party) -> {
        boolean noneAtOrBelow15HP = true;
        for (Troll enemy : enemies) {
            if (enemy.getCurrentHP() <= 15) {
                noneAtOrBelow15HP = false;
            }
        }

        if (noneAtOrBelow15HP) {
            Troll target = getRandomTarget(enemies);
            gvt.Attack attack = new Attack("", new int[]{20}, DamageType.HOLY);
            target.takeDamage(attack);
            removeVanquished(enemies, target);
        } else {
            for (int i = 0; i < enemies.size(); i++) {
                Troll enemy = enemies.get(i);
                gvt.Attack executeAttack = new Attack("", new int[]{enemy.getCurrentHP()}, DamageType.HOLY);
                if(enemy.getCurrentHP() <= 15) {
                    enemy.takeDamage(executeAttack); 
                    removeVanquished(enemies, enemy); 
                }
            }
        }
    };

    /**
     * Mage ability list. There is one list for all mages.
     */
    private static final Map <String, Ability> abilities = new HashMap<> ();
    static {
        /**
         * Add new abilities in here
         */
        abilities.put("Staff Attack", basicAttack);
        abilities.put("Magic Missile", magicMissile);
        abilities.put("Holy Nova", holyNova);
        abilities.put("Smite", smite);
    }

    public Mage(String name) {
        super(name, 100, abilities);
    }

    @Deprecated
    public Attack attack() {
        int[] hits = {9, 9, 9, 9};
        return new Attack("Magic Missiles", hits, DamageType.MAGICAL);
    }

    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL) {
            adjustment = 0.75;
        } else if(type == DamageType.PHYSICAL) {
            adjustment = 1.25;
        }
        takeDamage(attack, adjustment);
    }
}
