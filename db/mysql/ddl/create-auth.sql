
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
        LOGO_FILENAME varchar(80),
        COMMENTS varchar(400),
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
        FIRSTNAME varchar(40),
        LASTNAME varchar(40),
        OFFICEPHONE varchar(40),
        CELLPHONE varchar(40),
        EMAIL_ADDRESS varchar(40),
        UNLOCKED bit not null,
        ENABLED bit not null,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table USERS 
        add index USERS_TENANT_IDX (TENANT_ID), 
        add constraint USERS_TENANT_FK 
        foreign key (TENANT_ID) 
        references TENANTS (ID);
