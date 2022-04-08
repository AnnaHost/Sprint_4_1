public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    /*
     Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
     Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
 */
    public boolean checkNameToEmboss() {
        /*К сожалению совсем не изучала регэкспы, потрачу на это много времени*/
        if (name != null && name.length() >= 3 && name.length() <= 19 && countSpace() == 1 && !name.startsWith(" ") && !name.endsWith(" ") ) {
            return true;
        } else {
            return false;
        }

    }

    private int countSpace() {
        int count = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }

}
