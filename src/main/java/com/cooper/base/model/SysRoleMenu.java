package com.cooper.base.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_role_menu")
public class SysRoleMenu {
    /**
     * 编号主键
     */
    @Id
    private String id;

    /**
     * 角色编号
     */
    @Column(name = "role_id")
    private String roleId;

    /**
     * 菜单编号
     */
    @Column(name = "menu_id")
    private String menuId;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 获取编号主键
     *
     * @return id - 编号主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置编号主键
     *
     * @param id 编号主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取角色编号
     *
     * @return role_id - 角色编号
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色编号
     *
     * @param roleId 角色编号
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取菜单编号
     *
     * @return menu_id - 菜单编号
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单编号
     *
     * @param menuId 菜单编号
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}