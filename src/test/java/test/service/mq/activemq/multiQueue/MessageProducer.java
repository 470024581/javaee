package test.service.mq.activemq.multiQueue;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;

public class MessageProducer {

    private ActiveMQQueue destination;

    private List<JmsTemplate> jmsTemplate;

    //ԭ�����ͼ�����CAS�������Բ�ʹ��ͬ��
    private AtomicInteger current = new AtomicInteger(0);

    //��ѯ�㷨������ؾ���
    private JmsTemplate findJmsTemplate(){
        int cur = current.getAndIncrement();
        int index = cur%jmsTemplate.size();
        System.out.println("���ؾ��⣺������"+current+"   ģ�棺"+jmsTemplate.get(index).toString());
        return jmsTemplate.get(index);
    }
    
    //������Ϣ
    public void sendMessage(Product product){
        this.findJmsTemplate().convertAndSend(destination, product);
    }

    public ActiveMQQueue getDestination() {
        return destination;
    }

    public void setDestination(ActiveMQQueue destination) {
        this.destination = destination;
    }

    public List<JmsTemplate> getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(List<JmsTemplate> jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

  }
