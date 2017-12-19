package com.core.service;

import java.util.List;

import com.core.dao.domain.HestiaSupplier;

public interface ISupplierService {
	
	public void add(HestiaSupplier supplier);
	
	public void del(Long id);
	
	public List<HestiaSupplier> getSupplier(HestiaSupplier hestiaSupplier);
 
}
