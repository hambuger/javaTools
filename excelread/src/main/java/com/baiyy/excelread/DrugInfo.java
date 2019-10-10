package com.baiyy.excelread;

import java.math.BigDecimal;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class DrugInfo extends BaseRowModel {
	@ExcelProperty(index = 0)
	private String drugId;

	@ExcelProperty(index = 1)
	private BigDecimal marketPrice;

	@ExcelProperty(index = 2)
	private String drugGenericName;

	@ExcelProperty(index = 3)
	private String drugTradeName;

	@ExcelProperty(index = 4)
	private String dosage;

	@ExcelProperty(index = 5)
	private String spec;

	@ExcelProperty(index = 6)
	private String unit;

	@ExcelProperty(index = 7)
	private String companyName;

	@ExcelProperty(index = 8)
	private String approveNumber;

	@ExcelProperty(index = 9)
	private String systemSourceId;

	/**
	 * @return the drugId
	 */
	public String getDrugId() {
		return drugId;
	}

	/**
	 * @param drugId
	 *            the drugId to set
	 */
	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	/**
	 * @return the marketPrice
	 */
	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	/**
	 * @param marketPrice
	 *            the marketPrice to set
	 */
	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	/**
	 * @return the drugGenericName
	 */
	public String getDrugGenericName() {
		return drugGenericName;
	}

	/**
	 * @param drugGenericName
	 *            the drugGenericName to set
	 */
	public void setDrugGenericName(String drugGenericName) {
		this.drugGenericName = drugGenericName;
	}

	/**
	 * @return the drugTradeName
	 */
	public String getDrugTradeName() {
		return drugTradeName;
	}

	/**
	 * @param drugTradeName
	 *            the drugTradeName to set
	 */
	public void setDrugTradeName(String drugTradeName) {
		this.drugTradeName = drugTradeName;
	}

	/**
	 * @return the dosage
	 */
	public String getDosage() {
		return dosage;
	}

	/**
	 * @param dosage
	 *            the dosage to set
	 */
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	/**
	 * @return the spec
	 */
	public String getSpec() {
		return spec;
	}

	/**
	 * @param spec
	 *            the spec to set
	 */
	public void setSpec(String spec) {
		this.spec = spec;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 *            the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the approveNumber
	 */
	public String getApproveNumber() {
		return approveNumber;
	}

	/**
	 * @param approveNumber
	 *            the approveNumber to set
	 */
	public void setApproveNumber(String approveNumber) {
		this.approveNumber = approveNumber;
	}

	/**
	 * @return the systemSourceId
	 */
	public String getSystemSourceId() {
		return systemSourceId;
	}

	/**
	 * @param systemSourceId
	 *            the systemSourceId to set
	 */
	public void setSystemSourceId(String systemSourceId) {
		this.systemSourceId = systemSourceId;
	}
}
