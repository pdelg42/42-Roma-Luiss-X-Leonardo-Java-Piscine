public interface UserList {

    void    addUser(User user);
    User    userById(int userId) throws UserNotFoundException;
    User    userByIndex(int indexId);
    int     numberOfUsers();
}
