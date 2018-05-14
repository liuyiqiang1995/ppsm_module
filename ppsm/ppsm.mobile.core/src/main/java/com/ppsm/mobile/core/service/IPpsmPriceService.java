package com.ppsm.mobile.core.service;

import com.ppsm.mobile.base.dto.PpsmPriceDto;
import com.ppsm.mobile.base.dto.PpsmPriceRootIdDto;

import java.util.List;

/**
 * @Description:
 * @Author: LiuYiQiang
 * @Date: 20:13 2018/5/5
 */
public interface IPpsmPriceService {

    List<PpsmPriceDto> getPpsmPriceAll();

    List<PpsmPriceRootIdDto> getPriceForRootIdAll();
}
