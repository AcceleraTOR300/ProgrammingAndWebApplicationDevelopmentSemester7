/**
 * Задание 14, класс в котором представляется продукт с названием и ценой.
 */
public class Product
{
    private String name;
    private double price;

    /**
     * Конструктор создаёт продукт с названием и ценой.
     */
    public Product(String productName, double productPrice)
    {
        name = productName;
        price = productPrice;
    }

    /**
     * Возвращает название продукта.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Возвращает цену продукта.
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Снижает цену продукта на заданную сумму.
     */
    public void reducePrice(double amount)
    {
        price = price - amount;
    }
}

/**
 * Класс для печати информации о продуктах.
 */
class ProductPrinter
{
    public static void main(String[] args)
    {
        System.out.println("=== Задание 14: Программа ProductPrinter ===\n");


        Product product1 = new Product("Тостер", 29.95);
        Product product2 = new Product("Микроволновая печь", 99.99);

        System.out.println("Исходные цены:");
        System.out.println("  Продукт 1: " + product1.getName() + " - $" + product1.getPrice());
        System.out.println("  Продукт 2: " + product2.getName() + " - $" + product2.getPrice());


        System.out.println("\nСнижаем цены на $5.00...");
        product1.reducePrice(5);
        product2.reducePrice(5);


        System.out.println("\nЦены после снижения на $5.00:");
        System.out.println("  Продукт 1: " + product1.getName() + " - $" + product1.getPrice());
        System.out.println("  Продукт 2: " + product2.getName() + " - $" + product2.getPrice());


        System.out.println("\n" + "=".repeat(50));
        System.out.println("=== Дополнительные тесты ===\n");


        System.out.println("Тест 1: Несколько снижений цены подряд");
        Product book = new Product("Java книга", 49.99);
        System.out.println("Исходная цена: $" + book.getPrice());

        book.reducePrice(5);
        System.out.println("После снижения на $5.00: $" + book.getPrice());

        book.reducePrice(3);
        System.out.println("После снижения на $3.00: $" + book.getPrice());

        book.reducePrice(2);
        System.out.println("После снижения на $2.00: $" + book.getPrice());
        System.out.println("Ожидаемо: $39.99");


        System.out.println("\nТест 2: Разные продукты с разными ценами");
        Product pen = new Product("Ручка", 1.99);
        Product laptop = new Product("Ноутбук", 999.99);
        Product notebook = new Product("Тетрадь", 3.50);

        System.out.println("До снижения цен:");
        System.out.println("  " + pen.getName() + ": $" + pen.getPrice());
        System.out.println("  " + laptop.getName() + ": $" + laptop.getPrice());
        System.out.println("  " + notebook.getName() + ": $" + notebook.getPrice());

        pen.reducePrice(0.50);
        laptop.reducePrice(50);
        notebook.reducePrice(0.75);

        System.out.println("После снижения цен:");
        System.out.println("  " + pen.getName() + ": $" + pen.getPrice());
        System.out.println("  " + laptop.getName() + ": $" + laptop.getPrice());
        System.out.println("  " + notebook.getName() + ": $" + notebook.getPrice());


        System.out.println("\nТест 3: Полное тестирование всех методов");
        Product monitor = new Product("Монитор", 299.99);

        System.out.println("Создан продукт:");
        System.out.println("  getName() вернул: " + monitor.getName());
        System.out.println("  getPrice() вернул: $" + monitor.getPrice());

        monitor.reducePrice(20);
        System.out.println("После вызова reducePrice(20):");
        System.out.println("  getName() вернул: " + monitor.getName());
        System.out.println("  getPrice() вернул: $" + monitor.getPrice());
        System.out.println("  Ожидаемо: $279.99");


        System.out.println("\nТест 4: Граничные случаи");
        Product item1 = new Product("Дешёвый товар", 5.00);
        System.out.println("Исходная цена: $" + item1.getPrice());

        item1.reducePrice(2.50);
        System.out.println("После снижения на $2.50: $" + item1.getPrice());
        System.out.println("Ожидаемо: $2.5");


        System.out.println("\n" + "=".repeat(50));
        System.out.println("=== Демонстрация ровно как в задании ===\n");

        Product toaster = new Product("Тостер", 29.95);
        Product microwave = new Product("Микроволновка", 79.95);

        System.out.println("Созданы два продукта:");
        System.out.println(toaster.getName() + " - $" + toaster.getPrice());
        System.out.println(microwave.getName() + " - $" + microwave.getPrice());

        toaster.reducePrice(5);
        microwave.reducePrice(5);

        System.out.println("\nПосле снижения цены на $5:");
        System.out.println(toaster.getName() + " - $" + toaster.getPrice());
        System.out.println(microwave.getName() + " - $" + microwave.getPrice());
    }
}
