package mx.com.cinepolis.scheduler.commons.to;

import java.io.Serializable;

public class StatusLoginTO implements Serializable {
	
	private static final long serialVersionUID = -8598083408172341147L;
	
	boolean status;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
