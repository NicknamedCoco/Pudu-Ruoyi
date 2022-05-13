package world.keyi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 万一
 * @DATE 2022年03月17日21:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherInfo {
    private Integer highest;
    private Integer lowest;
    private String date;
}
