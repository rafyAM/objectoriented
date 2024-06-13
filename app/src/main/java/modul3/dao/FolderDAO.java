package modul3.dao;

import java.util.*;
import modul3.entities.Folder;

public interface FolderDAO {
    public int createFolder(String forldername);
    public ArrayList<Folder> listAllFolders();
}