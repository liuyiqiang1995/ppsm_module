package com.ppsm.mobile.core.service.impl;

import com.ppsm.mobile.base.common.CopyEntityToDtoUtils;
import com.ppsm.mobile.base.dto.PpsmPriceDto;
import com.ppsm.mobile.base.dto.PpsmPriceRootIdDto;
import com.ppsm.mobile.base.entity.MobilePrice;
import com.ppsm.mobile.base.entity.ProductRelation;
import com.ppsm.mobile.core.service.IPpsmPriceService;
import com.ppsm.mobile.dao.phoneImpl.MobilePriceDao;
import com.ppsm.mobile.dao.phoneImpl.PpsmMonitorDao;
import com.ppsm.mobile.dao.phoneImpl.ProductRelationDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: LiuYiQiang
 * @Date: 20:14 2018/5/5
 */
@Service
public class PpsmPriceServiceImpl implements IPpsmPriceService {

    private static Logger logger = LoggerFactory.getLogger(PpsmPriceServiceImpl.class);

    @Autowired
    MobilePriceDao mobilePriceDao;
    @Autowired
    ProductRelationDao productRelationDao;
    @Autowired
    PpsmMonitorDao ppsmMonitorDao;

    public List<PpsmPriceDto> getPpsmPriceAll() {
        List<MobilePrice> mobilePrices = mobilePriceDao.queryPriceAll();
        List<PpsmPriceDto> ppsmPriceDtos = new ArrayList<PpsmPriceDto>();
        for(MobilePrice mobilePrice : mobilePrices){
            PpsmPriceDto ppsmPriceDto = new PpsmPriceDto();
            CopyEntityToDtoUtils.copyMobilePriceToPpsmPriceDto(mobilePrice,ppsmPriceDto);
            ppsmPriceDtos.add(ppsmPriceDto);
        }
        return ppsmPriceDtos;
    }

    public List<PpsmPriceRootIdDto> getPriceForRootIdAll() {
        List<ProductRelation> productRelations = productRelationDao.queryAll();
        List<PpsmPriceRootIdDto> ppsmPriceRootIdDtos = new ArrayList<PpsmPriceRootIdDto>();
        for(ProductRelation productRelation : productRelations){
            PpsmPriceRootIdDto ppsmPriceRootIdDto = new PpsmPriceRootIdDto();
            List<MobilePrice> mobilePrices = mobilePriceDao.queryPriceByRootId(String.valueOf(productRelation.getId()));
            CopyEntityToDtoUtils.copyMobilePriceListToPpsmPriceRootIdDto(mobilePrices,ppsmPriceRootIdDto);
            ppsmPriceRootIdDtos.add(ppsmPriceRootIdDto);
        }
        return ppsmPriceRootIdDtos;
    }

    public Long getMonitorTime() {
        Date monitorTime = ppsmMonitorDao.queryMonitorTime();
        if(monitorTime == null){
            return 0l;
        }else{
            return monitorTime.getTime();
        }
    }

}
