package test.framework.guava.eventbus;

import com.google.common.util.concurrent.RateLimiter;

public class BaseMessage {
	
	RateLimiter rl = RateLimiter.create(1);

}
