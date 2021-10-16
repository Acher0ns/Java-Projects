package gvt;

public class Fighter extends Goat {
    public Fighter(String name) {
        super(name, 150);
    }

    @Override
    public Attack attack() {
        if (isConscious()) {
            int[] hits = {25};
            return new Attack("Magic Missles", hits, DamageType.PHYSICAL);
        }
        return new Attack("", new int[]{}, DamageType.NONE);
    }

    @Override
    public void takeDamage(Attack attack) {
        DamageType type = attack.getType();
        double adjustment = 1.0;

        if (type == DamageType.MAGICAL) {
            adjustment = 1.25;
        } else if (type == DamageType.PHYSICAL) {
            adjustment = 0.75;
        }
        takeDamage(attack, adjustment);
    }

    @Override
    public void sleep() {
        return;
    }
}
