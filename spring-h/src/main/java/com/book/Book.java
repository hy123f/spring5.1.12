package com.book;

public class Book{

    private String name;

//    public Book(String name) {
//        this.name = name;
//    }
    
    public Book() {
		System.out.println("���췽��ִ����");
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + "]";
	}
}
