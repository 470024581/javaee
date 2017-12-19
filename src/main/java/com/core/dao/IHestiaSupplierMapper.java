package com.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.core.base.BaseMapper;
import com.core.dao.domain.HestiaSupplier;

/**
 * hestia_supplier 表操作的dao
 * 
 * @author lliang
 *
 */
public interface IHestiaSupplierMapper extends BaseMapper<HestiaSupplier> {
	
	/**
	 * 根据供应商code查询可用状态(status == 10)供应商信息
	 * @param supplierCode
	 * @return
	 */
	public HestiaSupplier getBySupplierCode(@Param("supplierCode")String supplierCode);
	
	/**
	 * 根据条件查询供应商列表
	 * @param hestiaSupplier
	 * @return
	 */
	public List<HestiaSupplier> getSupplier(HestiaSupplier hestiaSupplier);
	
	/**
	 * 根据条件查询分页列表
	 * @param hestiaSupplier
	 * @param rowBounds
	 * @return
	 */
	public List<HestiaSupplier> getSupplier(HestiaSupplier hestiaSupplier, RowBounds rowBounds);
	
}

