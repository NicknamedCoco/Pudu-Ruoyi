package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 万一
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysQuestions implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;             //主键Id
    private String title;           //问题/回复
    private Integer parentId;       //问题id
    private Integer doctorId;       //医生Id
    private Integer patientId;     //问题所属患者id

    private Date createTime;        //创建时间

    private Date modifyTime;        //修改时间


    /**
     * 患者姓名
     */

    private String patientName;

    /**
     * 患者性别
     */

    private Integer ssex;

    /**
     * 患者生日
     */

    private Date birthday;

    /**
     *  回复内容
     */

    private String reply;

    /**
     * 回复时间，HH表示24小时进制,hh表示12小时进制
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date replyTime;

    /**
     * 回复医生姓名
     */

    private String replyName;


    private List<SysQuestions> questions;


}
