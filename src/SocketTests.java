import org.junit.jupiter.api.Test;

import messages.ShowRequestMsgPacker;
import sockets.SocketManager;

class SocketTests {

	@Test
	void test() {
		SocketManager sm = SocketManager.getInstance();
		
		ShowRequestMsgPacker showReq = new ShowRequestMsgPacker();
		
		showReq.sendMsg();
		
		
	}

}
