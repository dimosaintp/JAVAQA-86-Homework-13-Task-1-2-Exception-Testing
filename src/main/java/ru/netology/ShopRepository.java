package ru.netology;

// Класс репозиторий.

public class ShopRepository {
    private Product[] products = new Product[0];

    /**
     * Вспомогательный метод для имитации добавления элемента в массив
     *
     * @param current — массив, в который мы хотим добавить элемент
     * @param product — элемент, который мы хотим добавить
     * @return — возвращает новый массив, который выглядит, как тот, что мы передали,
     * но с добавлением нового элемента в конец
     */

    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
            if (current[i].getId() == product.getId()) {
                throw new AlreadyExistsException(product.getId());
            }
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    /**
     * Метод добавления товара в репозиторий.
     *
     * @param product — добавляемый товар.
     * В методе добавления нового товара в репозиторий должна осуществляться проверка на то,
     * что в нём уже нет товара, у которого бы совпадал ID с ID добавляемого товара.
     * Если же такой есть, то должно выкидываться ваше исключение — AlreadyExistsException.
     */

    public void add(Product product) {
        products = addToArray(products, product);
    }

    public Product[] findAll() {
        return products;
    }

    // Метод удаления товара из репозитория по id.

    public void remove(int id) {
        Product removeById = findById(id);
        if (removeById == null) {
            throw new NotFoundException(id);
        }

        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    private Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}