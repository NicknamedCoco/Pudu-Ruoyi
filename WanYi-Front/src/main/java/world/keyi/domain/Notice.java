package world.keyi.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 万一
 * @DATE 2022年04月04日17:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    private String id;
    private String title;
    private String text;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date time;

    /*文章作者*/
    private String createBy;
    /*文章url*/
    private String url;
}
