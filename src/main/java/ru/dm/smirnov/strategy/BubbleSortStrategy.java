package ru.dm.smirnov.strategy;

/**
 * Конкретная реализация Strategy - алгоритм пузырьковой сортировки
 * 
 * Простой алгоритм, но медленный для больших массивов.
 * Хорошо подходит для небольших массивов или учебных целей.
 */
public class BubbleSortStrategy implements SortStrategy {
    
    @Override
    public int[] sort(int[] array) {
        int[] result = array.clone(); // Создаем копию, чтобы не изменять исходный массив
        
        int n = result.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (result[j] > result[j + 1]) {
                    // Обмен элементов
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }
        
        return result;
    }
    
    @Override
    public String getStrategyName() {
        return "Пузырьковая сортировка (Bubble Sort)";
    }
}

