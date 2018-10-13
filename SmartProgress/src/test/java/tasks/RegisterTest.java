package tasks;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 25.08.2018
 */

public class RegisterTest {
    @Test
    public  void normalRegisterWhenLine() {
        String temp = "ИвАНОВ иВАн иВАНоВич";
        Register register = new Register();
        String result = register.normalsRegister(temp);
        assertThat(result, is("Иванов Иван Иванович"));
    }
}
