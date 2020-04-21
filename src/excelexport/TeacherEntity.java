package excelexport;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by kimvra on 2020/4/11
 */
@Data
@AllArgsConstructor
public class TeacherEntity implements Serializable {
    private String id;

    @Excel(name = "老师", needMerge = true, width = 40, mergeVertical = true)
    private String name;
}
