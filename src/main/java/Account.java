public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        boolean isValidName = false;
        if (name != null) {
            isValidName = name.matches("^\\S+\\s\\S+$(?<=^.{3,19}$)");
        }
        return isValidName;
    }
}