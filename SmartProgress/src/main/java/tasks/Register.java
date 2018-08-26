package tasks;
import java.lang.*;
import org.apache.commons.lang3.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 25.08.2018
 */

public class Register {
	/**
	 * The method of converting a string to a regular register
	 * @param line - incoming line
	 * @return
	 */
	public String normalsRegister(String line) {
		String[] splitLine = line.split(" ");
		String result = "";
		Character[] tempCharArray;
		for (int i = 0; i < splitLine.length; i++) {
			tempCharArray = ArrayUtils.toObject(splitLine[i].toCharArray());
			for (int j = 0; j < tempCharArray.length; j++) {
				if (j == 0 ) {
					result += Character.toUpperCase(tempCharArray[j]);
				} else {
					result += Character.toLowerCase(tempCharArray[j]);
				}
			}
			if (i != splitLine.length-1) {
				result += " ";
			}
		}
		return result;
	}
}
