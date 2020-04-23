package excelexport;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import cn.afterturn.easypoi.handler.inter.IExcelDataHandler;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by kimvra on 2020/4/11
 */
public class Main {
    public static void main(String[] args) throws Exception{
//        StudentEntity studentEntity = new StudentEntity("1");
//        StudentEntity studentEntity1 = new StudentEntity("2");
//        List<StudentEntity> studentEntities = Lists.newArrayList(studentEntity);
//        List<StudentEntity> studentEntities1 = Lists.newArrayList(studentEntity1);
//        TeacherEntity teacherEntity = new TeacherEntity("1", "math_teacher");
//        TeacherEntity teacherEntity1 = new TeacherEntity("2","science_teacher");
//        CourseEntity courseEntity = new CourseEntity("1", "综合", Lists.newArrayList(teacherEntity, teacherEntity1));
//        List<CourseEntity> courseEntities = Lists.newArrayList(courseEntity);
//        ExportParams exportParams = new ExportParams("class","学生");
//        exportParams.setHeight((short) 40);
//        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, CourseEntity.class, courseEntities);
//        File targetFile = new File("class34.xls");
//        FileOutputStream fos = new FileOutputStream(targetFile);
//        workbook.write(fos);
//        fos.close();
//
//        ExcelExportEntity excelExportEntity = new ExcelExportEntity()
        test();
//            export();
    }

    public static void test() throws Exception{

            List<ExcelExportEntity> entities;
            ExcelExportEntity excelExportEntity = new ExcelExportEntity("学生姓名", "name");
            ExcelExportEntity excelExportEntity1 = new ExcelExportEntity("学生性别", "sex");
            ExcelExportEntity excelExportEntity2 = new ExcelExportEntity("学生成绩", "grade");
            excelExportEntity2.setType(10);
            entities = Lists.newArrayList(excelExportEntity, excelExportEntity1, excelExportEntity2);

            ExcelExportEntity student = new ExcelExportEntity("学生", "stu");
            student.setList(Lists.newArrayList(entities));

            ExcelExportEntity course = new ExcelExportEntity("课程", "course");
            course.setMergeVertical(true);
            course.setNeedMerge(true);

            ExcelExportEntity teacher = new ExcelExportEntity("老师", "teacher");
            teacher.setNeedMerge(true);
            teacher.setMergeVertical(true);

            List<ExcelExportEntity> all = Lists.newArrayList(course, teacher, student);

            List<Map<String, Object>> list = Lists.newArrayList();
            Map<String, Object> data = Maps.newHashMap();
            data.put("course","综合1");
            data.put("teacher", "ios");
            List<Map<String, Object>> stuList = Lists.newArrayList();
            Map<String, Object> stuMap = Maps.newHashMap();
            stuMap.put("name", "kimvra");
            stuMap.put("sex", "1");
            stuMap.put("grade", "100");
            stuList.add(stuMap);
            data.put("stu", stuList);
            list.add(data);

            Map<String, Object> data2 = Maps.newHashMap();
            data2.put("course","综合1");
            data2.put("teacher","ios");
            List<Map<String,Object>> stuList1 = Lists.newArrayList();
            Map<String, Object> stuMap1 = Maps.newHashMap();
            stuMap1.put("name","kok");
            stuMap1.put("sex",2);
            stuMap1.put("grade","60");
            stuList1.add(stuMap1);
            data2.put("stu", stuList1);
            list.add(data2);

            Map<String, Object> data3 = Maps.newHashMap();
            data3.put("course","综合2");
            data3.put("teacher","android");
            List<Map<String,Object>> stuList2 = Lists.newArrayList();
            Map<String, Object> stuMap2 = Maps.newHashMap();
            stuMap2.put("name","kok");
            stuMap2.put("sex",2);
            stuMap2.put("grade","60");
            stuList2.add(stuMap2);
            data3.put("stu", stuList2);
            list.add(data3);

            Map<String, Object> data4 = Maps.newHashMap();
            data4.put("course","综合2");
            data4.put("teacher","android");
            List<Map<String,Object>> stuList3 = Lists.newArrayList();
            Map<String, Object> stuMap3 = Maps.newHashMap();
            stuMap3.put("name","kok");
            stuMap3.put("sex",2);
            stuMap3.put("grade","60");
            stuList3.add(stuMap3);
            data4.put("stu", stuList3);
            list.add(data4);

//            Workbook workbook = ExcelExportUtil.exportExcel(buildParam("超链接", "https://www.baidu.com"), all, list);
            Workbook workbook = ExcelExportUtil.exportExcel(buildParam("ceshi"), all, list);

            File targetFile = new File("class43.xls");
            FileOutputStream fos = new FileOutputStream(targetFile);
            workbook.write(fos);
            fos.close();
    }

