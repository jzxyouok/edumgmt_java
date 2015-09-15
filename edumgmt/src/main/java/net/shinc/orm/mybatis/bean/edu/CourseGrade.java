package net.shinc.orm.mybatis.bean.edu;

public class CourseGrade {
    private Integer id;

    private Integer shCourseId;

    private String name;

    private String type;

    private Integer shMaterialVersionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShCourseId() {
        return shCourseId;
    }

    public void setShCourseId(Integer shCourseId) {
        this.shCourseId = shCourseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getShMaterialVersionId() {
        return shMaterialVersionId;
    }

    public void setShMaterialVersionId(Integer shMaterialVersionId) {
        this.shMaterialVersionId = shMaterialVersionId;
    }
}