package com.ppsm.mobile.dao.phoneImpl;

import com.ppsm.mobile.base.entity.ProductRelation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRelationDao {

    /**
     * 查询所有productName
     */
    List<ProductRelation> queryAll();

    /**
     * 批量插入
     */
    void insertBatch(List<ProductRelation> list);

}
