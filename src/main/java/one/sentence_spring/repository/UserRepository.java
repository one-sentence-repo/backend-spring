package one.sentence_spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import one.sentence_spring.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  private final JdbcTemplate jdbcTemplate;

  public UserRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void saveUser(User user) {
    String sql = "insert into user(username, password) values(?, ?)";
    jdbcTemplate.update(sql, user);
  }

  public List<User> findAll() {
    String sql = "select * from user";
    return jdbcTemplate.query(sql, new UserRowMapper());
  }

  public User findById(Long id) {
    String sql = "select * from user where id = ?";
    return jdbcTemplate.query(sql, new Object[]{id}, new UserRowMapper())
        .stream()
        .findFirst()
        .orElse(null);
  }

  private static class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      User user = new User();
      user.setId(rs.getLong("id"));
      user.setUserName(rs.getString("username"));
      user.setAge(rs.getInt("age"));
      return user;
    }
  }
}
