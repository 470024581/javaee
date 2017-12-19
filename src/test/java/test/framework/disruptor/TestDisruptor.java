package test.framework.disruptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

public class TestDisruptor {

	public static void main(String[] args) {
		test();
	}
	
	public static void test(){
		ExecutorService es = Executors.newCachedThreadPool();
		Disruptor<OrderEvent> orderDisroptor = new Disruptor<OrderEvent>(OrderEvent.EVENT_FACTORY, 256, es);
		RingBuffer<OrderEvent> orderRing;
		OrderHandler handler = new OrderHandler();
		orderDisroptor.handleEventsWith(handler);
		orderRing = orderDisroptor.start();
		OrderEvent event = new OrderEvent();
		event.setValue("orderEvent 111");
		publish(event, orderRing);
		
		Disruptor<MdseEvent> mdseDisroptor = new Disruptor<MdseEvent>(MdseEvent.EVENT_FACTORY, 256, es);
		MdseHandler handler2 = new MdseHandler();
		mdseDisroptor.handleEventsWith(handler2);
		RingBuffer<MdseEvent> mdseRing = mdseDisroptor.start();
		MdseEvent mdseEvent = new MdseEvent();
		mdseEvent.setValue("mdseEvent 111");
		publish(mdseEvent, mdseRing);
		
		MdseEvent mdseEvent2 = new MdseEvent();
		mdseEvent2.setValue("mdseEvent 222");
		publish(mdseEvent2, mdseRing);
		
		// �ر�disruptor���ر��̳߳�
		orderDisroptor.shutdown();
		mdseDisroptor.shutdown();
		es.shutdown();
	}
	
	// TODO �ϲ���һ��������Event��һ������
	public static void publish(OrderEvent orderEvent, RingBuffer<OrderEvent> orderRing){
		System.out.println(orderRing.getBufferSize());
		long seq = orderRing.next();
		OrderEvent ringEvent = orderRing.get(seq);
		ringEvent.setValue(orderEvent.getValue());
		orderRing.publish(seq);
	}
	public static void publish(MdseEvent mdseEvent, RingBuffer<MdseEvent> mdseRing){
		long seq = mdseRing.next();
		MdseEvent ringEvent = mdseRing.get(seq);
		ringEvent.setValue(mdseEvent.getValue());
		mdseRing.publish(seq);
	}

}
