package gvt;

public abstract class Goat implements Actions {
    private final String name;
    private final int maxHP;
    private int currentHP;

    public abstract void takeDamage(Attack attack);

    public Goat(String name, int maxHP) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = this.maxHP;
    }

    // public Attack attack() {
    //     if (isConscious()) {
    //         int[] hits = {1};
    //         return new Attack("Bahhh", hits, DamageType.HOLY);
    //     }
    //     return new Attack("", new int[]{}, DamageType.NONE);
    // }

    public void takeDamage(Attack attack, double adjustment) {
        for (int hit : attack.getHits()) {
            currentHP -= hit * adjustment;
        }
        currentHP = currentHP < 0 ? 0 : currentHP;
    }

    // public void takeDamage(Attack attack) {
    //     takeDamage(attack, 1.0);
    // }

    public boolean isConscious() {
        return this.currentHP > 0;
    }

    public void heal(int amount) {
        currentHP += amount;
        currentHP = currentHP < maxHP ? currentHP : maxHP;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + name + "\n    Current HP = " + currentHP;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }
}
