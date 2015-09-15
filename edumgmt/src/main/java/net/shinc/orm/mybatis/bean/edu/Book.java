package net.shinc.orm.mybatis.bean.edu;

public class Book {
    private Integer id;

    private Integer shParterId;

    private String name;

    private String status;

    private String numReservation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShParterId() {
        return shParterId;
    }

    public void setShParterId(Integer shParterId) {
        this.shParterId = shParterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getNumReservation() {
        return numReservation;
    }

    public void setNumReservation(String numReservation) {
        this.numReservation = numReservation == null ? null : numReservation.trim();
    }
}