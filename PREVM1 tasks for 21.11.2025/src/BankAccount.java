/**
 * Класс банковского счёта.
 */
public class BankAccount
{
    private double balance;

    /**
     * Конструктор создаёт банковский счёт с начальным балансом.
     */
    public BankAccount(double initialBalance)
    {

        balance = initialBalance;
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
     * Добавляет проценты на счёт.
     */
    public void addInterest(double rate)
    {
        double interestAmount = balance * rate / 100;
        balance = balance + interestAmount;
    }
}

/**
 * Задание 7: Класс для тестирования банковского счёта.
 */
class BankAccountTester7
{
    public static void main(String[] args)
    {
        System.out.println("=== Задание 7: Тестирование BankAccount ===\n");

        BankAccount account = new BankAccount(0);


        account.deposit(1000);
        System.out.println("После внесения $1000: " + account.getBalance());


        account.withdraw(500);
        System.out.println("После снятия $500: " + account.getBalance());


        account.withdraw(400);
        System.out.println("После снятия ещё $400: " + account.getBalance());

        System.out.println("\nОжидаемый результат: 100.0");
    }
}

/**
 * Задание 8: Класс для тестирования с методом addInterest.
 */
class BankAccountTester8
{
    public static void main(String[] args)
    {
        System.out.println("=== Задание 8: Тестирование addInterest ===\n");

        System.out.println("Пример 1:");
        BankAccount momsSavings = new BankAccount(1000);
        System.out.println("Начальный баланс: " + momsSavings.getBalance());

        momsSavings.addInterest(10); // 10 процентов
        System.out.println("Баланс после 10% процентов: " + momsSavings.getBalance());
        System.out.println("Ожидаемый результат: 1100.0");

        // Пример 2: Баланс $500, процентная ставка 5%
        System.out.println("\nПример 2:");
        BankAccount savings = new BankAccount(500);
        System.out.println("Начальный баланс: " + savings.getBalance());

        savings.addInterest(5); // 5 процентов
        System.out.println("Баланс после 5% процентов: " + savings.getBalance());
        System.out.println("Ожидаемый результат: 525.0");

        // Пример 3: Комбинированные операции
        System.out.println("\nПример 3: Комбинированные операции");
        BankAccount account = new BankAccount(1000);
        System.out.println("Начальный баланс: " + account.getBalance());

        account.deposit(500);
        System.out.println("После внесения $500: " + account.getBalance());

        account.withdraw(200);
        System.out.println("После снятия $200: " + account.getBalance());

        account.addInterest(10);
        System.out.println("После добавления 10% процентов: " + account.getBalance());
        System.out.println("Ожидаемый результат: 1430.0");
    }
}
