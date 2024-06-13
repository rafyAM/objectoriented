package modul3.models;

import java.sql.*;
import java.util.ArrayList;

import modul3.dao.FolderDAO;
import modul3.database.modul9.DBconnect9;
import modul3.entities.Folder;

public class FolderDaoSQLite implements FolderDAO {

    private Connection conn;

    public FolderDaoSQLite() throws SQLException {
        this.conn = DBconnect9.connect();
    }

    @Override
    public int createFolder(String foldername) {
        String query = "INSERT INTO folder (name) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, foldername);
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Folder> listAllFolders() {
        ArrayList<Folder> folders = new ArrayList<>();
        String query = "SELECT * FROM folder";
        try (PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Folder folder = new Folder(id, name);
                folders.add(folder);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving folders: " + e.getMessage());
            e.printStackTrace();
        }
        return folders;
    }

}
    
