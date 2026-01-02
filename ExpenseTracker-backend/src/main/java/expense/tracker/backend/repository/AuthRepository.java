package expense.tracker.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public boolean Emailexists(String email) {
        String sql = "SELECT COUNT(*) FROM Users WHERE email = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return count > 0;
    }

    public boolean Usernameexists(String username) {
        String sql = "SELECT COUNT(*) FROM Users WHERE username = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, username);
        return count > 0;
    }
    public void register(String name, String email, String username, String password, String phone, int active_yn) {
        String query = "INSERT INTO Users " + "(name, email, username, password, phone, active_yn) " + "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, name, email, username, password, phone, active_yn);
    }
}
