package scanner1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScannerDemo2 {
	public static void main(String[] args) {
		
		System.out.println("«Î ‰»Î");
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = null;
		try {
				bw = new BufferedWriter(new FileWriter("a.txt"));
				String line = null;
				while((line = sc.nextLine())!=null) {
					if("exit".equals(line)) {
						break;
					}
					bw.write(line);
					bw.newLine();
					bw.flush();
				}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
