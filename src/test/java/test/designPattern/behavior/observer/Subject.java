package test.designPattern.behavior.observer;

public interface Subject {
	
	public void addSubject(Observer observer);
	
	public void removeSubject(Observer observer);
	
	public void notifySubjects(String str);

}
