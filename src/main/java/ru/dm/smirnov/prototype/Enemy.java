package ru.dm.smirnov.prototype;

/**
 * Простой класс врага для демонстрации паттерна Prototype
 */
public class Enemy implements Prototype<Enemy> {
    private String name;
    private int health;
    private int attack;
    private EnemyType type;
    
    public Enemy(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }
    
    public Enemy(EnemyType type) {
        this.name = type.getName();
        this.health = type.getHealth();
        this.attack = type.getAttack();
        this.type = type;
    }
    
    // Конструктор копирования
    private Enemy(Enemy source) {
        this.name = source.name;
        this.health = source.health;
        this.attack = source.attack;
        this.type = source.type;
    }
    
    @Override
    public Enemy copy() {
        return new Enemy(this);
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
    
    public EnemyType getType() {
        return type;
    }
    
    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }
    
    public boolean isAlive() {
        return health > 0;
    }
    
    @Override
    public String toString() {
        return String.format("Enemy[name=%s, type=%s, health=%d, attack=%d]", 
                           name, type != null ? type : "Unknown", health, attack);
    }
} 