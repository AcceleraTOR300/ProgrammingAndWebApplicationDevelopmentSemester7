/**
 * Задание 5, написать класс CircuitTester, который проверяет все комбинации переключателей в задании 4.
 */
class CircuitTester {
    public static void main(String[] args) {
        System.out.println("=== Проверка всех комбинаций ===\n");

        HallwayLighting test1 = new HallwayLighting();
        System.out.println("Тест 1: DOWN-DOWN");
        System.out.println("  Лампа: " + test1.getLampState() + " (ожидается 0)");

        HallwayLighting test2 = new HallwayLighting();
        test2.toggleFirstSwitch();
        System.out.println("\nТест 2: UP-DOWN");
        System.out.println("  Лампа: " + test2.getLampState() + " (ожидается 1)");

        HallwayLighting test3 = new HallwayLighting();
        test3.toggleSecondSwitch();
        System.out.println("\nТест 3: DOWN-UP");
        System.out.println("  Лампа: " + test3.getLampState() + " (ожидается 1)");

        HallwayLighting test4 = new HallwayLighting();
        test4.toggleFirstSwitch();
        test4.toggleSecondSwitch();
        System.out.println("\nТест 4: UP-UP");
        System.out.println("  Лампа: " + test4.getLampState() + " (ожидается 0)");
    }
}