// ЗАДАНИЕ P5.9
// Суть: Написать программу, которая определяет, является ли год високосным
// Правило Gregorian календаря (gregorian correction):
// - Год делится на 400 → ВИСОКОСНЫЙ (например, 2000)
// - Год делится на 100 (но не на 400) → НЕ ВИСОКОСНЫЙ (например, 1900)
// - Год делится на 4 (но не на 100) → ВИСОКОСНЫЙ (например, 1996)
// - Во всех остальных случаях → НЕ ВИСОКОСНЫЙ (например, 1982)
// Високосные годы нужны для синхронизации календаря с вращением Земли
// вокруг Солнца (365.25 дней за оборот)

// Класс для проверки високосного года
public class LeapYearChecker {
    private int year;

    // Конструктор с использованием уже this
    public LeapYearChecker(int year) {
        this.year = year;
    }

    // Проверяет, является ли год високосным
    public boolean isLeapYear() {
        if (this.year % 400 == 0) {
            return true;
        }
        if (this.year % 100 == 0) {
            return false;
        }
        if (this.year % 4 == 0) {
            return true;
        }
        return false;
    }

    // Получить год
    public int getYear() {
        return this.year;
    }
}

// Класс для тестирования
class LeapYearTester {
    public static void main(String[] args) {
        // Тест 1: 1900 - не високосный (делится на 100, но не на 400)
        LeapYearChecker year1 = new LeapYearChecker(1900);
        System.out.println("Год " + year1.getYear() + ": " + year1.isLeapYear());
        System.out.println("Ожидаемо: false");

        // Тест 2: 1982 - не високосный (не делится на 4)
        LeapYearChecker year2 = new LeapYearChecker(1982);
        System.out.println("\nГод " + year2.getYear() + ": " + year2.isLeapYear());
        System.out.println("Ожидаемо: false");

        // Тест 3: 1996 - високосный (делится на 4, но не на 100)
        LeapYearChecker year3 = new LeapYearChecker(1996);
        System.out.println("\nГод " + year3.getYear() + ": " + year3.isLeapYear());
        System.out.println("Ожидаемо: true");

        // Тест 4: 2000 - високосный (делится на 400)
        LeapYearChecker year4 = new LeapYearChecker(2000);
        System.out.println("\nГод " + year4.getYear() + ": " + year4.isLeapYear());
        System.out.println("Ожидаемо: true");

        // Тест 5: 2004 - високосный (делится на 4)
        LeapYearChecker year5 = new LeapYearChecker(2004);
        System.out.println("\nГод " + year5.getYear() + ": " + year5.isLeapYear());
        System.out.println("Ожидаемо: true");
    }
}
