/*
DROP DATABASE `demo`;
DROP DATABASE `artumas`;

*/

    alter table AIRPORTS drop foreign key AIRP_CITY_FK;
    alter table CITIES drop foreign key CITY_STATE_FK;
    alter table CITIES drop foreign key CITY_CTRY_FK;
    alter table COUNTRIES drop foreign key CTRY_CURR_FK;
    alter table COUNTRIES drop foreign key CTRY_WA_FK;
    alter table HOTELS drop foreign key HOT_HC_FK;
    alter table HOTELS drop foreign key HOT_AIRP_FK;
    alter table HOTELS drop foreign key HOT_CITY_FK;
    alter table HOTELFACILITIES drop foreign key HF_HOTEL_FK;
    alter table STATES drop foreign key ST_CTRY_FK;
    alter table USERPROFILES drop foreign key UP_CURR_FK;
--    alter table FARESCHEDULES drop foreign key FS_FR_FK;
--    alter table FLIGHTDEPARTURES drop foreign key FD_FR_FK;
--    alter table FLIGHTRESERVATIONS drop foreign key FR_FD_FK;
--    alter table FLIGHTRESERVATIONS drop foreign key FR_CURR_FK;
--    alter table FLIGHTRESERVATIONS drop foreign key FR_RESV_FK;
--    alter table FLIGHTRESERVATIONS drop foreign key FR_FS_FK;
--    alter table FLIGHTROUTES drop foreign key FR_AIR_FK;
--    alter table FLIGHTROUTES drop foreign key FR_OA_FK;
--    alter table FLIGHTROUTES drop foreign key FR_DA_FK;
--    alter table FLIGHTROUTES drop foreign key FR_MOD_FK;
    alter table MEDICALASSESSMENTS drop foreign key MA_TRV_FK;
    alter table MEDICALASSESSMENTS drop foreign key MA_CTRY_FK;
    alter table INSURANCES drop foreign key INS_TRAV_FK;
--    alter table HOTELRESERVATIONS drop foreign key HR_CURR_FK;
--    alter table HOTELRESERVATIONS drop foreign key HR_RESV_FK;
--    alter table HOTELRESERVATIONS drop foreign key HR_HOT_FK;
--    alter table HOTELRESERVATIONS drop foreign key HR_CITY_FK;
--    alter table OTHERRESERVATIONS drop foreign key OR_CURR_FK;
--    alter table OTHERRESERVATIONS drop foreign key OR_RESV_FK;
--    alter table OTHERRESERVATIONS drop foreign key OR_CITY_FK;
--    alter table VEHICLERESERVATIONS drop foreign key VR_CURR_FK;
--    alter table VEHICLERESERVATIONS drop foreign key VR_RESV_FK;
--    alter table VEHICLERESERVATIONS drop foreign key VR_CITY_FK;
    alter table RESERVATIONS drop foreign key RESV_ITIN_FK;
    alter table ITINERARIES drop foreign key ITIN_CURR_FK;
    alter table ITINERARIES drop foreign key ITIN_TRAV_FK;
    alter table VISAS drop foreign key VISA_TRAV_FK;
    alter table VISAS drop foreign key VISA_CTRY_FK;
    alter table VACCINATIONS drop foreign key VAC_TRAV_FK;
    alter table PASSPORTS drop foreign key PP_TRAV_FK;
    alter table PASSPORTS drop foreign key PP_CTRY_FK;
    alter table SOSCOVERAGES drop foreign key SOS_TRAV_FK;
    alter table SECURITYORIENTATIONS drop foreign key SEC_TRAV_FK;
    alter table SECURITYORIENTATIONS drop foreign key SEC_CTRY_FK;
    alter table SECURITYPROFILES drop foreign key SECP_TRAV_FK;
    alter table DEPENDANTS drop foreign key DEP_TRAV_FK;
    alter table NONEMPLOYMENTDETAILS drop foreign key NED_TRAV_FK;
    alter table NONEMPLOYMENTDETAILS drop foreign key NED_SUPV_FK;
    alter table EMPLOYMENTDETAILS drop foreign key EMP_TRAV_FK;
    alter table EMPLOYMENTDETAILS drop foreign key EMP_ASST_FK;
    alter table EMPLOYMENTDETAILS drop foreign key EMP_SUPV_FK;
--    alter table PERSONALDETAILS drop foreign key PERS_TRAV_FK;
--    alter table PERSONALDETAILS drop foreign key PERS_CTRY_FK;
	alter table COSTALLOCATIONS drop foreign key CA_RESV_FK;
	alter table COSTALLOCATIONS drop foreign key CA_ITIN_FK;

    drop table if exists COSTALLOCATIONS;
--    drop table if exists FLIGHTRESERVATIONS;
--    drop table if exists HOTELRESERVATIONS;
--    drop table if exists VEHICLERESERVATIONS;
--    drop table if exists OTHERRESERVATIONS;
    drop table if exists RESERVATIONS;
    
    drop table if exists METADATA;
    drop table if exists USERPROFILES;

--    drop table if exists FARESCHEDULES;
--    drop table if exists FLIGHTDEPARTURES;
--    drop table if exists FLIGHTROUTES;
    drop table if exists MEDICALASSESSMENTS;
    drop table if exists INSURANCES;
    drop table if exists VISAS;
    drop table if exists VACCINATIONS;
    drop table if exists PASSPORTS;
    drop table if exists SOSCOVERAGES;
    drop table if exists SECURITYORIENTATIONS;

    drop table if exists DEPENDANTS;
    drop table if exists SECURITYPROFILES;
    
    drop table if exists ITINERARIES;
    drop table if exists NONEMPLOYMENTDETAILS;
    drop table if exists EMPLOYMENTDETAILS;
--    drop table if exists PERSONALDETAILS;
    drop table if exists TRAVELLERS;

    drop table if exists HIBERNATESEQ;
    drop table if exists RESERVATIONS_SEQ;

	drop table if exists ADMINASSISTANTS;
    drop table if exists AIRCRAFTMODELS;
    drop table if exists AIRLINES;
    drop table if exists AIRPORTS;
    drop table if exists CITIES;
    drop table if exists COUNTRIES;
    drop table if exists CURRENCIES;
    drop table if exists HOTELS;
    drop table if exists HOTELCHAINS;
    drop table if exists HOTELFACILITIES;
    drop table if exists STATES;
    drop table if exists SUPERVISORS;
    drop table if exists TYPES;
    drop table if exists WORLDAREAS;
    
    