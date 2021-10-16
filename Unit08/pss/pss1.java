package pss;

import java.util.List;

import gvt.*;

public class pss1 {
    public interface Ability {
        void use(List<Troll> enemies, List<Goat> party);
    }
    /**
     * Problem Solving 1
     */
    Ability basicAttackAnon = new Ability() {
        @Override
        public void use(List<Troll> enemies, List<Goat> party) {
            Troll target = getRandomTarget(enemies);
            int[] hits = {5};
            gvt.Attack attack = new Attack("", hits, gvt.DamageType.PHYSICAL);
            target.takeDamage(attack);
            removeVanquished(enemies, target);
        }
    };


    /**
     * Problem Solving 2
     */
    Ability basicAttackLambda = (enemies, party) -> {
        Troll target = getRandomTarget(enemies);
        gvt.Attack attack = new Attack("", new int[]{5}, DamageType.PHYSICAL);
        target.takeDamage(attack);
        removeVanquished(enemies, target);
    };



    /**
     * Problem Solving 3
     * 
     * for 0 to 3:
     *     if num enemies is greater than 0:
     *         target = random enemy
     *         hit = 9
     *         attack = new Attack("", hit, physical)
     *         target takes damage from attack
     *         remove vanquished enemy from enemies
     */



    /**
     * Problem Solving 4
     */
    Ability magicMissileLambda = (enemies, party) -> {
        for (int i = 0; i < 4 && i < enemies.size(); i++) {
            Troll target = getRandomTarget(enemies);
            gvt.Attack attack = new Attack("", new int[]{9}, DamageType.MAGICAL);
            target.takeDamage(attack);
            removeVanquished(enemies, target);
        }
    };
}
 