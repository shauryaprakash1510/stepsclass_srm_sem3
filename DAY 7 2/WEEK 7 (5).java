package week_7.set_2;

class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        this.health = Math.max(0, this.health - amount);
        System.out.println("health = " + this.health);
    }

    public void heal(int amount) {
        this.health = Math.min(this.maxHealth, this.health + amount);
        System.out.println("health = " + this.health + " (capped)");
    }

    public int getHealth() {
        return this.health;
    }
}

public class P1_HealthBar {
    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
    }
}