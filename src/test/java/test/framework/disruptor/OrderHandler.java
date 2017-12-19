package test.framework.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 *	Ïû·ÑÕß 
 **/
public class OrderHandler implements EventHandler<OrderEvent>{

	@Override
	public void onEvent(OrderEvent event, long sequence, boolean endOfBatch)
			throws Exception {
		System.out.println("OrderHandler : Sequence: " + sequence + " ValueEvent: " + event.getValue());
	}

}
