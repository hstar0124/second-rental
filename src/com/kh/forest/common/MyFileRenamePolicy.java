package com.kh.forest.common;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File oldFile) {
		long currentTime = System.currentTimeMillis();
		
		System.out.println(currentTime);
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
		String now = ft.format(new Date(currentTime));
		int randomNumber = (int)(Math.random() * 100000);
		
		String name = oldFile.getName();
		String body = "";
		String ext = "";  
		int dot = name.lastIndexOf("."); /*.을 못찾으면 -1 리턴*/
		if(dot != -1) {
			//확장자가 있는 경우
			body = name.substring(0, dot);
			ext = name.substring(dot);
		}else {
			//확장자가 없는 경우
			body = name;
		}
		
		String fileName = now + randomNumber + ext;
		
		File newFile = new File(oldFile.getParent(), fileName);
		
		return newFile;
	}


}
