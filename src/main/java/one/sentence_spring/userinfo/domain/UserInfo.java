package one.sentence_spring.userinfo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {

  private int id;

  private String userName;

  private String avatarUrl;

  private String email;

  private String aboutMe;

}
