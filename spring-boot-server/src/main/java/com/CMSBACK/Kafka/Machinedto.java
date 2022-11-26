package com.CMSBACK.Kafka;

public class Machinedto {
	private MachineBefore before;

    private MachineAfter after;

    public MachineBefore getBefore ()
    {
        return before;
    }

    public void setBefore (MachineBefore before)
    {
        this.before = before;
    }

    public MachineAfter getAfter ()
    {
        return after;
    }

    public void setAfter (MachineAfter after)
    {
        this.after = after;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [before = "+before+", after = "+after+"]";
    }
}
