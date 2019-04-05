package messages;

import com.google.gson.JsonObject;

import data.InternalDataManager;
import sockets.SocketManager;

public class ShowUpdateMsgPacker{
	
	private JsonObject          showUpdateMessage;
	private InternalDataManager dataManager;
	private SocketManager       socketManager;
	
	public ShowUpdateMsgPacker() {
		this.showUpdateMessage = new JsonObject();
		this.dataManager       = InternalDataManager.getInstance();
		//this.socketManager     = SocketManager.getInstance();
	}

	public void sendMsg(String showDate, String venueName, String location) {
		packHeader();
		
		showUpdateMessage.addProperty("showDate", showDate);
		showUpdateMessage.addProperty("venueName", venueName);
		showUpdateMessage.addProperty("location", location);
		
		//socketManager.sendMessage(showUpdateMessage.getAsString());
		clearMsg();
	}
	

	public void clearMsg() {
		showUpdateMessage = null;
	}
	
	private void packHeader() {
		showUpdateMessage.addProperty("type", "showUpdate");
		showUpdateMessage.addProperty("userName", dataManager.getUserName());
		showUpdateMessage.addProperty("userId", dataManager.getUserId());	
	}
	
}
