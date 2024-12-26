package com.jdc.mkt.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class B_FileStreamTest {

	static File file;

	@BeforeAll
	static void init() throws IOException {
		file = new File("test.txt");
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
		try (FileReader fw = new FileReader(file)) {
			int i = 0;
			
			while((i = fw.read()) != -1) {			
				System.out.print((char)i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void writeFile() {
		try (FileWriter fw = new FileWriter(file)) {
			fw.write("Hello");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
