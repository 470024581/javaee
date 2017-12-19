package com.core.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.core.dao.IHestiaSupplierMapper;
import com.core.dao.domain.HestiaSupplier;

@Component("supplierServiceImpl")
public class SupplierServiceImpl implements ISupplierService {

	@Autowired
	private IHestiaSupplierMapper hestiaSupplierMapper;

	@Override
	public void add(HestiaSupplier supplier) {
		hestiaSupplierMapper.add(supplier);
	}

	@Override
	public void del(Long id) {
		hestiaSupplierMapper.del(id);
	}

	@Override
	public List<HestiaSupplier> getSupplier(HestiaSupplier hestiaSupplier) {
		// (0, -1)表示不使用分页：第一条数据， 取多少条
		RowBounds bound = new RowBounds(hestiaSupplier.getStart(), hestiaSupplier.getLimit());
		List<HestiaSupplier> list = hestiaSupplierMapper.getSupplier(hestiaSupplier, bound);
		return list;
	}

	
	
}
