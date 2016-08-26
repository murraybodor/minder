/*
CREATE DATABASE `auth` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE DATABASE `demo` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
*/

/*************************************************************************************/
    create table ADMINASSISTANTS (
        ID bigint not null auto_increment,
        FIRST_NAME varchar(40),
        LAST_NAME varchar(40),
        OFFICE_PHONE varchar(20),
        CELL_PHONE varchar(20),
        EMAIL varchar(40),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;
    
/*************************************************************************************/
/*    
    create table AIRCRAFTMODELS (
        ID bigint not null auto_increment,
        MODEL_TYPE varchar(80),
        MODEL_NAME varchar(40),
        DESCRIPTION varchar(20),
        MANUFACTURER varchar(40),
        PHOTO_FILENAME varchar(40),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;
*/
/*************************************************************************************/
    create table AIRLINES (
        ID bigint not null auto_increment,
        CODE varchar(8),
        NAME varchar(40),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    
/*************************************************************************************/
    create table CURRENCIES (
        ID bigint not null auto_increment,
        CURRENCY_CODE varchar(8),
        NAME varchar(40),
        EXCH_RATE_TO_1_USD float,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

/*************************************************************************************/
    create table TYPES (
        ID bigint not null auto_increment,
        DTYPE varchar(31) not null,
        NAME varchar(80),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

/*************************************************************************************/
    create table WORLDAREAS (
        ID bigint not null auto_increment,
        NAME varchar(40),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    
/*************************************************************************************/
    create table COUNTRIES (
        ID bigint not null auto_increment,
        WORLDAREA_ID bigint,
        NAME varchar(40),
        CURRENCY_ID bigint,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;


    alter table COUNTRIES 
        add index CTRY_CURR_IDX (CURRENCY_ID), 
        add constraint CTRY_CURR_FK 
        foreign key (CURRENCY_ID) 
        references CURRENCIES (ID);

    alter table COUNTRIES 
        add index CTRY_WA_IDX (WORLDAREA_ID), 
        add constraint CTRY_WA_FK 
        foreign key (WORLDAREA_ID) 
        references WORLDAREAS (ID);
    
/*************************************************************************************/
    create table STATES (
        ID bigint not null auto_increment,
        COUNTRY_ID bigint,
        ABBREV varchar(6),
        NAME varchar(40),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table STATES 
        add index ST_CTRY_IDX (COUNTRY_ID), 
        add constraint ST_CTRY_FK 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);
    
/*************************************************************************************/
    create table CITIES (
        ID bigint not null auto_increment,
        COUNTRY_ID bigint,
        STATE_ID bigint,
        NAME varchar(40),
        TIMEZONE float,
        LATITUDE float,
        LONGITUDE float,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table CITIES 
        add index CITY_STATE_IDX (STATE_ID), 
        add constraint CITY_STATE_FK 
        foreign key (STATE_ID) 
        references STATES (ID);

    alter table CITIES 
        add index CITY_CTRY_IDX (COUNTRY_ID), 
        add constraint CITY_CTRY_FK 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

/*************************************************************************************/
    create table AIRPORTS (
        ID bigint not null auto_increment,
        CITY_ID bigint,
        IATA_CODE varchar(6),
        NAME varchar(40),
        DESCRIPTION varchar(80),
        LATITUDE float,
        LONGITUDE float,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table AIRPORTS 
    	add index AIRP_CITY_IDX (CITY_ID), 
        add constraint AIRP_CITY_FK 
        foreign key (CITY_ID) 
        references CITIES (ID);
    
        
/*************************************************************************************/
    create table HOTELCHAINS (
        ID bigint not null auto_increment,
        NAME varchar(40),
        ACTIVE bit,
        PREFERRED_ORDER integer,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

/*************************************************************************************/
    create table HOTELS (
        ID bigint not null auto_increment,
        CITY_ID bigint,
        AIRPORT_ID bigint,
        HOTELCHAIN_ID bigint,
        NAME varchar(40),
        LOCATION varchar(6),
        ADDRESS varchar(200),
        ADDRESS2 varchar(80),
        ADDRESS3 varchar(80),
        ADDRESS4 varchar(80),
        COMMENTS varchar(400),
        FAX varchar(20),
        LATITUDE double precision,
        LONGITUDE double precision,
        ACTIVE bit,
        PHONE varchar(20),
        PHOTO_FILENAME varchar(40),
        PREFERRED_ORDER integer,
        URL varchar(240),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;
    
    alter table HOTELS 
        add index HOT_HC_IDX (HOTELCHAIN_ID), 
        add constraint HOT_HC_FK 
        foreign key (HOTELCHAIN_ID) 
        references HOTELCHAINS (ID);

    alter table HOTELS 
        add index HOT_AIRP_IDX (AIRPORT_ID), 
        add constraint HOT_AIRP_FK 
        foreign key (AIRPORT_ID) 
        references AIRPORTS (ID);

    alter table HOTELS 
        add index HOT_CITY_IDX (CITY_ID), 
        add constraint HOT_CITY_FK 
        foreign key (CITY_ID) 
        references CITIES (ID);


    
/*************************************************************************************/
    create table HOTELFACILITIES (
        ID bigint not null auto_increment,
        HOTEL_ID bigint,
        FACILITY_TYPE varchar(6),
        DESCRIPTION varchar(400),
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;
    
    alter table HOTELFACILITIES 
        add index HF_HOTEL_IDX (HOTEL_ID), 
        add constraint HF_HOTEL_FK 
        foreign key (HOTEL_ID) 
        references HOTELS (ID);

    
/*************************************************************************************/
    create table METADATA (
        ID bigint not null auto_increment,
        META_KEY varchar(40) not null,
        STR_VALUE varchar(80),
        DATE_VALUE datetime,
        NUM_VALUE integer,
        BOOL_VALUE bit,
        BLOB_VALUE longblob,
        META_DESC varchar(80),
        SUPP_INFO varchar(80),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;
    
/*************************************************************************************/
    create table USERPROFILES (
        ID bigint not null auto_increment,
        USER_ID varchar(50) not null,
        CURRENCY_ID bigint,
        DATE_FORMAT varchar(20) not null,
        EMAIL_ADDRESS varchar(40),
        TIME_ZONE integer,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;
    

    alter table USERPROFILES 
        add index UP_CURR_IDX (CURRENCY_ID), 
        add constraint UP_CURR_FK 
        foreign key (CURRENCY_ID) 
        references CURRENCIES (ID);

/*************************************************************************************/
    create table TRAVELLERS (
        ID bigint not null auto_increment,
        FIRST_NAME varchar(40),
        LAST_NAME varchar(40),
        BIRTH_DATE datetime,
        BIRTH_PLACE varchar(80),
        BIRTH_COUNTRY_ID bigint,
        CELL_PHONE varchar(20),
        HOME_PHONE varchar(20),
        EMAIL varchar(40),
        EMPLOYEE bit,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

        
/*************************************************************************************
    create table PERSONALDETAILS (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        FIRST_NAME varchar(40),
        LAST_NAME varchar(40),
        BIRTH_DATE datetime,
        BIRTH_PLACE varchar(80),
        BIRTH_COUNTRY_ID bigint,
        CELL_PHONE varchar(20),
        HOME_PHONE varchar(20),
        EMAIL varchar(40),
        EMPLOYEE bit,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table PERSONALDETAILS 
        add index PERS_TRAV_IDX (TRAVELLER_ID), 
        add constraint PERS_TRAV_FK 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);
    
    alter table PERSONALDETAILS 
        add index PERS_CTRY_IDX (BIRTH_COUNTRY_ID), 
        add constraint PERS_CTRY_FK 
        foreign key (BIRTH_COUNTRY_ID) 
        references COUNTRIES (ID);
*************************************************************************************/

        
        

/*************************************************************************************/
/*
    create table FLIGHTROUTES (
        ID bigint not null auto_increment,
        AIRLINE_ID bigint,
        FLIGHT_NUMBER varchar(8),
        ORIGIN_AIRPORT_ID bigint,
        DEST_AIRPORT_ID bigint,
        FLIGHT_CATEGORY varchar(6),
        FLIGHT_DISTANCE integer,
        AVAILABLE_DAYS varchar(7),
        LOCATOR varchar(12),
        MEAL bit,
        MOVIE bit,
        CONNECTING bit,
        NUMBER_OF_STOPS integer,
        SYSTEM varchar(6),
        AIRCRAFTMODEL_ID bigint,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table FLIGHTROUTES 
        add index FR_AIR_IDX (AIRLINE_ID), 
        add constraint FR_AIR_FK 
        foreign key (AIRLINE_ID) 
        references AIRLINES (ID);

    alter table FLIGHTROUTES 
        add index FR_OA_IDX (ORIGIN_AIRPORT_ID), 
        add constraint FR_OA_FK 
        foreign key (ORIGIN_AIRPORT_ID) 
        references AIRPORTS (ID);

    alter table FLIGHTROUTES 
        add index FR_DA_IDX (DEST_AIRPORT_ID), 
        add constraint FR_DA_FK 
        foreign key (DEST_AIRPORT_ID) 
        references AIRPORTS (ID);

    alter table FLIGHTROUTES 
        add index FR_MOD_IDX (AIRCRAFTMODEL_ID), 
        add constraint FR_MOD_FK 
        foreign key (AIRCRAFTMODEL_ID) 
        references AIRCRAFTMODELS (ID);
*/        
/*************************************************************************************/
/*    
    create table FARESCHEDULES (
        ID bigint not null auto_increment,
        FLIGHT_ROUTE_ID bigint,
        START_DATE datetime,
        END_DATE datetime,
        CABIN_CLASS varchar(6),
        ENDORSEMENTS varchar(240),
        FARE_CATEGORY varchar(6),
        STANDARD_PRICE float,
        TAX_RATE float,
        OTHER_FEE float,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;
    
    alter table FARESCHEDULES 
        add index FS_FR_IDX (FLIGHT_ROUTE_ID), 
        add constraint FS_FR_FK 
        foreign key (FLIGHT_ROUTE_ID) 
        references FLIGHTROUTES (ID);
*/
/*************************************************************************************/
/*    
    create table FLIGHTDEPARTURES (
        ID bigint not null auto_increment,
        FLIGHTROUTE_ID bigint,
        DEPARTURE_DATE datetime,
        DEPARTURE_TIME_HRS integer,
        DEPARTURE_TIME_MINS integer,
        ARRIVAL_DATE datetime,
        ARRIVAL_TIME_HRS integer,
        ARRIVAL_TIME_MINS integer,
        FLIGHT_STATUS varchar(6),
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table FLIGHTDEPARTURES 
        add index FD_FR_IDX (FLIGHTROUTE_ID), 
        add constraint FD_FR_FK 
        foreign key (FLIGHTROUTE_ID) 
        references FLIGHTROUTES (ID);
*/


/*************************************************************************************/
    create table VISAS (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        COUNTRY_ID bigint,
        VISA_TYPE varchar(80),
        VISA_ID varchar(80),
        ISSUE_DATE datetime,
        EXPIRY_DATE datetime,
        REMIND_ON_EXPIRY bit,
        REMIND_DATE datetime,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table VISAS 
        add index VISA_TRAV_IDX (TRAVELLER_ID), 
        add constraint VISA_TRAV_FK 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table VISAS 
        add index VISA_CTRY_IDX (COUNTRY_ID), 
        add constraint VISA_CTRY_FK 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

/*************************************************************************************/
    create table VACCINATIONS (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        VACCINATION_TYPE varchar(80),
        VACCINATION_DATE datetime,
        EXPIRY_DATE datetime,
        REMIND_ON_EXPIRY bit,
        REMIND_DATE datetime,
        BOOSTER1_DUE_DATE datetime,
        B1_REMIND_DATE datetime,
        BOOSTER2_DUE_DATE datetime,
        B2_REMIND_DATE datetime,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table VACCINATIONS 
        add index VAC_TRAV_IDX (TRAVELLER_ID), 
        add constraint VAC_TRAV_FK 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);
/*************************************************************************************/
    create table PASSPORTS (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        COUNTRY_ID bigint,
        PP_NUMBER varchar(80),
        ISSUE_DATE datetime,
        FIRST_NAME varchar(40),
        MIDDLE_NAME varchar(40),
        LAST_NAME varchar(40),
        PLACE_OF_ISSUE varchar(80),
        EXPIRY_DATE datetime,
        REMIND_ON_EXPIRY bit,
        REMIND_DATE datetime,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;
    
    alter table PASSPORTS 
        add index PP_TRAV_IDX (TRAVELLER_ID), 
        add constraint PP_TRAV_FK 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table PASSPORTS 
        add index PP_CTRY_IDX (COUNTRY_ID), 
        add constraint PP_CTRY_FK 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

/*************************************************************************************/
    create table SOSCOVERAGES (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        PERSONAL_COVERAGE bit,
        CARD_TYPE varchar(80),
        CARD_NUMBER varchar(40),
        ISSUE_DATE datetime,
        EXPIRY_DATE datetime,
        RETURN_DATE datetime,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;
        
    alter table SOSCOVERAGES 
        add index SOS_TRAV_IDX (TRAVELLER_ID), 
        add constraint SOS_TRAV_FK 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);
        
/*************************************************************************************/
    create table SECURITYORIENTATIONS (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        ORIENT_TYPE varchar(80),
        COUNTRY_ID bigint,
        NAME varchar(80),
        ORIENT_DATE datetime,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;
        
    alter table SECURITYORIENTATIONS 
        add index SEC_TRAV_IDX (TRAVELLER_ID), 
        add constraint SEC_TRAV_FK 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table SECURITYORIENTATIONS 
        add index SEC_CTRY_IDX (COUNTRY_ID), 
        add constraint SEC_CTRY_FK 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);

/*************************************************************************************/
    create table SECURITYPROFILES (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        HOME_ADDRESS varchar(1000),
        EMERG_CONTACT1_NAME varchar(240),
        EMERG_CONTACT1_RSHIP varchar(80),
        EMERG_CONTACT1_DAYPHONE varchar(40),
        EMERG_CONTACT1_EVEPHONE varchar(40),
        EMERG_CONTACT1_CELLPHONE varchar(40),
        EMERG_CONTACT1_ALT varchar(80),
        EMERG_CONTACT2_NAME varchar(240),
        EMERG_CONTACT2_RSHIP varchar(80),
        EMERG_CONTACT2_DAYPHONE varchar(40),
        EMERG_CONTACT2_EVEPHONE varchar(40),
        EMERG_CONTACT2_CELLPHONE varchar(40),
        EMERG_CONTACT2_ALT varchar(240),
        DOCTOR_NAME varchar(240),
        DOCTOR_ADDRESS varchar(600),
        DOCTOR_PHONE varchar(40),
        BLOOD_TYPE varchar(8),
        PHARM_NAME varchar(240),
        PHARM_ADDRESS varchar(600),
        PHARM_PHONE varchar(40),
        VITAL_PRESC varchar(600),
        ALLERGIES varchar(600),
        OPTO_NAME varchar(240),
        OPTO_ADDRESS varchar(600),
        OPTO_PHONE varchar(40),
        OPTO_PRESC_LE varchar(8),
        OPTO_PRESC_RE varchar(8),
        GLASSES bit,
        CONTACTS bit,
        CONTACT_SOLN varchar(40),
        VISION_COND varchar(600),
        DENTIST_NAME varchar(240),
        DENTIST_ADDR varchar(400),
        DENTIST_PHONE varchar(40),
        DENTAL_CONDITIONS varchar(600),
        PHYSICAL_DESCRIPTION varchar(1000),
        LIKES varchar(600),
        DISLIKES varchar(600),
        ACTIVITY_PARTICIPATES varchar(600),
        ACTIVITY_DISLIKES varchar(600),
        CODE_PHRASE varchar(600),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;
        
    alter table SECURITYPROFILES 
        add index SECP_TRAV_IDX (TRAVELLER_ID), 
        add constraint SECP_TRAV_FK 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);
        
    
/*************************************************************************************/
     create table MEDICALASSESSMENTS (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        COUNTRY_ID bigint,
        ASSESSMENT_TYPE varchar(80),
        ASSESSMENT_DATE datetime,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table MEDICALASSESSMENTS 
        add index MA_TRAV_IDX (TRAVELLER_ID), 
        add constraint MA_TRV_FK 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table MEDICALASSESSMENTS 
        add index MA_CTRY_IDX (COUNTRY_ID), 
        add constraint MA_CTRY_FK 
        foreign key (COUNTRY_ID) 
        references COUNTRIES (ID);
    
/*************************************************************************************/
    create table INSURANCES (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        INSURANCE_TYPE varchar(80),
        PROVIDER varchar(400),
        POLICY_NUMBER varchar(80),
        ISSUE_DATE datetime,
        EXPIRY_DATE datetime,
        POLICY_CONTACT varchar(80),
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;
    
    
    alter table INSURANCES 
        add index INS_TRAV_IDK (TRAVELLER_ID), 
        add constraint INS_TRAV_FK 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

/*************************************************************************************/
    create table ITINERARIES (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        AUTH_ID varchar(80),
        DEPART_DATE datetime,
        PNR_LOCATOR varchar(8),
        NAME varchar(240),
        PURPOSE varchar(240),
        CONTACT varchar(240),
        RESERVATION_DATE datetime,
        RETURN_DATE datetime,
        INTERNATIONAL bit,
        TICKET_NUMBER integer,
        TRIP_DAYS integer,
        FLIGHT_COST float,
        TAX float,
        TOAL_COST float,
        CURRENCY_ID bigint,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table ITINERARIES 
        add index ITIN_CURR_IDX (CURRENCY_ID), 
        add constraint ITIN_CURR_FK 
        foreign key (CURRENCY_ID) 
        references CURRENCIES (ID);

    alter table ITINERARIES 
        add index ITIN_TRAV_IDX (TRAVELLER_ID), 
        add constraint ITIN_TRAV_FK 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);
        
        
/*************************************************************************************/
/*
    create table RESERVATIONS (
        ID bigint not null,
        ITINERARY_ID bigint,
        RES_TYPE varchar(255),
        RESV_ORDER integer,
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table RESERVATIONS 
        add index RESV_ITIN_IDX (ITINERARY_ID), 
        add constraint RESV_ITIN_FK 
        foreign key (ITINERARY_ID) 
        references ITINERARIES (ID);
*/
        
    create table RESERVATIONS (
        ID bigint not null,
        ITINERARY_ID bigint,
        RES_TYPE varchar(255),
        RESV_ORDER integer,

        AIRLINE_ID bigint,
        FLIGHT_NUMBER varchar(8),
        ORIG_AIRPORT_ID bigint,
        DEST_AIRPORT_ID bigint,
        
        PURPOSE varchar(240),

        CITY_ID bigint,
        HOTEL_ID bigint,
        OTHER_HOTEL varchar(120),
        ROOM_TYPE varchar(80),

        RENTAL_AGENCY varchar(300),
        VEH_TYPE varchar(80),
        
        RESV_BEGIN_DATE datetime,
        RESV_BEGIN_TIME varchar(12),
        RESV_END_DATE datetime,
        RESV_END_TIME varchar(12),
        
        COST float,
        CURRENCY_ID bigint,
        COST_CENTER varchar(40),
        COMMENTS varchar(400),
        FOLLOWUP bit,
        
        CONF 	 varchar(40),
        
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table RESERVATIONS 
        add index RESV_ITIN_IDX (ITINERARY_ID), 
        add constraint RESV_ITIN_FK 
        foreign key (ITINERARY_ID) 
        references ITINERARIES (ID);
        
/*************************************************************************************/
        
    create table COSTALLOCATIONS (
        ID bigint not null auto_increment,
        ITINERARY_ID bigint,
        RESERVATION_ID bigint,
        ALLOC_PCT float,
        COST_CENTER varchar(40),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table COSTALLOCATIONS 
        add index CA_RESV_IDX (RESERVATION_ID);

    alter table COSTALLOCATIONS 
        add constraint CA_RESV_FK 
        foreign key (RESERVATION_ID) 
        references RESERVATIONS (ID);
        
    alter table COSTALLOCATIONS 
        add index CA_ITIN_IDX (ITINERARY_ID), 
        add constraint CA_ITIN_FK 
        foreign key (ITINERARY_ID) 
        references ITINERARIES (ID);
    
/*************************************************************************************/
/*
    create table FLIGHTRESERVATIONS (
        ID bigint not null,
        FARESCHEDULE_ID bigint,
        FLIGHTDEPARTURE_ID bigint,
        COST float,
        CURRENCY_ID bigint,
        COST_CENTER varchar(40),
        COMMENTS varchar(400),
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table FLIGHTRESERVATIONS 
        add index FR_FD_IDX (FLIGHTDEPARTURE_ID), 
        add constraint FR_FD_FK 
        foreign key (FLIGHTDEPARTURE_ID) 
        references FLIGHTDEPARTURES (ID);

    alter table FLIGHTRESERVATIONS 
        add index FR_CURR_IDX (CURRENCY_ID), 
        add constraint FR_CURR_FK 
        foreign key (CURRENCY_ID) 
        references CURRENCIES (ID);

    alter table FLIGHTRESERVATIONS 
        add constraint FR_RESV_FK 
        foreign key (ID) 
        references RESERVATIONS (ID);

    alter table FLIGHTRESERVATIONS 
        add index FR_FS_IDX (FARESCHEDULE_ID), 
        add constraint FR_FS_FK 
        foreign key (FARESCHEDULE_ID) 
        references FARESCHEDULES (ID);

*/        
        
/*************************************************************************************/
/*
   create table HOTELRESERVATIONS (
        ID bigint not null,
        CITY_ID bigint,
        ARRIVAL_DATE datetime,
        CHECKOUT_DATE datetime,
        HOTEL_ID bigint,
        OTHER_HOTEL varchar(120),
        COST float,
        CURRENCY_ID bigint,
        COST_CENTER varchar(40),
        ROOM_TYPE varchar(80),
        COMMENTS varchar(400),
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table HOTELRESERVATIONS 
        add index HR_CURR_IDX (CURRENCY_ID), 
        add constraint HR_CURR_FK 
        foreign key (CURRENCY_ID) 
        references CURRENCIES (ID);

    alter table HOTELRESERVATIONS 
        add constraint HR_RESV_FK 
        foreign key (ID) 
        references RESERVATIONS (ID);

    alter table HOTELRESERVATIONS 
        add index HR_HOT_IDX (HOTEL_ID), 
        add constraint HR_HOT_FK 
        foreign key (HOTEL_ID) 
        references HOTELS (ID);

    alter table HOTELRESERVATIONS 
        add index HR_CITY_IDX (CITY_ID), 
        add constraint HR_CITY_FK 
        foreign key (CITY_ID) 
        references CITIES (ID);
    
*/
    
/*************************************************************************************/
/*
    create table VEHICLERESERVATIONS (
        ID bigint not null,
        CITY_ID bigint,
        START_DATE datetime,
        END_DATE datetime,
        RENTAL_AGENCY varchar(300),
        VEH_TYPE varchar(80),
        COST float,
        CURRENCY_ID bigint,
        COST_CENTER varchar(40),
        COMMENTS varchar(400),
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table VEHICLERESERVATIONS 
        add index VR_CURR_IDX (CURRENCY_ID), 
        add constraint VR_CURR_FK 
        foreign key (CURRENCY_ID) 
        references CURRENCIES (ID);

    alter table VEHICLERESERVATIONS 
        add constraint VR_RESV_FK 
        foreign key (ID) 
        references RESERVATIONS (ID);

    alter table VEHICLERESERVATIONS 
        add index VR_CITY_IDX (CITY_ID), 
        add constraint VR_CITY_FK 
        foreign key (CITY_ID) 
        references CITIES (ID);

*/
/*************************************************************************************/
/*
    create table OTHERRESERVATIONS (
        ID bigint not null,
        RESV_DATE datetime,
        CITY_ID bigint,
        COST float,
        CURRENCY_ID bigint,
        COST_CENTER varchar(40),
        COMMENTS varchar(400),
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table OTHERRESERVATIONS 
        add index OR_CURR_IDX (CURRENCY_ID), 
        add constraint OR_CURR_FK 
        foreign key (CURRENCY_ID) 
        references CURRENCIES (ID);

    alter table OTHERRESERVATIONS 
        add constraint OR_RESV_FK 
        foreign key (ID) 
        references RESERVATIONS (ID);

    alter table OTHERRESERVATIONS 
        add index OR_CITY_IDX (CITY_ID), 
        add constraint OR_CITY_FK 
        foreign key (CITY_ID) 
        references CITIES (ID);
*/        

/*************************************************************************************/
    create table SUPERVISORS (
        ID bigint not null auto_increment,
        FIRST_NAME varchar(40),
        LAST_NAME varchar(40),
        OFFICE_PHONE varchar(20),
        EMAIL varchar(40),
        CELL_PHONE varchar(20),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;
        
        
/*************************************************************************************/
    create table DEPENDANTS (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        FULL_NAME varchar(400),
        BIRTH_DATE datetime,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table DEPENDANTS 
        add index DEP_TRAV_IDX (TRAVELLER_ID), 
        add constraint DEP_TRAV_FK 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);
    
/*************************************************************************************/
    create table NONEMPLOYMENTDETAILS (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        TITLE varchar(40),
        COMPANY varchar(80),
        OFFICE_PHONE varchar(20),
        EMAIL varchar(40),
        COST_CENTRE varchar(40),
        SUPV_EMAIL varchar(40),
        SUPV_NAME varchar(40),
        SUPV_PHONE varchar(20),
        CORP_SUPV_ID bigint,
        CONTRACT_EFFECTIVE datetime,
        CONTRACT_EXPIRY datetime,
        DEPENDANT bit,
        GUEST bit,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table NONEMPLOYMENTDETAILS 
        add index NED_TRAV_IDX (TRAVELLER_ID), 
        add constraint NED_TRAV_FK 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);
    
    alter table NONEMPLOYMENTDETAILS 
        add index NED_SUPV_IDX (CORP_SUPV_ID), 
        add constraint NED_SUPV_FK 
        foreign key (CORP_SUPV_ID) 
        references SUPERVISORS (ID);
        
/*************************************************************************************/
    create table EMPLOYMENTDETAILS (
        ID bigint not null auto_increment,
        TRAVELLER_ID bigint,
        TITLE varchar(40),
        DEPT varchar(40),
        DIVISION varchar(40),
        BUS_UNIT varchar(40),
        COST_CENTER varchar(40),
        EMPL_NUM varchar(40),
        EMAIL varchar(40),
        OFFICE_PHONE varchar(20),
        OFFICE_FAX varchar(20),
        ASST_ID bigint,
        SUPV_ID bigint,
        START_DATE datetime,
        TERMINATION_DATE datetime,
        EXPAT bit,
        COMMENTS varchar(400),
        AUDIT_DATETIME datetime,
        AUDIT_USERID varchar(20),
        VERSION integer,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table EMPLOYMENTDETAILS 
        add index EMP_TRAV_IDX (TRAVELLER_ID), 
        add constraint EMP_TRAV_FK 
        foreign key (TRAVELLER_ID) 
        references TRAVELLERS (ID);

    alter table EMPLOYMENTDETAILS 
        add index EMP_ASST_IDX (ASST_ID), 
        add constraint EMP_ASST_FK 
        foreign key (ASST_ID) 
        references ADMINASSISTANTS (ID);
    
    alter table EMPLOYMENTDETAILS 
        add index EMP_SUPV_IDX (SUPV_ID), 
        add constraint EMP_SUPV_FK 
        foreign key (SUPV_ID) 
        references SUPERVISORS (ID);
        
    
/*************************************************************************************/
    create table RESERVATIONS_SEQ (
         NEXTVAL integer 
    ) ENGINE=InnoDB;

    insert into RESERVATIONS_SEQ values ( 0 );

/*************************************************************************************/
/*
	create sequence AIRLINES_SEQ;
	...
		
*/ 
    
/*

    grant select, insert, update, delete on demo.* to 'minder' identified by 'goulash';
    grant select, insert, update, delete on auth.* to 'minder' identified by 'goulash';
  
*/    
    commit;

-- ALTER TABLE ITINERARIES MODIFY AUTH_ID varchar(80);
    