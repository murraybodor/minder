
    drop table if exists AIRCRAFTMODELS;

    drop table if exists AIRLINES;

    drop table if exists AIRPORTS;

    drop table if exists CITIES;

    drop table if exists CODES;

    drop table if exists COUNTRIES;

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

    drop table if exists TRAVELCOORDS;

    drop table if exists TRAVELLERS;

    drop table if exists TYPES;

    drop table if exists VACCINATIONS;

    drop table if exists VEHICLERESERVATIONS;

    drop table if exists VISAS;

    drop table if exists WORLDAREAS;

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
        CURRENCY varchar(10),
        FLAG_PHOTO_FILENAME varchar(40),
        NAME varchar(40),
        WORLDAREA_ID bigint,
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
        TITLE varchar(40),
        ASST_ID bigint,
        PERSON_ID bigint,
        SUPV_ID bigint,
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
        ARRIVAL_DATETIME datetime,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
        DEPARTURE_DATETIME datetime,
        FLIGHT_STATUS varchar(6),
        FLIGHTROUTE_ID bigint,
        primary key (ID)
    );

    create table FLIGHTRESERVATIONS (
        ID bigint not null,
        ITINERARY_ID bigint,
        ASSIGNED_SEAT varchar(6),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
        PRICE_PAID float,
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
        ID bigint not null,
        ITINERARY_ID bigint,
        ARRIVAL_DATE datetime,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
        CURRENCY varchar(6),
        NUMBER_OF_NIGHTS integer,
        NUMBER_OF_ROOMS integer,
        ROOM_RATE float,
        ROOM_TYPE varchar(6),
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
        CITY_ID bigint unique,
        AIRPORT_ID bigint unique,
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
        FLIGHT_COSTS float,
        HOTEL_COSTS float,
        INTERNATIONAL bit,
        OTHER_COSTS float,
        PNR_LOCATOR varchar(8),
        PURPOSE varchar(240),
        RESERVATION_DATE datetime,
        TICKET_NUMBER integer,
        TRIP_DAYS integer,
        VEHICLE_COSTS float,
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
        ID bigint not null,
        ITINERARY_ID bigint,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        COMMENTS text,
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
        PHONE_HOME varchar(20),
        BIRTH_CITY_ID bigint,
        BIRTH_COUNTRY_ID bigint,
        primary key (ID)
    );

    create table RESERVATIONS (
        ID bigint not null,
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

    create table TRAVELCOORDS (
        ID bigint not null auto_increment,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        INITIALS varchar(4),
        EMPLOYEE_ID bigint,
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
        ID bigint not null,
        ITINERARY_ID bigint,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        DAY_RATE float,
        END_DATE datetime,
        START_DATE datetime,
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
        add index FK64D2D08FBE9D532 (CITY_ID), 
        add constraint FK64D2D08FBE9D532 
        foreign key (CITY_ID) 
        references CITIES (ID);

    alter table CITIES 
        add index FK7680AF49EE886689 (STATE_ID), 
        add constraint FK7680AF49EE886689 
        foreign key (STATE_ID) 
        references STATES (ID);

    alter table CITIES 
        add index FK7680AF493A9F83A2 (COUNTRY_ID), 
        add constraint FK7680AF493A9F83A2 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

    alter table COUNTRIES 
        add index FKF6B7AA948A8F9522 (WORLDAREA_ID), 
        add constraint FKF6B7AA948A8F9522 
        foreign key (WORLDAREA_ID) 
        references WORLDAREAS (ID);

    alter table EMPLOYEES 
        add index FK4351FF656012D6D8 (SUPV_ID), 
        add constraint FK4351FF656012D6D8 
        foreign key (SUPV_ID) 
        references EMPLOYEES (ID);

    alter table EMPLOYEES 
        add index FK4351FF65338E1EF2 (PERSON_ID), 
        add constraint FK4351FF65338E1EF2 
        foreign key (PERSON_ID) 
        references PEOPLE (ID);

    alter table EMPLOYEES 
        add index FK4351FF65A4A258CD (ASST_ID), 
        add constraint FK4351FF65A4A258CD 
        foreign key (ASST_ID) 
        references EMPLOYEES (ID);

    alter table FARESCHEDULES 
        add index FK517F542E79F80B21 (FLIGHT_ROUTE_ID), 
        add constraint FK517F542E79F80B21 
        foreign key (FLIGHT_ROUTE_ID) 
        references FLIGHTROUTES (ID);

    alter table FLIGHTDEPARTURES 
        add index FK3E18AE6F5D8C74A2 (FLIGHTROUTE_ID), 
        add constraint FK3E18AE6F5D8C74A2 
        foreign key (FLIGHTROUTE_ID) 
        references FLIGHTROUTES (ID);

    alter table FLIGHTRESERVATIONS 
        add index FKFC156E97802D6CC2 (FLIGHTDEPARTURE_ID), 
        add constraint FKFC156E97802D6CC2 
        foreign key (FLIGHTDEPARTURE_ID) 
        references FLIGHTDEPARTURES (ID);

    alter table FLIGHTRESERVATIONS 
        add index FK41F21E277B4C4982fc156e97 (ITINERARY_ID), 
        add constraint FK41F21E277B4C4982fc156e97 
        foreign key (ITINERARY_ID) 
        references ITINERARIES (ID);

    alter table FLIGHTRESERVATIONS 
        add index FKFC156E97E9696B12 (FARESCHEDULE_ID), 
        add constraint FKFC156E97E9696B12 
        foreign key (FARESCHEDULE_ID) 
        references FARESCHEDULES (ID);

    alter table FLIGHTROUTES 
        add index FK39B2EFBAAFC662A2 (AIRLINE_ID), 
        add constraint FK39B2EFBAAFC662A2 
        foreign key (AIRLINE_ID) 
        references AIRLINES (ID);

    alter table FLIGHTROUTES 
        add index FK39B2EFBA18A54E3B (ORIGIN_AIRPORT_ID), 
        add constraint FK39B2EFBA18A54E3B 
        foreign key (ORIGIN_AIRPORT_ID) 
        references AIRPORTS (ID);

    alter table FLIGHTROUTES 
        add index FK39B2EFBAA64CB93F (DEST_AIRPORT_ID), 
        add constraint FK39B2EFBAA64CB93F 
        foreign key (DEST_AIRPORT_ID) 
        references AIRPORTS (ID);

    alter table FLIGHTROUTES 
        add index FK39B2EFBA3F103062 (AIRCRAFTMODEL_ID), 
        add constraint FK39B2EFBA3F103062 
        foreign key (AIRCRAFTMODEL_ID) 
        references AIRCRAFTMODELS (ID);

    alter table HOTELFACILITIES 
        add index FKBFD2EF15C55130E2 (HOTEL_ID), 
        add constraint FKBFD2EF15C55130E2 
        foreign key (HOTEL_ID) 
        references HOTELS (ID);

    alter table HOTELRESERVATIONS 
        add index FKB96829BBC55130E2 (HOTEL_ID), 
        add constraint FKB96829BBC55130E2 
        foreign key (HOTEL_ID) 
        references HOTELS (ID);

    alter table HOTELRESERVATIONS 
        add index FK41F21E277B4C4982b96829bb (ITINERARY_ID), 
        add constraint FK41F21E277B4C4982b96829bb 
        foreign key (ITINERARY_ID) 
        references ITINERARIES (ID);

    alter table HOTELS 
        add index FK7F5D693FBEEFF7D2 (HOTELCHAIN_ID), 
        add constraint FK7F5D693FBEEFF7D2 
        foreign key (HOTELCHAIN_ID) 
        references HOTELCHAINS (ID);

    alter table HOTELS 
        add index FK7F5D693F8DDD7B82 (AIRPORT_ID), 
        add constraint FK7F5D693F8DDD7B82 
        foreign key (AIRPORT_ID) 
        references AIRPORTS (ID);

    alter table HOTELS 
        add index FK7F5D693FFBE9D532 (CITY_ID), 
        add constraint FK7F5D693FFBE9D532 
        foreign key (CITY_ID) 
        references CITIES (ID);

    alter table INSURANCES 
        add index FKA3E420D970433D02 (TRAVELLER_ID), 
        add constraint FKA3E420D970433D02 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table ITINERARIES 
        add index FK5D251EC970433D02 (TRAVELLER_ID), 
        add constraint FK5D251EC970433D02 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table MEDICALASSESSMENTS 
        add index FK296ECEC070433D02 (TRAVELLER_ID), 
        add constraint FK296ECEC070433D02 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table MEDICALASSESSMENTS 
        add index FK296ECEC03A9F83A2 (COUNTRY_ID), 
        add constraint FK296ECEC03A9F83A2 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

    alter table OTHERRESERVATIONS 
        add index FK41F21E277B4C4982b6afbd17 (ITINERARY_ID), 
        add constraint FK41F21E277B4C4982b6afbd17 
        foreign key (ITINERARY_ID) 
        references ITINERARIES (ID);

    alter table PASSPORTS 
        add index FK6E63068170433D02 (TRAVELLER_ID), 
        add constraint FK6E63068170433D02 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table PASSPORTS 
        add index FK6E6306813A9F83A2 (COUNTRY_ID), 
        add constraint FK6E6306813A9F83A2 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

    alter table PEOPLE 
        add index FK8C75268F78A14722 (BIRTH_COUNTRY_ID), 
        add constraint FK8C75268F78A14722 
        foreign key (BIRTH_COUNTRY_ID) 
        references COUNTRIES (ID);

    alter table PEOPLE 
        add index FK8C75268F396AC1B2 (BIRTH_CITY_ID), 
        add constraint FK8C75268F396AC1B2 
        foreign key (BIRTH_CITY_ID) 
        references CITIES (ID);

    alter table RESERVATIONS 
        add index FK41F21E277B4C4982 (ITINERARY_ID), 
        add constraint FK41F21E277B4C4982 
        foreign key (ITINERARY_ID) 
        references ITINERARIES (ID);

    alter table SECURITIES 
        add index FK7ABB63DE70433D02 (TRAVELLER_ID), 
        add constraint FK7ABB63DE70433D02 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table STATES 
        add index FK9260C2023A9F83A2 (COUNTRY_ID), 
        add constraint FK9260C2023A9F83A2 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

    alter table TRAVELCOORDS 
        add index FK380C4FB8519BE52 (EMPLOYEE_ID), 
        add constraint FK380C4FB8519BE52 
        foreign key (EMPLOYEE_ID) 
        references EMPLOYEES (ID);

    alter table TRAVELLERS 
        add index FK4599EF94338E1EF2 (PERSON_ID), 
        add constraint FK4599EF94338E1EF2 
        foreign key (PERSON_ID) 
        references PEOPLE (ID);

    alter table VACCINATIONS 
        add index FK51E98ACE70433D02 (TRAVELLER_ID), 
        add constraint FK51E98ACE70433D02 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table VEHICLERESERVATIONS 
        add index FK41F21E277B4C498232750733 (ITINERARY_ID), 
        add constraint FK41F21E277B4C498232750733 
        foreign key (ITINERARY_ID) 
        references ITINERARIES (ID);

    alter table VISAS 
        add index FK4DE543270433D02 (TRAVELLER_ID), 
        add constraint FK4DE543270433D02 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table VISAS 
        add index FK4DE54323A9F83A2 (COUNTRY_ID), 
        add constraint FK4DE54323A9F83A2 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);
