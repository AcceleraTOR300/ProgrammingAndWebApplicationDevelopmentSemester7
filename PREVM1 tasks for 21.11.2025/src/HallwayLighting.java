/**
 * Задание 4, в котором класс моделирует систему управления освещением коридора с двумя выключателями на обоих концах.
 */
public class HallwayLighting
{
    private int firstSwitchState;
    private int secondSwitchState;
    private int lampState;

    /**
     * Конструктор создаёт систему с обоими выключателями в положении down и выключенной лампой.
     */
    public HallwayLighting()
    {
        firstSwitchState = 0;
        secondSwitchState = 0;
        lampState = 0;
    }

    /**
     * Возвращает состояние первого выключателя.
     */
    public int getFirstSwitchState()
    {

        return firstSwitchState;
    }

    /**
     * Возвращает состояние второго выключателя.
     */
    public int getSecondSwitchState()
    {

        return secondSwitchState;
    }

    /**
     * Возвращает состояние лампы.
     */
    public int getLampState()
    {

        return lampState;
    }

    /**
     * Переключает первый выключатель и обновляет состояние лампы.
     * Логика вот в чём:если оба выключателя в одинаковом состоянии, свет выключен,
     * если в разных состояниях, свет включен.
     */
    public void toggleFirstSwitch()
    {
        // Переключаем выключатель
        firstSwitchState = 1 - firstSwitchState;

        // Обновляем состояние лампы
        updateLampState();
    }

    /**
     * Переключает второй выключатель и обновляет состояние лампы.
     */
    public void toggleSecondSwitch()
    {
        // Переключаем выключатель
        secondSwitchState = 1 - secondSwitchState;

        // Обновляем состояние лампы
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
 * Класс для тестирования системы управления освещением коридора.
 */
class HallwayLightingTester
{
    public static void main(String[] args)
    {
        HallwayLighting lighting = new HallwayLighting();

        System.out.println("=== Система освещения коридора ===\n");
        System.out.println("Начальное состояние:");
        printState(lighting);


        System.out.println("\n--- Первый выключатель поднят ---");
        lighting.toggleFirstSwitch();
        printState(lighting);


        System.out.println("\n--- Второй выключатель поднят ---");
        lighting.toggleSecondSwitch();
        printState(lighting);

        // Первый переключатель опущен
        System.out.println("\n--- Первый выключатель опущен ---");
        lighting.toggleFirstSwitch();
        printState(lighting);


        System.out.println("\n--- Второй выключатель опущен ---");
        lighting.toggleSecondSwitch();
        printState(lighting);


        System.out.println("\n=== Полная демонстрация всех состояний ===\n");

        HallwayLighting demo = new HallwayLighting();

        System.out.println("Состояние 1: Оба выключателя down");
        printState(demo);

        demo.toggleFirstSwitch();
        System.out.println("\nСостояние 2: Первый up, второй down");
        printState(demo);

        demo.toggleSecondSwitch();
        System.out.println("\nСостояние 3: Оба up");
        printState(demo);

        demo.toggleFirstSwitch();
        System.out.println("\nСостояние 4: Первый down, второй up");
        printState(demo);

        demo.toggleFirstSwitch();
        System.out.println("\nСостояние 5: Оба up (снова)");
        printState(demo);


        System.out.println("\n=== Симуляция реального коридора ===\n");

        HallwayLighting corridor = new HallwayLighting();

        System.out.println("Человек входит в коридор с начала");
        System.out.println("Нажимает выключатель в начале (нужен свет)");
        corridor.toggleFirstSwitch();
        printState(corridor);

        System.out.println("\nЧеловек идёт через коридор...");

        System.out.println("\nЧеловек выходит в конец коридора");
        System.out.println("Нажимает выключатель в конце (выключить свет)");
        corridor.toggleSecondSwitch();
        printState(corridor);

        System.out.println("\nЧеловек выходит из коридора");
        System.out.println("Позже другой человек входит с конца");
        System.out.println("Нажимает выключатель в конце");
        corridor.toggleSecondSwitch();
        printState(corridor);
    }

    /**
     * Вспомогательный метод для вывода информации о состоянии системы.
     */
    private static void printState(HallwayLighting lighting)
    {
        String firstState = lighting.getFirstSwitchState() == 0 ? "DOWN" : "UP";
        String secondState = lighting.getSecondSwitchState() == 0 ? "DOWN" : "UP";
        String lampState = lighting.getLampState() == 0 ? "OFF" : "ON";

        System.out.println("  Первый выключатель: " + firstState);
        System.out.println("  Второй выключатель: " + secondState);
        System.out.println("  Лампа: " + lampState);
    }
}
