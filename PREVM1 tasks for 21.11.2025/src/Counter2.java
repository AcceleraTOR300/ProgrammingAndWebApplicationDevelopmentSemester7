/**
 * Задание 2, класс счётчика с ограничением по лимиту людей.
 */
public class Counter2
{
    private int value;
    private int limit;

    /**
     * Конструктор создаёт счётчик с начальным значением и без лимита.
     */
    public Counter2(int initialValue)
    {
        value = initialValue;
        limit = Integer.MAX_VALUE; // Без ограничения по умолчанию
    }

    /**
     * Устанавливает максимальный лимит для счётчика.
     */
    public void setLimit(int maximum)
    {
        limit = maximum;
    }

    /**
     * Нажимает кнопку счётчика, увеличивая значение на 1.
     * Если значение достигнет лимита, кнопка не будет иметь эффекта.
     */
    public void click()
    {
        if (value < limit)
        {
            value = value + 1;
        }
    }

    /**
     * Возвращает текущее значение счётчика.
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Возвращает установленный лимит.
     */
    public int getLimit()
    {
        return limit;
    }
}

/**
 * Класс для тестирования счётчика с лимитом.
 */
class Counter2Tester
{
    public static void main(String[] args)
    {
        Counter2 counter = new Counter2(0);

        System.out.println("=== Счётчик без лимита ===");
        System.out.println("Начальное значение: " + counter.getValue());

        counter.click();
        counter.click();
        counter.click();
        System.out.println("После 3 нажатий: " + counter.getValue());

        System.out.println("\n=== Установка лимита на 5 ===");
        counter.setLimit(5);
        System.out.println("Лимит установлен: " + counter.getLimit());

        // Текущее значение 3, нажимаем до лимита
        counter.click();
        System.out.println("После click (3->4): " + counter.getValue());

        counter.click();
        System.out.println("После click (4->5): " + counter.getValue());

        System.out.println("\n=== Попытка превысить лимит ===");
        counter.click();
        System.out.println("После click (попытка 5->6): " + counter.getValue());

        counter.click();
        System.out.println("После click (попытка 5->6): " + counter.getValue());

        counter.click();
        System.out.println("После click (попытка 5->6): " + counter.getValue());

        System.out.println("Значение остаётся на лимите: " + counter.getValue());

        System.out.println("\n=== Новый счётчик с лимитом 3 ===");
        Counter2 counter2 = new Counter2(0);
        counter2.setLimit(3);

        counter2.click();
        System.out.println("После 1-го click: " + counter2.getValue());

        counter2.click();
        System.out.println("После 2-го click: " + counter2.getValue());

        counter2.click();
        System.out.println("После 3-го click: " + counter2.getValue());

        counter2.click();
        System.out.println("После 4-го click (превышение): " + counter2.getValue());

        counter2.click();
        System.out.println("После 5-го click (превышение): " + counter2.getValue());
    }
}
