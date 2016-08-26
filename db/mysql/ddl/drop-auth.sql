
    alter table USERS 
        drop 
        foreign key USERS_TENANT_FK;

    drop table USERS;
    
    drop table AUTHORITIES;

    drop table TENANTS;


