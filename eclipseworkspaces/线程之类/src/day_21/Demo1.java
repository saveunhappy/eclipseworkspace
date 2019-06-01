package day_21;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		File f = new File("file/obj.txt");
		writeobject(f);
		readobject(f);
	}

	private static void readobject(File f) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		User user = (User)in.readObject();
		System.out.println(user);
		in.close();
		
	}

	private static void writeobject(File f) throws Exception {
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(new User("will","1234",17));
		out.close();
	}
	
}
