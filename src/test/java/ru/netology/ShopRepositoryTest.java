package ru.netology;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    // Проверка удаления товара из репозитория.

    Product p1 = new Product(1124, "Смартфон", 75_000);
    Product p2 = new Product(2896, "Робот пылесос", 25_000);
    Product p3 = new Product(3547, "Бойлер", 30_000);

    @Test
    public void testFindAll() {
        ShopRepository repo = new ShopRepository();
        repo.add(p1);
        repo.add(p2);
        repo.add(p3);

        Product[] expected = {p1, p2, p3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    // Удаление товара из репозитория с существующим id.

    @Test
    public void shouldRemoveById() {
        ShopRepository repo = new ShopRepository();
        repo.add(p1);
        repo.add(p2);
        repo.add(p3);
        repo.remove(1124);

        Product[] expected = {p2, p3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

        System.out.println("Element with id: " + p1.getId() + " not found");
    }

    // Удаление товара из репозитория с несуществующим id и с генерацией исключения NotFoundException.

    @Test
    public void shouldRemoveByFakeId() {
        ShopRepository repo = new ShopRepository();
        repo.add(p1);
        repo.add(p2);
        repo.add(p3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(5789));
    }

    @Test
    public void shouldAddProduct() {
        ShopRepository repo = new ShopRepository();
        repo.add(p1);
        repo.add(p2);
        repo.add(p3);

        Product[] expected = {p1, p2, p3,};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}