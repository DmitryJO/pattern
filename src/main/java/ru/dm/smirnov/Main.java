package ru.dm.smirnov;

import ru.dm.smirnov.prototype.ComplexEnemy;
import ru.dm.smirnov.prototype.Enemy;
import ru.dm.smirnov.prototype.EnemySpawner;
import ru.dm.smirnov.prototype.EnemyType;

/**
 * Простая демонстрация паттерна Prototype в Java
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== ПАТТЕРН PROTOTYPE ===\n");

        // Создаем спавнер
        EnemySpawner spawner = new EnemySpawner();

        // Показываем доступные типы
        spawner.showAvailableTypes();
        System.out.println();

        // Создаем врагов через прототипы
        System.out.println("Создание врагов:");

        Enemy goblin1 = spawner.spawnEnemy(EnemyType.GOBLIN);
        Enemy goblin2 = spawner.spawnEnemy(EnemyType.GOBLIN);
        Enemy orc = spawner.spawnEnemy(EnemyType.ORC);
        Enemy troll = spawner.spawnEnemy(EnemyType.TROLL);
        Enemy dragon = spawner.spawnEnemy(EnemyType.DRAGON);

        System.out.println(goblin1);
        System.out.println(goblin2);
        System.out.println(orc);
        System.out.println(troll);
        System.out.println(dragon);

        // Демонстрируем независимость объектов
        System.out.println("\nДемонстрация независимости:");
        goblin1.takeDamage(15);
        System.out.println("Гоблин 1 после урона: " + goblin1);
        System.out.println("Гоблин 2 без изменений: " + goblin2);

        // Сравнение производительности для простых объектов
        System.out.println("\n" + "=".repeat(50));
        System.out.println("СРАВНЕНИЕ ПРОИЗВОДИТЕЛЬНОСТИ (ПРОСТЫЕ ОБЪЕКТЫ)");

        // Тест через new
        long startTime = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            Enemy enemy = new Enemy(EnemyType.GOBLIN);
        }
        long newTime = System.nanoTime() - startTime;

        // Тест через copy
        Enemy prototype = new Enemy(EnemyType.GOBLIN);
        startTime = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            Enemy enemy = prototype.copy();
        }
        long copyTime = System.nanoTime() - startTime;

        System.out.println("Время создания 100,000 простых объектов:");
        System.out.println("  Через new: " + String.format("%.2f", newTime / 1_000_000.0) + " мс");
        System.out.println("  Через copy: " + String.format("%.2f", copyTime / 1_000_000.0) + " мс");
        System.out.println("  Разница: " + String.format("%.1f", (double) newTime / copyTime) + "x (new быстрее)");

        // Сравнение производительности для сложных объектов
        System.out.println("\n" + "=".repeat(50));
        System.out.println("СРАВНЕНИЕ ПРОИЗВОДИТЕЛЬНОСТИ (СЛОЖНЫЕ ОБЪЕКТЫ)");

        System.out.println("Создание сложных объектов (с дорогостоящей инициализацией)...");

        // Тест через new (медленно)
        startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            ComplexEnemy enemy = new ComplexEnemy(EnemyType.DRAGON);
        }
        long complexNewTime = System.nanoTime() - startTime;

        // Тест через copy (быстро)
        ComplexEnemy complexPrototype = new ComplexEnemy(EnemyType.DRAGON);
        startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            ComplexEnemy enemy = complexPrototype.copy();
        }
        long complexCopyTime = System.nanoTime() - startTime;

        System.out.println("Время создания 10 сложных объектов:");
        System.out.println("  Через new: " + String.format("%.2f", complexNewTime / 1_000_000.0) + " мс");
        System.out.println("  Через copy: " + String.format("%.2f", complexCopyTime / 1_000_000.0) + " мс");
        System.out.println("  Разница: " + String.format("%.1f", (double) complexNewTime / complexCopyTime) + "x (copy быстрее!)");

        System.out.println("\n" + "=".repeat(50));
        System.out.println("ВЫВОД:");
        System.out.println("  ✓ Для простых объектов: new быстрее copy");
        System.out.println("  ✓ Для сложных объектов: copy намного быстрее new");
        System.out.println("  ✓ Паттерн Prototype выгоден при дорогостоящей инициализации");
    }

}
