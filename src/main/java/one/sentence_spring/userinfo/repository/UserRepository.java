package one.sentence_spring.userinfo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import one.sentence_spring.userinfo.dto.AddUserRequest;
import one.sentence_spring.userinfo.entity.UserInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  private final JdbcTemplate jdbcTemplate;

  public UserRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void saveUser(AddUserRequest request) {
    String sql = "insert into user_info(username, email) values(?, ?)";
    jdbcTemplate.update(sql, request.username(), request.email());
  }

  public List<UserInfo> findAll() {
    String sql = "select * from user_info";
    return jdbcTemplate.query(sql, new UserRowMapper());
  }

  public UserInfo findById(Long id) {
    String sql = "select * from user_info where id = ?";
    return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
  }

  private static class UserRowMapper implements RowMapper<UserInfo> {

    @Override
    public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
      UserInfo user = new UserInfo();
      user.setUser_name(rs.getString("username"));
      user.setEmail(rs.getString("email"));
      return user;
    }
  }
}
