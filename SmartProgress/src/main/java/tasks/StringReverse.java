package tasks;
import org.apache.commons.lang3.*;
/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 25.08.2018
 */

public class StringReverse {
    public String[] sentenceReserve(String[] lines) {
        String[] result = new String[lines.length];
        for (int j = 0; j < lines.length; j++) {
            result[j] = "";
            Character[] tempArray = ArrayUtils.toObject(lines[j].toCharArray());
            int lastCount = tempArray.length - 1;
            int sizeTempArray = tempArray[0].equals(' ') ? tempArray.length - 1 : tempArray.length;
            for (int i = 0; i < sizeTempArray; i++) {
                Character[] resultTemp = new Character[sizeTempArray];
                resultTemp[i] = tempArray[lastCount--];
                if (i == 0) {
                    result[j] += Character.toUpperCase(resultTemp[i]);
                } else {
                    result[j] += Character.toLowerCase(resultTemp[i]);
                }
            }
        }
        return result;
    }


    public String reverseLine(String inLine) {
        String result = "";
        String[] splitLine = inLine.split("\\.");
        String[] stroka = this.sentenceReserve(splitLine);
        for (int i = 0; i < stroka.length; i++) {
            if (i ==0) {
                result += stroka[i] + ". ";
            } else {
                result += stroka[i] + ".";
            }
        }
        return result;
    }
}
