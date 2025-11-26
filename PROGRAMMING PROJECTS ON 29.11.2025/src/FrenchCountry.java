// ЗАДАНИЕ P5.11
// Суть: Определить артикль (le или la) для французского названия страны
// Правило:
// - Страны, оканчивающиеся на 'e' → ЖЕНСКИЙ РОД (la)
// - Все остальные → МУЖСКОЙ РОД (le)
// ИСКЛЮЧЕНИЕ: Следующие страны МУЖСКОГО РОДА, несмотря на окончание 'e':
//   • le Belize
//   • le Cambodge
//   • le Mexique
//   • le Mozambique
//   • le Zaïre
//   • le Zimbabwe

import java.util.Scanner;

// Класс для определения артикля французской страны
public class FrenchCountry {
    private String countryName;

    // Конструктор
    public FrenchCountry(String countryName) {
        this.countryName = countryName;
    }

    // Проверяет, является ли страна исключением (мужского рода, несмотря на 'e')
    private boolean isMasculineException() {
        return this.countryName.equalsIgnoreCase("Belize") ||
                this.countryName.equalsIgnoreCase("Cambodge") ||
                this.countryName.equalsIgnoreCase("Mexique") ||
                this.countryName.equalsIgnoreCase("Mozambique") ||
                this.countryName.equalsIgnoreCase("Zaïre") ||
                this.countryName.equalsIgnoreCase("Zimbabwe");
    }

    // Возвращает артикль с названием страны
    public String getWithArticle() {
        // Если это исключение, используем "le"
        if (this.isMasculineException()) {
            return "le " + this.countryName;
        }

        // Если страна оканчивается на 'e', используем "la"
        if (this.countryName.toLowerCase().endsWith("e")) {
            return "la " + this.countryName;
        }

        // Во всех остальных случаях используем "le"
        return "le " + this.countryName;
    }
}

// Класс для тестирования
class CountryTester {
    public static void main(String[] args) {
        // Тест 1: Страна, оканчивающаяся на 'e' (женский род)
        FrenchCountry country1 = new FrenchCountry("Belgique");
        System.out.println("Бельгия: " + country1.getWithArticle());
        System.out.println("Ожидаемо: la Belgique\n");

        // Тест 2: Страна, не оканчивающаяся на 'e' (мужской род)
        FrenchCountry country2 = new FrenchCountry("Canada");
        System.out.println("Канада: " + country2.getWithArticle());
        System.out.println("Ожидаемо: le Canada\n");

        // Тест 3: Исключение - Mexique (мужского рода, несмотря на 'e')
        FrenchCountry country3 = new FrenchCountry("Mexique");
        System.out.println("Мексика: " + country3.getWithArticle());
        System.out.println("Ожидаемо: le Mexique\n");

        // Тест 4: Исключение - Belize
        FrenchCountry country4 = new FrenchCountry("Belize");
        System.out.println("Белиз: " + country4.getWithArticle());
        System.out.println("Ожидаемо: le Belize\n");

        // Тест 5: Исключение - Zimbabwe
        FrenchCountry country5 = new FrenchCountry("Zimbabwe");
        System.out.println("Зимбабве: " + country5.getWithArticle());
        System.out.println("Ожидаемо: le Zimbabwe\n");

        // Тест 6: Страна, оканчивающаяся на 'e' (женский род)
        FrenchCountry country6 = new FrenchCountry("France");
        System.out.println("Франция: " + country6.getWithArticle());
        System.out.println("Ожидаемо: la France\n");

        // Тест 7: Страна, не оканчивающаяся на 'e' (мужской род)
        FrenchCountry country7 = new FrenchCountry("Japon");
        System.out.println("Япония: " + country7.getWithArticle());
        System.out.println("Ожидаемо: le Japon");
    }
}
