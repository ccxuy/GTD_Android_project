package com.gtdtool.object;

public class GtdEvent {
	String id = "";
	String name = "";
	EventType eventType;
	EventStatus eventStatus;
	String bookmark = "";

	public enum EventType{Simple}
	public enum EventStatus{NORMAL, URGENT, FINISHED}

	/**
	 * Constructor for a new GtdEvent
	 * It would generate new id and default value
	 */
	public GtdEvent() {
		super();
		this.setGeneratedId();
		this.name = "No Name";
		this.eventType = EventType.Simple;
		this.bookmark = "default_bookmark";
	}

	/**
	 * Constructor for recover an existed GtdEvent
	 * @param id
	 * @param name
	 * @param eventType
	 * @param eventStatus
	 * @param bookmark
	 */
	public GtdEvent(String id, String name, String eventType,
			String eventStatus, String bookmark) {
		super();
		this.id = id;
		this.name = name;
		this.eventType = EventType.valueOf(eventType);
		this.eventStatus = EventStatus.valueOf(eventStatus);
		this.bookmark = bookmark;
	}

	/**
	 * Constructor for recover an existed GtdEvent
	 * @param id
	 * @param name
	 * @param eventType
	 * @param eventStatus
	 * @param bookmark
	 */
	public GtdEvent(String id, String name, EventType eventType,
			EventStatus eventStatus, String bookmark) {
		super();
		this.id = id;
		this.name = name;
		this.eventType = eventType;
		this.eventStatus = eventStatus;
		this.bookmark = bookmark;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * If it is a NEW created GtdEvent instead of retrieve from database
	 * ,use this method to generate a new id.
	 * @param id the id to set
	 */
	public void setGeneratedId() {
		this.id = java.util.UUID.randomUUID().toString();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the eventType
	 */
	public EventType getEventType() {
		return eventType;
	}

	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	/**
	 * @return the eventStatus
	 */
	public EventStatus getEventStatus() {
		return eventStatus;
	}

	/**
	 * @param eventStatus the eventStatus to set
	 */
	public void setEventStatus(EventStatus eventStatus) {
		this.eventStatus = eventStatus;
	}

	/**
	 * @return the bookmark
	 */
	public String getBookmark() {
		return bookmark;
	}

	/**
	 * @param bookmark the bookmark to set
	 */
	public void setBookmark(String bookmark) {
		this.bookmark = bookmark;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GtdEvent [id=" + id + ", name=" + name + ", eventType="
				+ eventType + ", bookmark=" + bookmark + "]";
	}

	
	
	

}
