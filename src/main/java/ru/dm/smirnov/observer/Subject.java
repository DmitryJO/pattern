package ru.dm.smirnov.observer;

/**
 * Интерфейс Subject (Издатель/Наблюдаемый объект)
 * 
 * Представляет объект, за которым могут наблюдать другие объекты.
 * Издатель уведомляет всех подписчиков об изменениях своего состояния.
 */
public interface Subject {
    /**
     * Регистрирует нового наблюдателя
     * @param observer наблюдатель для регистрации
     */
    void registerObserver(Observer observer);
    
    /**
     * Удаляет наблюдателя из списка подписчиков
     * @param observer наблюдатель для удаления
     */
    void removeObserver(Observer observer);
    
    /**
     * Уведомляет всех зарегистрированных наблюдателей об изменениях
     */
    void notifyObservers();
}

