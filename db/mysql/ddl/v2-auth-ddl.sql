
    alter table USERS drop foreign key USER_TEN_FK;

    drop table if exists AUTHORITIES;

    drop table if exists TENANTS;

    drop table if exists USERS;

    create table AUTHORITIES (
        ID bigint not null auto_increment,
        USERNAME varchar(50) not null,
        AUTHORITY varchar(50) not null,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table TENANTS (
        ID bigint not null auto_increment,
        CONTEXT varchar(40),
        TENANT_NAME varchar(80),
        COMMENTS varchar(400),
        LOGO_FILENAME varchar(80),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table USERS (
        ID bigint not null auto_increment,
        TENANT_ID bigint not null,
        USERNAME varchar(50) not null,
        PASSWORD varchar(20) not null,
        EMAIL_ADDRESS varchar(40),
        UNLOCKED bit not null,
        ENABLED bit not null,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table USERS 
        add index USER_TEN_IDX (TENANT_ID), 
        add constraint USER_TEN_FK 
        foreign key (TENANT_ID) 
        references TENANTS (ID);
