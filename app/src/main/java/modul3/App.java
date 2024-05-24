/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package modul3;

import java.util.ArrayList;
import java.util.List;

import modul3.GUI.MahasiswaGUI;
import modul3.Input;
import modul3.Listpasswordpage;
import modul3.Selectinput;
import modul3.Hline;
import modul3.Label;
import modul3.Space;
import modul3.models.DataPassword;
import modul3.models.Mahasiswa;
import modul3.models.PasswordStore;
import modul3.Inputpage;
import modul3.Mainpage;

import java.awt.EventQueue;
import java.util.ArrayList;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        try {
            // DataPassword.loadCSVData();
            // Mainpage mainPage = new Mainpage(80);
            // mainPage.draw();
            // DataPassword.saveCSVData();

            // Menampilkan Data Mahasiswa
            ArrayList<Mahasiswa> mahasiswaList = Loader.csvMhsLoad();
            MahasiswaApp app = new MahasiswaApp();
            System.out.println("Sorted by name:");
            List<Mahasiswa> sortedByName = app.sort(1);
            sortedByName.forEach(System.out::println);

            // GUI data Mahasiswa
            ArrayList<Mahasiswa> dataMhs = Loader.csvMhsLoad();
            MahasiswaGUI gui = new MahasiswaGUI(dataMhs);
            EventQueue.invokeLater(() -> gui.setVisible(true));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
