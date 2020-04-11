package excelexport;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by kimvra on 2020/4/11
 */
@Data
@AllArgsConstructor
public class StudentEntity implements Serializable {

    private String id;

    @Excel(name = "学生姓名")
    private String name;

    @Excel(name = "学生性别", replace = {"男_1", "女_2"}, suffix = "生")
    private int sex;

    @Excel(name = "成绩", type = 10)
    private String grade;
}
