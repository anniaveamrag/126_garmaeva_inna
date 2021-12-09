package task;

public abstract class BattleUnitBase implements BattleUnit {
    private String name;
    private int maxHealth;
    private int health;
    private int baseStrength;
    private int strength;
    private int maxArmor;
    private int armor;

    public BattleUnitBase(String name, int maxHealth, int baseStrength, int maxArmor) {
        this.name = name;
        this.maxHealth = maxHealth;
        health = maxHealth;
        this.baseStrength = baseStrength;
        strength = baseStrength;
        this.maxArmor = maxArmor;
        armor = maxArmor;
    }

    public String name() {
        return name;
    }

    public int health() {
        return health;
    }

    public int maxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int value) {
        int maxHealthChange;
        if (value < 0) {
            maxHealthChange = maxHealth;
            maxHealth = 0;
        } else {
            maxHealthChange = value;
            maxHealth = value;
        }
        if (health == maxHealth)
            health = maxHealth;
    }

    public void heal(int value) {
        int healthChange;
        if (health + value > maxHealth) {
            healthChange = maxHealth - health;
            health = maxHealth;
        } else {
            healthChange = value;
            health += value;
        }
    }

    public void takeDamage(int value) {
        int damageDealt;
        if (health - value < 0) {
            damageDealt = health;
            health = 0;
        } else {
            damageDealt = value;
            health -= value;
        }
    }

    public int strength() {
        return strength;
    }

    public void setStrength(int value) {
        strength = value;
    }

    public int baseStrength() {
        return baseStrength;
    }

    public int armor() {
        return armor;
    }

    public int maxArmor() {
        return maxArmor;
    }

    public void restoreArmor(int value) {
        if (armor + value > maxArmor)
            armor = maxArmor;
        else
            armor += value;
    }

    public void damageArmor(int value) {
        int damageDealt;
        if (armor - value < 0) {
            damageDealt = armor;
            armor = 0;
        } else {
            damageDealt = value;
            armor -= value;
        }
    }

    public void setMaxArmor(int value) {
        maxArmor = value;
        if (armor > maxArmor)
            armor = maxArmor;
    }

    public abstract void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam);

    public abstract void attack(BattleUnit other);
}
