package sh.kim.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.document.AbstractExcelView;


public class Excel extends AbstractExcelView{
	
	/**
	 * 엑셀 다운로드 받기
	 * @method : exel
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 25
	 * @param 
	 * @return
	 */
	@Override
	protected void buildExcelDocument(Map<String, Object> reqMap,
			HSSFWorkbook work, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<String> list = (ArrayList<String>) reqMap.get("list");

		 response.setHeader("Content-Disposition", "attachment;filename=\"excel.xls\"");
		 	 		 
		 Sheet sheet = work.createSheet("bbs Data");
		 Row header = sheet.createRow(0);
		 header.createCell(0).setCellValue("b_idx");
		 header.createCell(1).setCellValue("b_title");
		 header.createCell(2).setCellValue("b_content");
		 header.createCell(3).setCellValue("b_writer_name");
		 header.createCell(4).setCellValue("b_write_date");
		 header.createCell(5).setCellValue("b_modify_date");
		 header.createCell(6).setCellValue("b_view_hit");
		 
		 int rowNum = 1;
		 
		 for (Object temp : list) {
			 Row row = sheet.createRow(rowNum++);	
			 Map<String, Object> dd = (Map<String, Object>) temp;
			 row.createCell(0).setCellValue((Integer) dd.get("bIdx"));
			 row.createCell(1).setCellValue((String) dd.get("bTitle"));
			 row.createCell(2).setCellValue((String) dd.get("bContent"));
			 row.createCell(3).setCellValue((String) dd.get("bWriterName"));
			 row.createCell(4).setCellValue((String) dd.get("bWriteDate"));
			 row.createCell(5).setCellValue((String) dd.get("bModifyDate"));
			 row.createCell(6).setCellValue((Integer) dd.get("bViewHit"));
			}

	
	}
}

