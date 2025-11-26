/**
 * Задание 16, класс, в котором, для моделирования жука, движущегося по горизонтальной линии.
 */
public class Bug {
    private int position;
    private int direction; // 1 для вправо, -1 для влево

    /**
     * Конструктор создаёт жука с начальной позицией.
     * Изначально жук движется вправо.
     */
    public Bug(int initialPosition) {
        position = initialPosition;
        direction = 1;
    }

    /**
     * Разворачивает жука (меняет направление).
     */
    public void turn() {
        direction = -direction;
    }

    /**
     * Перемещает жука на одну единицу в текущем направлении.
     */
    public void move() {
        position = position + direction;
    }

    /**
     * Возвращает текущую позицию жука.
     */
    public int getPosition() {

        return position;
    }
}

/**
 * Класс для тестирования класса Bug.
 */
class BugTester {
    public static void main(String[] args) {
        System.out.println("=== Задание 16: Тестирование класса Bug ===\n");


        System.out.println("Пример из задания:");
        Bug bugsy = new Bug(10);
        System.out.println("Начальная позиция: " + bugsy.getPosition());
        System.out.println("Ожидаемо: 10");

        bugsy.move();
        System.out.println("После move(): " + bugsy.getPosition());
        System.out.println("Ожидаемо: 11");

        bugsy.turn();
        System.out.println("После turn()");

        bugsy.move();
        System.out.println("После move(): " + bugsy.getPosition());
        System.out.println("Ожидаемо: 10");

        System.out.println("\nТест 1: Движение вправо");
        Bug bug1 = new Bug(0);
        System.out.println("Начало: " + bug1.getPosition());
        bug1.move();
        System.out.println("После 1-го move: " + bug1.getPosition() + " (ожидается 1)");
        bug1.move();
        System.out.println("После 2-го move: " + bug1.getPosition() + " (ожидается 2)");
        bug1.move();
        System.out.println("После 3-го move: " + bug1.getPosition() + " (ожидается 3)");


        System.out.println("\nТест 2: Поворот и движение влево");
        Bug bug2 = new Bug(5);
        System.out.println("Начало: " + bug2.getPosition());
        bug2.turn();
        System.out.println("После turn()");
        bug2.move();
        System.out.println("После move: " + bug2.getPosition() + " (ожидается 4)");
        bug2.move();
        System.out.println("После move: " + bug2.getPosition() + " (ожидается 3)");


        System.out.println("\nТест 3: Несколько поворотов");
        Bug bug3 = new Bug(10);
        System.out.println("Начало: " + bug3.getPosition());

        bug3.move();
        System.out.println("После move (вправо): " + bug3.getPosition() + " (ожидается 11)");

        bug3.turn();
        bug3.move();
        System.out.println("После turn и move (влево): " + bug3.getPosition() + " (ожидается 10)");

        bug3.turn();
        bug3.move();
        System.out.println("После turn и move (вправо): " + bug3.getPosition() + " (ожидается 11)");

        bug3.turn();
        bug3.move();
        System.out.println("После turn и move (влево): " + bug3.getPosition() + " (ожидается 10)");


    }
}
