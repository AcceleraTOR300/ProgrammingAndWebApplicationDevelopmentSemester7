/**
 * Задание 3, класс управления диапазоном значений (например, температура в автомобиле).
 */
public class RangeInput {
    private int value;
    private int minLimit;
    private int maxLimit;

    /**
     * Конструктор создаёт элемент управления с диапазоном от min до max.
     * Начальное значение устанавливается в середину диапазона.
     */
    public RangeInput(int min, int max) {
        minLimit = min;
        maxLimit = max;
        value = (min + max) / 2; // Середина диапазона
    }

    /**
     * Увеличивает текущее значение на 1.
     * Значение не может превышать максимум.
     */
    public void up() {

        value = Math.min(value + 1, maxLimit);
    }

    /**
     * Уменьшает текущее значение на 1.
     * Значение не может быть меньше минимума.
     */
    public void down() {
        value = Math.max(value - 1, minLimit);
    }

    /**
     * Возвращает текущее значение.
     */
    public int getValue() {
        return value;
    }

    /**
     * Возвращает минимальное значение диапазона.
     */
    public int getMin() {

        return minLimit;
    }

    /**
     * Возвращает максимальное значение диапазона.
     */
    public int getMax() {
        return maxLimit;
    }
}

/**
 * Класс для симуляции управления температурой в автомобиле(здесь идет еще для ясности верхних и нижних границ водитель
 * и пришлось применять конструкцию цикла for.
 */
class RangeInputTester {
    public static void main(String[] args) {
        System.out.println("=== Управление температурой в автомобиле ===\n");

        // Создаём элемент управления температурой: от 60 до 80 градусов
        RangeInput driverControl = new RangeInput(60, 80);
        RangeInput passengerControl = new RangeInput(60, 80);

        System.out.println("Диапазон температуры: " + driverControl.getMin() +
                " - " + driverControl.getMax() + " градусов");
        System.out.println("Начальная температура водителя: " + driverControl.getValue());
        System.out.println("Начальная температура пассажира: " + passengerControl.getValue());

        // Водитель увеличивает температуру
        System.out.println("\n=== Действия водителя ===");
        driverControl.up();
        System.out.println("Водитель нажал UP: " + driverControl.getValue());

        driverControl.up();
        System.out.println("Водитель нажал UP: " + driverControl.getValue());

        driverControl.up();
        System.out.println("Водитель нажал UP: " + driverControl.getValue());

        // Пассажир уменьшает температуру
        System.out.println("\n=== Действия пассажира ===");
        passengerControl.down();
        System.out.println("Пассажир нажал DOWN: " + passengerControl.getValue());

        passengerControl.down();
        System.out.println("Пассажир нажал DOWN: " + passengerControl.getValue());

        passengerControl.down();
        System.out.println("Пассажир нажал DOWN: " + passengerControl.getValue());

        System.out.println("\n=== Тест верхней границы (водитель) ===");
        for (int i = 0; i < 20; i++) {
            driverControl.up();
        }
        System.out.println("После множественных UP: " + driverControl.getValue());
        System.out.println("Максимум: " + driverControl.getMax());
        System.out.println("Температура остаётся на максимуме");

        System.out.println("\n=== Тест нижней границы (пассажир) ===");
        for (int i = 0; i < 20; i++) {
            passengerControl.down();
        }
        System.out.println("После множественных DOWN: " + passengerControl.getValue());
        System.out.println("Минимум: " + passengerControl.getMin());
        System.out.println("Температура остаётся на минимуме");

        System.out.println("\n=== Комбинированные действия ===");
        RangeInput control = new RangeInput(60, 80);
        System.out.println("Начальное значение: " + control.getValue());

        control.up();
        control.up();
        control.up();
        System.out.println("После 3 UP: " + control.getValue());

        control.down();
        control.down();
        System.out.println("После 2 DOWN: " + control.getValue());

        control.up();
        System.out.println("После 1 UP: " + control.getValue());
    }
}
