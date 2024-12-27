package com.jdc.mkt.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class D_DataStreamTest {

	static File file;

	@BeforeAll
	static void init() throws IOException {
		file = new File("object.obj");
		if (!file.exists()) {
			file.createNewFile();
		}
	}
	
	@Test
	void readWriteTest() {
		writeFile();
		readFile();
	}

	void readFile() {
		try (DataInputStream fw = 
				new DataInputStream(new FileInputStream(file))) {
			
			System.out.println(fw.readUTF());
			System.out.println(fw.readInt());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void writeFile() {
		try (DataOutputStream fw = 
				new DataOutputStream(new FileOutputStream(file))) {
			fw.writeUTF("Hello");
			fw.writeInt(10);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










