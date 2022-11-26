package com.CMSBACK.Kafka;

import com.CMSBACK.models.EMType;

public class MachineAfter {
    private String revisiondate;

    private String revisionauthor;

    private EMType typemach;

    private String name;

    private String description;

    private String id;

    private String line_id;

    private String fese;

    private String allocated;

    private String status;



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

    public EMType getTypemach ()
    {
        return typemach;
    }

    public void setTypemach (EMType typemach)
    {
        this.typemach = typemach;
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

    public String getLine_id ()
    {
        return line_id;
    }

    public void setLine_id (String line_id)
    {
        this.line_id = line_id;
    }

    public String getFese ()
    {
        return fese;
    }

    public void setFese (String fese)
    {
        this.fese = fese;
    }

    public String getAllocated ()
    {
        return allocated;
    }

    public void setAllocated (String allocated)
    {
        this.allocated = allocated;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [revisiondate = "+revisiondate+", revisionauthor = "+revisionauthor+", typemach = "+typemach+", name = "+name+", description = "+description+", id = "+id+", line_id = "+line_id+", fese = "+fese+", allocated = "+allocated+", status = "+status+"]";
    }
}
