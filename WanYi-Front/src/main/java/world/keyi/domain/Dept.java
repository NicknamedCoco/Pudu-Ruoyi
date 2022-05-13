package world.keyi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author 万一
 * @DATE 2022年04月03日20:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private String deptName;
    private String deptId;
    private String describe;
    private ArrayList<User> members;
}
