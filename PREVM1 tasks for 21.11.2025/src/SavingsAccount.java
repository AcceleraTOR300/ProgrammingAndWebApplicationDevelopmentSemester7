/**
 * Задание 9, класс сберегательного счёта с процентной ставкой.
 */
public class SavingsAccount
{
    private double balance;
    private double interest;

    /**
     * Конструктор создаёт сберегательный счёт с начальным балансом и процентной ставкой.
     */
    public SavingsAccount(double initialBalance, double rate)
    {
        balance = initialBalance;
        interest = rate;
    }

    /**
     * Вносит деньги на счёт.
     */
    public void deposit(double amount)
    {
        balance = balance + amount;
    }

    /**
     * Снимает деньги со счёта.
     */
    public void withdraw(double amount)
    {
        balance = balance - amount;
    }

    /**
     * Возвращает текущий баланс счёта.
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * Возвращает текущую процентную ставку.
     */
    public double getInterestRate()
    {
        return interest;
    }

    /**
     * Добавляет проценты к счёту на основе установленной ставки.
     * Процентная ставка хранится в переменной interest.
     */
    public void addInterest()
    {
        double interestAmount = balance * interest / 100;
        balance = balance + interestAmount;
    }
}

/**
 * Класс для тестирования SavingsAccount.
 */
class SavingsAccountTester
{
    public static void main(String[] args)
    {
        System.out.println("=== Задание 9: Тестирование SavingsAccount ===\n");


        SavingsAccount account = new SavingsAccount(1000, 10);

        System.out.println("Начальные параметры счёта:");
        System.out.println("  Начальный баланс: $" + account.getBalance());
        System.out.println("  Процентная ставка: " + account.getInterestRate() + "%");


        System.out.println("\nПрименяем метод addInterest()...");
        account.addInterest();

        System.out.println("\nРезультаты после добавления процентов:");
        System.out.println("  Фактический баланс: $" + account.getBalance());


        System.out.println("\nВычисление ожидаемого результата:");
        System.out.println("  Начальный баланс: $1000");
        System.out.println("  Процентная ставка: 10%");
        System.out.println("  Сумма процентов: $1000 * 10 / 100 = $100");
        System.out.println("  Новый баланс: $1000 + $100 = $1100");
        System.out.println("  Ожидаемый баланс: $1100.0");

        // Проверка корректности
        System.out.println("\n" + "=".repeat(50));
        if (account.getBalance() == 1100.0)
        {
            System.out.println("✓ ТЕСТ ПРОЙДЕН: Фактический баланс совпадает с ожидаемым!");
        }
        else
        {
            System.out.println("✗ ТЕСТ НЕ ПРОЙДЕН: Результаты не совпадают!");
        }
        System.out.println("=".repeat(50));

        // Дополнительный пример: применение процентов несколько раз
        System.out.println("\n=== Дополнительный пример: Сложные проценты ===\n");

        SavingsAccount savings = new SavingsAccount(1000, 10);

        System.out.println("Начальный баланс: $" + savings.getBalance());

        // Первый год
        savings.addInterest();
        System.out.println("После 1-го года (10% от $1000): $" + savings.getBalance());

        // Второй год
        savings.addInterest();
        System.out.println("После 2-го года (10% от $1100): $" + savings.getBalance());

        // Третий год
        savings.addInterest();
        System.out.println("После 3-го года (10% от $1210): $" + savings.getBalance());

        System.out.println("\nРасчёты:");
        System.out.println("  После 1-го года: $1000 + ($1000 * 10%) = $1100");
        System.out.println("  После 2-го года: $1100 + ($1100 * 10%) = $1210");
        System.out.println("  После 3-го года: $1210 + ($1210 * 10%) = $1331");
    }
}
