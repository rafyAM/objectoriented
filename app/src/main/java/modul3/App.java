/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package modul3;

import java.util.ArrayList;
import java.util.List;

import modul3.GUI.MahasiswaGUI;
import modul3.components.input.Input;
import modul3.components.input.Listpasswordpage;
import modul3.components.input.Selectinput;
import modul3.components.output.Hline;
import modul3.components.output.Label;
import modul3.components.output.Space;
import modul3.database.modul9.DBsetup9;
import modul3.entities.Folder;
import modul3.entities.PasswordStores;
import modul3.entities.UserData;
import modul3.models.DataPassword;
import modul3.models.FolderDaoSQLite;
import modul3.models.Mahasiswa;
import modul3.models.PasswordStore;
import modul3.models.PasswordStoreDaoSQLite;
import modul3.models.UserDaoSQLite;
import modul3.pages.Inputpage;
import modul3.pages.Mainpage;

import java.awt.EventQueue;
import java.util.ArrayList;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        try {
            DBsetup9.createTable();

                        UserDaoSQLite userDao = new UserDaoSQLite();
                        FolderDaoSQLite folderDao = new FolderDaoSQLite();
                        PasswordStoreDaoSQLite passwordStoreDao = new PasswordStoreDaoSQLite();

                        // Add 2 users
                        int user1Id = userDao.register("user1", "password1", "User One");
                        int user2Id = userDao.register("user2", "password2", "User Two");

                        // Add 4 folders
                        folderDao.createFolder("Folder 1");
                        folderDao.createFolder("Folder 2");
                        folderDao.createFolder("Folder 3");
                        folderDao.createFolder("Folder 4");

                        ArrayList<Folder> folders = folderDao.listAllFolders();

                        // Get user data for user1
                        UserData user1 = userDao.login("user1", "password1");

                        // Add 5 passwords for user1
                        passwordStoreDao.addPassword(new PasswordStores("Account 1", "username1", "password1",
                                        PasswordStores.CAT_WEBAPP, folders.get(0)), user1);
                        passwordStoreDao.addPassword(new PasswordStores("Account 2", "username2", "password2",
                                        PasswordStores.CAT_MOBILEAPP, folders.get(1)), user1);
                        passwordStoreDao.addPassword(new PasswordStores("Account 3", "username3", "password3",
                                        PasswordStores.CAT_OTHER, folders.get(2)), user1);
                        passwordStoreDao.addPassword(new PasswordStores("Account 4", "username4", "password4",
                                        PasswordStores.UNCATEGORIZED, folders.get(3)), user1);
                        passwordStoreDao.addPassword(new PasswordStores("Account 5", "username5", "password5",
                                        PasswordStores.CAT_WEBAPP, null), user1);
                        ArrayList<PasswordStores> userPasswords = passwordStoreDao.listPassword(user1);
                        System.out.println("Password data for " + user1.fullname + ":");
                        for (PasswordStores password : userPasswords) {
                                System.out.println("Account Name: " + password.name);
                                System.out.println("Username: " + password.username);
                                System.out.println("Category: " + password.getCategory());
                                System.out.println("Folder: "
                                                + (password.folder != null ? password.folder.name : "No folder"));
                                System.out.println();
                        }
            // DataPassword.loadCSVData();
            // Mainpage mainPage = new Mainpage(80);
            // mainPage.draw();
            // DataPassword.saveCSVData();

            // Menampilkan Data Mahasiswa
            // ArrayList<Mahasiswa> mahasiswaList = Loader.csvMhsLoad();
            // MahasiswaApp app = new MahasiswaApp();
            // System.out.println("Sorted by name:");
            // List<Mahasiswa> sortedByName = app.sort(1);
            // sortedByName.forEach(System.out::println);

            // // GUI data Mahasiswa
            // ArrayList<Mahasiswa> dataMhs = Loader.csvMhsLoad();
            // MahasiswaGUI gui = new MahasiswaGUI(dataMhs);
            // EventQueue.invokeLater(() -> gui.setVisible(true));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
