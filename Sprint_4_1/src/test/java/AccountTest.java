import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final String description;
    private final boolean result;

    public AccountTest(String name, String description, boolean result) {
        this.name = name;
        this.description = description;
        this.result = result;

    }

    @Parameterized.Parameters
    public static Object[][] getNameAndDescription() {
        return new Object[][]{
                {"Иван Иванов", "Валдиные данные владельца проходят проверку", true},
                {"О K", "Строка длиной 3 символа  пройдет проверку", true},
                {"123456789 123456789", "Строка длиной 19 символов не пройдет проверку", true},
                {"ИванИванов", "Данные без пробела между фамилией и именем не пройдут проверку", false},
                {" Иван Иванов", "Данные с пробелом в начале не пройдут проверку", false},
                {"Иван Иванов ", "Данные с пробелом в конце не пройдут проверку", false},
                {" ", "Строка без имени и фамилии с одним пробелом не пройдет проверку", false},
                {"", "Пустая строка не пройдет проверку", false},
                {"ОК", "Строка меньше 3 символов не пройдет проверку", false},
                {"123456789 1234567892", "Строка больше 19 символов не пройдет проверку", false},
                {null,"Не строка не пройдет проверку",false}

        };
    }

    @Test
    @DisplayName("Проверка ввода разных данных владельца карты.")
    public void test() {
        Account account = new Account(name);
        //Allure.addAttachment("Строка для проверки", name);
        Allure.addAttachment("Ожидаемый результат", description);
        MatcherAssert.assertThat(account.checkNameToEmboss(), is(result));
    }
}