package com.baiyy.excelread;

public class TestExcute {

	public static void main(String[] args) {
		String path = "C://test.xls";
		Execute.execute(path, 1, 1, new DrugInfo());
	}

}
