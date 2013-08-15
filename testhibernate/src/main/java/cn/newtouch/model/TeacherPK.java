package cn.newtouch.model;

import java.io.Serializable;

public class TeacherPK implements Serializable
{
    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = 1L;

    private int               id;

    private String            name;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof TeacherPK)
        {
            TeacherPK pk = (TeacherPK) o;
            if (this.id == pk.getId() && this.name.equals(pk.getName()))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return this.id + this.name.hashCode();
    }
}
