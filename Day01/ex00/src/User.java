import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private UUID    _identifier;
    private String  _name;
    private int     _balance;

    public User(String name, int balance) {
        if (this.nameConvalidation(name) && (balance > -1 && balance <= Integer.MAX_VALUE) && name.length() < 30) {
            this._identifier = UUID.randomUUID();
            this._name = name;
            this._balance = balance;
        } else {
            System.out.println("Fail to create user: input error.");
        }
    };

    private boolean nameConvalidation(String userName) {
        String  _pattern = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(_pattern);
        Matcher matcher = pattern.matcher(userName);

        return matcher.matches();
    }
    public UUID getIdentifier() {
        return this._identifier;
    }

    public String getName() {
        return this._name;
    }

    public Integer getBalance() {
        return this._balance;
    }

    public int addBalance(int amount) {
        return this._balance += amount;
    }

    public int lessBalance(int amount) {
        return this._balance -= amount;
    }
}
