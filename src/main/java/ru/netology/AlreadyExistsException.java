package ru.netology;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(int id) {
        super("Элемент с id: " + id + " уже существует.");
    }
}