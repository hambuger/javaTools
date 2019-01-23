package com.hanbuger.excelread;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

/**
 *
 * @Author HanJiabao
 * @Description 从Excel中导入List
 * @Date 2019-01-23
 * @Time 14:44
 */

public class Execute {

	/**
	 * @param path
	 *            Excel文件绝对路径
	 * @param sheetNo
	 *            读取数据所在sheet页，从1开始
	 * @param headLineMun
	 *            读取数据所在行数，从0开始
	 * @param clazz
	 *            读取数据对应的POJO类
	 * @return 读取数据的一个list对象
	 */
	public static List<Object> execute(String path, int sheetNo, int headLineMun, BaseRowModel clazz) {
		InputStream inputStream = null;
		try {
			// 读取Excel文件
			inputStream = new BufferedInputStream(new FileInputStream(path));
			ExcelListener listener = new ExcelListener();
			ExcelReader excelReader = new ExcelReader(inputStream, null, listener, false);
			excelReader.read(new Sheet(sheetNo, headLineMun, clazz.getClass()));
			// 获取并打印POJO对象List
			List<Object> list = listener.getDatas();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
