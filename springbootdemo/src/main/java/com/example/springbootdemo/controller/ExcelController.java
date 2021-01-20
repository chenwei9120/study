package com.example.springbootdemo.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ExcelController.java
 * @Description TODO
 * @createTime 2019年11月03日 16:29:00
 */
@RestController
@RequestMapping("excel")
public class ExcelController {

    @RequestMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        List<DownloadData> data = new ArrayList<>();
        data.add(new DownloadData(1L, "李雷", new Date()));
        data.add(new DownloadData(2L, "韩梅梅", new Date()));
        data.add(new DownloadData(3L, "Jim", new Date()));
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=demo.xlsx");
        EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data);
    }

    /**
     * 文件上传
     * <p>1. 创建excel对应的实体对象 参照{@link UploadData}
     * <p>2. 由于默认异步读取excel，所以需要创建excel一行一行的回调监听器，参照{@link UploadDataListener}
     * <p>3. 直接读即可
     */
    @PostMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), UploadData.class, new UploadDataListener()).sheet().doRead();
        return "success";
    }

    @Data
    public static class UploadData {
        @ExcelProperty("id")
        private Long id;

        @ExcelProperty("名称")
        private String name;

        @ExcelProperty("创建日期")
        private Date createDate;
    }

    @Data
    private static class DownloadData {

        public DownloadData(Long id, String name, Date createDate) {
            this.id = id;
            this.name = name;
            this.createDate = createDate;
        }

        @ExcelProperty("id")
        private Long id;

        @ExcelProperty("名称")
        private String name;

        @ExcelProperty("创建日期")
        private Date createDate;
    }

    private static class UploadDataListener extends AnalysisEventListener<UploadData> {

        public UploadDataListener() {
            System.out.println("UploadDataListener::UploadDataListener");
        }

        private static final Logger LOGGER = LoggerFactory.getLogger(UploadDataListener.class);
        /**
         * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
         */
        private static final int BATCH_COUNT = 5;
        List<UploadData> list = new ArrayList<UploadData>();

        @Override
        public void invoke(UploadData data, AnalysisContext context) {
            LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
            list.add(data);
            if (list.size() >= BATCH_COUNT) {
                saveData();
                list.clear();
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            saveData();
            LOGGER.info("所有数据解析完成！");
        }

        /**
         * 加上存储数据库
         */
        private void saveData() {
            LOGGER.info("{}条数据，开始存储数据库！", list.size());
            LOGGER.info("存储数据库成功！");
        }
    }
}