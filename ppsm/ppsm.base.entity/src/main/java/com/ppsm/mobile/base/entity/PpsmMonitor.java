package com.ppsm.mobile.base.entity;

import java.util.Date;

/**
 * @Description:
 * @Author: LiuYiQiang
 * @Date: 8:37 2018/6/21
 */
public class PpsmMonitor {

    private Integer id;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
