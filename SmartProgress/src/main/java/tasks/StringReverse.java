package tasks;
import org.apache.commons.lang3.*;
/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 26.08.2018
 */

public class StringReverse {
    /**
     * Метод упорядочивает символы массива строк в обратном направлении используя дополнительный
     * массив. В случае когда еще в первом элементе неупорядоченного массива есть " ", то
     * сокрщаем размер дпополнителдьного массива, что бы в конце массива не дописывать " ".
     * @param lines - массив строк которые изначально были разделены смиволом "."
     * @return - обратно упорядоченный массив с правильным регистром.
     */
    public String[] sentenceReserve(String[] lines) {
        String[] result = new String[lines.length];
        for (int j = 0; j < lines.length; j++) {
            result[j] = "";
            Character[] tempArray = ArrayUtils.toObject(lines[j].toCharArray());
            int lastCount = tempArray.length - 1;
            int sizeTempArray = tempArray[0].equals(' ') ? tempArray.length - 1 : tempArray.length;
            for (int i = 0; i < sizeTempArray; i++) {
                Character[] temp = new Character[sizeTempArray];
                temp[i] = tempArray[lastCount--];
                if (i == 0) {
                    result[j] += Character.toUpperCase(temp[i]);
                } else {
                    result[j] += Character.toLowerCase(temp[i]);
                }
            }
        }
        return result;
    }
    /**
     * Метод передает массив string в каждом из которых содержатся предложения,
     * метод sentenceReserve возвращает обратно упорядоченный массив. После чего
     * дописываем символы ". " если строка не последняя, в ином случае добавим "." .
     * @param inLine - входящая строка
     * @return
     */
    public String reverseLine(String inLine) {
        String result = "";
        String[] lines = this.sentenceReserve(inLine.split("\\."));
        for (int i = 0; i < lines.length; i++) {
            if (i == lines.length-1) {
                result += lines[i] + ".";
            } else {
                result += lines[i] + ". ";
            }
        }
        return result;
    }
}
