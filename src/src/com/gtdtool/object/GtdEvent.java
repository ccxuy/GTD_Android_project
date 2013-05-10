package com.gtdtool.object;

public class GtdEvent {
	String name;
	EventType eventType;
	
	public enum EventType{Simple}

	/**
	 * Empty Constructor for GtdEvent
	 */
	public GtdEvent() {
		super();
		this.name = "No Name";
		this.eventType = EventType.Simple;
	}

	/**
	 * @param name
	 * @param eventType
	 */
	public GtdEvent(String name, EventType eventType) {
		super();
		this.name = name;
		this.eventType = eventType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
	
	

}
