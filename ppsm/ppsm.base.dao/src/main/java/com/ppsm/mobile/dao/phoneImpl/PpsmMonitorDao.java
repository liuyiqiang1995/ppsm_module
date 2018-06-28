package com.ppsm.mobile.dao.phoneImpl;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Description:
 * @Author: LiuYiQiang
 * @Date: 22:39 2018/4/26
 */
public interface PpsmMonitorDao {

    void insertMonitor(Timestamp time);

    Date queryMonitorTime();

}
