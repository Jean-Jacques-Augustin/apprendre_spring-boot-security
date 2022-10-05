package com.jja.apprendre.spring.security.security;

public enum UserPermission {
    STUDENT_READ("student:read"), STUDENT_WRITE("student:write"), COURSE_READ("course:read"), COURSE_WRITE("course:write"), ADMINISTRATE("administrate");


    private final String Permission;

    UserPermission(String permission) {
        Permission = permission;
    }

    public String getPermission() {
        return Permission;
    }
}
