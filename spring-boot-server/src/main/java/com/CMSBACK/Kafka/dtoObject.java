package com.CMSBACK.Kafka;

import org.springframework.stereotype.Component;

@Component
public class dtoObject {
	  private Before before;


	

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
		public String toString() {
			return "dtoObject [before=" + before + ", after=" + after + "]";
		}

	  
}
