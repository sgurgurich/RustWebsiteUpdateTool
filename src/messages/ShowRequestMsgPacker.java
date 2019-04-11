package messages;

import com.google.gson.JsonObject;

import data.InternalDataManager;
import sockets.SocketManager;

public class ShowRequestMsgPacker {
	private JsonObject          showUpdateMessage;
	private InternalDataManager dataManager;
	private SocketManager       socketManager;
	
	public ShowRequestMsgPacker() {
		this.showUpdateMessage = new JsonObject();
		this.dataManager       = InternalDataManager.getInstance();
		this.socketManager     = SocketManager.getInstance();
	}

	public void sendMsg() {
		packHeader();
		socketManager.sendMessage(showUpdateMessage.toString());
		clearMsg();
	}
	

	public void clearMsg() {
		showUpdateMessage = null;
	}
	
	private void packHeader() {
		showUpdateMessage.addProperty("type", "showsRequest");
		showUpdateMessage.addProperty("userName", dataManager.getUserName());
		showUpdateMessage.addProperty("uniqueID", dataManager.getUserId());	
	}
	
}
