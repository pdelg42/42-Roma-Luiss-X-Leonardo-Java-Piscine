
public class UserIdsGenerator {

    private static  UserIdsGenerator    _id;
    private int                         _lastIdGenerated = 0;

    private UserIdsGenerator() {};

    public static UserIdsGenerator getId() {
        if (_id == null) {
            _id = new UserIdsGenerator();
        }
        return _id;
    }

    public int generateId() {
        return _lastIdGenerated++;
    }

    public int getLastGeneratedId() {
        return this._lastIdGenerated;
    }
}