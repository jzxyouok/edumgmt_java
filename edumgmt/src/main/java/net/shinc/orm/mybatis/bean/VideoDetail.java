package net.shinc.orm.mybatis.bean;

import java.util.Date;

/** 
 * @ClassName VideoDetail 
 * @Description 视频详细信息
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:53:09  
 */
public class VideoDetail  {
    private String url;

    private Date updatetime;

    private String storeInfo;

    private String storeType;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(String storeInfo) {
        this.storeInfo = storeInfo == null ? null : storeInfo.trim();
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType == null ? null : storeType.trim();
    }
}