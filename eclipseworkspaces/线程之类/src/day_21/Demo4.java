package day_21;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.shape.Path;

public class Demo4 {
	public static void main(String[] args) throws Exception, IOException {
	
		
		Files.copy(Paths.get("file/hello.txt"), new FileOutputStream("file/jj.txt"));
		Files.copy(new FileInputStream("file/jj.txt"),Paths.get("file/bb.txt"));
		
	}
}
