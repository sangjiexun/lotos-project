package cn.newtouch.ws.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.common.collect.Lists;

/**
 * Web Service传输User信息的DTO.
 * 
 * 只传输外部接口需要的属性.使用JAXB 2.0的annotation标注JAVA-XML映射,尽量使用默认约定.
 * 
 * @author calvin
 */
@XmlType(name = "User")
public class UserDTO
{

    private Long          id;

    private String        loginName;

    private String        name;

    private String        email;

    private List<RoleDTO> roleList = Lists.newArrayList();

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long value)
    {
        this.id = value;
    }

    public String getLoginName()
    {
        return this.loginName;
    }

    public void setLoginName(String value)
    {
        this.loginName = value;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String value)
    {
        this.name = value;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String value)
    {
        this.email = value;
    }

    // 配置输出xml为<roleList><role><id>1</id></role></roleList>
    @XmlElementWrapper(name = "roleList")
    @XmlElement(name = "role")
    public List<RoleDTO> getRoleList()
    {
        return this.roleList;
    }

    public void setRoleList(List<RoleDTO> roleList)
    {
        this.roleList = roleList;
    }

    /**
     * 重新实现toString()函数方便在日志中打印DTO信息.
     */
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}
