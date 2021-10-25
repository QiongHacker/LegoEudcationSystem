package cn.bw.lego.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;

public class ExcelUtil2 {
	public static void exportData(List<HashMap<String, Object>> list,String path){
		String[] title={"编号","姓名","性别","生日","电话","学校","状态","缴费金额","缴费时间"};
		//创建一个工作薄对象
		jxl.write.WritableWorkbook wb=null;
		String fileName=path;
		File file=new File(fileName);
		try {
			wb=jxl.Workbook.createWorkbook(file);
			//创建工作表对象
			WritableSheet sheet=wb.createSheet("第一页", 0);
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
				label2=new Label(3,i+1,String.valueOf(map.get("birth")));
				sheet.addCell(label2);
				label2=new Label(4,i+1,String.valueOf(map.get("tele")));
				sheet.addCell(label2);
				label2=new Label(5,i+1,String.valueOf(map.get("school")));
				sheet.addCell(label2);
				label2=new Label(6,i+1,String.valueOf(map.get("state_name")));
				sheet.addCell(label2);
				label2=new Label(7,i+1,String.valueOf(map.get("finalprice")));
				sheet.addCell(label2);
				label2=new Label(8,i+1,String.valueOf(map.get("pricetime")));
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
