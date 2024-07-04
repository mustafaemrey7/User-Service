import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    // Kullanıcı Ekleme
    public void addUser(String username, String password, String email, boolean canAddUser, boolean canDeleteUser, boolean canUpdateUser, boolean canViewUser, boolean canViewAllUsers) {
        String sql = "INSERT INTO \"peoples\" (username, password, email, can_add_user, can_delete_user, can_update_user, can_view_user, can_view_all_users) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.setBoolean(4, canAddUser);
            statement.setBoolean(5, canDeleteUser);
            statement.setBoolean(6, canUpdateUser);
            statement.setBoolean(7, canViewUser);
            statement.setBoolean(8, canViewAllUsers);

            statement.executeUpdate();

            System.out.println("User added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Kullanıcı Silme
    public void deleteUser(int userId) {
        String sql = "DELETE FROM \"peoples\" WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("No user found with ID: " + userId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Kullanıcı Güncelleme
    public void updateUser(int userId, String newUsername, String newEmail) {
        String sql = "UPDATE \"peoples\" SET username = ?, email = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newUsername);
            statement.setString(2, newEmail);
            statement.setInt(3, userId);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("No user found with ID: " + userId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Kullanıcıyı Görme
    public void getUserById(int userId) {
        String sql = "SELECT * FROM \"peoples\" WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Can Add User: " + resultSet.getBoolean("can_add_user"));
                System.out.println("Can Delete User: " + resultSet.getBoolean("can_delete_user"));
                System.out.println("Can Update User: " + resultSet.getBoolean("can_update_user"));
                System.out.println("Can View User: " + resultSet.getBoolean("can_view_user"));
                System.out.println("Can View All Users: " + resultSet.getBoolean("can_view_all_users"));
            } else {
                System.out.println("No user found with ID: " + userId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Tüm Kullanıcıları Görme
    public void getAllUsers() {
        String sql = "SELECT * FROM \"peoples\"";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Can Add User: " + resultSet.getBoolean("can_add_user"));
                System.out.println("Can Delete User: " + resultSet.getBoolean("can_delete_user"));
                System.out.println("Can Update User: " + resultSet.getBoolean("can_update_user"));
                System.out.println("Can View User: " + resultSet.getBoolean("can_view_user"));
                System.out.println("Can View All Users: " + resultSet.getBoolean("can_view_all_users"));
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
