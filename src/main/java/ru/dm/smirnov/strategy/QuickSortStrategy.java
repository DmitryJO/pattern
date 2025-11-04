package ru.dm.smirnov.strategy;

/**
 * Конкретная реализация Strategy - алгоритм быстрой сортировки
 * 
 * Эффективный алгоритм для больших массивов.
 * Средняя сложность: O(n log n)
 */
public class QuickSortStrategy implements SortStrategy {
    
    @Override
    public int[] sort(int[] array) {
        int[] result = array.clone();
        quickSort(result, 0, result.length - 1);
        return result;
    }
    
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
    
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        return i + 1;
    }
    
    @Override
    public String getStrategyName() {
        return "Быстрая сортировка (Quick Sort)";
    }
}

