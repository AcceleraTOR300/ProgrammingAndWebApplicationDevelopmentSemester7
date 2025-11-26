/**
 * Задание P3.12, в котором нужно класс должен симулировать избирательную машину для простых выборов.
 */
public class VotingMachine
{
    private int democratVotes;
    private int republicanVotes;

    /**
     * Конструктор создаёт машину с нулевыми голосами.
     */
    public VotingMachine()
    {
        democratVotes = 0;
        republicanVotes = 0;
    }

    /**
     * Очищает состояние машины (сбрасывает все голоса на ноль).
     */
    public void clear()
    {
        democratVotes = 0;
        republicanVotes = 0;
    }

    /**
     * Добавляет голос за демократа.
     */
    public void voteForDemocrat()

    {
        democratVotes = democratVotes + 1;
    }

    /**
     * Добавляет голос за республиканца.
     */
    public void voteForRepublican()
    {

        republicanVotes = republicanVotes + 1;
    }

    /**
     * Возвращает количество голосов за демократов
     */
    public int getDemocratVotes()
    {

        return democratVotes;
    }

    /**
     * Возвращает количество голосов за республиканцев.
     */
    public int getRepublicanVotes()
    {

        return republicanVotes;
    }
}

/**
 * Класс для тестирования избирательной машины.
 */
class VotingMachineTest
{
    public static void main(String[] args)
    {
        VotingMachine machine = new VotingMachine();

        System.out.println("=== Начало голосования ===");
        System.out.println("Голосов за демократов: " + machine.getDemocratVotes());
        System.out.println("Голосов за республиканцев: " + machine.getRepublicanVotes());

        // Первый раунд голосования
        System.out.println("\n=== Первый раунд ===");
        machine.voteForDemocrat();
        machine.voteForDemocrat();
        machine.voteForRepublican();

        System.out.println("Голосов за демократов: " + machine.getDemocratVotes());
        System.out.println("Голосов за республиканцев: " + machine.getRepublicanVotes());

        // Второй раунд голосования
        System.out.println("\n=== Второй раунд ===");
        machine.voteForRepublican();
        machine.voteForRepublican();
        machine.voteForDemocrat();

        System.out.println("Голосов за демократов: " + machine.getDemocratVotes());
        System.out.println("Голосов за республиканцев: " + machine.getRepublicanVotes());

        // Очистка машины
        System.out.println("\n=== Очистка машины ===");
        machine.clear();
        System.out.println("Голосов за демократов: " + machine.getDemocratVotes());
        System.out.println("Голосов за республиканцев: " + machine.getRepublicanVotes());

        // Новое голосование после очистки
        System.out.println("\n=== Новое голосование ===");
        machine.voteForDemocrat();
        machine.voteForRepublican();
        machine.voteForRepublican();
        machine.voteForRepublican();

        System.out.println("Голосов за демократов: " + machine.getDemocratVotes());
        System.out.println("Голосов за республиканцев: " + machine.getRepublicanVotes());
    }
}
