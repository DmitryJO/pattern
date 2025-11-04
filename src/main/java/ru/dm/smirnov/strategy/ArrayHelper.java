package ru.dm.smirnov.strategy;

/**
 * Вспомогательный класс для работы с массивами
 */
public class ArrayHelper {
    
    /**
     * Выводит массив в консоль
     * @param array массив для вывода
     * @param label метка перед массивом
     */
    public static void printArray(int[] array, String label) {
        System.out.print(label + ": [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    /**
     * Создает случайный массив заданного размера
     * @param size размер массива
     * @param max максимальное значение
     * @return случайный массив
     */
    public static int[] generateRandomArray(int size, int max) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * max) + 1;
        }
        return array;
    }
    
    /**
     * Проверяет, отсортирован ли массив
     * @param array массив для проверки
     * @return true если отсортирован
     */
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

