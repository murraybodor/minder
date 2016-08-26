
    alter table AIRPORTS 
        drop 
        foreign key FK64D2D08D1E9611;

    alter table CITIES 
        drop 
        foreign key FK7680AF4992867813;

    alter table CITIES 
        drop 
        foreign key FK7680AF4984982263;

    alter table COUNTRIES 
        drop 
        foreign key FKF6B7AA94C1D958D1;

    alter table COUNTRIES 
        drop 
        foreign key FKF6B7AA9438DB87A3;

    alter table EMPLOYEES 
        drop 
        foreign key FK4351FF65CA962411;

    alter table EMPLOYEES 
        drop 
        foreign key FK4351FF6549C0DE8D;

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
        foreign key FK5D251EC91E8F2F83;

    alter table MEDICALASSESSMENTS 
        drop 
        foreign key FK296ECEC01E8F2F83;

    alter table MEDICALASSESSMENTS 
        drop 
        foreign key FK296ECEC084982263;

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

    alter table PEOPLE 
        drop 
        foreign key FK8C75268FC299E5E3;

    alter table PEOPLE 
        drop 
        foreign key FK8C75268F4A9F8291;

    alter table RESERVATIONS 
        drop 
        foreign key FK41F21E2729983C03;

    alter table SECURITIES 
        drop 
        foreign key FK7ABB63DE1E8F2F83;

    alter table STATES 
        drop 
        foreign key FK9260C20284982263;

    alter table TRAVELLERS 
        drop 
        foreign key FK4599EF94CA962411;

    alter table USERS 
        drop 
        foreign key FK4D495E8301DA7F1;

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

    drop table if exists AUTHORITIES;

    drop table if exists CITIES;

    drop table if exists CODES;

    drop table if exists COUNTRIES;

    drop table if exists CURRENCIES;

    drop table if exists EMPLOYEES;

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

    drop table if exists OTHERRESERVATIONS;

    drop table if exists PASSPORTS;

    drop table if exists PEOPLE;

    drop table if exists RESERVATIONS;

    drop table if exists SECURITIES;

    drop table if exists STATES;

    drop table if exists TENANTS;

    drop table if exists TRAVELLERS;

    drop table if exists TYPES;

    drop table if exists USERS;

    drop table if exists VACCINATIONS;

    drop table if exists VEHICLERESERVATIONS;

    drop table if exists VISAS;

    drop table if exists WORLDAREAS;

    drop table if exists HIBERNATESEQ;

    create table ADMINASSISTANTS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        EMAIL varchar(40),
        INITIALS varchar(6),
        NAME varchar(40),
        PHONE varchar(20),
        primary key (ID)
    );

    create table AIRCRAFTMODELS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        DESCRIPTION varchar(20),
        MANUFACTURER varchar(40),
        MODEL_NAME varchar(40),
        PHOTO_FILENAME varchar(40),
        MODEL_TYPE varchar(40),
        primary key (ID)
    );

    create table AIRLINES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        CODE varchar(8),
        NAME varchar(40),
        primary key (ID)
    );

    create table AIRPORTS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        DESCRIPTION varchar(80),
        IATA_CODE varchar(6),
        NAME varchar(40),
        CITY_ID bigint,
        primary key (ID)
    );

    create table AUTHORITIES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        AUTHORITY varchar(50) not null,
        USER_ID varchar(50) not null,
        primary key (ID)
    );

    create table CITIES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        NAME varchar(40),
        TIMEZONE integer,
        COUNTRY_ID bigint,
        STATE_ID bigint,
        primary key (ID)
    );

    create table CODES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        CODE_TYPE varchar(20) not null,
        CODE_DESC varchar(80),
        CODE_VALUE_DATE datetime,
        CODE_VALUE_NUM integer,
        ORDER_INFO integer,
        CODE_VALUE_STR varchar(20),
        SUPP_INFO varchar(80),
        primary key (ID)
    );

    create table COUNTRIES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        FLAG_PHOTO_FILENAME varchar(40),
        NAME varchar(40),
        CURRENCY_ID bigint,
        WORLDAREA_ID bigint,
        primary key (ID)
    );

    create table CURRENCIES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        CURRENCY_CODE varchar(8),
        EXCH_RATE_TO_1_USD float,
        NAME varchar(40),
        primary key (ID)
    );

    create table EMPLOYEES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        BUS_UNIT varchar(40),
        COMMENTS text,
        COMPANY varchar(40),
        COST_CENTRE varchar(40),
        DEPT varchar(40),
        DIVISION varchar(40),
        EMPL_NUM varchar(40),
        PHONE_OFFICE_1 varchar(20),
        PHONE_OFFICE_2 varchar(20),
        SUPV_APPOVAL_REQD bit,
        SUPV_EMAIL varchar(40),
        SUPV_NAME varchar(40),
        SUPV_PHONE varchar(20),
        TITLE varchar(40),
        ASST_ID bigint,
        PERSON_ID bigint,
        primary key (ID)
    );

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
        FLIGHT_ROUTE_ID bigint,
        primary key (ID)
    );

    create table FLIGHTDEPARTURES (
        ID bigint not null auto_increment,
        ARRIVAL_DATE datetime,
        ARRIVAL_TIME varchar(255),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
        DEPARTURE_DATE datetime,
        DEPARTURE_TIME varchar(8),
        FLIGHT_STATUS varchar(6),
        FLIGHTROUTE_ID bigint,
        primary key (ID)
    );

    create table FLIGHTRESERVATIONS (
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
        COST float,
        ID bigint not null,
        CURRENCY_ID bigint,
        FARESCHEDULE_ID bigint,
        FLIGHTDEPARTURE_ID bigint,
        primary key (ID)
    );

    create table FLIGHTROUTES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        AVAILABLE_DAYS varchar(7),
        COMMENTS text,
        FLIGHT_CATEGORY varchar(6),
        FLIGHT_DISTANCE integer,
        FLIGHT_NUMBER varchar(8),
        LOCATOR varchar(12),
        MEAL bit,
        MOVIE bit,
        NUMBER_OF_STOPS integer,
        SYSTEM varchar(6),
        AIRCRAFTMODEL_ID bigint,
        AIRLINE_ID bigint,
        DEST_AIRPORT_ID bigint,
        ORIGIN_AIRPORT_ID bigint,
        primary key (ID)
    );

    create table HOTELCHAINS (
        ID bigint not null auto_increment,
        ACTIVE bit,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
        NAME varchar(40),
        PREFERRED_ORDER integer,
        primary key (ID)
    );

    create table HOTELFACILITIES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
        DESCRIPTION text,
        FACILITY_TYPE varchar(6),
        HOTEL_ID bigint,
        primary key (ID)
    );

    create table HOTELRESERVATIONS (
        ARRIVAL_DATE datetime,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
        COST float,
        NUMBER_OF_NIGHTS integer,
        NUMBER_OF_ROOMS integer,
        OTHER_HOTEL varchar(120),
        ROOM_TYPE varchar(6),
        ID bigint not null,
        CITY_ID bigint,
        CURRENCY_ID bigint,
        HOTEL_ID bigint,
        primary key (ID)
    );

    create table HOTELS (
        ID bigint not null auto_increment,
        ACTIVE bit,
        ADDRESS varchar(200),
        ADDRESS2 varchar(80),
        ADDRESS3 varchar(80),
        ADDRESS4 varchar(80),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
        FAX varchar(20),
        LOCATION varchar(6),
        NAME varchar(40),
        PHONE varchar(20),
        PHOTO_FILENAME varchar(40),
        PREFERRED_ORDER integer,
        URL varchar(240),
        CITY_ID bigint,
        AIRPORT_ID bigint,
        HOTELCHAIN_ID bigint,
        primary key (ID)
    );

    create table INSURANCES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        TRAVELLER_ID bigint,
        primary key (ID)
    );

    create table ITINERARIES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        AUTH_ID bigint,
        CONTACT varchar(240),
        DEPART_DATE datetime,
        FLIGHT_COST float,
        HOTEL_COST float,
        INTERNATIONAL bit,
        OTHER_COST float,
        PNR_LOCATOR varchar(8),
        PURPOSE varchar(240),
        RESERVATION_DATE datetime,
        TICKET_NUMBER integer,
        TOTAL_COST float,
        TRIP_DAYS integer,
        VEHICLE_COST float,
        TRAVELLER_ID bigint,
        primary key (ID)
    );

    create table MEDICALASSESSMENTS (
        ID bigint not null auto_increment,
        ASSESSMENT_DATE datetime,
        ASSESSMENT_TYPE varchar(20),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
        COUNTRY_ID bigint,
        TRAVELLER_ID bigint,
        primary key (ID)
    );

    create table OTHERRESERVATIONS (
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
        COST float,
        RESV_DATE datetime,
        ID bigint not null,
        CITY_ID bigint,
        CURRENCY_ID bigint,
        primary key (ID)
    );

    create table PASSPORTS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
        EXPIRY_DATE datetime,
        FIRST_NAME varchar(40),
        LAST_NAME varchar(40),
        LAST_REMINDER_DATE datetime,
        MIDDLE_NAME varchar(40),
        PP_NUMBER varchar(80),
        ISSUED varchar(80),
        REMIND_ON_EXPIRY bit,
        COUNTRY_ID bigint,
        TRAVELLER_ID bigint,
        primary key (ID)
    );

    create table PEOPLE (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        BIRTH_DATE datetime,
        BIRTH_PLACE varchar(40),
        COMMENTS text,
        CONTRACT_COMMENTS varchar(240),
        CONTRACT_EFF_DATE datetime,
        CONTRACT_EXP_DATE datetime,
        CONTRACTOR bit,
        DEPENDANT bit,
        EMAIL1 varchar(40),
        EMAIL2 varchar(40),
        EXPAT bit,
        FIRST_NAME varchar(40),
        GUEST bit,
        LAST_NAME varchar(40),
        MIDDLE_NAME varchar(40),
        PHONE_CELL varchar(20),
        PHONE_FAX varchar(20),
        PHONE_HOME varchar(20),
        BIRTH_CITY_ID bigint,
        BIRTH_COUNTRY_ID bigint,
        primary key (ID)
    );

    create table RESERVATIONS (
        ID bigint not null,
        RES_TYPE varchar(255),
        ITINERARY_ID bigint,
        primary key (ID)
    );

    create table SECURITIES (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        TRAVELLER_ID bigint,
        primary key (ID)
    );

    create table STATES (
        ID bigint not null auto_increment,
        ABBREV varchar(6),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        NAME varchar(40),
        COUNTRY_ID bigint,
        primary key (ID)
    );

    create table TENANTS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
        DB_NAME varchar(20),
        LOGO_FILENAME varchar(80),
        TENANT_NAME varchar(80),
        primary key (ID)
    );

    create table TRAVELLERS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
        PERSON_ID bigint unique,
        primary key (ID)
    );

    create table TYPES (
        DTYPE varchar(31) not null,
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        NAME varchar(80),
        primary key (ID)
    );

    create table USERS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        EMAIL_ADDRESS varchar(40),
        ENABLED bit not null,
        PASSWORD varchar(20) not null,
        USER_ID varchar(50) not null,
        TENANT_ID bigint not null,
        primary key (ID)
    );

    create table VACCINATIONS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        BOOSTER1_DUE_DATE datetime,
        BOOSTER2_DUE_DATE datetime,
        COMMENTS text,
        EXPIRY_DATE datetime,
        HAD_BOOSTER_1 bit,
        HAD_BOOSTER_2 bit,
        VACCINATION_TYPE varchar(20),
        VACCINATION_DATE datetime,
        TRAVELLER_ID bigint,
        primary key (ID)
    );

    create table VEHICLERESERVATIONS (
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
        COST float,
        END_DATE datetime,
        RENTAL_AGENCY varchar(80),
        START_DATE datetime,
        VEH_TYPE varchar(80),
        ID bigint not null,
        CITY_ID bigint,
        CURRENCY_ID bigint,
        primary key (ID)
    );

    create table VISAS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
        EXPIRY_DATE datetime,
        LAST_REMINDER_DATE datetime,
        REMIND_ON_EXPIRY bit,
        VISA_TYPE varchar(40),
        COUNTRY_ID bigint,
        TRAVELLER_ID bigint,
        primary key (ID)
    );

    create table WORLDAREAS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        NAME varchar(40),
        primary key (ID)
    );

    alter table AIRPORTS 
        add index FK64D2D08D1E9611 (CITY_ID), 
        add constraint FK64D2D08D1E9611 
        foreign key (CITY_ID) 
        references CITIES (ID);

    alter table CITIES 
        add index FK7680AF4992867813 (STATE_ID), 
        add constraint FK7680AF4992867813 
        foreign key (STATE_ID) 
        references STATES (ID);

    alter table CITIES 
        add index FK7680AF4984982263 (COUNTRY_ID), 
        add constraint FK7680AF4984982263 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

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

    alter table PEOPLE 
        add index FK8C75268F4A9F8291 (BIRTH_CITY_ID), 
        add constraint FK8C75268F4A9F8291 
        foreign key (BIRTH_CITY_ID) 
        references CITIES (ID);

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

    alter table USERS 
        add index FK4D495E8301DA7F1 (TENANT_ID), 
        add constraint FK4D495E8301DA7F1 
        foreign key (TENANT_ID) 
        references TENANTS (ID);

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
    );

    insert into HIBERNATESEQ values ( 0 );
