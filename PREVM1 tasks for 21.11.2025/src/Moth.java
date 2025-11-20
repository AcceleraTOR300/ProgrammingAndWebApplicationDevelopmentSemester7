/**
 * Задание 17, класс, в котором демонстрируется моделирования мотылька, летящего к свету.
 */
public class Moth
{
    private double position;

    /**
     * Конструктор создаёт мотылька с начальной позицией.
     */
    public Moth(double initialPosition)
    {
        position = initialPosition;
    }

    /**
     * Перемещает мотылька к источнику света.
     * Новое положение = половина пути между старой позицией и позицией света.
     */
    public void moveToLight(double lightPosition)
    {
        position = (position + lightPosition) / 2;
    }

    /**
     * Возвращает текущую позицию мотылька.
     */
    public double getPosition()
    {
        return position;
    }
}

/**
 * Класс для юнит-тестирования класса Moth.
 */
class MothTester
{
    public static void main(String[] args)
    {

        Moth moth1 = new Moth(0);
        moth1.moveToLight(10);
        System.out.println("Тест 1: " + moth1.getPosition() + " (ожидается 5.0)");


        Moth moth2 = new Moth(0);
        moth2.moveToLight(-10);
        System.out.println("Тест 2: " + moth2.getPosition() + " (ожидается -5.0)");


        Moth moth3 = new Moth(10);
        moth3.moveToLight(-10);
        System.out.println("Тест 3: " + moth3.getPosition() + " (ожидается 0.0)");


        Moth moth4 = new Moth(2.5);
        moth4.moveToLight(7.5);
        System.out.println("Тест 4: " + moth4.getPosition() + " (ожидается 5.0)");


        Moth moth5 = new Moth(0);
        moth5.moveToLight(100);
        moth5.moveToLight(100);
        moth5.moveToLight(100);
        System.out.println("Тест 5: " + moth5.getPosition() + " (ожидается 87.5)");
    }
}
