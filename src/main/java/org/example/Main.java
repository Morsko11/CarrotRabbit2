package org.example;

//Алгоритм
//Инициализация: Сначала создаем массив с массой моркови на каждой полянке.
//Сортировка: Отсортируем массив полянок по количеству моркови в убывающем порядке.
//Перемещение моркови: Используем жадный подход, чтобы за каждую ходку пытаться взять максимальное количество моркови (до 5 кг) с полянок, начиная с той, где моркови больше всего.
//Подсчет: Подсчитываем общее количество моркови, которое было унесено за 10 ходок.
public class Main {
    public static void main(String[] args) {
        int[] fields = {1, 2, 3, 4, 5};
        int maxCarry = 5;
        int maxTrips = 10;
        int maxCarrots = getMaxCarrots(fields, maxCarry, maxTrips);
        System.out.println("Максимальное количество моркови, которое можно унести: " + maxCarrots);
    }

    public static int getMaxCarrots(int[] fields, int maxCarry, int maxTrips) {

        java.util.Arrays.sort(fields);
        int totalCarrots = 0;
        int tripsLeft = maxTrips;


        for (int i = fields.length - 1; i >= 0 && tripsLeft > 0; i--) {
            int carrots = fields[i];

            int carry = Math.min(carrots, maxCarry);
            totalCarrots += carry;
            tripsLeft--;


            fields[i] -= carry;


            if (fields[i] == 0) {
                continue;
            }
        }

        return totalCarrots;
    }
}