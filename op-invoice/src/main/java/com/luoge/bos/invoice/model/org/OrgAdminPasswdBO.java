package com.luoge.bos.invoice.model.org;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class OrgAdminPasswdBO {
    /**
     * 机构id
     */
    @NotNull
    private Integer id;
    /**
     * 管理员初始密码
     */
    @NotEmpty(message = "密码不能为空")
    @Size(min = 8, max = 30)
    private String adminPassword;


    public Integer getId() {
        return id;
    }

    public OrgAdminPasswdBO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public OrgAdminPasswdBO setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
        return this;
    }
}
