package ru.job4j.solid.icp.examples.first;

public interface Algotrading {

    String analyzeSellersData(); // анализируем продажи

    String analyzeBuyersData(); // аналищируем закпкупи и затраты

    String analyzeWhatToBuy(); // анализируем какой продукт лучше купить

    // Здесь по идее каждый интерфейс должен быть отдельный и под них можно еще выделить структуры
    // в зависимотси от задач
}
