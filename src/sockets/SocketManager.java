package sockets;

import java.net.URI;
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import com.google.gson.JsonObject;

import data.InternalDataManager;

@ClientEndpoint
public class SocketManager {
	
	private static SocketManager instance;
	private InternalDataManager dataManager;
	
	
	private URI endpointURI;
	
	public static SocketManager getInstance() {
		if (instance == null) {
			instance = new SocketManager();
		}
		return instance;
	}
	
    Session userSession = null;
    private SocketMessageHandler msgHandler;

    public SocketManager() {
		this.endpointURI  = null;
		this.msgHandler   = new SocketMessageHandler();
		this.dataManager  = InternalDataManager.getInstance();
    	
        try {
        	this.endpointURI = new URI("ws://rustnstardust.com:8082");
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, endpointURI);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

 
    @OnOpen
    public void onOpen(Session userSession) {
        System.out.println("opening websocket");
        this.userSession = userSession;
        sendNewConnectionMsg();
    }


    @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        System.out.println("closing websocket");
        this.userSession = null;
    }

    @OnMessage
    public void onMessage(String message) {
        if (this.msgHandler != null) {
            this.msgHandler.handleMsg(message);
        }
    }

    public void sendMessage(String message) {
        this.userSession.getAsyncRemote().sendText(message);
    }
    
    public SocketMessageHandler getMsgHandler(){
    	return this.msgHandler;
    }
    
    private void sendNewConnectionMsg() {
    	JsonObject newConnectionMsg = new JsonObject();
    	
    	 newConnectionMsg.addProperty("type", "newConnection");
         newConnectionMsg.addProperty("userName", dataManager.getUserName());
         newConnectionMsg.addProperty("uniqueID", dataManager.getUserId());	
         
         sendMessage(newConnectionMsg.toString());
    }

}
