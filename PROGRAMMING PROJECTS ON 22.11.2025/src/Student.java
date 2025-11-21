/**
 * Задание P3.8, класс, который типо представляет студента с его именем и оценками по тестам.
 * Использует пятибальную шкалу (1-5).
 */
public class Student
{
    private String name;
    private int totalScore;
    private int quizCount;

    /**
     * Конструктор создаёт студента с именем и нулевыми оценками.
     */
    public Student(String studentName)
    {
        name = studentName;
        totalScore = 0;
        quizCount = 0;
    }

    /**
     * Возвращает имя студента.
     */
    public String getName()
    {

        return name;
    }

    /**
     * Добавляет оценку по тесту (по пятибальной шкале: 1-5).
     */
    public void addQuiz(int score)
    {
        if (score >= 1 && score <= 5)
        {
            totalScore = totalScore + score;
            quizCount = quizCount + 1;
        }
        else
        {
            System.out.println("Ошибка: оценка должна быть от 1 до 5!");
        }
    }

    /**
     * Возвращает общую сумму всех оценок.
     */
    public int getTotalScore()
    {
        return totalScore;
    }

    /**
     * Возвращает среднюю оценку по всем тестам.
     */
    public double getAverageScore()
    {
        if (quizCount == 0)
        {
            return 0;
        }
        return (double) totalScore / quizCount;
    }
}

/**
 * Класс для тестирования класса Student (тут возникли проблемы, связанные обозначить класс public или нет на StudentTester.
 * Поэтому решил сделать вывод внутри файла, а не создвать дргуой файл, который будет вызывать этот метод, чтобы не создавать путаницу
 * при проверке.
 */
class StudentTester
{
    public static void main(String[] args)
    {
        Student student1 = new Student("Иван");

        System.out.println("Имя студента: " + student1.getName());

        student1.addQuiz(5);
        student1.addQuiz(4);
        student1.addQuiz(3);

        System.out.println("Общая сумма оценок: " + student1.getTotalScore());
        System.out.println("Средняя оценка: " + student1.getAverageScore());

        Student student2 = new Student("Мария");
        System.out.println("\nИмя студента: " + student2.getName());
        student2.addQuiz(5);
        student2.addQuiz(5);

        System.out.println("Общая сумма оценок: " + student2.getTotalScore());
        System.out.println("Средняя оценка: " + student2.getAverageScore());

        // Тест с неправильной оценкой
        System.out.println("\nТест с неправильной оценкой:");
        student1.addQuiz(10);
    }
}
