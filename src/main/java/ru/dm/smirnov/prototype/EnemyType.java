package ru.dm.smirnov.prototype;

/**
 * Enum для типов врагов
 */
public enum EnemyType {
    GOBLIN("Goblin", 30, 10),
    ORC("Orc", 60, 20),
    TROLL("Troll", 100, 30),
    DRAGON("Dragon", 200, 50);
    
    private final String name;
    private final int health;
    private final int attack;
    
    EnemyType(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }
    
    public String getName() {
        return name;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getAttack() {
        return attack;
    }
    
    @Override
    public String toString() {
        return name.toLowerCase();
    }
} 