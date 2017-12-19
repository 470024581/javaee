package test.framework.disruptor;

import com.lmax.disruptor.EventFactory;

public class OrderEvent {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public final static EventFactory<OrderEvent> EVENT_FACTORY = new EventFactory<OrderEvent>() {
		public OrderEvent newInstance() {
			return new OrderEvent();
		}
	};
}
