SET AUTOCOMMIT=0;

insert into TENANTS(tenant_name,context,audit_datetime, audit_userid, version) values ('Demo Company Ltd.','demo',sysdate(),'sys', 0);

insert into USERS(username, password, tenant_id, unlocked, firstname, lastname, email_address, enabled, audit_datetime, audit_userid, version) values ('demo','password',1,true,'Murray','Bodor','murray.bodor@gmail.com', true, sysdate(), 'sys', 0);

insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_USER',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_ANONYMOUS',sysdate(), 'sys', 0);

insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_MANAGE_TRAVELLERS',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_EDIT_TRAVELLERS',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_TRAV_SECURITY_PROFILE',sysdate(), 'sys', 0);

insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_REPORTS',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_REPORTS_WHOSTRAVELLING',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_REPORTS_CUSTOMTRAVELLERS',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_REPORTS_DEPARTURESMANIFEST',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_REPORTS_ARRIVALSMANIFEST',sysdate(), 'sys', 0);

insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_ADMIN',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_ADMIN_WORLDAREAS',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_ADMIN_CURRENCIES',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_ADMIN_COUNTRIES',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_ADMIN_CITIES',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_ADMIN_STATES',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_ADMIN_AIRPORTS',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_ADMIN_HOTELS',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_ADMIN_ADMINS',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_ADMIN_AIRLINES',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_ADMIN_SUPERVISORS',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_ADMIN_TYPES',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('demo','ROLE_ADMIN_USERS',sysdate(), 'sys', 0);

/*
insert into USERS(username, password, tenant_id, unlocked, email_address, enabled, audit_datetime, audit_userid, version) values ('user1','password',1,true,'murray.bodor@gmail.com', true, sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('user1','ROLE_USER',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('user1','ROLE_ANONYMOUS',sysdate(), 'sys', 0);

insert into USERS(username, password, tenant_id, unlocked, email_address, enabled, audit_datetime, audit_userid, version) values ('user2','password',1,true,'murray.bodor@gmail.com', true, sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('user2','ROLE_USER',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('user2','ROLE_ANONYMOUS',sysdate(), 'sys', 0);

insert into USERS(username, password, tenant_id, unlocked, email_address, enabled, audit_datetime, audit_userid, version) values ('user3','password',1,true,'murray.bodor@gmail.com', true, sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('user3','ROLE_USER',sysdate(), 'sys', 0);
insert into AUTHORITIES(username, authority, audit_datetime, audit_userid, version) values ('user3','ROLE_ANONYMOUS',sysdate(), 'sys', 0);
*/



COMMIT;
