package com.CMSBACK.Kafka;

public class Userdto {
	 private Userbefore before;

	    private After after;

	    public Userbefore getBefore ()
	    {
	        return before;
	    }

	    public void setBefore (Userbefore before)
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

