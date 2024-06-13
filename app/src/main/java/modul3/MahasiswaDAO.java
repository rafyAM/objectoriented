package modul3;

import java.util.*;
import modul3.models.Mahasiswa;

public interface MahasiswaDAO {
    void insert(Mahasiswa mahasiswa);
    Mahasiswa selectByNim(String nim);
    List<Mahasiswa> selectAll();
    void update(Mahasiswa mahasiswa);
    void delete(String nim);
}
