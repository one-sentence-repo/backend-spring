package one.sentence_spring.userinfo.dao;

import java.util.List;
import one.sentence_spring.userinfo.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

  private final static String SAVE_USER_SQL = "insert into user_info (id, username) values (?, ?)";
  private final static String FIND_USER_SQL = "select * from user_info where id = ?";
  private final static String FIND_ALL_USER_SQL = "select * from user_info";
  private JdbcTemplate jdbcTemplate;

  @Autowired
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void saveUser(String userName, String email) {
    jdbcTemplate.update(SAVE_USER_SQL, userName, email);
  }

  public List<UserInfo> findAll() {
    return jdbcTemplate.query(FIND_ALL_USER_SQL, new BeanPropertyRowMapper<>(UserInfo.class));
  }

  public UserInfo findById(int id) {
    return jdbcTemplate.queryForObject(FIND_USER_SQL, new BeanPropertyRowMapper<>(UserInfo.class),
        id);
  }
}
