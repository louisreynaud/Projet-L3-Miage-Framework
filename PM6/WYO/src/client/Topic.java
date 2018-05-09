package client;

import java.util.ArrayList;

public class Topic extends Publication {
	
	public Topic(int id, String nom, String description, ArrayList<Message> listMSG){
		super(id, nom, description);
		this.setListMsg(listMsg);
	}
	
}
