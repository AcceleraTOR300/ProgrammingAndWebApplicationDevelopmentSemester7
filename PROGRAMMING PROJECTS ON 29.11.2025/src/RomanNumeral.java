// ЗАДАНИЕ P5.10
// Суть: Преобразовать положительное целое число в римскую нотацию
// Правила:
// - Только числа до 3,999
// - Тысячи, сотни, десятки и единицы выражаются отдельно
// - Числа 1-9: I II III IV V VI VII VIII IX
// - I перед V или X вычитается из значения
// - Никогда не более трёх одинаковых символов подряд
// - Десятки и сотни используют X, L, C и C, D, M соответственно
// - Пример: 1978 → MCMLXXVIII

// Класс для преобразования числа в римскую нотацию
public class RomanNumeral {
    private int number;

    // Конструктор
    public RomanNumeral(int number) {
        this.number = number;
    }

    // Преобразует число в римскую нотацию
    public String toRoman() {
        String roman = "";

        // Тысячи
        int thousands = this.number / 1000;
        for (int i = 0; i < thousands; i++) {
            roman = roman + "M";
        }

        // Сотни
        int hundreds = (this.number % 1000) / 100;
        roman = roman + convertHundreds(hundreds);

        // Десятки
        int tens = (this.number % 100) / 10;
        roman = roman + convertTens(tens);

        // Единицы
        int ones = this.number % 10;
        roman = roman + convertOnes(ones);

        return roman;
    }

    // Преобразует сотни (100-900)
    private String convertHundreds(int hundreds) {
        if (hundreds == 4) {
            return "CD";
        } else if (hundreds == 9) {
            return "CM";
        } else if (hundreds >= 5) {
            String result = "D";
            for (int i = 0; i < hundreds - 5; i++) {
                result = result + "C";
            }
            return result;
        } else {
            String result = "";
            for (int i = 0; i < hundreds; i++) {
                result = result + "C";
            }
            return result;
        }
    }

    // Преобразует десятки (10-90)
    private String convertTens(int tens) {
        if (tens == 4) {
            return "XL";
        } else if (tens == 9) {
            return "XC";
        } else if (tens >= 5) {
            String result = "L";
            for (int i = 0; i < tens - 5; i++) {
                result = result + "X";
            }
            return result;
        } else {
            String result = "";
            for (int i = 0; i < tens; i++) {
                result = result + "X";
            }
            return result;
        }
    }

    // Преобразует единицы (1-9)
    private String convertOnes(int ones) {
        if (ones == 4) {
            return "IV";
        } else if (ones == 9) {
            return "IX";
        } else if (ones >= 5) {
            String result = "V";
            for (int i = 0; i < ones - 5; i++) {
                result = result + "I";
            }
            return result;
        } else {
            String result = "";
            for (int i = 0; i < ones; i++) {
                result = result + "I";
            }
            return result;
        }
    }
}

// Класс для тестирования
class RomanNumeralTester {
    public static void main(String[] args) {
        // Тест 1: Пример из задания - 1978
        RomanNumeral number1 = new RomanNumeral(1978);
        System.out.println("1978 → " + number1.toRoman());
        System.out.println("Ожидаемо: MCMLXXVIII\n");

        // Тест 2: Простое число - 5
        RomanNumeral number2 = new RomanNumeral(5);
        System.out.println("5 → " + number2.toRoman());
        System.out.println("Ожидаемо: V\n");

        // Тест 3: Число с вычитанием - 4
        RomanNumeral number3 = new RomanNumeral(4);
        System.out.println("4 → " + number3.toRoman());
        System.out.println("Ожидаемо: IV\n");

        // Тест 4: Число с вычитанием - 9
        RomanNumeral number4 = new RomanNumeral(9);
        System.out.println("9 → " + number4.toRoman());
        System.out.println("Ожидаемо: IX\n");

        // Тест 5: 1994 (MCMXCIV)
        RomanNumeral number5 = new RomanNumeral(1994);
        System.out.println("1994 → " + number5.toRoman());
        System.out.println("Ожидаемо: MCMXCIV\n");

        // Тест 6: 58 (LVIII)
        RomanNumeral number6 = new RomanNumeral(58);
        System.out.println("58 → " + number6.toRoman());
        System.out.println("Ожидаемо: LVIII\n");

        // Тест 7: 2023 (MMXXIII)
        RomanNumeral number7 = new RomanNumeral(2023);
        System.out.println("2023 → " + number7.toRoman());
        System.out.println("Ожидаемо: MMXXIII\n");

        // Тест 8: 3999 (максимум - MMMCMXCIX)
        RomanNumeral number8 = new RomanNumeral(3999);
        System.out.println("3999 → " + number8.toRoman());
        System.out.println("Ожидаемо: MMMCMXCIX");
    }
}
