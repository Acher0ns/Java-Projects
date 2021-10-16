package gvt;

public class Mage extends Goat{
    public Mage(String name) {
        super(name, 100);
    }

    @Override
    public Attack attack() {
        if (isConscious()) {
            int[] hits = { 9, 9, 9, 9 };
            return new Attack("Magic Missles", hits, DamageType.MAGICAL);
        }
        return new Attack("", new int[]{}, DamageType.NONE);
    }

    @Override
    public void takeDamage(Attack attack) {
        DamageType type = attack.getType();
        double adjustment = 1.0;

        if (type == DamageType.MAGICAL) {
            adjustment = 0.75;
        } else if (type == DamageType.PHYSICAL) {
            adjustment = 1.25;
        }
        takeDamage(attack, adjustment);
    }

    @Override
    public void sleep() {
        return;
    }
}