    private static ExportParams buildParam(String title, String hyperLinkAddress) {
            ExportParams exportParams = new ExportParams();
            exportParams.setTitle(title);
            exportParams.setSheetName(title);
            exportParams.setType(ExcelType.HSSF);
            exportParams.setDataHandler(new ExcelDataHandlerDefaultImpl() {
                    @Override
                    public Hyperlink getHyperlink(CreationHelper creationHelper, Object obj, String name, Object value) {
                            Hyperlink hyperlink = creationHelper.createHyperlink(HyperlinkType.URL);
                            System.out.println(obj.toString());
                            System.out.println(obj.getClass());
                            System.out.println(name);
                            System.out.println(value);
                            hyperlink.setAddress(hyperLinkAddress);
                            return hyperlink;
                    }
            });
            return exportParams;
    }

    private static ExportParams buildParam(String title) {
            ExportParams exportParams = new ExportParams();
            exportParams.setTitle(title);
            exportParams.setSheetName(title);
            exportParams.setType(ExcelType.HSSF);
            return exportParams;
    }

    public static void export() throws Exception{
            List<HyperLinkEntity> list = Lists.newArrayList();
            HyperLinkEntity client = new HyperLinkEntity();
            client.setName("百度");
            client.setUrl("https://www.baidu.com");
            list.add(client);
            client = new HyperLinkEntity();
            client.setName("新浪");
            client.setUrl("https://www.sina.com");

            ExportParams exportParams = new ExportParams("超链接测试", "超链接测试", ExcelType.XSSF);
            exportParams.setDataHandler(new ExcelDataHandlerDefaultImpl() {
                    @Override
                    public Hyperlink getHyperlink(CreationHelper creationHelper, Object obj, String name, Object value) {
                            Hyperlink hyperlink = creationHelper.createHyperlink(HyperlinkType.URL);
                            HyperLinkEntity entity = (HyperLinkEntity) obj;
                            hyperlink.setAddress(entity.getUrl());
                            return hyperlink;
                    }
            });
            Workbook workbook = ExcelExportUtil.exportExcel(exportParams, HyperLinkEntity.class, list);

            File file = new File("class27.xls");
            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            fos.close();;
    }

    public static void test2() throws Exception{
            List<ExcelExportEntity> entities = Lists.newArrayList();

            ExcelExportEntity platform = new ExcelExportEntity("平台", "platform", 20);
            ExcelExportEntity iOS = new ExcelExportEntity("iOS", "iOS", 20);
            iOS.setHyperlink(true);
            iOS.setType(10);

            ExcelExportEntity android = new ExcelExportEntity("android", "android", 20);
            android.setHyperlink(true);
            android.setType(10);

            ExcelExportEntity test1 = new ExcelExportEntity("测试1", "test1", 20);
            test1.setNeedMerge(true);

            ExcelExportEntity test2 = new ExcelExportEntity("测试2", "test2", 20);
            test2.setNeedMerge(true);

            ExcelExportEntity iOSUrl = new ExcelExportEntity("iOSUrl", "iOSUrl", 20);
            iOSUrl.setColumnHidden(true);
            ExcelExportEntity androidUrl = new ExcelExportEntity("androidUrl", "androidUrl", 20);
            androidUrl.setColumnHidden(true);

            entities = Lists.newArrayList(platform,iOS,android,iOSUrl,androidUrl,test1,test2);

            ExportParams exportParams = new ExportParams("ceshi", "ceshi", ExcelType.XSSF);
            exportParams.setDataHandler(new ExcelDataHandlerDefaultImpl() {
                    @Override
                    public Hyperlink getHyperlink(CreationHelper creationHelper, Object obj, String name, Object value) {
                            Hyperlink hyperlink = creationHelper.createHyperlink(HyperlinkType.URL);
                            System.out.println(obj.toString());
                            System.out.println(obj.getClass());
                            HashMap<String, Object> map = (HashMap<String, Object>) obj;
                            System.out.println(name);
                            System.out.println(value);
                            hyperlink.setAddress(map.get(name+"Url").toString());
                            return hyperlink;
                    }
            });

            Map<String, Object> data = new HashMap<>();
            data.put("platform", "1");
            data.put("iOS", 2);
            data.put("android", 3);
            data.put("iOSUrl", "https://www.baidu.com");
            data.put("androidUrl", "https://www.google.com");
            data.put("test1","test1");
            data.put("test2","test2");

            Workbook workbook = ExcelExportUtil.exportExcel(exportParams, entities, Lists.newArrayList(data));

            File targetFile = new File("class39.xls");
            FileOutputStream fos = new FileOutputStream(targetFile);
            workbook.write(fos);
            fos.close();
    }
}
