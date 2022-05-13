package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 万一
 * @DATE 2022年04月28日15:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRegistration {
    private static final long serialVersionUID = 1L;


    private Integer id;             //主键id
    private String number;          //唯一编号
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;              //预约时间，默认为当前时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;        //挂号时间
    private Integer doctorId;       //挂号医生
    private Integer patientsId;     //挂号患者Id
    private Integer status;         //0:未处理，1已处理
    private String evaluate;        //满意，一般，不满意
    private Integer accept;         //状态，1为采纳，2为不采纳
    private BigDecimal amountPayable;   //金额
    private String type;            //结算类型
    private String level;           //挂号级别
    private Boolean isInvoice;      //是否开票
    private String invoiceCode;     //发票代码
    private String invoiceNumber;   //发票号


    /**
     * LocalDate对应的是yyyy-MM-dd
     * LocalDateTime对应的是yyyy-MM-dd HH:mm:ss
     */

    private LocalDate invoiceDate;       //开票日期

    /**
     * 科室部门Id
     */
    private Integer depId;

    /**
     * 挂号患者姓名
     */
    private String patientName;

    /**
     * 挂号患者性别
     */
    private Integer ssex;

    /**
     * 挂号患者生日
     */
    private Date birthday;

    /**
     * 挂号医生姓名
     */
    private String doctorName;

    /**
     * 挂号患者年龄
     */
    private Integer age;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
        this.setAge(getCurrentAge(birthday));
    }

    public static int getCurrentAge(Date birthday) {
        // 当前时间
        Calendar curr = Calendar.getInstance();
        // 生日
        Calendar born = Calendar.getInstance();
        born.setTime(birthday);
        // 年龄 = 当前年 - 出生年
        int age = curr.get(Calendar.YEAR) - born.get(Calendar.YEAR);
        if (age <= 0) {
            return 0;
        }
        // 如果当前月份小于出生月份: age-1
        // 如果当前月份等于出生月份, 且当前日小于出生日: age-1
        int currMonth = curr.get(Calendar.MONTH);
        int currDay = curr.get(Calendar.DAY_OF_MONTH);
        int bornMonth = born.get(Calendar.MONTH);
        int bornDay = born.get(Calendar.DAY_OF_MONTH);
        if ((currMonth < bornMonth) || (currMonth == bornMonth && currDay <= bornDay)) {
            age--;
        }
        return age < 0 ? 0 : age;
    }
}
