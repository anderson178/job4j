package tasks;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 26.08.2018
 */
public class StringReverseTest {
    @Test
    public  void reserveLine() {
        String temp = "мАма мЫЛА рАму. маШа игрАла в мЯч.";
        StringReverse reserve= new StringReverse();
        String result = reserve.reverseLine(temp);
        assertThat(result, is ("Умар алым амам. Чям в аларги ашам."));
    }
}
