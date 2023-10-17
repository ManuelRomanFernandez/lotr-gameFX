package formacion.bosonit.lotrgamefx.model;

public abstract class Unit {
    private String name;
    private int health;
    private int armor;
    private boolean alive;

    public abstract int[] attack(Unit enemy);
    public void getAttacked(int damage){
        setHealth(this.health - damage);
    }

    public String printUnitStats() {
        return this.name
                + " (Vida:"
                + this.health
                + " Armadura:"
                + this.armor
                + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}

