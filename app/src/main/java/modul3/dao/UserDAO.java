package modul3.dao;

import modul3.entities.UserData;

public interface UserDAO{
    public int register(String username, String password, String fullname);
    public UserData login(String username, String password);
    public int update(int id, String fullname);
    public int update(int id, String password, String fullname);
    public int delete(int id);
}
