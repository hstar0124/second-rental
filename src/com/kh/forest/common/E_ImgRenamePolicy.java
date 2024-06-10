package com.kh.forest.common;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class E_ImgRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File oldFile) {
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
		String now = ft.format(new Date(currentTime));
		int randomNumber = (int) (Math.random() * 100000);
		
		String name = oldFile.getName();
		String body = "";
		String ext = "";
		int dot = name.lastIndexOf(".");
		if(dot != -1) {
			body = name.substring(0, dot);
			ext = name.substring(dot);
		}else {
			body = name;
		}
		
		String fileName = now + randomNumber + ext;
		
		File newFile = new File(oldFile.getParent(), fileName);

		return newFile;
	}

}
