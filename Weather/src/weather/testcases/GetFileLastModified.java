package weather.testcases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import weather.sikuli.SaveNotepad;

public class GetFileLastModified extends SaveNotepad {
    public String getFile() throws Exception {

	String fileName = new SimpleDateFormat("yyyyMMdd(hh_mm).txt").format(new Date());
	System.out.println("FileName is: " + fileName);

	File file = new File("D:\\weather\\" + fileName);

	System.out.println("Before Format : " + file.lastModified());

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd(hh_mm)");

	System.out.println("After Format : " + sdf.format(file.lastModified()));
	String filename = sdf.format(file.lastModified());
	return filename;
    }
}