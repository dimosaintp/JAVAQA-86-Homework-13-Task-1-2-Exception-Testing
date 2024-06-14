package ru.netology;

// Класс исключения.

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Элемент с id: " + id + " не найден.");
    }
}