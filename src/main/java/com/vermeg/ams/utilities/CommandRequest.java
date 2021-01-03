package com.vermeg.ams.utilities;

import java.util.List;

import com.vermeg.ams.entities.Command;

public class CommandRequest {
	
	private long id ;
	private String title;
	private String author;
	private  double price;
	private int cartQuantity;
	private String date;
	private String picture;
	private int quantity;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCartQuantity() {
		return cartQuantity;
	}
	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CommandRequest(int id, String title, String author, double price, int cartQuantity, String date,
			String picture, int quantity) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.cartQuantity = cartQuantity;
		this.date = date;
		this.picture = picture;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CommandRequest [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price
				+ ", cartQuantity=" + cartQuantity + ", date=" + date + ", picture=" + picture + ", quantity="
				+ quantity + "]";
	}

	
}
