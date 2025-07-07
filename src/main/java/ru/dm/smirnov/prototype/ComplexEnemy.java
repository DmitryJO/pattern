package ru.dm.smirnov.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Сложный класс врага с дорогостоящей инициализацией
 * Демонстрирует преимущества паттерна Prototype
 */
public class ComplexEnemy implements Prototype<ComplexEnemy> {
    private String name;
    private int health;
    private int attack;
    private EnemyType type;
    private List<String> abilities;
    private List<String> inventory;
    private String aiBehavior;
    
    public ComplexEnemy(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        
        // Дорогостоящая инициализация
        initializeAbilities();
        initializeInventory();
        initializeAI();
    }
    
    public ComplexEnemy(EnemyType type) {
        this.name = type.getName();
        this.health = type.getHealth();
        this.attack = type.getAttack();
        this.type = type;
        
        // Дорогостоящая инициализация
        initializeAbilities();
        initializeInventory();
        initializeAI();
    }
    
    // Конструктор копирования - БЫСТРЫЙ
    private ComplexEnemy(ComplexEnemy source) {
        this.name = source.name;
        this.health = source.health;
        this.attack = source.attack;
        this.type = source.type;
        this.abilities = new ArrayList<>(source.abilities);
        this.inventory = new ArrayList<>(source.inventory);
        this.aiBehavior = source.aiBehavior;
    }
    
    private void initializeAbilities() {
        abilities = new ArrayList<>();
        // Симуляция дорогостоящей операции
        try {
            Thread.sleep(1); // 1 миллисекунда задержки
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        abilities.add("Attack");
        abilities.add("Defend");
        abilities.add("Special Move");
        abilities.add("Heal");
    }
    
    private void initializeInventory() {
        inventory = new ArrayList<>();
        // Симуляция загрузки данных
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        inventory.add("Sword");
        inventory.add("Shield");
        inventory.add("Potion");
        inventory.add("Armor");
    }
    
    private void initializeAI() {
        // Симуляция сложной инициализации ИИ
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        aiBehavior = "Aggressive";
    }
    
    @Override
    public ComplexEnemy copy() {
        return new ComplexEnemy(this);
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
    
    public List<String> getAbilities() {
        return new ArrayList<>(abilities);
    }
    
    public List<String> getInventory() {
        return new ArrayList<>(inventory);
    }
    
    public String getAiBehavior() {
        return aiBehavior;
    }
    
    public EnemyType getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return String.format("ComplexEnemy[name=%s, type=%s, health=%d, attack=%d, abilities=%d, inventory=%d]", 
                           name, type != null ? type : "Unknown", health, attack, abilities.size(), inventory.size());
    }
} 