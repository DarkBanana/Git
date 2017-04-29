package cn.cjpt.mes.pojo.po;

public class Todayplan {
    private String id;

    private String time;

    private String name;

    private String code;

    private String num;

    private String line;

    private String ordersid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line == null ? null : line.trim();
    }

    public String getOrdersid() {
        return ordersid;
    }

    public void setOrdersid(String ordersid) {
        this.ordersid = ordersid == null ? null : ordersid.trim();
    }
}