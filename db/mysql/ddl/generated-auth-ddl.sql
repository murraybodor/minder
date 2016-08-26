
    alter table USERS 
        drop 
        foreign key FK4D495E8FF521CA9;

    drop table if exists AUTHORITIES;

    drop table if exists TENANTS;

    drop table if exists USERS;

    create table AUTHORITIES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        AUTHORITY varchar(50) not null,
        USERNAME varchar(50) not null,
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table TENANTS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS varchar(400),
        CONTEXT varchar(40),
        LOGO_FILENAME varchar(80),
        TENANT_NAME varchar(80),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table USERS (
        ID bigint not null auto_increment,
        UNLOCKED bit not null,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        CELLPHONE varchar(40),
        EMAIL_ADDRESS varchar(40),
        ENABLED bit not null,
        FIRSTNAME varchar(40),
        LASTNAME varchar(40),
        OFFICEPHONE varchar(40),
        PASSWORD varchar(20) not null,
        USERNAME varchar(50) not null,
        VERSION integer,
        TENANT_ID bigint not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table USERS 
        add index FK4D495E8FF521CA9 (TENANT_ID), 
        add constraint FK4D495E8FF521CA9 
        foreign key (TENANT_ID) 
        references TENANTS (ID);
