package ru.job4j.condition;
/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 02.08.2018
 */
public class DummyBot {

    //phrase one
    private String phraseone = "Привет, умник.";
    //phrase two
    private String phrasetwo = "До скорой встречи.";
    //any other phrase
    private String anyotherpgraze = "Это ставит меня в тупик. Спросите другой вопрос.";

    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String answ = this.anyotherpgraze;
        if (question.equals("Привет, Бот.")) {
            answ = this.phraseone;
        } else if (question.equals("Пока.")) {
            answ = this.phrasetwo;
        }
        return answ;
    }
}
