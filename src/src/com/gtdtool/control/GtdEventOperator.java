/**
 * 
 */
package com.gtdtool.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;

import com.gtdtool.data.GtdEventDbProxy;
import com.gtdtool.object.GtdEvent;

/**
 * @author Andrew
 *
 */
public class GtdEventOperator {
	/**
	 * An array of GtdEvent items.
	 */
	public List<GtdEvent> events = new ArrayList<GtdEvent>();

	/**
	 * A map of GtdEvent items, by ID.
	 */
	public Map<String, GtdEvent> events_map = new HashMap<String, GtdEvent>();

	/**
	 * Default
	 */
	public GtdEventOperator() {
		super();
	}
	
	/**
	 * @deprecated
	 * @param events
	 */
	public GtdEventOperator(List<GtdEvent> events) {
		super();
		this.events = events;
	}

	public List<GtdEvent> getEvents() {
		return events;
	}

	/**
	 * Load by GtdEventDbProxy
	 */
	public void doLoadGtdEvents(){
		this.events = GtdEventDbProxy.loadAllGtdEventItem();
		
	}
	
	/**
	 * Save by GtdEventDbProxy
	 */
	public void doSaveGtdEvents(){
		GtdEventDbProxy.saveAllGtdEventItem(this.events);
	}
	
	/**
	 * @param item GtdEvent
	 */
	public void addGtdEvents(GtdEvent item){
		this.events.add(item);
		this.events_map.put(item.getId(), item);
	}
	
	/**
	 * @param item description of todo event
	 */
	public void addGtdEvents(String eventTitle){
		GtdEvent item = new GtdEvent();
		item.setName(eventTitle);
		this.events.add(item);
		this.events_map.put(item.getId(), item);
	}
	
	/**
	 * @param item GtdEvent you want to delete
	 */
	public void deleteGtdEvent(GtdEvent item){
		this.events.remove(item);
		this.events_map.remove(item);
	}

	/**
	 * @param postion GtdEvent at position you want to delete
	 */
	public void deleteGtdEvent(int position){
		GtdEvent ge = this.events.get(position);
		this.events.remove(ge);
		this.events_map.remove(ge);
	}

	/**
	 * TODO
	 */
	public void deleteAllGtdEvents(){
		
	}

	/**
	 * CLEANME
	 */
	public void loadDefaultGtdEvents() {
		GtdEvent ge = new GtdEvent();
		addGtdEvents(ge);
		ge = new GtdEvent();
		ge.setName("1");
		addGtdEvents(ge);
		ge = new GtdEvent();
		ge.setName("2");
		addGtdEvents(ge);
		ge = new GtdEvent();
		ge.setName("3");
		addGtdEvents(ge);
		Log.d(this.getClass().getName(), this.toString());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GtdEventOperator [events=" + events + "]";
	}

}
