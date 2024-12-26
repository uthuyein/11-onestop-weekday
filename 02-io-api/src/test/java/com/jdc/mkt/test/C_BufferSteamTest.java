package com.jdc.mkt.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class C_BufferSteamTest {

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
		try (BufferedReader fo = new BufferedReader(new FileReader(file))) {
			
			while(fo.ready()) {
				System.out.println(fo.readLine());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void writeFile() {
		try (BufferedWriter fw = new BufferedWriter(new FileWriter(file))) {
			fw.write("Hello java developer");
			fw.newLine();
			fw.append("Java Courses.");
			fw.newLine();
			fw.append("core java");
			fw.newLine();
			fw.append("spring framework");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




