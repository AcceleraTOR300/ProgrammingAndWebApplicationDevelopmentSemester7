/**
 * Класс кассового регистра для обработки продаж.
 */
public class CashRegister
{
    private double purchase;
    private double payment;
    private double salesTotal;      // Новое: общая сумма всех продаж
    private int salesCount;         // Новое: количество продаж

    /**
     * Конструктор создаёт кассовый регистр.
     */
    public CashRegister()
    {
        purchase = 0;
        payment = 0;
        salesTotal = 0;
        salesCount = 0;
    }

    /**
     * Записывает покупку товара.
     */
    public void recordPurchase(double amount)
    {
        purchase = purchase + amount;
    }

    /**
     * Получает платёж от покупателя.
     */
    public void receivePayment(double amount)
    {
        payment = payment + amount;
    }

    /**
     * Вычисляет сдачу и сбрасывает счёт для следующего покупателя.
     */
    public double giveChange()
    {
        double change = payment - purchase;

        // Добавляем текущую продажу к итогам
        salesTotal = salesTotal + purchase;
        salesCount = salesCount + 1;

        purchase = 0;
        payment = 0;
        return change;
    }

    /**
     * Печатает чек со всеми товарами и итоговой суммой.
     * Задание 10.
     */
    public void printReceipt()
    {
        System.out.println("=== ЧЕК ===");
        System.out.println("Сумма к оплате: $" + String.valueOf(purchase));
        System.out.println("================");
    }

    /**
     * Возвращает общую сумму всех продаж за день.
     * Задание 11.
     */
    public double getSalesTotal()
    {
        return salesTotal;
    }

    /**
     * Возвращает количество совершённых продаж за день.
     * Задание 11.
     */
    public int getSalesCount()
    {
        return salesCount;
    }

    /**
     * Сбрасывает все счётчики для начала нового дня.
     * Задание 11.
     */
    public void reset()
    {
        purchase = 0;
        payment = 0;
        salesTotal = 0;
        salesCount = 0;
    }
}

/**
 * Класс для тестирования CashRegister (Задания 10 и 11).
 */
class CashRegisterTester
{
    public static void main(String[] args)
    {
        System.out.println("=== Задание 10: Тестирование printReceipt ===\n");

        CashRegister register1 = new CashRegister();

        // Записываем товары
        register1.recordPurchase(29.95);
        register1.recordPurchase(9.95);

        System.out.println("Товары записаны:");
        System.out.println("  Товар 1: $29.95");
        System.out.println("  Товар 2: $9.95");
        System.out.println("  Итого: $39.90\n");

        // Печатаем чек
        register1.printReceipt();

        // Получаем платёж и выдаём сдачу
        register1.receivePayment(50);
        double change1 = register1.giveChange();
        System.out.println("Получено платежа: $50.00");
        System.out.println("Сдача: $" + String.valueOf(change1));

        System.out.println("\n=== Задание 11: Тестирование счётчиков ===\n");

        CashRegister register2 = new CashRegister();

        // Продажа 1
        System.out.println("Продажа 1:");
        register2.recordPurchase(29.50);
        register2.recordPurchase(9.25);
        register2.receivePayment(50);
        double change2 = register2.giveChange();
        System.out.println("  Сумма: $38.75, Сдача: $" + String.valueOf(change2));

        // Продажа 2
        System.out.println("\nПродажа 2:");
        register2.recordPurchase(15.00);
        register2.receivePayment(20);
        double change3 = register2.giveChange();
        System.out.println("  Сумма: $15.00, Сдача: $" + String.valueOf(change3));

        // Продажа 3
        System.out.println("\nПродажа 3:");
        register2.recordPurchase(45.50);
        register2.receivePayment(50);
        double change4 = register2.giveChange();
        System.out.println("  Сумма: $45.50, Сдача: $" + String.valueOf(change4));

        // Итоги за день
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ИТОГИ ЗА ДЕНЬ:");
        System.out.println("  Всего продаж: " + register2.getSalesCount());
        System.out.println("  Общая сумма: $" + String.valueOf(register2.getSalesTotal()));
        System.out.println("  Средняя чек: $" + String.valueOf(register2.getSalesTotal() / register2.getSalesCount()));
        System.out.println("=".repeat(50));

        // Сброс на следующий день
        System.out.println("\nСброс реестра на новый день...");
        register2.reset();

        System.out.println("После сброса:");
        System.out.println("  Всего продаж: " + register2.getSalesCount());
        System.out.println("  Общая сумма: $" + String.valueOf(register2.getSalesTotal()));

        // Новая продажа в новый день
        System.out.println("\nНовая продажа в новый день:");
        register2.recordPurchase(12.99);
        register2.receivePayment(20);
        double change5 = register2.giveChange();
        System.out.println("  Сумма: $12.99, Сдача: $" + String.valueOf(change5));

        System.out.println("\nНовые итоги:");
        System.out.println("  Всего продаж: " + register2.getSalesCount());
        System.out.println("  Общая сумма: $" + String.valueOf(register2.getSalesTotal()));
    }
}
