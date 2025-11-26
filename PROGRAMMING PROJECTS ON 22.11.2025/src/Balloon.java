/**
 * Задание P3.3, создание класса Ballon и методов расчётов размеров надувания этого шарика.
 */
public class Balloon
{
    private double radius;

    /**
     * Конструктор создаёт шарик с радиусом 0.
     */
    public Balloon()
    {

        radius = 0;
    }

    /**
     * Надувает шарик, увеличивая его радиус.
     * @param amount величина, на которую увеличивается радиус
     */
    public void inflate(double amount)
    {

        radius = radius + amount;
    }

    /**
     * Получает текущий объём шарика.
     * @return объём
     */
    public double getVolume()
    {
        double volume = (4.0 / 3.0) * Math.PI * radius * radius * radius;
        return volume;
    }

    /**
     * Главный метод для вывода результата класса Balloon.
     */
    public static void main(String[] args)
    {
        Balloon myBalloon = new Balloon();

        myBalloon.inflate(5);
        System.out.println("Объём после первого надувания: " + myBalloon.getVolume());

        myBalloon.inflate(5);
        System.out.println("Объём после второго надувания: " + myBalloon.getVolume());
    }
}
