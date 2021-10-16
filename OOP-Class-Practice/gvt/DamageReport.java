package gvt;

public class DamageReport {
    Character attacker;
    Character target;
    Attack attack;

    DamageReport(Character attacker, Character target, Attack attack) {
        this.attacker = attacker;
        this.target = target;
        this.attack = attack;
    }

    public Character getAttacker() {
        return attacker;
    }
    
    public Character getTarget() {
        return target;
    }

    public Attack getAttack() {
        return attack;
    }
}
