package com.jdc.mkt.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.dto.Account;
import com.jdc.mkt.dto.Person;

public class E_ObjectStreamTest {

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
		var acc = new Account(1,"user","user");
		var person = new Person(1,"aaa",23,acc);
		
		writeFile(person);		
		readFile();
	}

	void readFile() {
		try (ObjectInputStream fw = 
				new ObjectInputStream(new FileInputStream(file))) {
			
			Person person = (Person) fw.readObject();
			System.out.println(person.getName()+"\t"+person.getAge());
			System.out.println(
					person.getAccount().getUser()+
					"\t"+person.getAccount().getPassword());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void writeFile(Person person) {
		try (ObjectOutputStream ow = 
				new ObjectOutputStream(new FileOutputStream(file))) {
			
			ow.writeObject(person);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










