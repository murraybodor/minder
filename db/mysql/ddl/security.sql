    drop table if exists COMPANIES;

    create table COMPANIES (
        ID bigint not null auto_increment,
        COMPANY_NAME varchar(80),
        COMMENTS varchar(80),
        DBNAME varchar(12),
        LOGO_FILENAME varchar(80),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    );

    drop table if exists USERS;

    create table USERS (
        ID bigint not null auto_increment,
        USER_NAME varchar(40),
        PASSWORD varchar(40),
        COMPANY_ID bigint,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    );

    drop table if exists ROLES;

    create table ROLES (
        ID bigint not null auto_increment,
        ROLE_NAME varchar(40),
        COMMENTS varchar(80),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    );

    drop table if exists USERROLES;

    create table USERROLES (
        ID bigint not null auto_increment,
        USER_ID bigint not null,
        ROLE_ID bigint not null,
        primary key (ID)
    );


insert into COMPANIES (COMPANY_NAME, COMMENTS, DBNAME, LOGO_FILENAME) values ('Demo Company', 'A fake company name for demo purposes', 'demo', 'demo.gif');
insert into USERS (USER_NAME, PASSWORD, COMPANY_ID) values ('dev', 'password', 1);
insert into ROLES (ROLE_NAME) values ('user');
insert into USERROLES (USER_ID, ROLE_ID) values (1, 1);

