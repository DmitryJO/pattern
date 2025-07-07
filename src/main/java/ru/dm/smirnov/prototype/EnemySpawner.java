package ru.dm.smirnov.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Простой спавнер врагов - демонстрирует паттерн Prototype
 */
public class EnemySpawner {

    private Map<EnemyType, Enemy> prototypes = new HashMap<>();

    public EnemySpawner() {
        // Создаем прототипы врагов используя enum
        for (EnemyType type : EnemyType.values()) {
            prototypes.put(type, new Enemy(type));
        }
    }

    /**
     * Создает нового врага на основе прототипа
     */
    public Enemy spawnEnemy(EnemyType type) {
        Enemy prototype = prototypes.get(type);
        if (prototype != null) {
            return prototype.copy();
        }
        return null;
    }

    /**
     * Показывает доступные типы врагов
     */
    public void showAvailableTypes() {
        System.out.println("Доступные типы врагов:");
        for (EnemyType type : EnemyType.values()) {
            System.out.println("  - " + type.getName() + " (health: " + type.getHealth() +
                    ", attack: " + type.getAttack() + ")");
        }
    }

}