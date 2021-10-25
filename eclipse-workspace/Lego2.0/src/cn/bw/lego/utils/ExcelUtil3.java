package cn.bw.lego.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;

public class ExcelUtil3 {
	public static void exportData(List<HashMap<String, Object>> list,String path){
		String[] title={"���","����","�Ա�","����","�绰","ѧУ","״̬","�˿���","�˿�ʱ��"};
		//����һ������������
		jxl.write.WritableWorkbook wb=null;
		String fileName=path;
		File file=new File(fileName);
		try {
			wb=jxl.Workbook.createWorkbook(file);
			//�������������
			WritableSheet sheet=wb.createSheet("��һҳ", 0);
			//���ɱ�ͷ
			Label label=null;
			for (int i = 0; i < title.length; i++) {
				label=new Label(i, 0,title[i]);
				sheet.addCell(label);
			}
			//׷������
			Label label2=null;
			HashMap<String, Object> map=null;
			for (int i = 0; i < list.size(); i++) {
				map =list.get(i);
				//����i+1�еĵ�һ�и���׷������
				
				
				label2=new Label(0,i+1,String.valueOf(map.get("name")));
				sheet.addCell(label2);
				
				label2=new Label(1,i+1,String.valueOf(map.get("sex")));
				sheet.addCell(label2);
				label2=new Label(2,i+1,String.valueOf(map.get("birth")));
				sheet.addCell(label2);
				label2=new Label(3,i+1,String.valueOf(map.get("tele")));
				sheet.addCell(label2);
				label2=new Label(4,i+1,String.valueOf(map.get("school")));
				sheet.addCell(label2);
				label2=new Label(5,i+1,String.valueOf(map.get("state_name")));
				sheet.addCell(label2);
				label2=new Label(6,i+1,String.valueOf(map.get("refundprice")));
				sheet.addCell(label2);
				label2=new Label(7,i+1,String.valueOf(map.get("refunddate")));
				sheet.addCell(label2);
				//д������
				
			}
			wb.write();
			//�ر���
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
