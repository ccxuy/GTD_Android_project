/**
 * 
 */
package com.gtdtool.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.gtdtools.dummy.DummyContent.DummyItem;
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
		this.events = new ArrayList<GtdEvent>();
	}
	
	/**
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
	 * TODO
	 */
	public void doLoadGtdEvents(){
		
	}
	
	/**
	 * TODO
	 */
	public void doSaveGtdEvents(){
		
	}
	
	/**
	 * @param item
	 */
	public void addGtdEvents(GtdEvent item){
		this.events.add(item);
		this.events_map.put(item.getId(), item);
	}
	

	/**
	 * TODO
	 */
	public void deleteGtdEvents(){
		
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
		addGtdEvents(new GtdEvent());
		addGtdEvents(new GtdEvent());
		addGtdEvents(new GtdEvent());
		addGtdEvents(new GtdEvent());
		
	}

}
