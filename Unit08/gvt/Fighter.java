package gvt;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Fighter extends Goat {

    /**
     * Basic Goat attack
     */
    private static Ability basicAttack = Goat::basicAttack;

    /**
     * Fighter chooses 3 random targets.
     * Does 25 physical damage to the first target
     * Does 13 physical damge to upto 2 targets after that.
     */
    private static Ability cleave = (enemies, party) -> {
        for (int i = 0; i < 3 && i < enemies.size(); i++) {
            Troll target = getRandomTarget(enemies);
            Attack attack = new Attack("", new int[]{25}, DamageType.PHYSICAL);
            if (i != 0) {
                attack = new Attack("", new int[]{13}, DamageType.PHYSICAL);
            }

            target.takeDamage(attack); 
            removeVanquished(enemies, target); 
        }
    };

    /**
     * Figher chooses a target at random
     * Does 25% of the targets current HP as physical damage
     * Heals entire party for twice the damage dealt, evenly split between party size
     */
    private static Ability lifeSteal = (enemies, party) -> {
        Troll target = getRandomTarget(enemies);
        int damage = (int)((double)target.getCurrentHP() * .25);
        Attack attack = new Attack("", new int[]{damage}, DamageType.PHYSICAL);
        target.takeDamage(attack); 
        removeVanquished(enemies, target); 
        
        for (Goat ally : party) {
            ally.heal((2 * damage) / party.size());
        }
    };

    /**
     * Fighter chooses a target at random
     * Releases 3 attacks that have 50% chance to hit
     * If target is vanquished with attacks remaining and enemies remaining, choose a new target
     */
    private static Ability flurryOfBlows = (enemies, party) -> {
        Random r = new Random();
        Troll target = getRandomTarget(enemies);
        Attack attack;
        for (int i = 0; i < 3; i++) {
            if (r.nextInt(2) == 0) {
                attack = new Attack("", new int[]{15}, DamageType.PHYSICAL);
            } else {
                attack = new Attack("", new int[]{0}, DamageType.PHYSICAL);
            }
            target.takeDamage(attack);
            removeVanquished(enemies, target); 

            if (enemies.size() == 0) {
                return;
            }

            if (target.getCurrentHP() == 0) {
                target = getRandomTarget(enemies);
            } 
        }
    };

    /**
     * Fighter ability list. There is one list for all fighters.
     */
    private static final Map <String, Ability> abilities = new HashMap<> ();

    static {
        /**
         * Add new abilities in here
         */
        abilities.put("Punch", basicAttack);
        abilities.put("Cleave", cleave);
        abilities.put("Life Steal", lifeSteal);
        abilities.put("Flurry of Blows", flurryOfBlows);
    }

    public Fighter(String name) {
        super(name, 150, abilities);
    }
    
    @Deprecated
    @Override
    public Attack attack() {
        int[] hits = {25};
        return new Attack("Cleave", hits, DamageType.PHYSICAL);
    }

    @Override
    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL) {
            adjustment = 1.25;
        } else if(type == DamageType.PHYSICAL) {
            adjustment = 0.75;
        }
        takeDamage(attack, adjustment);
    }
}
