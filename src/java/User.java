
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

    String username;
    String password;
    int accessLevel;

    public User(String username, String password, int accessLevel) {
        this.username = username;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public static User getUser(String username, String password) {

        try {
            DB.getConnection();
            PreparedStatement st;
            ResultSet rs;
            // Creating a select query to check if the username and password is in the database.
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            st = DB.connection.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            rs = st.executeQuery();
            while (rs.next()) {
                String dbUser = rs.getString("username");
                String dbPass = rs.getString("password");
                int dbAccessLevel = rs.getInt("access_level");

                return new User(dbUser, dbPass, dbAccessLevel);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
