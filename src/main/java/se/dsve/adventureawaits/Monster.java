package se.dsve.adventureawaits;
public class Monster {
    public String name;
    public int hp;
    protected int damage;
    protected int xpReward;

    public Monster(String name, int damage, int xpReward) {
        this.name = name;
        this.hp = 100;
        this.damage = damage;
        this.xpReward = xpReward;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void applyDamage(int hp) {
        this.hp =- hp;
    }

    public boolean isDead() {
        if (this.hp <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getDamage() {
        return damage;
    }
        public int getXpReward() {
        return xpReward;
    }
}
