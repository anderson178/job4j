package ru.job4j.condition;
/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 02.08.2018
 */
public class DummyBot {

    private String phraseone = "Привет, умник.";
    private String phrasetwo = "До скорой встречи.";
    private String any = "Это ставит меня в тупик. Спросите другой вопрос.";

    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String result = this.any;
        if (question.equals("Привет, Бот.")) {
            result = this.phraseone;
        } else if (question.equals("Пока.")) {
            result = this.phrasetwo;
        }
        return result;
    }
}
