package org.lessons.java.eventi;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EventProgram {
	
	private String programTitle;
	private List<Event> eventList;
	
	public EventProgram(String programTitle) {
		
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
	
	
	//Method that return a list of the events in a specific date
	
	public List checkEventsAtDate(Calendar date) {
		
		 List<Event> listAtDate = new ArrayList<Event>();
		
		 for(int i = 0; i < eventList.size(); i++) {
			 
			 Calendar dateInList = eventList.get(i).getEventDate();
			 
			 if(dateInList.compareTo(date) == 0) {
				 
				 listAtDate.add(eventList.get(i));
				 
			 }
			 
		 }
		
		return listAtDate;
		
		
	}
	
	
	//Method that sort the list by date and print the program title and the sorted event list 
	
	public void eventListByDate() {
		
		//Sort the ArrayList using the insertion sort
		
		for(int i=1; i < eventList.size(); i++) {
			
			Calendar date = eventList.get(i).getEventDate();
			
			int j = i-1;
			
			while(j <= 0 && eventList.get(j).getEventDate().compareTo(date) > 0 ){
				
				eventList.set(j + 1, eventList.get(j));
				
				j--;
				
			}
			
			eventList.set(j + 1, eventList.get(i));
			
		}
		
		System.out.println("List of the " + this.programTitle + " events sorted by date:\n");
		
		for(Event ev : eventList) {
			
			System.out.println(EventManagerUtil.dateFormatter(ev.getEventDate()) + " - " + ev.getTitle());
		}
		
		
	}

}
