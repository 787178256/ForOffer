package excelexport;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kimvra on 2020/4/11
 */
@Data
@AllArgsConstructor
@ExcelTarget("courseEntity")
public class CourseEntity implements Serializable {

    private String id;

    @Excel(name = "课程名称", needMerge = true)
    private String name;

    @ExcelEntity
    private TeacherEntity teacherEntity;

    @ExcelCollection(name = "学生")
    private List<StudentEntity> studentEntities;
//    @ExcelEntity(name = "学生")
//    private StudentEntity studentEntity;
}
