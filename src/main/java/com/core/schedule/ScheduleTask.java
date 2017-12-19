package com.core.schedule;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask implements ApplicationListener<ContextRefreshedEvent> {
	
	protected Logger log = Logger.getLogger(this.getClass());
	
	// ÿ���賿����ִ��ͬ����Ʒ����
	@Scheduled(cron="0 0 2 * * ?")
	// ÿ5��ִ��һ��
//	@Scheduled(cron="0/5 * * * * ? ")  
	public void syncMdse() {
		log.info(new Date().toString());
		log.info("Supply-Hestia-SyncMdseSchedule-syncMdseͬ����Ʒ����ִ���С�����");
		// ����QueryMdseServiceImpl�����еĲ�ѯ����������Ʒͬ����������
		log.info("Supply-Hestia-SyncMdseSchedule-syncMdseͬ����Ʒ�����ѽ�����");
	}

	// ��Ŀ����ִ��
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){//root application context ��ֹspringMVC��2��context���ܻ�ִ������
			syncMdse();	//��Ҫִ�е��߼����룬��spring������ʼ����ɺ�ͻ�ִ�и÷�����
		}
	}

}
