    drop table if exists FLIGHTRESERVATIONS;
    drop table if exists HOTELRESERVATIONS;
    drop table if exists OTHERRESERVATIONS;
    drop table if exists VEHICLERESERVATIONS;
    drop table if exists RESERVATIONS;
    drop table if exists SECURITIES;
    drop table if exists ITINERARIES;
    drop table if exists MEDICALASSESSMENTS;
    drop table if exists OTHERTRAVELDOCS;
    drop table if exists VACCINATIONS;
    drop table if exists PASSPORTS;
    drop table if exists VISAS;
    drop table if exists INSURANCES;
    
    drop table if exists TRAVELLERS;
    drop table if exists CONTRACTORS;
    drop table if exists EMPLOYEES;
    drop table if exists PEOPLE;

    drop table if exists FARESCHEDULES;
    drop table if exists FLIGHTROUTES;
    drop table if exists FLIGHTDEPARTURES;

    drop table if exists HOTELFACILITIES;
    drop table if exists HOTELS;
    drop table if exists HOTELCHAINS;

    drop table if exists AIRPORTS;
    drop table if exists CITIES;
    drop table if exists STATES;
    drop table if exists COUNTRIES;
    drop table if exists CURRENCIES;
    drop table if exists WORLDAREAS;

    drop table if exists AIRCRAFTMODELS;
    drop table if exists AIRLINES;

    drop table if exists METADATA;
    drop table if exists USERPROFILES;
    drop table if exists VISATYPES;
    drop table if exists TYPES;
    drop table if exists ADMINASSISTANTS;

    drop table if exists HIBERNATESEQ;

    create table ADMINASSISTANTS (
        ID bigint not null auto_increment,
        FIRST_NAME varchar(40),
        LAST_NAME varchar(40),
        EMAIL varchar(40),
        OFFICE_PHONE varchar(20),
        CELL_PHONE varchar(20),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table AIRCRAFTMODELS (
        ID bigint not null auto_increment,
        MODEL_NAME varchar(40),
        MODEL_TYPE varchar(80),
        DESCRIPTION varchar(20),
        MANUFACTURER varchar(40),
        PHOTO_FILENAME varchar(40),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table AIRLINES (
        ID bigint not null auto_increment,
        CODE varchar(8),
        NAME varchar(40),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table AIRPORTS (
        ID bigint not null auto_increment,
        IATA_CODE varchar(6),
        NAME varchar(40),
        CITY_ID bigint,
        DESCRIPTION varchar(80),
        LATITUDE float,
        LONGITUDE float,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table CITIES (
        ID bigint not null auto_increment,
        NAME varchar(40),
        COUNTRY_ID bigint,
        STATE_ID bigint,
        TIMEZONE float,
        LATITUDE float,
        LONGITUDE float,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table CONTRACTORS (
        ID bigint not null auto_increment,
        PERSON_ID bigint,
        TITLE varchar(40),
        COMPANY varchar(80),
        EMAIL varchar(40),
        OFFICE_PHONE varchar(20),
        SUPV_EMAIL varchar(40),
        SUPV_NAME varchar(40),
        SUPV_PHONE varchar(20),
        COST_CENTRE varchar(40),
        CORP_CONTACT_EMAIL varchar(40),
        CORP_CONTACT_NAME varchar(40),
        CONTRACT_EFFECTIVE datetime,
        CONTRACT_EXPIRY datetime,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table COUNTRIES (
        ID bigint not null auto_increment,
        NAME varchar(40),
        WORLDAREA_ID bigint,
        CURRENCY_ID bigint,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table CURRENCIES (
        ID bigint not null auto_increment,
        CURRENCY_CODE varchar(8),
        NAME varchar(40),
        EXCH_RATE_TO_1_USD float,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table EMPLOYEES (
        ID bigint not null auto_increment,
        PERSON_ID bigint,
        TITLE varchar(40),
        DEPT varchar(40),
        BUS_UNIT varchar(40),
        DIVISION varchar(40),
        EMAIL varchar(40),
        ASST_ID bigint,
        EMPL_NUM varchar(40),
        OFFICE_FAX varchar(20),
        OFFICE_PHONE varchar(20),
        COST_CENTER varchar(40),
        SUPV_NAME varchar(40),
        SUPV_EMAIL varchar(40),
        SUPV_PHONE varchar(20),
        START_DATE datetime,
        TERMINATION_DATE datetime,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table FARESCHEDULES (
        ID bigint not null auto_increment,
        FLIGHT_ROUTE_ID bigint,
        FARE_CATEGORY varchar(6),
        CABIN_CLASS varchar(6),
        STANDARD_PRICE float,
        TAX_RATE float,
        OTHER_FEE float,
        START_DATE datetime,
        END_DATE datetime,
        ENDORSEMENTS varchar(240),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table FLIGHTDEPARTURES (
        ID bigint not null auto_increment,
        FLIGHTROUTE_ID bigint,
        DEPARTURE_DATE datetime,
        DEPARTURE_TIME varchar(8),
        ARRIVAL_DATE datetime,
        ARRIVAL_TIME varchar(255),
        FLIGHT_STATUS varchar(6),
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table FLIGHTRESERVATIONS (
        ID bigint not null,
        FARESCHEDULE_ID bigint,
        FLIGHTDEPARTURE_ID bigint,
        COST float,
        CURRENCY_ID bigint,
        COMMENTS varchar(400),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table FLIGHTROUTES (
        ID bigint not null auto_increment,
        AIRLINE_ID bigint,
        ORIGIN_AIRPORT_ID bigint,
        DEST_AIRPORT_ID bigint,
        FLIGHT_NUMBER varchar(8),
        FLIGHT_CATEGORY varchar(6),
        FLIGHT_DISTANCE integer,
        AVAILABLE_DAYS varchar(7),
        LOCATOR varchar(12),
        MEAL bit,
        MOVIE bit,
        NUMBER_OF_STOPS integer,
        SYSTEM varchar(6),
        AIRCRAFTMODEL_ID bigint,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table HOTELCHAINS (
        ID bigint not null auto_increment,
        NAME varchar(40),
        ACTIVE bit,
        PREFERRED_ORDER integer,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table HOTELFACILITIES (
        ID bigint not null auto_increment,
        HOTEL_ID bigint,
        FACILITY_TYPE varchar(6),
        DESCRIPTION varchar(400),
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table HOTELRESERVATIONS (
        ID bigint not null,
        HOTEL_ID bigint,
        OTHER_HOTEL varchar(120),
        ARRIVAL_DATE datetime,
        CHECKOUT_DATE datetime,
        CITY_ID bigint,
        COST float,
        CURRENCY_ID bigint,
        ROOM_TYPE varchar(80),
        COMMENTS varchar(400),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table HOTELS (
        ID bigint not null auto_increment,
        HOTELCHAIN_ID bigint,
        NAME varchar(40),
        LOCATION varchar(6),
        CITY_ID bigint,
        AIRPORT_ID bigint,
        ACTIVE bit,
        ADDRESS varchar(200),
        ADDRESS2 varchar(80),
        ADDRESS3 varchar(80),
        ADDRESS4 varchar(80),
        COMMENTS varchar(400),
        PHONE varchar(20),
        FAX varchar(20),
        URL varchar(240),
        LATITUDE double precision,
        LONGITUDE double precision,
        PHOTO_FILENAME varchar(40),
        PREFERRED_ORDER integer,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table INSURANCES (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table ITINERARIES (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        DEPART_DATE datetime,
        RETURN_DATE datetime,
        PNR_LOCATOR varchar(8),
        PURPOSE varchar(240),
        CONTACT varchar(240),
        AUTH_ID bigint,
        INTERNATIONAL bit,
        RESERVATION_DATE datetime,
        TICKET_NUMBER integer,
        FLIGHT_COST float,
        HOTEL_COST float,
        VEHICLE_COST float,
        OTHER_COST float,
        TOTAL_COST float,
        CURRENCY_ID bigint,
        TRIP_DAYS integer,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table MEDICALASSESSMENTS (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        COUNTRY_ID bigint,
        ASSESSMENT_TYPE varchar(80),
        ASSESSMENT_DATE datetime,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table METADATA (
        ID bigint not null auto_increment,
        META_KEY varchar(40) not null,
        STR_VALUE varchar(80),
        DATE_VALUE datetime,
        NUM_VALUE integer,
        BOOL_VALUE bit,
        BLOB_VALUE longblob,
        SUPP_INFO varchar(80),
        META_DESC varchar(80),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table OTHERRESERVATIONS (
        ID bigint not null,
        RESV_DATE datetime,
        CITY_ID bigint,
        COST float,
        CURRENCY_ID bigint,
        COMMENTS varchar(400),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table OTHERTRAVELDOCS (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        COUNTRY_ID bigint,
        DOC_TYPE varchar(80),
        DOC_ID varchar(80),
        EXPIRY_DATE datetime,
        REMIND_ON_EXPIRY bit,
        LAST_REMINDER_DATE datetime,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table PASSPORTS (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        COUNTRY_ID bigint,
        PP_NUMBER varchar(80),
        FIRST_NAME varchar(40),
        MIDDLE_NAME varchar(40),
        LAST_NAME varchar(40),
        EXPIRY_DATE datetime,
        REMIND_ON_EXPIRY bit,
        LAST_REMINDER_DATE datetime,
        ISSUED varchar(80),
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table PEOPLE (
        ID bigint not null auto_increment,
        FIRST_NAME varchar(40),
        LAST_NAME varchar(40),
        BIRTH_DATE datetime,
        BIRTH_PLACE varchar(80),
        BIRTH_COUNTRY_ID bigint,
        HOME_PHONE varchar(20),
        CELL_PHONE varchar(20),
        EMAIL varchar(40),
        BLOOD_TYPE varchar(8),
        STAFF bit,
        CONTRACT bit,
        DEPENDANT bit,
        EXPAT bit,
        GUEST bit,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table RESERVATIONS (
        ID bigint not null,
        ITINERARY_ID bigint,
        RES_TYPE varchar(255),
        RESV_ORDER integer,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table SECURITIES (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table STATES (
        ID bigint not null auto_increment,
        ABBREV varchar(6),
        NAME varchar(40),
        COUNTRY_ID bigint,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table TRAVELLERS (
        ID bigint not null auto_increment,
        PERSON_ID bigint unique,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table TYPES (
        ID bigint not null auto_increment,
        DTYPE varchar(31) not null,
        NAME varchar(80),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table USERPROFILES (
        ID bigint not null auto_increment,
        USER_ID varchar(50) not null,
        CURRENCY_ID bigint,
        TIME_ZONE integer,
        DATE_FORMAT varchar(20) not null,
        EMAIL_ADDRESS varchar(40),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table VACCINATIONS (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        VACCINATION_TYPE varchar(80),
        VACCINATION_DATE datetime,
        EXPIRY_DATE datetime,
        BOOSTER1_DUE_DATE datetime,
        HAD_BOOSTER_1 bit,
        BOOSTER2_DUE_DATE datetime,
        HAD_BOOSTER_2 bit,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table VEHICLERESERVATIONS (
        ID bigint not null,
        CITY_ID bigint,
        START_DATE datetime,
        END_DATE datetime,
        VEH_TYPE varchar(80),
        RENTAL_AGENCY varchar(300),
        COST float,
        CURRENCY_ID bigint,
        COMMENTS varchar(400),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table VISAS (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        COUNTRY_ID bigint,
        VISA_TYPE varchar(80),
        VISA_ID varchar(80),
        EXPIRY_DATE datetime,
        REMIND_ON_EXPIRY bit,
        LAST_REMINDER_DATE datetime,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table VISATYPES (
        ID bigint not null auto_increment,
        TYPE_CODE varchar(20),
        DESCRIPTION varchar(400),
        ENABLED bit,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        primary key (ID)
    ) ENGINE=InnoDB;

    create table WORLDAREAS (
        ID bigint not null auto_increment,
        NAME varchar(40),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
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

    alter table CONTRACTORS 
        add index FK1C2C07ECA962411 (PERSON_ID), 
        add constraint FK1C2C07ECA962411 
        foreign key (PERSON_ID) 
        references PEOPLE (ID);

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

    alter table EMPLOYEES 
        add index FK4351FF65CA962411 (PERSON_ID), 
        add constraint FK4351FF65CA962411 
        foreign key (PERSON_ID) 
        references PEOPLE (ID);

    alter table EMPLOYEES 
        add index FK4351FF6549C0DE8D (ASST_ID), 
        add constraint FK4351FF6549C0DE8D 
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

    alter table OTHERTRAVELDOCS 
        add index FKF60F0B451E8F2F83 (TRAVELLER_ID), 
        add constraint FKF60F0B451E8F2F83 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table OTHERTRAVELDOCS 
        add index FKF60F0B4584982263 (COUNTRY_ID), 
        add constraint FKF60F0B4584982263 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

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

    alter table PEOPLE 
        add index FK8C75268FC299E5E3 (BIRTH_COUNTRY_ID), 
        add constraint FK8C75268FC299E5E3 
        foreign key (BIRTH_COUNTRY_ID) 
        references COUNTRIES (ID);

    alter table RESERVATIONS 
        add index FK41F21E2729983C03 (ITINERARY_ID), 
        add constraint FK41F21E2729983C03 
        foreign key (ITINERARY_ID) 
        references ITINERARIES (ID);

    alter table SECURITIES 
        add index FK7ABB63DE1E8F2F83 (TRAVELLER_ID), 
        add constraint FK7ABB63DE1E8F2F83 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table STATES 
        add index FK9260C20284982263 (COUNTRY_ID), 
        add constraint FK9260C20284982263 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

    alter table TRAVELLERS 
        add index FK4599EF94CA962411 (PERSON_ID), 
        add constraint FK4599EF94CA962411 
        foreign key (PERSON_ID) 
        references PEOPLE (ID);

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

    create table HIBERNATESEQ (
         NEXTVAL integer 
    ) ENGINE=InnoDB;

    insert into HIBERNATESEQ values ( 0 );
