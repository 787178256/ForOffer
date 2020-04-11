package excelexport;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by kimvra on 2020/4/11
 */
public class Main {
    public static void main(String[] args) throws Exception{
//        StudentEntity studentEntity = new StudentEntity("1", "kimvra", 1, "90");
//        StudentEntity studentEntity1 = new StudentEntity("2", "kok", 2, "80");
//        List<StudentEntity> studentEntities = Lists.newArrayList(studentEntity);
//        List<StudentEntity> studentEntities1 = Lists.newArrayList(studentEntity1);
//        TeacherEntity teacherEntity = new TeacherEntity("1", "math_teacher");
//        TeacherEntity teacherEntity1 = new TeacherEntity("2","science_teacher");
//        CourseEntity courseEntity = new CourseEntity("1", "综合", teacherEntity, studentEntities);
//        CourseEntity courseEntity1 = new CourseEntity("2", "综合1", teacherEntity1, studentEntities1);
//        List<CourseEntity> courseEntities = Lists.newArrayList(courseEntity, courseEntity1);
//        ExportParams exportParams = new ExportParams("class","学生");
//        exportParams.setHeight((short) 40);
//        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, CourseEntity.class, courseEntities);
//        File targetFile = new File("class11.xls");
//        FileOutputStream fos = new FileOutputStream(targetFile);
//        workbook.write(fos);
//        fos.close();
//
//        ExcelExportEntity excelExportEntity = new ExcelExportEntity()
        test();
    }

    public static void test() throws Exception{

            List<ExcelExportEntity> entities;
            ExcelExportEntity excelExportEntity = new ExcelExportEntity("学生姓名", "name");
            ExcelExportEntity excelExportEntity1 = new ExcelExportEntity("学生性别", "sex");
            ExcelExportEntity excelExportEntity2 = new ExcelExportEntity("学生成绩", "grade");
            excelExportEntity2.setType(10);
            entities = Lists.newArrayList(excelExportEntity, excelExportEntity1, excelExportEntity2);

            ExcelExportEntity student = new ExcelExportEntity("学生", "stu");
            student.setList(entities);

            ExcelExportEntity excelExportEntity3 = new ExcelExportEntity("学生姓名2", "name2");
            ExcelExportEntity excelExportEntity4 = new ExcelExportEntity("学生性别2", "sex2");
            ExcelExportEntity excelExportEntity5 = new ExcelExportEntity("学生成绩2", "grade2");
            ExcelExportEntity student2 = new ExcelExportEntity("学生2", "stu2");
            student2.setList(Lists.newArrayList(excelExportEntity3, excelExportEntity4, excelExportEntity5));

            ExcelExportEntity course = new ExcelExportEntity("课程", "course");
            course.setNeedMerge(true);

            ExcelExportEntity teacher = new ExcelExportEntity("老师", "teacher");
            teacher.setNeedMerge(true);

            List<ExcelExportEntity> all = Lists.newArrayList(course, teacher, student, student2);

            List<Map<String, Object>> list = Lists.newArrayList();
            Map<String, Object> data = Maps.newHashMap();
            data.put("course","综合");
            data.put("teacher", "数学老师");

            List<Map<String, Object>> stuList = Lists.newArrayList();
            Map<String, Object> stuMap = Maps.newHashMap();
            stuMap.put("name", "kimvra");
            stuMap.put("sex", "1");
            stuMap.put("grade", "100");
            stuList.add(stuMap);
            data.put("stu", stuList);

            List<Map<String, Object>> stuList2 = Lists.newArrayList();
            Map<String, Object> stuMap2 = Maps.newHashMap();
            stuMap2.put("name2", "kimvra");
            stuMap2.put("sex2", "1");
            stuMap2.put("grade2", "100");
            stuList2.add(stuMap2);
            data.put("stu2", stuList2);


            list.add(data);

            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("class", "class"), all, list);



            File targetFile = new File("class20.xls");
            FileOutputStream fos = new FileOutputStream(targetFile);
            workbook.write(fos);
            fos.close();





//            List<ExcelExportEntity> entity = new ArrayList<>();
////构造对象等同于@Excel
//            ExcelExportEntity excelentity = new ExcelExportEntity("姓名", "name");
//            excelentity.setNeedMerge(true);
//            entity.add(excelentity);
//
//            entity.add(new ExcelExportEntity("性别", "sex"));
//
//            excelentity = new ExcelExportEntity(null, "students");
//            List<ExcelExportEntity> temp = new ArrayList<ExcelExportEntity>();
//            temp.add(new ExcelExportEntity("姓名", "name"));
//            temp.add(new ExcelExportEntity("性别", "sex"));
//
////构造List等同于@ExcelCollection
//            excelentity.setList(temp);
//
//            entity.add(excelentity);
//            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
////把我们构造好的bean对象放到params就可以了
//            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("测试", "测试"), entity,
//                    list);
//            FileOutputStream fos = new FileOutputStream("ExcelExportForMap.tt.xls");
//            workbook.write(fos);
//            fos.close();

    }
}
