package edu.csula.jaxrs.models;

public class Orders {

	public enum Status {
		IN_QUEUE, IN_PROGRESS, COMPLETED
	}

	public int id;
	public String customer_name;
	public String status;

	public Orders(int id, String customer_name, String status) {
		this.id = id;
		this.customer_name = customer_name;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public String getcustomer_name() {
		return customer_name;
	}

	public String getStatus() {
		return status;
	}

}