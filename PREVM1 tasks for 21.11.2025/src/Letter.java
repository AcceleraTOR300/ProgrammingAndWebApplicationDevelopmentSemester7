/**
 * Задание 15, класс, который участвует для написания простого письма.
 */
public class Letter {
    private String from;
    private String to;
    private String body;

    /**
     * Конструктор создаёт письмо с указанными отправителем и получателем.
     */
    public Letter(String sender, String recipient) {
        from = sender;
        to = recipient;
        body = "";
    }

    /**
     * Добавляет строку текста к телу письма.
     */
    public void addLine(String line) {

        body = body + line + "\n";
    }

    /**
     * Возвращает полное письмо в соответствии с шаблоном.
     */
    public String getText() {
        return "Dear " + to + ":\n" +
                "\n" +
                body +
                "\n" +
                "Sincerely,\n" +
                "\n" +
                from;
    }
}

/**
 * Класс для создания и печати письма.
 */
class LetterPrinter {
    public static void main(String[] args) {
        Letter letter = new Letter("Mary", "John");

        letter.addLine("I am sorry we must part.");
        letter.addLine("I wish you all the best.");

        System.out.println(letter.getText());
    }
}
