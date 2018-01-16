package com.text.keywords;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternaleUser implements Externalizable{
	
	private String username;
	private transient String password;

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(username);
		out.writeObject(password);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		username = (String) in.readObject();
		password = (String) in.readObject();
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
