package world.keyi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 万一
 * @DATE 2022年04月06日15:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Base {
    private Integer pageSize;
    private Integer pageNum;
}
