package modul3.models;

import modul3.Encryptor;

public class PasswordStore {
   public String name, username;
   private String password, hashkey;
   private double score;
   private int category;
   public static final int UNCATEROGIZED = 0;
   public static final int CAT_MOBILEAPP = 1;
   public static final int CAT_WEBAPP = 2;
   public static final int CAT_DESKTOPAPP = 3;
   public static final int CAT_OTHER = 4;

   public PasswordStore(String name, String username, String plainPass, int category) {
    try {
        this.hashkey = Encryptor.generateKey();
        this.name = name;
        this.username = username;
        setPassword(plainPass);
        setCategory(category);
    } catch (Exception e) {
        // TODO: handle exception
    }
   }

   public PasswordStore(String name, String username, String plainPass) {
    try {
        this.hashkey = Encryptor.generateKey();
        this.name = name;
        this.username = username;
        setPassword(plainPass);
        setCategory(UNCATEROGIZED);
    } catch (Exception e) {
        e.printStackTrace();
    }
   }

   public void setPassword(String plainPass) {
    try {
        this.password = Encryptor.encrypt(plainPass, this.hashkey);
        calculateScore(plainPass);
    } catch (Exception e) {
        e.printStackTrace();
    }
   }

   public String getPassword() {
    try {
        return Encryptor.decrypt(this.password, this.hashkey);
    } catch (Exception e) {
       e.printStackTrace();
       return null;
    }
   }

   public void setCategory(int category) {
        if (category >= 0 && category <= 4) {
            this.category = category;
        } else {
            this.category = 0;
        }
    }

    public String getCategory() {
        switch (this.category) {
            case 0:
                return "Belum terkategori";
            case 1:
                return "mobile application";
            case 2:
                return "web application";
            case 3:
                return "desktop application";
            case 4:
                return "other account";
            default:
                return "Belum terkategori";
        }
    }

    private void calculateScore(String plainPass) {
        if (plainPass.length() > 15) {
            this.score = 10;
        } else {
            this.score = (plainPass.length() / 15.0) * 10;
        }
    }

    @Override
    public String toString() {
        return "Username: " + this.username + "\nPassword (encrypted): " + this.password + "\nHashkey: " + this.hashkey
                + "\nKategori: " + this.getCategory() + "\nScore: " + this.score;
    }
}
