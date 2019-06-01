package car;

public class book {

	
	private String book_name;
	private String book_writer;
	private String book_img_path;
	private double book_price;
	private int book_kucun;
	private int book_number = 0;//记录所选数量
	public int getBook_Number() {
		return book_number;
	}
	public void setBook_number(int book_number) {
		this.book_number = book_number;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_writer() {
		return book_writer;
	}
	public void setBook_writer(String book_writer) {
		this.book_writer = book_writer;
	}
	public double getBook_price() {
		return book_price;
	}
	public void setBook_price(double book_price) {
		this.book_price = book_price;
	}
	public int getBook_kucun() {
		return book_kucun;
	}
	public void setBook_kucun(int book_kucun) {
		this.book_kucun = book_kucun;
	}
	public String getBook_img_path() {
		return book_img_path;
	}
	public void setBook_img_path(String book_img_path) {
		this.book_img_path = book_img_path;
	}
	
}
