package world.keyi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 万一
 * @DATE 2022年04月06日15:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugInfo extends Base {
    private String keyword;

    private String classifyId;
}
