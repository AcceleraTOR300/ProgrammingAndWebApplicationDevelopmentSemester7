/**
 * Задание P3.11, в котором класс симулирует рост популяции тараканов (дожили, класс).
 */
public class RoachPopulation
{
    private int roachCount;

    /**
     * Для начало построили конструктор, который создаёт популяцию с начальным количеством тараканов.
     */
    public RoachPopulation(int initialPopulation)
    {

        roachCount = initialPopulation;
    }

    /**
     * Затем, включаем симуляцию периода размножения тараканов (в этом симулци удваиваеваем популяцию в примере).
     */
    public void breed()
    {

        roachCount = roachCount * 2;
    }

    /**
     * Симулирует опрыскивание инсектицидом (т.е. средством для уменьшения популяцию на заданный процент).
     */
    public void spray(double percent)
    {

        roachCount = roachCount - (int)(roachCount * percent / 100);
    }

    /**
     * И в итоге возвращает текущее количество тараканов.
     */
    public int getRoaches()
    {

        return roachCount;
    }
}

/**
 * Класс для симуляции популяции тараканов.
 */
class RoachSimulation
{
    public static void main(String[] args)
    {
        RoachPopulation population = new RoachPopulation(10);

        System.out.println("Начальная популяция: " + population.getRoaches() + " тараканов");

        // Первый цикл
        population.breed();
        System.out.println("После размножения: " + population.getRoaches() + " тараканов");
        population.spray(10);
        System.out.println("После опрыскивания на 10%: " + population.getRoaches() + " тараканов");

        // Второй цикл
        population.breed();
        System.out.println("\nПосле размножения: " + population.getRoaches() + " тараканов");
        population.spray(10);
        System.out.println("После опрыскивания на 10%: " + population.getRoaches() + " тараканов");

        // Третий цикл
        population.breed();
        System.out.println("\nПосле размножения: " + population.getRoaches() + " тараканов");
        population.spray(10);
        System.out.println("После опрыскивания на 10%: " + population.getRoaches() + " тараканов");

        // Четвёртый цикл
        population.breed();
        System.out.println("\nПосле размножения: " + population.getRoaches() + " тараканов");
        population.spray(10);
        System.out.println("После опрыскивания на 10%: " + population.getRoaches() + " тараканов");
    }
}
