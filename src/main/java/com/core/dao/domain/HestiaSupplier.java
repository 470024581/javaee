package com.core.dao.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.core.dao.domain.table.HestiaSupplierTable;

/**
 * 供应商信息
 * 
 * @author lliang
 * 
 */
public class HestiaSupplier extends HestiaSupplierTable implements Serializable {

	private static final long serialVersionUID = -640188475210459843L;

	private int start = 0;

	private int limit = -1;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
