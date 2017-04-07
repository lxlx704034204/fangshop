package com.fang.fangshop.been;

import java.io.Serializable;

public class Role implements Serializable {
    /** t_role.id */
    private Integer id;

    /** t_role.role_name */
    private String roleName;

    /** t_role.role_desc */
    private String roleDesc;

    /** t_role.role_dbPrivilege */
    private String roleDbprivilege;

    /** t_role.status */
    private String status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    public String getRoleDbprivilege() {
        return roleDbprivilege;
    }

    public void setRoleDbprivilege(String roleDbprivilege) {
        this.roleDbprivilege = roleDbprivilege == null ? null : roleDbprivilege.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}