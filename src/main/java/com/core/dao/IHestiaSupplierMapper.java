package com.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.core.base.BaseMapper;
import com.core.dao.domain.HestiaSupplier;

/**
 * hestia_supplier �������dao
 * 
 * @author lliang
 *
 */
public interface IHestiaSupplierMapper extends BaseMapper<HestiaSupplier> {
	
	/**
	 * ���ݹ�Ӧ��code��ѯ����״̬(status == 10)��Ӧ����Ϣ
	 * @param supplierCode
	 * @return
	 */
	public HestiaSupplier getBySupplierCode(@Param("supplierCode")String supplierCode);
	
	/**
	 * ����������ѯ��Ӧ���б�
	 * @param hestiaSupplier
	 * @return
	 */
	public List<HestiaSupplier> getSupplier(HestiaSupplier hestiaSupplier);
	
	/**
	 * ����������ѯ��ҳ�б�
	 * @param hestiaSupplier
	 * @param rowBounds
	 * @return
	 */
	public List<HestiaSupplier> getSupplier(HestiaSupplier hestiaSupplier, RowBounds rowBounds);
	
}

