package test.framework.disruptor;

import com.lmax.disruptor.EventHandler;

public class MdseHandler implements EventHandler<MdseEvent>{

	@Override
	public void onEvent(MdseEvent event, long sequence, boolean endOfBatch)
			throws Exception {
		System.out.println("MdseHandler:  Sequence: " + sequence + "   ValueEvent: " + event.getValue());
	}

}
