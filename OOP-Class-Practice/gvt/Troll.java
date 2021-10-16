package gvt;

public abstract class Troll {
    private final String name;
    private final int maxHP;
    private int currentHP;
    private final double regenAmount;

    public abstract Attack attack();
    public abstract void takeDamage(Attack attack);

    public Troll(String name, int maxHP, double regenAmount) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = this.maxHP;
        this.regenAmount = regenAmount;
    }

    public void regenerate(double percent) {
        if (!isVanquished()) {
            this.currentHP += (int)(this.maxHP * regenAmount);
            currentHP = currentHP > maxHP ? maxHP : currentHP;
        }
    }

    public boolean isVanquished() {
        return this.currentHP <= 0;
    }

    protected void deductHP(double amount) {
        currentHP -= amount;
        currentHP = currentHP < 0 ? 0 : currentHP;
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
