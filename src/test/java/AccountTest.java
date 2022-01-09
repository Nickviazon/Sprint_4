import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    @Parameterized.Parameter()
    public String accountName;

    @Parameterized.Parameter(1)
    public boolean expectedIsAccountNameValid;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"Karl Third", true}, // строка в диапазоне 3 <= x <= 19 (два слова с 1 пробелом)
                {"K T", true}, // 3 символа (буква пробел буква)
                {"KarlThird KarlThird", true}, // 19 символов (2 слова с 1 пробелом)
                {"KarlThird KarlThirdK", false}, // более 19 сомволов в стороке
                {"", false}, // пустая строка
                {" ", false}, // единичный пробел
                {"KarlThird", false}, // 1 слово без пробелов
                {"Karl  Third", false}, // два пробела между словами
                {" Karl Third", false}, // пробел вначале
                {"Karl Third ", false}, // пробел вконце
                {"Karl Third Karl", false}, // более 2 слов разделенных пробелами
                {"  KarlThird", false}, // пробел вместо первого слова
                {"KarlThird  ", false}, // пробел вместо второго слова
        };
    }

    @Test
    public void checkNameToEmbossMethodTest() {
        Account account = new Account(accountName);
        boolean actualIsAccountNameValid = account.checkNameToEmboss();

        assertEquals("Account.checkNameToEmboss() returns wrong result",
                expectedIsAccountNameValid, actualIsAccountNameValid);
    }
}