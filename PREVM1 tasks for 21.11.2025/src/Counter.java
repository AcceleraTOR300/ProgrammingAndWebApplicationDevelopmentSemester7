/**
 * Задание 1, попробовать реализвать класс счётчик с возможностью отмены последнего нажатия.
 */
public class Counter
{
    private int value;

    /**
     * Конструктор создаёт счётчик с начальным значением.
     */
    public Counter(int initialValue)
    {
        value = initialValue;
    }

    /**
     * Нажимает кнопку счётчика, увеличивая значение на 1.
     */
    public void click()
    {
        value = value + 1;
    }

    /**
     * Нажимает кнопку отмены, уменьшая значение на 1.
     * Не может привести значение ниже нуля.
     */
    public void undo()
    {
        value = Math.max(value - 1, 0);
    }

    /**
     * Возвращает текущее значение счётчика.
     */
    public int getValue()
    {
        return value;
    }
}

/**
 * Класс для тестирования класса Counter с методом undo.
 */
class CounterTester
{
    public static void main(String[] args)
    {
        Counter counter = new Counter(0);

        System.out.println("Начальное значение: " + counter.getValue());

        counter.click();
        counter.click();
        counter.click();
        System.out.println("После 3 нажатий click: " + counter.getValue());


        counter.undo();
        System.out.println("После 1 нажатия undo: " + counter.getValue());

        counter.undo();
        System.out.println("После 2 нажатия undo: " + counter.getValue());


        System.out.println("\n=== Тест защиты ===");
        counter.click();
        System.out.println("После click: " + counter.getValue());

        counter.undo();
        System.out.println("После первого undo: " + counter.getValue());

        counter.undo();
        System.out.println("После второго undo (должно быть 0): " + counter.getValue());

        counter.undo();
        System.out.println("После третьего undo (должно остаться 0): " + counter.getValue());

        counter.undo();
        System.out.println("После четвёртого undo (должно остаться 0): " + counter.getValue());
    }
}
