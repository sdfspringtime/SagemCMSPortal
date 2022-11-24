package com.CMSBACK.Kafka;

import org.springframework.stereotype.Component;

@Component
public class dtoObject {
	  private Before before;
private long id;

	    public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

		private After after;

	    public Before getBefore ()
	    {
	        return before;
	    }

	    public void setBefore (Before before)
	    {
	        this.before = before;
	    }

	    public After getAfter ()
	    {
	        return after;
	    }

	    public void setAfter (After after)
	    {
	        this.after = after;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [before = "+before+", after = "+after+"]";
	    }
}
