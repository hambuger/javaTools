package com.hanbuger.excelread;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

public class ExcelListener extends AnalysisEventListener<Object> {
	private List<Object> datas = new ArrayList<Object>();

	public void invoke(Object object, AnalysisContext context) {
		// 表头一行，所以加1
		System.out.println("当前数据行数：" + (context.getCurrentRowNum() + 1));
		datas.add(object);
		doSomething(object);
	}

	private void doSomething(Object object) {

		// 设置输出格式
		ReflectionToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
		// 设置POJO中不输出的属性
		String s = ReflectionToStringBuilder.toStringExclude(object, "cellStyleMap");
		System.out.println(s);

	}

	public void doAfterAllAnalysed(AnalysisContext context) {
	}

	public List<Object> getDatas() {
		return datas;
	}

	public void setDatas(List<Object> datas) {
		this.datas = datas;
	}
}
