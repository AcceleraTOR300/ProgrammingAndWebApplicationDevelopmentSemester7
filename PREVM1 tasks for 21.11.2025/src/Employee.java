/**
 * Задание 12, класс, который представляет сотрудника с именем и зарплатой.
 */
public class Employee
{
    private String name;
    private double salary;

    /**
     * Конструктор создаёт сотрудника с именем и зарплатой.
     */
    public Employee(String employeeName, double currentSalary)
    {
        name = employeeName;
        salary = currentSalary;
    }

    /**
     * Возвращает имя сотрудника.
     */
    public String getName()
    {

        return name;
    }

    /**
     * Возвращает текущую зарплату сотрудника.
     */
    public double getSalary()
    {

        return salary;
    }

    /**
     * Повышает зарплату сотрудника на определённый процент.
     */
    public void raiseSalary(double byPercent)
    {
        double raiseAmount = salary * byPercent / 100;
        salary = salary + raiseAmount;
    }
}

/**
 * Класс для тестирования класса Employee.
 */
class EmployeeTester
{
    public static void main(String[] args)
    {
        System.out.println("=== Задание 12: Тестирование класса Employee ===\n");


        Employee harry = new Employee("Hacker, Harry", 50000);

        System.out.println("Создан сотрудник:");
        System.out.println("  Имя: " + harry.getName());
        System.out.println("  Зарплата: $" + harry.getSalary());


        System.out.println("\nПовышение зарплаты на 10%...");
        System.out.println("  Расчёт: $50000 * 10 / 100 = $5000");
        System.out.println("  Новая зарплата: $50000 + $5000 = $55000");

        harry.raiseSalary(10);

        System.out.println("\nПосле повышения:");
        System.out.println("  Имя: " + harry.getName());
        System.out.println("  Зарплата: $" + harry.getSalary());


        System.out.println("\n" + "=".repeat(50));
        if (harry.getSalary() == 55000)
        {
            System.out.println("✓ Повышение зарплаты работает корректно!");
        }
        System.out.println("=".repeat(50));


        System.out.println("\n=== Дополнительные тесты ===\n");


        System.out.println("Тест 1: Сотрудник с начальной зарплатой $40000");
        Employee jane = new Employee("Smith, Jane", 40000);
        System.out.println("  Имя: " + jane.getName());
        System.out.println("  Зарплата: $" + jane.getSalary());

        jane.raiseSalary(5);
        System.out.println("  После повышения на 5%: $" + jane.getSalary());
        System.out.println("  Ожидаемо: $40000 + ($40000 * 5%) = $42000");


        System.out.println("\nТест 2: Несколько повышений подряд");
        Employee bob = new Employee("Johnson, Bob", 60000);
        System.out.println("  Начальная зарплата: $" + bob.getSalary());

        bob.raiseSalary(10);
        System.out.println("  После повышения на 10%: $" + bob.getSalary());

        bob.raiseSalary(5);
        System.out.println("  После повышения на 5%: $" + bob.getSalary());

        bob.raiseSalary(2);
        System.out.println("  После повышения на 2%: $" + bob.getSalary());

        System.out.println("  Расчёты:");
        System.out.println("    $60000 * 1.10 = $66000");
        System.out.println("    $66000 * 1.05 = $69300");
        System.out.println("    $69300 * 1.02 = $70686");

        // Тест 3: Тестирование всех методов
        System.out.println("\nТест 3: Полное тестирование методов");
        Employee alice = new Employee("Brown, Alice", 55000);

        System.out.println("  Создан сотрудник:");
        System.out.println("    getName() вернул: " + alice.getName());
        System.out.println("    getSalary() вернул: $" + alice.getSalary());

        alice.raiseSalary(20);
        System.out.println("  После вызова raiseSalary(20):");
        System.out.println("    getName() вернул: " + alice.getName());
        System.out.println("    getSalary() вернул: $" + alice.getSalary());
        System.out.println("    Ожидаемо: $66000");

        // Тест 4: Граничные случаи
        System.out.println("\nТест 4: Граничные случаи");
        Employee charlie = new Employee("Davis, Charlie", 100000);
        System.out.println("  Начальная зарплата: $" + charlie.getSalary());

        charlie.raiseSalary(0); // Нулевое повышение
        System.out.println("  После повышения на 0%: $" + charlie.getSalary());

        charlie.raiseSalary(1); // Очень маленькое повышение
        System.out.println("  После повышения на 1%: $" + charlie.getSalary());
    }
}
