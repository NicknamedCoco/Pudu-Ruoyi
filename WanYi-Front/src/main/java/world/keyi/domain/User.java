package world.keyi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 万一
 * @DATE 2022年04月03日20:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;
    private String nickName;
    private String avatar;
    private String sex;
    private String mobilePhone;
    private String brief;
    private String userDept;
    private String userPost;
}
