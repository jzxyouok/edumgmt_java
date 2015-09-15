package net.shinc.orm.mybatis.bean.edu;

import javax.validation.constraints.NotNull;

public class Parter {
    private Integer id;

    @NotNull(message = "{parter.name.not.empty}")
    private String name;
    //视频数量
    private String videoNum;
    //预定视频数量
	private String videoReservationNum;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoNum() {
		return videoNum;
	}

	public void setVideoNum(String videoNum) {
		this.videoNum = videoNum;
	}

	public String getVideoReservationNum() {
		return videoReservationNum;
	}

	public void setVideoReservationNum(String videoReservationNum) {
		this.videoReservationNum = videoReservationNum;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}