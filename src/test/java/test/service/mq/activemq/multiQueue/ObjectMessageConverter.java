package test.service.mq.activemq.multiQueue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * ��Ϣת��
 * @author lliang
 *
 */
public class ObjectMessageConverter implements MessageConverter {
	// ����Ϣ��ȡ������
	@Override
	public Object fromMessage(Message message) throws JMSException,
			MessageConversionException {
		Object object = null;
		if (message instanceof ObjectMessage) {
			// ����ǿת�������Ϣ�е���������ֽ�������
			byte[] obj = (byte[]) ((ObjectMessage) message).getObject();
			// ��ȡ�ֽ�������Ϊ�ֽ�������
			ByteArrayInputStream bis = new ByteArrayInputStream(obj);
			try {
				// ���ֽ�������Ϊ���������
				ObjectInputStream ois = new ObjectInputStream(bis);
				// �Ӷ����������ȡ������ ��ǿת
				object = ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return object;
	}
	
	// ������ת������Ϣ
	@Override
	public Message toMessage(Object object, Session session)
			throws JMSException, MessageConversionException {
		ObjectMessage objectMessage = session.createObjectMessage();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();// �ֽ����������
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bos);// ���������
			oos.writeObject(object);// д�����
			byte[] objMessage = bos.toByteArray();// �ֽ����������ת���ֽ�����
			objectMessage.setObject(objMessage);// ���ֽ�������䵽��Ϣ����Ϊ��Ϣ����
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objectMessage;
	}

}
