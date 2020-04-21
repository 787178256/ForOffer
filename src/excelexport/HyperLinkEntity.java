package excelexport;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * Created by kimvra on 2020/4/14
 */
public class HyperLinkEntity {
    @Excel(name = "名称", isHyperlink = true)
    private String name;

    @Excel(name = "URL", isColumnHidden = true)
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

