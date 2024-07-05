package org.lessons.java.eventi;

import java.util.ArrayList;
import java.util.List;

public class eventProgram {
	
	private String programTitle;
	private List<Event> eventList;
	
	public eventProgram(String programTitle) {
		
		this.programTitle = programTitle;
		this.eventList = new ArrayList<Event>();
		
	}

	public String getProgramTitle() {
		return programTitle;
	}

	public void setProgramTitle(String programTitle) {
		this.programTitle = programTitle;
	}

	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}  
	
	//Method to add an event to the list
	
	public void addEvent(Event newEvent) {
		
		this.eventList.add(newEvent);
		
	}
	
	//Method to clear the list
	
	public void clearEventList() {
		
		this.eventList.clear();
		System.out.println("The event list has been cleared");
		
	}
	
	//Method that return the number of element in the list
	
	public int eventListSize() {
		
		return this.eventList.size();
		
	}
	

}
