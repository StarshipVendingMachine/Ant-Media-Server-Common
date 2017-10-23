package io.antmedia.datastore.db.types;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Reference;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity("broadcast")
@Indexes(
	    @Index(fields = @Field("name"))
	)
public class Broadcast {
	
	/**
	 * id of the broadcast
	 */
	@JsonIgnore
	@Id
	private ObjectId dbId;
	
	
	private String streamId;

	/**
	 * "finished", "broadcasting", "created" 
	 */
	private String status;

	/**
	 * name of the broadcast
	 */
	private String name;
	
	/**
	 * description of the broadcast
	 */
	private String description;
	
	/**
	 * It is a video filter for the service, 
	 * this value is controlled by the user, 
	 * default value is true in the db
	 */
	private boolean publish = true;

	/**
	 * date when record is created in milliseconds
	 */
	private Long date;
	
	/**
	 * Planned start date
	 */
	private Long plannedStartDate;

	/**
	 * duration of the stream in milliseconds
	 */
	private Long duration;

	@Embedded
	private List<Endpoint> endPointList;

	/**
	 * is public
	 */
	private boolean publicStream = true;

	/**
	 * If this stream is a 360 degree video
	 */
	private boolean is360 = false;;
	
	
	private String listenerHookURL;
	

	public Broadcast(String status, String name) {
		this.setStatus(status);
		this.setName(name);
	}

	public Broadcast() {
	}

	public String getStreamId() {
		if (streamId != null) {
			return streamId;
		}
		if (dbId == null){
			return null;
		}
		return dbId.toString();
	}

	public void setStreamId(String id) {
		this.streamId = id;
		dbId = new ObjectId(id);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublish() {
		return publish;
	}

	public void setPublish(boolean publish) {
		this.publish = publish;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Long getPlannedStartDate() {
		return plannedStartDate;
	}

	public void setPlannedStartDate(Long plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public List<Endpoint> getEndPointList() {
		return endPointList;
	}

	public void setEndPointList(List<Endpoint> endPointList) {
		this.endPointList = endPointList;
	}


	public boolean isIs360() {
		return is360;
	}

	public void setIs360(boolean is360) {
		this.is360 = is360;
	}

	public boolean isPublicStream() {
		return publicStream;
	}

	public void setPublicStream(boolean publicStream) {
		this.publicStream = publicStream;
	}

	public String getListenerHookURL() {
		return listenerHookURL;
	}

	public void setListenerHookURL(String listenerHookURL) {
		this.listenerHookURL = listenerHookURL;
	}
	

}