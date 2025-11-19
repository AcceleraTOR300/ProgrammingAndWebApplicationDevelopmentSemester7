/**
 * Заадние 6, улучшенный класс системы управления освещением коридора
 * с унифицированным интерфейсом для работы с выключателями.
 */
public class HallwayLighting2
{
    private int firstSwitchState;  // 0 = down, 1 = up
    private int secondSwitchState; // 0 = down, 1 = up
    private int lampState;         // 0 = off, 1 = on

    /**
     * Конструктор создаёт систему с обоими выключателями в положении down
     * и выключенной лампой.
     */
    public HallwayLighting2()
    {
        firstSwitchState = 0;
        secondSwitchState = 0;
        lampState = 0;
    }

    /**
     * Возвращает состояние выключателя по номеру.
     * @param switchNum номер выключателя (1 или 2)
     * @return 0 если down, 1 если up, -1 если неправильный номер
     */
    public int getSwitchState(int switchNum)
    {
        if (switchNum == 1)
        {
            return firstSwitchState;
        }
        else if (switchNum == 2)
        {
            return secondSwitchState;
        }
        else
        {
            return -1; // Ошибка: неправильный номер выключателя
        }
    }

    /**
     * Возвращает состояние лампы.
     * @return 0 если off, 1 если on
     */
    public int getLampState()
    {
        return lampState;
    }

    /**
     * Переключает выключатель по номеру.
     * @param switchNum номер выключателя (1 или 2)
     */
    public void toggleSwitch(int switchNum)
    {
        if (switchNum == 1)
        {
            firstSwitchState = 1 - firstSwitchState;
        }
        else if (switchNum == 2)
        {
            secondSwitchState = 1 - secondSwitchState;
        }

        updateLampState();
    }

    /**
     * Обновляет состояние лампы.
     * Лампа включена (1), если выключатели в разных положениях,
     * лампа выключена (0), если в одинаковых положениях.
     */
    private void updateLampState()
    {
        if (firstSwitchState == secondSwitchState)
        {
            lampState = 0;
        }
        else
        {
            lampState = 1;
        }
    }
}

/**
 * Класс CircuitTester для проверки всех комбинаций с новым интерфейсом.
 */
class CircuitTester2
{
    public static void main(String[] args)
    {
        System.out.println("=== Проверка всех комбинаций (новый интерфейс) ===\n");

        // Комбинация 1: DOWN-DOWN
        HallwayLighting2 test1 = new HallwayLighting2();
        System.out.println("Тест 1: DOWN-DOWN");
        System.out.println("  Первый выключатель: " + test1.getSwitchState(1) + " (ожидается 0)");
        System.out.println("  Второй выключатель: " + test1.getSwitchState(2) + " (ожидается 0)");
        System.out.println("  Лампа: " + test1.getLampState() + " (ожидается 0)");

        // Комбинация 2: UP-DOWN
        HallwayLighting2 test2 = new HallwayLighting2();
        test2.toggleSwitch(1);
        System.out.println("\nТест 2: UP-DOWN");
        System.out.println("  Первый выключатель: " + test2.getSwitchState(1) + " (ожидается 1)");
        System.out.println("  Второй выключатель: " + test2.getSwitchState(2) + " (ожидается 0)");
        System.out.println("  Лампа: " + test2.getLampState() + " (ожидается 1)");

        // Комбинация 3: DOWN-UP
        HallwayLighting2 test3 = new HallwayLighting2();
        test3.toggleSwitch(2);
        System.out.println("\nТест 3: DOWN-UP");
        System.out.println("  Первый выключатель: " + test3.getSwitchState(1) + " (ожидается 0)");
        System.out.println("  Второй выключатель: " + test3.getSwitchState(2) + " (ожидается 1)");
        System.out.println("  Лампа: " + test3.getLampState() + " (ожидается 1)");

        // Комбинация 4: UP-UP
        HallwayLighting2 test4 = new HallwayLighting2();
        test4.toggleSwitch(1);
        test4.toggleSwitch(2);
        System.out.println("\nТест 4: UP-UP");
        System.out.println("  Первый выключатель: " + test4.getSwitchState(1) + " (ожидается 1)");
        System.out.println("  Второй выключатель: " + test4.getSwitchState(2) + " (ожидается 1)");
        System.out.println("  Лампа: " + test4.getLampState() + " (ожидается 0)");

        // Дополнительный тест: последовательные переключения
        System.out.println("\n=== Дополнительный тест: последовательные переключения ===");
        HallwayLighting2 test5 = new HallwayLighting2();

        System.out.println("\nНачальное состояние: DOWN-DOWN, лампа OFF");
        System.out.println("  Выключатель 1: " + test5.getSwitchState(1));
        System.out.println("  Выключатель 2: " + test5.getSwitchState(2));
        System.out.println("  Лампа: " + test5.getLampState());

        test5.toggleSwitch(1);
        System.out.println("\nПосле toggleSwitch(1): UP-DOWN, лампа ON");
        System.out.println("  Выключатель 1: " + test5.getSwitchState(1));
        System.out.println("  Выключатель 2: " + test5.getSwitchState(2));
        System.out.println("  Лампа: " + test5.getLampState());

        test5.toggleSwitch(2);
        System.out.println("\nПосле toggleSwitch(2): UP-UP, лампа OFF");
        System.out.println("  Выключатель 1: " + test5.getSwitchState(1));
        System.out.println("  Выключатель 2: " + test5.getSwitchState(2));
        System.out.println("  Лампа: " + test5.getLampState());

        test5.toggleSwitch(1);
        System.out.println("\nПосле toggleSwitch(1): DOWN-UP, лампа ON");
        System.out.println("  Выключатель 1: " + test5.getSwitchState(1));
        System.out.println("  Выключатель 2: " + test5.getSwitchState(2));
        System.out.println("  Лампа: " + test5.getLampState());
    }
}
