public class UserArrayList implements UserList {

    public User[] _usersArray = new User[10];

    private void resizeUsersArray(User[] usersArray) {

        int len = usersArray.length;
        int newLen = len + len/2;
        User[] tempArray = new User[newLen];

        for (int i = 0; i < usersArray.length; i++) {
            tempArray[i] = _usersArray[i];
        }
        _usersArray = tempArray;
    }

    @Override
    public void addUser(User user) {

        int i = -1;
        int temp = 0;

        while (_usersArray[++i] != null) {
            temp = i;
            if (temp + 1 == _usersArray.length) {
                resizeUsersArray(_usersArray);
                i++;
                break ;
            }
        };
        _usersArray[i] = user;
        for (User u: _usersArray) {
            System.out.println(u);
        }
    }

    @Override
    public User userById(int userId) throws UserNotFoundException {

        for(int i = 0; i < _usersArray.length; i++) {
            if (_usersArray[i] != null && userId == _usersArray[i].getIdentifier()) {
                return _usersArray[i];
            }
        }
        throw new UserNotFoundException("User not in archive.");
    }
    @Override
    public User userByIndex(int index) {

        if (index > _usersArray.length) {
            return null;
        }
        return _usersArray[index];
    }

    @Override
    public int numberOfUsers() {

        int i = 0;

        while (_usersArray[i] != null) {
            i++;
        };

        return i;
    }
}
