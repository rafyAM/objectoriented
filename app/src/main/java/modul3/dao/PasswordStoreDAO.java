package modul3.dao;
import modul3.entities.PasswordStores;
import modul3.entities.UserData;
import java.util.*;

public interface PasswordStoreDAO {
    int addPassword(PasswordStores newPassword, UserData user);

    ArrayList<PasswordStores> listPassword(UserData user);

    ArrayList<PasswordStores> findPassword(String name, UserData user);

    int updatePass(PasswordStores changedPass);

    int deletePass(PasswordStores deletedPass);
}
