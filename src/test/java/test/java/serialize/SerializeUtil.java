package test.java.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author lianglong
 */
public class SerializeUtil {

	public static byte[] serialize(Object value) {
		if (value == null) {
			throw new NullPointerException("Can't serialize null");
		}
		byte[] result = null;
		ByteArrayOutputStream bos = null;
		ObjectOutputStream os = null;
		try {
			bos = new ByteArrayOutputStream();
			os = new ObjectOutputStream(bos);
			os.writeObject(value);
			os.close();
			bos.close();
			result = bos.toByteArray();
		} catch (IOException e) {
			throw new IllegalArgumentException("Non-serializable object", e);
		} finally {
			close(os);
			close(bos);
		}
		return result;
	}
	
	public static Object deserialize(byte[] in) {
		Object result = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream is = null;
		try {
			if (in != null) {
				bis = new ByteArrayInputStream(in);
				is = new ObjectInputStream(bis);
				result = is.readObject();
				is.close();
				bis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(is);
			close(bis);
		}
		return result;
	}

	public static void close(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		User u = new User();
		u.setId(4);
		u.setName("小屋");
		
		byte[] bs = serialize(u);
		System.out.println(bs.toString());
		
		User user = (User) deserialize(bs);
		System.out.println(user.getName());
		
		List<User> users = new ArrayList<>();
		users.add(user);
		
		byte[] listBs = serialize(users);
		List<User> list = (List<User>) deserialize(listBs);
		System.out.println(list.get(0).getName());
	}

}
