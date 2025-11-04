package ru.dm.smirnov.strategy;

/**
 * Класс Context (Контекст)
 * 
 * Использует объект Strategy для выполнения алгоритма.
 * Context не знает конкретную реализацию стратегии - он работает только с интерфейсом.
 * Это позволяет менять стратегии во время выполнения.
 */
public class SorterContext {
    private SortStrategy strategy;
    
    /**
     * Конструктор с установкой стратегии
     * @param strategy стратегия сортировки
     */
    public SorterContext(SortStrategy strategy) {
        this.strategy = strategy;
    }
    
    /**
     * Устанавливает новую стратегию сортировки
     * @param strategy новая стратегия
     */
    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
        System.out.println("Стратегия изменена на: " + strategy.getStrategyName());
    }
    
    /**
     * Выполняет сортировку используя текущую стратегию
     * @param array массив для сортировки
     * @return отсортированный массив
     */
    public int[] executeSort(int[] array) {
        if (strategy == null) {
            throw new IllegalStateException("Стратегия не установлена!");
        }
        
        System.out.println("Используется: " + strategy.getStrategyName());
        return strategy.sort(array);
    }
    
    /**
     * Возвращает текущую стратегию
     * @return текущая стратегия
     */
    public SortStrategy getStrategy() {
        return strategy;
    }
}

