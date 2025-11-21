/**
 * Задание P3.3,симулятор микроволновой печки.
 */
public class Microwave
{
    private int timeSeconds;
    private int powerLevel;

    /**
     * Конструктор создаёт микроволновую печь с нулевым временем и уровнем мощности 1.
     */
    public Microwave()
    {
        timeSeconds = 0;
        powerLevel = 1;
    }

    /**
     * Увеличивает время приготовления на 30 секунд.
     */
    public void addTime()
    {

        timeSeconds = timeSeconds + 30;
    }

    /**
     * Переключает уровень мощности между 1 и 2.
     */
    public void switchPowerLevel()
    {
        if (powerLevel == 1)
        {
            powerLevel = 2;
        }
        else
        {
            powerLevel = 1;
        }
    }

    /**
     * Сбрасывает время и уровень мощности.
     */
    public void reset()
    {
        timeSeconds = 0;
        powerLevel = 1;
    }

    /**
     * Запускает микроволновую печь и выводит сообщение о приготовлении.
     */
    public void start()
    {

        System.out.println("Готовилось за " + timeSeconds + " секунд на уровне " + powerLevel);
    }

    /**
     * Главный метод для вывода результата класса Microwave.
     */
    public void main(String[] args)
    {
        Microwave microwave = new Microwave();

        microwave.addTime();
        microwave.addTime();
        System.out.println("Время: " + timeSeconds + " секунд");

        microwave.switchPowerLevel();
        System.out.println("Уровень мощности: " + microwave.powerLevel);

        microwave.start();

        microwave.reset();
        System.out.println("После сброса - Время: " + timeSeconds + ", Уровень: " + microwave.powerLevel);

        microwave.addTime();
        microwave.start();
    }
}

