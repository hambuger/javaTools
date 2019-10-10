package httppost;

import java.util.List;

public class ReqTakeMedicine {
	private String access_token;
	private String join_drugstore_id;
	private String drugstore_id;
	private String prescription_id;
	private String operaterId;
	private String operaterName;
	List<TBTradeDetail> t_b_trade_details;
	private String cost_category;
	private String injection_status;

	public String getPrescription_id() {
		return prescription_id;
	}

	public void setPrescription_id(String prescription_id) {
		this.prescription_id = prescription_id;
	}

	public String getDrugstore_id() {
		return drugstore_id;
	}

	public void setDrugstore_id(String drugstore_id) {
		this.drugstore_id = drugstore_id;
	}

	public String getOperaterId() {
		return operaterId;
	}

	public void setOperaterId(String operaterId) {
		this.operaterId = operaterId;
	}

	public String getOperaterName() {
		return operaterName;
	}

	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}

	public List<TBTradeDetail> getT_b_trade_details() {
		return t_b_trade_details;
	}

	public void setT_b_trade_details(List<TBTradeDetail> t_b_trade_details) {
		this.t_b_trade_details = t_b_trade_details;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getJoin_drugstore_id() {
		return join_drugstore_id;
	}

	public void setJoin_drugstore_id(String join_drugstore_id) {
		this.join_drugstore_id = join_drugstore_id;
	}

	public String getCost_category() {
		return cost_category;
	}

	public void setCost_category(String cost_category) {
		this.cost_category = cost_category;
	}

	public String getInjection_status() {
		return injection_status;
	}

	public void setInjection_status(String injection_status) {
		this.injection_status = injection_status;
	}

}
