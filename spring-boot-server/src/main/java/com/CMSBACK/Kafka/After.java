package com.CMSBACK.Kafka;

public class After {

	private String id;
	private String name;
	private String revisiondate;
	private String description;
    private String revisionauthor;

	    

	    

	    

	 

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
		public String toString() {
			return "After [id=" + id + ", name=" + name + ", revisiondate=" + revisiondate + ", description="
					+ description + ", revisionauthor=" + revisionauthor + "]";
		}

		

	 
}
