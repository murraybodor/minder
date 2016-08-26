
    alter table AIRPORTS 
        drop 
        foreign key FK64D2D08D1E9611;

    alter table CITIES 
        drop 
        foreign key FK7680AF493AE1C2C3;

    alter table CITIES 
        drop 
        foreign key FK7680AF4984982263;

    alter table COSTALLOCATIONS 
        drop 
        foreign key FKC53EC586FAB0D223;

    alter table COSTALLOCATIONS 
        drop 
        foreign key FKC53EC58629983C03;

    alter table COUNTRIES 
        drop 
        foreign key FKF6B7AA94C1D958D1;

    alter table COUNTRIES 
        drop 
        foreign key FKF6B7AA9438DB87A3;

    alter table DEPENDANTS 
        drop 
        foreign key FK1B56EFD81E8F2F83;

    alter table EMPLOYMENTDETAILS 
        drop 
        foreign key FK6B396CB6DC092B31;

    alter table EMPLOYMENTDETAILS 
        drop 
        foreign key FK6B396CB61E8F2F83;

    alter table EMPLOYMENTDETAILS 
        drop 
        foreign key FK6B396CB649C0DE8D;

    alter table FARESCHEDULES 
        drop 
        foreign key FK517F542EC5116162;

    alter table FLIGHTDEPARTURES 
        drop 
        foreign key FK3E18AE6FA8A5CAE3;

    alter table FLIGHTRESERVATIONS 
        drop 
        foreign key FKFC156E97563FBA83;

    alter table FLIGHTRESERVATIONS 
        drop 
        foreign key FKFC156E97C1D958D1;

    alter table FLIGHTRESERVATIONS 
        drop 
        foreign key FKFC156E97EAD2D4D0;

    alter table FLIGHTRESERVATIONS 
        drop 
        foreign key FKFC156E9717ADCF1;

    alter table FLIGHTROUTES 
        drop 
        foreign key FK39B2EFBAF9BF0163;

    alter table FLIGHTROUTES 
        drop 
        foreign key FK39B2EFBA629DECFC;

    alter table FLIGHTROUTES 
        drop 
        foreign key FK39B2EFBAF0455800;

    alter table FLIGHTROUTES 
        drop 
        foreign key FK39B2EFBA292CFA63;

    alter table HOTELFACILITIES 
        drop 
        foreign key FKBFD2EF15DAB48BE3;

    alter table HOTELRESERVATIONS 
        drop 
        foreign key FKB96829BBC1D958D1;

    alter table HOTELRESERVATIONS 
        drop 
        foreign key FKB96829BBEAD2D4D0;

    alter table HOTELRESERVATIONS 
        drop 
        foreign key FKB96829BBDAB48BE3;

    alter table HOTELRESERVATIONS 
        drop 
        foreign key FKB96829BBD1E9611;

    alter table HOTELS 
        drop 
        foreign key FK7F5D693FDA225571;

    alter table HOTELS 
        drop 
        foreign key FK7F5D693FD7D61A43;

    alter table HOTELS 
        drop 
        foreign key FK7F5D693FD1E9611;

    alter table INSURANCES 
        drop 
        foreign key FKA3E420D91E8F2F83;

    alter table ITINERARIES 
        drop 
        foreign key FK5D251EC9C1D958D1;

    alter table ITINERARIES 
        drop 
        foreign key FK5D251EC91E8F2F83;

    alter table MEDICALASSESSMENTS 
        drop 
        foreign key FK296ECEC01E8F2F83;

    alter table MEDICALASSESSMENTS 
        drop 
        foreign key FK296ECEC084982263;

    alter table NONEMPLOYMENTDETAILS 
        drop 
        foreign key FK5A8FCDA9981A379C;

    alter table NONEMPLOYMENTDETAILS 
        drop 
        foreign key FK5A8FCDA91E8F2F83;

    alter table OTHERRESERVATIONS 
        drop 
        foreign key FKB6AFBD17C1D958D1;

    alter table OTHERRESERVATIONS 
        drop 
        foreign key FKB6AFBD17EAD2D4D0;

    alter table OTHERRESERVATIONS 
        drop 
        foreign key FKB6AFBD17D1E9611;

    alter table PASSPORTS 
        drop 
        foreign key FK6E6306811E8F2F83;

    alter table PASSPORTS 
        drop 
        foreign key FK6E63068184982263;

    alter table PERSONALDETAILS 
        drop 
        foreign key FK3EBADFE2C299E5E3;

    alter table PERSONALDETAILS 
        drop 
        foreign key FK3EBADFE21E8F2F83;

    alter table RESERVATIONS 
        drop 
        foreign key FK41F21E2729983C03;

    alter table SECURITYORIENTATIONS 
        drop 
        foreign key FKD1E233E31E8F2F83;

    alter table SECURITYORIENTATIONS 
        drop 
        foreign key FKD1E233E384982263;

    alter table SECURITYPROFILES 
        drop 
        foreign key FK3BE5C32A1E8F2F83;

    alter table SOSCOVERAGES 
        drop 
        foreign key FKC119CBD41E8F2F83;

    alter table STATES 
        drop 
        foreign key FK9260C20284982263;

    alter table USERPROFILES 
        drop 
        foreign key FK1CC184B5C1D958D1;

    alter table VACCINATIONS 
        drop 
        foreign key FK51E98ACE1E8F2F83;

    alter table VEHICLERESERVATIONS 
        drop 
        foreign key FK32750733C1D958D1;

    alter table VEHICLERESERVATIONS 
        drop 
        foreign key FK32750733EAD2D4D0;

    alter table VEHICLERESERVATIONS 
        drop 
        foreign key FK32750733D1E9611;

    alter table VISAS 
        drop 
        foreign key FK4DE54321E8F2F83;

    alter table VISAS 
        drop 
        foreign key FK4DE543284982263;

    drop table if exists ADMINASSISTANTS;

    drop table if exists AIRCRAFTMODELS;

    drop table if exists AIRLINES;

    drop table if exists AIRPORTS;

    drop table if exists CITIES;

    drop table if exists COSTALLOCATIONS;

    drop table if exists COUNTRIES;

    drop table if exists CURRENCIES;

    drop table if exists DEPENDANTS;

    drop table if exists EMPLOYMENTDETAILS;

    drop table if exists FARESCHEDULES;

    drop table if exists FLIGHTDEPARTURES;

    drop table if exists FLIGHTRESERVATIONS;

    drop table if exists FLIGHTROUTES;

    drop table if exists HOTELCHAINS;

    drop table if exists HOTELFACILITIES;

    drop table if exists HOTELRESERVATIONS;

    drop table if exists HOTELS;

    drop table if exists INSURANCES;

    drop table if exists ITINERARIES;

    drop table if exists MEDICALASSESSMENTS;

    drop table if exists METADATA;

    drop table if exists NONEMPLOYMENTDETAILS;

    drop table if exists OTHERRESERVATIONS;

    drop table if exists PASSPORTS;

    drop table if exists PERSONALDETAILS;

    drop table if exists RESERVATIONS;

    drop table if exists SECURITYORIENTATIONS;

    drop table if exists SECURITYPROFILES;

    drop table if exists SOSCOVERAGES;

    drop table if exists STATES;

    drop table if exists SUPERVISORS;

    drop table if exists TRAVELLERS;

    drop table if exists TYPES;

    drop table if exists USERPROFILES;

    drop table if exists VACCINATIONS;

    drop table if exists VEHICLERESERVATIONS;

    drop table if exists VISAS;

    drop table if exists WORLDAREAS;

    drop table if exists RESERVATIONS_SEQ;

    create table ADMINASSISTANTS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        CELL_PHONE varchar(20),
        EMAIL varchar(40),
        FIRST_NAME varchar(40),
        LAST_NAME varchar(40),
        OFFICE_PHONE varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table AIRCRAFTMODELS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        DESCRIPTION varchar(20),
        MANUFACTURER varchar(40),
        MODEL_NAME varchar(40),
        PHOTO_FILENAME varchar(40),
        MODEL_TYPE varchar(80),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table AIRLINES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        CODE varchar(8),
        NAME varchar(40),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table AIRPORTS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        CITY_ID bigint,
        DESCRIPTION varchar(80),
        IATA_CODE varchar(6),
        LATITUDE float,
        LONGITUDE float,
        NAME varchar(40),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table CITIES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COUNTRY_ID bigint,
        LATITUDE float,
        LONGITUDE float,
        NAME varchar(40),
        STATE_ID bigint,
        TIMEZONE float,
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table COSTALLOCATIONS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COST_CENTER varchar(40),
        ALLOC_PCT float,
        VERSION integer,
        ITINERARY_ID bigint,
        RESERVATION_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table COUNTRIES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        CURRENCY_ID bigint,
        NAME varchar(40),
        VERSION integer,
        WORLDAREA_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table CURRENCIES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        CURRENCY_CODE varchar(8),
        EXCH_RATE_TO_1_USD float,
        NAME varchar(40),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table DEPENDANTS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        BIRTH_DATE datetime,
        COMMENTS varchar(400),
        FULL_NAME varchar(400),
        VERSION integer,
        TRAVELLER_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table EMPLOYMENTDETAILS (
        ID bigint not null auto_increment,
        ASST_ID bigint,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        BUS_UNIT varchar(40),
        COMMENTS varchar(400),
        COST_CENTER varchar(40),
        DEPT varchar(40),
        DIVISION varchar(40),
        EMAIL varchar(40),
        EMPL_NUM varchar(40),
        EXPAT bit,
        OFFICE_FAX varchar(20),
        OFFICE_PHONE varchar(20),
        START_DATE datetime,
        SUPV_ID bigint,
        TERMINATION_DATE datetime,
        TITLE varchar(40),
        VERSION integer,
        TRAVELLER_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table FARESCHEDULES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        CABIN_CLASS varchar(6),
        END_DATE datetime,
        ENDORSEMENTS varchar(240),
        FARE_CATEGORY varchar(6),
        OTHER_FEE float,
        STANDARD_PRICE float,
        START_DATE datetime,
        TAX_RATE float,
        VERSION integer,
        FLIGHT_ROUTE_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table FLIGHTDEPARTURES (
        ID bigint not null auto_increment,
        ARRIVAL_DATE datetime,
        ARRIVAL_TIME_HRS integer,
        ARRIVAL_TIME_MINS integer,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS varchar(400),
        DEPARTURE_DATE datetime,
        DEPARTURE_TIME_HRS integer,
        DEPARTURE_TIME_MINS integer,
        FLIGHT_STATUS varchar(6),
        VERSION integer,
        FLIGHTROUTE_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table FLIGHTRESERVATIONS (
        COMMENTS varchar(400),
        COST float,
        COST_CENTER varchar(40),
        CURRENCY_ID bigint,
        ID bigint not null,
        FARESCHEDULE_ID bigint,
        FLIGHTDEPARTURE_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table FLIGHTROUTES (
        ID bigint not null auto_increment,
        AIRLINE_ID bigint,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        AVAILABLE_DAYS varchar(7),
        COMMENTS varchar(400),
        CONNECTING bit,
        DEST_AIRPORT_ID bigint,
        FLIGHT_CATEGORY varchar(6),
        FLIGHT_DISTANCE integer,
        FLIGHT_NUMBER varchar(8),
        LOCATOR varchar(12),
        MEAL bit,
        MOVIE bit,
        NUMBER_OF_STOPS integer,
        ORIGIN_AIRPORT_ID bigint,
        SYSTEM varchar(6),
        VERSION integer,
        AIRCRAFTMODEL_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table HOTELCHAINS (
        ID bigint not null auto_increment,
        ACTIVE bit,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS varchar(400),
        NAME varchar(40),
        PREFERRED_ORDER integer,
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table HOTELFACILITIES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS varchar(400),
        DESCRIPTION varchar(400),
        FACILITY_TYPE varchar(6),
        VERSION integer,
        HOTEL_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table HOTELRESERVATIONS (
        ARRIVAL_DATE datetime,
        CHECKOUT_DATE datetime,
        CITY_ID bigint,
        COMMENTS varchar(400),
        COST float,
        COST_CENTER varchar(40),
        CURRENCY_ID bigint,
        HOTEL_ID bigint,
        OTHER_HOTEL varchar(120),
        ROOM_TYPE varchar(80),
        ID bigint not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table HOTELS (
        ID bigint not null auto_increment,
        ACTIVE bit,
        ADDRESS varchar(200),
        ADDRESS2 varchar(80),
        ADDRESS3 varchar(80),
        ADDRESS4 varchar(80),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        CITY_ID bigint,
        AIRPORT_ID bigint,
        COMMENTS varchar(400),
        FAX varchar(20),
        HOTELCHAIN_ID bigint,
        LATITUDE float,
        LOCATION varchar(6),
        LONGITUDE float,
        NAME varchar(40),
        PHONE varchar(20),
        PHOTO_FILENAME varchar(40),
        PREFERRED_ORDER integer,
        URL varchar(240),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table INSURANCES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS varchar(400),
        EXPIRY_DATE datetime,
        ISSUE_DATE datetime,
        POLICY_CONTACT varchar(80),
        POLICY_NUMBER varchar(80),
        PROVIDER varchar(400),
        INSURANCE_TYPE varchar(80),
        VERSION integer,
        TRAVELLER_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table ITINERARIES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        AUTH_ID bigint,
        COMMENTS varchar(400),
        CONTACT varchar(240),
        CURRENCY_ID bigint,
        DEPART_DATE datetime,
        FLIGHT_COST float,
        INTERNATIONAL bit,
        NAME varchar(240),
        PNR_LOCATOR varchar(8),
        PURPOSE varchar(240),
        RESERVATION_DATE datetime,
        RETURN_DATE datetime,
        TAX float,
        TICKET_NUMBER integer,
        TOAL_COST float,
        TRIP_DAYS integer,
        VERSION integer,
        TRAVELLER_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table MEDICALASSESSMENTS (
        ID bigint not null auto_increment,
        ASSESSMENT_DATE datetime,
        ASSESSMENT_TYPE varchar(80),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS varchar(400),
        COUNTRY_ID bigint,
        VERSION integer,
        TRAVELLER_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table METADATA (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        BLOB_VALUE longblob,
        BOOL_VALUE bit,
        DATE_VALUE datetime,
        META_DESC varchar(80),
        META_KEY varchar(40) not null,
        SUPP_INFO varchar(80),
        NUM_VALUE integer,
        STR_VALUE varchar(80),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table NONEMPLOYMENTDETAILS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS varchar(400),
        COMPANY varchar(80),
        CONTRACT_EFFECTIVE datetime,
        CONTRACT_EXPIRY datetime,
        CORP_SUPV_ID bigint,
        COST_CENTRE varchar(40),
        DEPENDANT bit,
        EMAIL varchar(40),
        GUEST bit,
        OFFICE_PHONE varchar(20),
        SUPV_EMAIL varchar(40),
        SUPV_NAME varchar(40),
        SUPV_PHONE varchar(20),
        TITLE varchar(40),
        VERSION integer,
        TRAVELLER_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table OTHERRESERVATIONS (
        CITY_ID bigint,
        COMMENTS varchar(400),
        COST float,
        COST_CENTER varchar(40),
        CURRENCY_ID bigint,
        RESV_DATE datetime,
        ID bigint not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table PASSPORTS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS varchar(400),
        COUNTRY_ID bigint,
        EXPIRY_DATE datetime,
        FIRST_NAME varchar(40),
        ISSUE_DATE datetime,
        LAST_NAME varchar(40),
        MIDDLE_NAME varchar(40),
        PP_NUMBER varchar(80),
        PLACE_OF_ISSUE varchar(80),
        REMIND_DATE datetime,
        REMIND_ON_EXPIRY bit,
        VERSION integer,
        TRAVELLER_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table PERSONALDETAILS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        BIRTH_DATE datetime,
        BIRTH_PLACE varchar(80),
        CELL_PHONE varchar(20),
        COMMENTS varchar(400),
        EMAIL varchar(40),
        EMPLOYEE bit,
        FIRST_NAME varchar(40),
        HOME_PHONE varchar(20),
        LAST_NAME varchar(40),
        VERSION integer,
        BIRTH_COUNTRY_ID bigint,
        TRAVELLER_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table RESERVATIONS (
        ID bigint not null,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        RESV_ORDER integer,
        RES_TYPE varchar(255),
        VERSION integer,
        ITINERARY_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table SECURITYORIENTATIONS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS varchar(400),
        COUNTRY_ID bigint,
        NAME varchar(80),
        ORIENT_DATE datetime,
        ORIENT_TYPE varchar(80),
        VERSION integer,
        TRAVELLER_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table SECURITYPROFILES (
        ID bigint not null auto_increment,
        ACTIVITY_DISLIKES varchar(600),
        ACTIVITY_PARTICIPATES varchar(600),
        ALLERGIES varchar(600),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        BLOOD_TYPE varchar(8),
        CODE_PHRASE varchar(600),
        CONTACT_SOLN varchar(40),
        CONTACTS bit,
        DENTIST_ADDR varchar(600),
        DENTAL_CONDITIONS varchar(600),
        DENTIST_NAME varchar(240),
        DENTIST_PHONE varchar(40),
        DISLIKES varchar(600),
        DOCTOR_ADDRESS varchar(600),
        DOCTOR_NAME varchar(240),
        DOCTOR_PHONE varchar(40),
        EMERG_CONTACT1_CELLPHONE varchar(40),
        EMERG_CONTACT1_DAYPHONE varchar(40),
        EMERG_CONTACT1_EVEPHONE varchar(40),
        EMERG_CONTACT1_ALT varchar(80),
        EMERG_CONTACT1_NAME varchar(240),
        EMERG_CONTACT1_RSHIP varchar(80),
        EMERG_CONTACT2_CELLPHONE varchar(40),
        EMERG_CONTACT2_DAYPHONE varchar(40),
        EMERG_CONTACT2_EVEPHONE varchar(40),
        EMERG_CONTACT2_ALT varchar(240),
        EMERG_CONTACT2_NAME varchar(240),
        EMERG_CONTACT2_RSHIP varchar(80),
        GLASSES bit,
        HOME_ADDRESS varchar(1000),
        LIKES varchar(600),
        OPTO_ADDRESS varchar(600),
        OPTO_NAME varchar(240),
        OPTO_PHONE varchar(40),
        PHARM_ADDRESS varchar(600),
        PHARM_NAME varchar(240),
        PHARM_PHONE varchar(40),
        PHYSICAL_DESCRIPTION varchar(1000),
        OPTO_PRESC_LE varchar(8),
        OPTO_PRESC_RE varchar(8),
        VERSION integer,
        VISION_COND varchar(600),
        VITAL_PRESC varchar(600),
        TRAVELLER_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table SOSCOVERAGES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        CARD_TYPE varchar(80),
        COMMENTS varchar(400),
        COVERED bit,
        EXPIRY_DATE datetime,
        ISSUE_DATE datetime,
        RETURN_DATE datetime,
        VERSION integer,
        TRAVELLER_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table STATES (
        ID bigint not null auto_increment,
        ABBREV varchar(6),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COUNTRY_ID bigint,
        NAME varchar(40),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table SUPERVISORS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        CELL_PHONE varchar(20),
        EMAIL varchar(40),
        FIRST_NAME varchar(40),
        LAST_NAME varchar(40),
        OFFICE_PHONE varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table TRAVELLERS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS varchar(400),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table TYPES (
        DTYPE varchar(31) not null,
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        NAME varchar(80),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table USERPROFILES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        CURRENCY_ID bigint,
        DATE_FORMAT varchar(20) not null,
        TIME_ZONE integer,
        USER_ID varchar(50) not null,
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table VACCINATIONS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        BOOSTER1_DUE_DATE datetime,
        B1_REMIND_DATE datetime,
        BOOSTER2_DUE_DATE datetime,
        B2_REMIND_DATE datetime,
        COMMENTS varchar(400),
        EXPIRY_DATE datetime,
        REMIND_DATE datetime,
        REMIND_ON_EXPIRY bit,
        VACCINATION_DATE datetime,
        VACCINATION_TYPE varchar(80),
        VERSION integer,
        TRAVELLER_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table VEHICLERESERVATIONS (
        CITY_ID bigint,
        COMMENTS varchar(400),
        COST float,
        COST_CENTER varchar(40),
        CURRENCY_ID bigint,
        END_DATE datetime,
        RENTAL_AGENCY varchar(300),
        START_DATE datetime,
        VEH_TYPE varchar(80),
        ID bigint not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table VISAS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS varchar(400),
        COUNTRY_ID bigint,
        EXPIRY_DATE datetime,
        ISSUE_DATE datetime,
        REMIND_DATE datetime,
        REMIND_ON_EXPIRY bit,
        VERSION integer,
        VISA_ID varchar(80),
        VISA_TYPE varchar(80),
        TRAVELLER_ID bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table WORLDAREAS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        NAME varchar(40),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table AIRPORTS 
        add index FK64D2D08D1E9611 (CITY_ID), 
        add constraint FK64D2D08D1E9611 
        foreign key (CITY_ID) 
        references CITIES (ID);

    alter table CITIES 
        add index FK7680AF493AE1C2C3 (STATE_ID), 
        add constraint FK7680AF493AE1C2C3 
        foreign key (STATE_ID) 
        references STATES (ID);

    alter table CITIES 
        add index FK7680AF4984982263 (COUNTRY_ID), 
        add constraint FK7680AF4984982263 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

    alter table COSTALLOCATIONS 
        add index FKC53EC586FAB0D223 (RESERVATION_ID), 
        add constraint FKC53EC586FAB0D223 
        foreign key (RESERVATION_ID) 
        references RESERVATIONS (ID);

    alter table COSTALLOCATIONS 
        add index FKC53EC58629983C03 (ITINERARY_ID), 
        add constraint FKC53EC58629983C03 
        foreign key (ITINERARY_ID) 
        references ITINERARIES (ID);

    alter table COUNTRIES 
        add index FKF6B7AA94C1D958D1 (CURRENCY_ID), 
        add constraint FKF6B7AA94C1D958D1 
        foreign key (CURRENCY_ID) 
        references CURRENCIES (ID);

    alter table COUNTRIES 
        add index FKF6B7AA9438DB87A3 (WORLDAREA_ID), 
        add constraint FKF6B7AA9438DB87A3 
        foreign key (WORLDAREA_ID) 
        references WORLDAREAS (ID);

    alter table DEPENDANTS 
        add index FK1B56EFD81E8F2F83 (TRAVELLER_ID), 
        add constraint FK1B56EFD81E8F2F83 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table EMPLOYMENTDETAILS 
        add index FK6B396CB6DC092B31 (SUPV_ID), 
        add constraint FK6B396CB6DC092B31 
        foreign key (SUPV_ID) 
        references SUPERVISORS (ID);

    alter table EMPLOYMENTDETAILS 
        add index FK6B396CB61E8F2F83 (TRAVELLER_ID), 
        add constraint FK6B396CB61E8F2F83 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table EMPLOYMENTDETAILS 
        add index FK6B396CB649C0DE8D (ASST_ID), 
        add constraint FK6B396CB649C0DE8D 
        foreign key (ASST_ID) 
        references ADMINASSISTANTS (ID);

    alter table FARESCHEDULES 
        add index FK517F542EC5116162 (FLIGHT_ROUTE_ID), 
        add constraint FK517F542EC5116162 
        foreign key (FLIGHT_ROUTE_ID) 
        references FLIGHTROUTES (ID);

    alter table FLIGHTDEPARTURES 
        add index FK3E18AE6FA8A5CAE3 (FLIGHTROUTE_ID), 
        add constraint FK3E18AE6FA8A5CAE3 
        foreign key (FLIGHTROUTE_ID) 
        references FLIGHTROUTES (ID);

    alter table FLIGHTRESERVATIONS 
        add index FKFC156E97563FBA83 (FLIGHTDEPARTURE_ID), 
        add constraint FKFC156E97563FBA83 
        foreign key (FLIGHTDEPARTURE_ID) 
        references FLIGHTDEPARTURES (ID);

    alter table FLIGHTRESERVATIONS 
        add index FKFC156E97C1D958D1 (CURRENCY_ID), 
        add constraint FKFC156E97C1D958D1 
        foreign key (CURRENCY_ID) 
        references CURRENCIES (ID);

    alter table FLIGHTRESERVATIONS 
        add index FKFC156E97EAD2D4D0 (ID), 
        add constraint FKFC156E97EAD2D4D0 
        foreign key (ID) 
        references RESERVATIONS (ID);

    alter table FLIGHTRESERVATIONS 
        add index FKFC156E9717ADCF1 (FARESCHEDULE_ID), 
        add constraint FKFC156E9717ADCF1 
        foreign key (FARESCHEDULE_ID) 
        references FARESCHEDULES (ID);

    alter table FLIGHTROUTES 
        add index FK39B2EFBAF9BF0163 (AIRLINE_ID), 
        add constraint FK39B2EFBAF9BF0163 
        foreign key (AIRLINE_ID) 
        references AIRLINES (ID);

    alter table FLIGHTROUTES 
        add index FK39B2EFBA629DECFC (ORIGIN_AIRPORT_ID), 
        add constraint FK39B2EFBA629DECFC 
        foreign key (ORIGIN_AIRPORT_ID) 
        references AIRPORTS (ID);

    alter table FLIGHTROUTES 
        add index FK39B2EFBAF0455800 (DEST_AIRPORT_ID), 
        add constraint FK39B2EFBAF0455800 
        foreign key (DEST_AIRPORT_ID) 
        references AIRPORTS (ID);

    alter table FLIGHTROUTES 
        add index FK39B2EFBA292CFA63 (AIRCRAFTMODEL_ID), 
        add constraint FK39B2EFBA292CFA63 
        foreign key (AIRCRAFTMODEL_ID) 
        references AIRCRAFTMODELS (ID);

    alter table HOTELFACILITIES 
        add index FKBFD2EF15DAB48BE3 (HOTEL_ID), 
        add constraint FKBFD2EF15DAB48BE3 
        foreign key (HOTEL_ID) 
        references HOTELS (ID);

    alter table HOTELRESERVATIONS 
        add index FKB96829BBC1D958D1 (CURRENCY_ID), 
        add constraint FKB96829BBC1D958D1 
        foreign key (CURRENCY_ID) 
        references CURRENCIES (ID);

    alter table HOTELRESERVATIONS 
        add index FKB96829BBEAD2D4D0 (ID), 
        add constraint FKB96829BBEAD2D4D0 
        foreign key (ID) 
        references RESERVATIONS (ID);

    alter table HOTELRESERVATIONS 
        add index FKB96829BBDAB48BE3 (HOTEL_ID), 
        add constraint FKB96829BBDAB48BE3 
        foreign key (HOTEL_ID) 
        references HOTELS (ID);

    alter table HOTELRESERVATIONS 
        add index FKB96829BBD1E9611 (CITY_ID), 
        add constraint FKB96829BBD1E9611 
        foreign key (CITY_ID) 
        references CITIES (ID);

    alter table HOTELS 
        add index FK7F5D693FDA225571 (HOTELCHAIN_ID), 
        add constraint FK7F5D693FDA225571 
        foreign key (HOTELCHAIN_ID) 
        references HOTELCHAINS (ID);

    alter table HOTELS 
        add index FK7F5D693FD7D61A43 (AIRPORT_ID), 
        add constraint FK7F5D693FD7D61A43 
        foreign key (AIRPORT_ID) 
        references AIRPORTS (ID);

    alter table HOTELS 
        add index FK7F5D693FD1E9611 (CITY_ID), 
        add constraint FK7F5D693FD1E9611 
        foreign key (CITY_ID) 
        references CITIES (ID);

    alter table INSURANCES 
        add index FKA3E420D91E8F2F83 (TRAVELLER_ID), 
        add constraint FKA3E420D91E8F2F83 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table ITINERARIES 
        add index FK5D251EC9C1D958D1 (CURRENCY_ID), 
        add constraint FK5D251EC9C1D958D1 
        foreign key (CURRENCY_ID) 
        references CURRENCIES (ID);

    alter table ITINERARIES 
        add index FK5D251EC91E8F2F83 (TRAVELLER_ID), 
        add constraint FK5D251EC91E8F2F83 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table MEDICALASSESSMENTS 
        add index FK296ECEC01E8F2F83 (TRAVELLER_ID), 
        add constraint FK296ECEC01E8F2F83 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table MEDICALASSESSMENTS 
        add index FK296ECEC084982263 (COUNTRY_ID), 
        add constraint FK296ECEC084982263 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

    alter table NONEMPLOYMENTDETAILS 
        add index FK5A8FCDA9981A379C (CORP_SUPV_ID), 
        add constraint FK5A8FCDA9981A379C 
        foreign key (CORP_SUPV_ID) 
        references SUPERVISORS (ID);

    alter table NONEMPLOYMENTDETAILS 
        add index FK5A8FCDA91E8F2F83 (TRAVELLER_ID), 
        add constraint FK5A8FCDA91E8F2F83 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table OTHERRESERVATIONS 
        add index FKB6AFBD17C1D958D1 (CURRENCY_ID), 
        add constraint FKB6AFBD17C1D958D1 
        foreign key (CURRENCY_ID) 
        references CURRENCIES (ID);

    alter table OTHERRESERVATIONS 
        add index FKB6AFBD17EAD2D4D0 (ID), 
        add constraint FKB6AFBD17EAD2D4D0 
        foreign key (ID) 
        references RESERVATIONS (ID);

    alter table OTHERRESERVATIONS 
        add index FKB6AFBD17D1E9611 (CITY_ID), 
        add constraint FKB6AFBD17D1E9611 
        foreign key (CITY_ID) 
        references CITIES (ID);

    alter table PASSPORTS 
        add index FK6E6306811E8F2F83 (TRAVELLER_ID), 
        add constraint FK6E6306811E8F2F83 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table PASSPORTS 
        add index FK6E63068184982263 (COUNTRY_ID), 
        add constraint FK6E63068184982263 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

    alter table PERSONALDETAILS 
        add index FK3EBADFE2C299E5E3 (BIRTH_COUNTRY_ID), 
        add constraint FK3EBADFE2C299E5E3 
        foreign key (BIRTH_COUNTRY_ID) 
        references COUNTRIES (ID);

    alter table PERSONALDETAILS 
        add index FK3EBADFE21E8F2F83 (TRAVELLER_ID), 
        add constraint FK3EBADFE21E8F2F83 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table RESERVATIONS 
        add index FK41F21E2729983C03 (ITINERARY_ID), 
        add constraint FK41F21E2729983C03 
        foreign key (ITINERARY_ID) 
        references ITINERARIES (ID);

    alter table SECURITYORIENTATIONS 
        add index FKD1E233E31E8F2F83 (TRAVELLER_ID), 
        add constraint FKD1E233E31E8F2F83 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table SECURITYORIENTATIONS 
        add index FKD1E233E384982263 (COUNTRY_ID), 
        add constraint FKD1E233E384982263 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

    alter table SECURITYPROFILES 
        add index FK3BE5C32A1E8F2F83 (TRAVELLER_ID), 
        add constraint FK3BE5C32A1E8F2F83 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table SOSCOVERAGES 
        add index FKC119CBD41E8F2F83 (TRAVELLER_ID), 
        add constraint FKC119CBD41E8F2F83 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table STATES 
        add index FK9260C20284982263 (COUNTRY_ID), 
        add constraint FK9260C20284982263 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

    alter table USERPROFILES 
        add index FK1CC184B5C1D958D1 (CURRENCY_ID), 
        add constraint FK1CC184B5C1D958D1 
        foreign key (CURRENCY_ID) 
        references CURRENCIES (ID);

    alter table VACCINATIONS 
        add index FK51E98ACE1E8F2F83 (TRAVELLER_ID), 
        add constraint FK51E98ACE1E8F2F83 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table VEHICLERESERVATIONS 
        add index FK32750733C1D958D1 (CURRENCY_ID), 
        add constraint FK32750733C1D958D1 
        foreign key (CURRENCY_ID) 
        references CURRENCIES (ID);

    alter table VEHICLERESERVATIONS 
        add index FK32750733EAD2D4D0 (ID), 
        add constraint FK32750733EAD2D4D0 
        foreign key (ID) 
        references RESERVATIONS (ID);

    alter table VEHICLERESERVATIONS 
        add index FK32750733D1E9611 (CITY_ID), 
        add constraint FK32750733D1E9611 
        foreign key (CITY_ID) 
        references CITIES (ID);

    alter table VISAS 
        add index FK4DE54321E8F2F83 (TRAVELLER_ID), 
        add constraint FK4DE54321E8F2F83 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table VISAS 
        add index FK4DE543284982263 (COUNTRY_ID), 
        add constraint FK4DE543284982263 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

    create table RESERVATIONS_SEQ (
         NEXTVAL integer 
    );

    insert into RESERVATIONS_SEQ values ( 0 );
