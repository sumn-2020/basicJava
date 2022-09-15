package memo2;

import java.util.Date;

public class Memo2VO {
	private int no;
	private String title;
	private String content;
	private String writer;
	private Date registerDate;
	private Date modifyDate;
	
	public Memo2VO() {
	}

	public Memo2VO(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public Memo2VO(int no, String title, String content, String writer) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public Memo2VO(int no, String title, String content, String writer, Date registerDate, Date modifyDate) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.registerDate = registerDate;
		this.modifyDate = modifyDate;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return String.format("Memo2VO [no=%s, title=%s, content=%s, writer=%s, registerDate=%s, modifyDate=%s]", no,
				title, content, writer, registerDate, modifyDate);
	}
	
	
}
