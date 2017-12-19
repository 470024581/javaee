package test.framework.disruptor;

import com.lmax.disruptor.EventFactory;

public final class MdseEvent {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public final static EventFactory<MdseEvent> EVENT_FACTORY = new EventFactory<MdseEvent>() {
		public MdseEvent newInstance() {
			return new MdseEvent();
		}
	};
}
