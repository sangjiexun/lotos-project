package cn.newtouch.web.account;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import cn.newtouch.dao.HibernateUtils;
import cn.newtouch.entity.account.Authority;
import cn.newtouch.entity.account.Role;
import cn.newtouch.service.account.AccountManager;
import cn.newtouch.web.CrudActionSupport;

/**
 * 角色管理Action.
 * 
 * 演示不分页的简单管理界面.
 * 
 * @author calvin
 */
@Namespace("/account")
@Results({ @Result(name = CrudActionSupport.RELOAD, location = "role.action", type = "redirect") })
public class RoleAction extends CrudActionSupport<Role>
{

    private static final long serialVersionUID = -4052047494894591406L;

    private AccountManager    accountManager;

    // -- 页面属性 --//
    private Long              id;

    private Role              entity;

    private List<Role>        allRoleList;                             // 角色列表

    private List<Long>        checkedAuthIds;                          // 页面中钩选的权限id列表

    // -- ModelDriven 与 Preparable函数 --//
    public Role getModel()
    {
        return this.entity;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    protected void prepareModel() throws Exception
    {
        if (this.id != null)
        {
            this.entity = this.accountManager.getRole(this.id);
        }
        else
        {
            this.entity = new Role();
        }
    }

    // -- CRUD Action 函数 --//
    @Override
    public String list() throws Exception
    {
        this.allRoleList = this.accountManager.getAllRole();
        return SUCCESS;
    }

    @Override
    public String input() throws Exception
    {
        this.checkedAuthIds = this.entity.getAuthIds();
        return INPUT;
    }

    @Override
    public String save() throws Exception
    {
        // 根据页面上的checkbox 整合Role的Authorities Set.
        HibernateUtils.mergeByCheckedIds(this.entity.getAuthorityList(),
                this.checkedAuthIds, Authority.class);
        // 保存用户并放入成功信息.
        this.accountManager.saveRole(this.entity);
        this.addActionMessage("保存角色成功");
        return RELOAD;
    }

    @Override
    public String delete() throws Exception
    {
        this.accountManager.deleteRole(this.id);
        this.addActionMessage("删除角色成功");
        return RELOAD;
    }

    // -- 页面属性访问函数 --//
    /**
     * list页面显示所有角色列表.
     */
    public List<Role> getAllRoleList()
    {
        return this.allRoleList;
    }

    /**
     * input页面显示所有授权列表.
     */
    public List<Authority> getAllAuthorityList()
    {
        return this.accountManager.getAllAuthority();
    }

    /**
     * input页面显示角色拥有的授权.
     */
    public List<Long> getCheckedAuthIds()
    {
        return this.checkedAuthIds;
    }

    /**
     * input页面提交角色拥有的授权.
     */
    public void setCheckedAuthIds(List<Long> checkedAuthIds)
    {
        this.checkedAuthIds = checkedAuthIds;
    }

    @Autowired
    public void setAccountManager(AccountManager accountManager)
    {
        this.accountManager = accountManager;
    }
}