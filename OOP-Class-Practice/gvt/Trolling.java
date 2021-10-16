package gvt;

public class Trolling extends Troll{
    private static final int MAX_HP = 38;
    private static final double REGEN_AMOUNT = 0.03;

    public Trolling(String name) {
        super(name, MAX_HP, REGEN_AMOUNT);
    }

    @Override
    public Attack attack() {
        if (!isVanquished()) {
            int[] hits = { 15 };
            return new Attack("U Mad?", hits, DamageType.PHYSICAL);
        }
        return new Attack("", new int[]{}, DamageType.NONE);
    }

    @Override
    public void takeDamage(Attack attack) {
        DamageType type = attack.getType();
        double adjustment = 1.0;

        if (type == DamageType.MAGICAL) {
            adjustment = 1.25;
        }
        
        for (int hit : attack.getHits()) {
            double amount = hit * adjustment;
            deductHP(amount);
        }
    }
}
