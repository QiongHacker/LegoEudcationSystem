package cn.bw.lego.utils;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * 使用根据类
 * excel导出
 * @author 
 *
 */
public class ExcelUtil {
	public static void exportData(List<HashMap<String, Object>> list,String path){
		String[] title={"编号","用户名称","性别","电话","学校","状态","生日","备注"};
		//创建一个工作薄对象
		jxl.write.WritableWorkbook wb=null;
		String fileName=path;
		File file=new File(fileName);
		try {
			wb=jxl.Workbook.createWorkbook(file);
			//创建工作表对象
			WritableSheet sheet=wb.createSheet("2019十月份", 0);
			//生成表头
			Label label=null;
			for (int i = 0; i < title.length; i++) {
				label=new Label(i, 0,title[i]);
				sheet.addCell(label);
			}
			//追加数据
			Label label2=null;
			HashMap<String, Object> map=null;
			for (int i = 0; i < list.size(); i++) {
				map =list.get(i);
				//往第i+1行的第一列格子追加数据
				label2=new Label(0,i+1,String.valueOf(map.get("id")));
				sheet.addCell(label2);
				
				label2=new Label(1,i+1,String.valueOf(map.get("name")));
				sheet.addCell(label2);
				
				label2=new Label(2,i+1,String.valueOf(map.get("sex")));
				sheet.addCell(label2);
				label2=new Label(3,i+1,String.valueOf(map.get("tele")));
				sheet.addCell(label2);
				label2=new Label(4,i+1,String.valueOf(map.get("school")));
				sheet.addCell(label2);
				label2=new Label(5,i+1,String.valueOf(map.get("state_name")));
				sheet.addCell(label2);
				label2=new Label(6,i+1,String.valueOf(map.get("birth")));
				sheet.addCell(label2);
				label2=new Label(7,i+1,String.valueOf(map.get("remark")));
				sheet.addCell(label2);
				//写入数据
				
			}
			wb.write();
			//关闭流
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
