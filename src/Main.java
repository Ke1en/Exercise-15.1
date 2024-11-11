/*
Задача: Анализ продаж
Есть список транзакций, каждая из которых содержит информацию о продукте, количестве проданных единиц и цене за единицу.
Ваша задача состоит в том, чтобы выполнить анализ продаж, используя Stream API.
Условия:
        1. Создайте класс Transaction с полями: product, quantity и unitPrice.
        2. Создайте список транзакций.
        3. Напишите код, который использует Stream API для выполнения следующих задач:
        - Найдите общее количество проданных единиц всех продуктов.
        - Найдите общую сумму продаж (сумма quantity * unitPrice для всех транзакций).
        - Найдите продукт с наибольшим количеством продаж.
        - Найдите продукт с наименьшей суммой продаж.
Подскaзка
        - Используйте методы map, reduce, max, и min для выполнения различных операций.
        - Может будет полезен метод collect(Collectors.toList()).
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Transaction> transactionList = Arrays.asList(
                new Transaction("Cheese", 5, 949.99),
                new Transaction("Butter", 10, 139.99),
                new Transaction("Pork", 2, 349.0)
        );

        // Общее количество проданных единиц всех продуктов
        int soldUnits = transactionList.stream()
                .mapToInt(Transaction::getQuantity)
                .sum();

        System.out.println("Amount of products sold: " + soldUnits);
        // Общая сумма продаж (сумма quantity * unitPrice для всех транзакций)
        double receivedMoney = transactionList.stream()
                .mapToDouble(Transaction::getTotalPrice)
                .sum();

        System.out.println("Money received after selling all products " + receivedMoney + " (in rubles)");
        // Продукт с наибольшим количеством продаж.
        Transaction maxQuantity = transactionList.stream()
                .max(Comparator.comparingInt(Transaction::getQuantity))
                        .orElse(null);

        System.out.println("Product sold mostly sold on market: " + maxQuantity);
        // Продукт с наименьшей суммой продаж.
        Transaction minQuantity = transactionList.stream()
                .min(Comparator.comparingDouble(Transaction::getTotalPrice))
                .orElse(null);

        System.out.println("The least profitable product sold on market: " + minQuantity);
    }
}