package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

public class A_FileObjectTest {
	
	@Test
	void directoryAndReadWriteTest() throws IOException {
		File f = new File("/Users/MKT/Desktop/folderOne/folderTwo");
		assertTrue(f.mkdirs());
		assertFalse(f.isHidden());
		assertTrue(f.isAbsolute());
		assertTrue(f.isDirectory());
		assertFalse(f.isFile());
		f.delete();
//		File f1 = new File(f,"test.txt");
//		f1.createNewFile();
//		f1.setReadable(false);
//		f1.setWritable(false);
			
		
	}

	//@Test
	void createFileTest() throws IOException, URISyntaxException {
		
		//File f1 = new File("hello.txt");
		File f = new File("/Users/MKT/Desktop/test");
		File f1 = new File(f,"hello.txt");	
		
		assertFalse(f1.exists());
		
		f1.createNewFile();
		assertTrue(f1.exists());
		
		//f1.delete();
		//assertFalse(f1.exists());
		
		// will delete on end of execution wherever code exists
//		f1.deleteOnExit();
//		assertTrue(f1.exists());
		
		//URI
//		URI uri = f1.toURI();
//		File f2 = new File(uri);
//		
//		f2.createNewFile();
//		assertTrue(f2.exists());
	}
}









