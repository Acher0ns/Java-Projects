package gvt;

public class Trollzord extends Troll{
    private static final int MAX_HP = 64;
    private static final double REGEN_AMOUNT = 0.05;

    public Trollzord(String name) {
        super(name, MAX_HP, REGEN_AMOUNT);
    }

    @Override
    public Attack attack() {
        if (!isVanquished()) {
            int[] hits = { 25 };
            return new Attack("Flame War", hits, DamageType.MAGICAL);
        }
        return new Attack("", new int[]{}, DamageType.NONE);
    }

    @Override
    public void takeDamage(Attack attack) {
        DamageType type = attack.getType();
        double adjustment = 1.0;

        if (type == DamageType.HOLY) {
            adjustment = 1.25;
        }
        
        for (int hit : attack.getHits()) {
            double amount = hit * adjustment;
            deductHP(amount);
        }
    }
}
