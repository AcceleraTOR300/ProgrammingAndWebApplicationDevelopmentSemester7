/**
 * Задание 13, класс, в котором представляется автомобиль с определённым расходом топлива.
 */
public class Car
{
    private double fuelConsumption; // литры на 100 км
    private double gasInTank;       // текущее количество топлива в баке

    /**
     * Конструктор создаёт автомобиль с определённым расходом топлива.
     * Начальный уровень топлива равен 0.
     */
    public Car(double consumption)
    {
        fuelConsumption = consumption;
        gasInTank = 0;
    }

    /**
     * Добавляет топливо в топливный бак.
     */
    public void addGas(double amount)
    {

        gasInTank = gasInTank + amount;
    }

    /**
     * Возвращает текущее количество топлива в баке.
     */
    public double getGasInTank()
    {

        return gasInTank;
    }

    /**
     * Имитирует движение автомобиля на определённое расстояние.
     * Уменьшает количество бензина в топливном баке в зависимости от расстояния.
     */
    public void drive(double distance)
    {
        double fuelNeeded = fuelConsumption * distance / 100;
        gasInTank = gasInTank - fuelNeeded;
    }
}

/**
 * Класс для тестирования класса Car.
 */
class CarTester
{
    public static void main(String[] args)
    {
        System.out.println("=== Задание 13: Тестирование класса Car ===\n");

        // Пример из задания
        System.out.println("Пример из задания:");
        Car myHybrid = new Car(10); // 10 литров / 100 км
        System.out.println("Создан автомобиль с расходом 10 л/100км");
        System.out.println("  Начальное топливо в баке: " + myHybrid.getGasInTank() + " л");

        myHybrid.addGas(50); // Заправить 50л
        System.out.println("  После заправки 50л: " + myHybrid.getGasInTank() + " л");

        myHybrid.drive(100); // Проехать 100 км
        System.out.println("  Расход при 100 км: 10л/100км * 100км = 10л");
        double gasLeft = myHybrid.getGasInTank(); // Получить объем оставшегося топлива
        System.out.println("  После проезда 100 км: " + gasLeft + " л");
        System.out.println("  Ожидаемо: 40.0 л");

        System.out.println("\n" + "=".repeat(50));
        if (gasLeft == 40.0)
        {
            System.out.println("Расчёт расхода топлива работает корректно!");
        }
        System.out.println("=".repeat(50));


        System.out.println("\n=== Тест 1: Автомобиль с высоким расходом (обычный) ===");
        Car gasolineCar = new Car(8); // 8 литров / 100 км
        System.out.println("Расход: 8 л/100км");
        System.out.println("Начальное топливо: " + gasolineCar.getGasInTank() + " л");

        gasolineCar.addGas(80);
        System.out.println("После заправки 80л: " + gasolineCar.getGasInTank() + " л");

        gasolineCar.drive(500);
        System.out.println("После проезда 500 км:");
        System.out.println("  Расход: 8л * 500км / 100км = 40л");
        System.out.println("  Оставшееся топливо: " + gasolineCar.getGasInTank() + " л");
        System.out.println("  Ожидаемо: 40.0 л");

        // Тест 2: Несколько поездок подряд
        System.out.println("\n=== Тест 2: Несколько поездок подряд ===");
        Car car2 = new Car(6); // 6 литров / 100 км
        System.out.println("Расход: 6 л/100км");

        car2.addGas(100);
        System.out.println("Начальное топливо: " + car2.getGasInTank() + " л");

        car2.drive(200);
        System.out.println("После 1-й поездки (200 км):");
        System.out.println("  Расход: 6л * 200км / 100км = 12л");
        System.out.println("  Оставшееся топливо: " + car2.getGasInTank() + " л");

        car2.drive(150);
        System.out.println("После 2-й поездки (150 км):");
        System.out.println("  Расход: 6л * 150км / 100км = 9л");
        System.out.println("  Оставшееся топливо: " + car2.getGasInTank() + " л");

        car2.addGas(50);
        System.out.println("После заправки 50л: " + car2.getGasInTank() + " л");

        car2.drive(300);
        System.out.println("После 3-й поездки (300 км):");
        System.out.println("  Расход: 6л * 300км / 100км = 18л");
        System.out.println("  Оставшееся топливо: " + car2.getGasInTank() + " л");
        System.out.println("  Ожидаемо: 29.0 л");


        System.out.println("\n=== Тест 3: Экономичный гибридный автомобиль ===");
        Car hybrid = new Car(5); // 5 литров / 100 км
        System.out.println("Расход: 5 л/100км (гибрид)");

        hybrid.addGas(60);
        System.out.println("После заправки 60л: " + hybrid.getGasInTank() + " л");

        hybrid.drive(1000);
        System.out.println("После проезда 1000 км:");
        System.out.println("  Расход: 5л * 1000км / 100км = 50л");
        System.out.println("  Оставшееся топливо: " + hybrid.getGasInTank() + " л");
        System.out.println("  Ожидаемо: 10.0 л");

        // Тест 4: Малые расстояния
        System.out.println("\n=== Тест 4: Малые расстояния ===");
        Car car4 = new Car(12); // 12 литров / 100 км
        System.out.println("Расход: 12 л/100км");

        car4.addGas(50);
        System.out.println("После заправки 50л: " + car4.getGasInTank() + " л");

        car4.drive(25);
        System.out.println("После проезда 25 км:");
        System.out.println("  Расход: 12л * 25км / 100км = 3л");
        System.out.println("  Оставшееся топливо: " + car4.getGasInTank() + " л");
        System.out.println("  Ожидаемо: 47.0 л");
    }
}
