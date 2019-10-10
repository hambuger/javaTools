package httppost;

public class TBTradeDetail {
	private String prescription_drug_id;
	private String amount;
	private String stock;
	private String drug_id;

	public String getPrescription_drug_id() {
		return prescription_drug_id;
	}

	public void setPrescription_drug_id(String prescription_drug_id) {
		this.prescription_drug_id = prescription_drug_id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getDrug_id() {
		return drug_id;
	}

	public void setDrug_id(String drug_id) {
		this.drug_id = drug_id;
	}

}
