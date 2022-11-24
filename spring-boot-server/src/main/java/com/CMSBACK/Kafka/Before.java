package com.CMSBACK.Kafka;

public class Before {
	  private String revisiondate;

	    private String revisionauthor;

	    private String name;

	    private String description;

	    private String id;

	 

	    public String getRevisiondate ()
	    {
	        return revisiondate;
	    }

	    public void setRevisiondate (String revisiondate)
	    {
	        this.revisiondate = revisiondate;
	    }

	    public String getRevisionauthor ()
	    {
	        return revisionauthor;
	    }

	    public void setRevisionauthor (String revisionauthor)
	    {
	        this.revisionauthor = revisionauthor;
	    }

	    public String getName ()
	    {
	        return name;
	    }

	    public void setName (String name)
	    {
	        this.name = name;
	    }

	    public String getDescription ()
	    {
	        return description;
	    }

	    public void setDescription (String description)
	    {
	        this.description = description;
	    }

	    public String getId ()
	    {
	        return id;
	    }

	    public void setId (String id)
	    {
	        this.id = id;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [revisionauthor_id = "+", revisiondate = "+revisiondate+", revisionauthor = "+revisionauthor+", name = "+name+", description = "+description+", id = "+id+"]";
	    }

}
