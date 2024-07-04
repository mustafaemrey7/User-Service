public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        // Kullanıcı Ekleme
        userDao.addUser("newuser", "password123", "newuser@example.com", true, true, true, true, true);
        userDao.addUser("user1", "password1", "user1@example.com", true, false, true, true, false);
        userDao.addUser("user2", "password2", "user2@example.com", false, true, true, false, true);
        userDao.addUser("user3", "password3", "user3@example.com", true, true, false, true, false);
        userDao.addUser("user4", "password4", "user4@example.com", false, false, true, true, true);
        userDao.addUser("user5", "password5", "user5@example.com", true, true, false, false, true);
        userDao.addUser("user6", "password6", "user6@example.com", false, true, true, true, false);
        userDao.addUser("user7", "password7", "user7@example.com", true, false, true, true, true);
        userDao.addUser("user8", "password8", "user8@example.com", false, true, false, true, false);
        userDao.addUser("user9", "password9", "user9@example.com", true, true, true, false, true);
        userDao.addUser("user10", "password10", "user10@example.com", false, false, true, true, false);

        // Kullanıcı Silme
        userDao.deleteUser(1);

        // Kullanıcı Güncelleme
        userDao.updateUser(1, "updateduser", "updateduser@example.com");

        // Kullanıcıyı Görme
        userDao.getUserById(1);

        // Tüm Kullanıcıları Görme
        userDao.getAllUsers();
    }
}
