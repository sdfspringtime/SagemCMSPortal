package com.CMSBACK.Kafka;

public class Userbefore {
	private String password;

    private String revisionauthor;

    private String revisiondate;

    private String id;

    private String email;

    private String username;

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public String getRevisionauthor ()
    {
        return revisionauthor;
    }

    public void setRevisionauthor (String revisionauthor)
    {
        this.revisionauthor = revisionauthor;
    }

    public String getRevisiondate ()
    {
        return revisiondate;
    }

    public void setRevisiondate (String revisiondate)
    {
        this.revisiondate = revisiondate;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [password = "+password+", revisionauthor = "+revisionauthor+", revisiondate = "+revisiondate+", id = "+id+", email = "+email+", username = "+username+"]";
    }
}
