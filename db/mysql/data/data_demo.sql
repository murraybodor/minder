SET AUTOCOMMIT=1;

insert into METADATA(id,meta_key,str_value,meta_desc,audit_datetime,audit_userid, version) values (1,'TENANT_NAME','Demo Company Ltd.','Tenant name',sysdate(),'sys', 0);

insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Type', 'Blood', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Type', 'Insurance', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Type', 'Medical Assessment', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Type', 'Other Doc', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Type', 'Reserve System', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Type', 'Room', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Type', 'SOS Card', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Type', 'Vaccination', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Type', 'Vehicle', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Type', 'Visa', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Type', 'Security Orientation', sysdate(), 'sys', 0);

insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Blood', 'A+', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Blood', 'A-', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Blood', 'B+', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Blood', 'B-', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Blood', 'AB+', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Blood', 'AB-', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Blood', 'O+', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Blood', 'O-', sysdate(), 'sys', 0);

insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Insurance', 'Comprehensive', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Insurance', 'KR Insurance', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Insurance', 'Med Evac Insurance', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Insurance', 'Medical Insurance', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Insurance', 'Other', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Insurance', 'Sec Vac Insurance', sysdate(), 'sys', 0);

insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Medical Assessment', 'Health Orientation', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Medical Assessment', 'Periodic Medical', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Medical Assessment', 'Pre-Travel Medical', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Medical Assessment', 'Pre-Departure Preparation', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Medical Assessment', 'Questionnaire Only', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Medical Assessment', 'Repatriation Medical', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Medical Assessment', 'Travel Kit', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Medical Assessment', 'Other', sysdate(), 'sys', 0);


insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Reserve System', 'Amadeus', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Reserve System', 'Galileo', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Reserve System', 'Other', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Reserve System', 'Sabre', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Reserve System', 'Unknown', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Reserve System', 'WorldSpan', sysdate(), 'sys', 0);

insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Room', 'Standard', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Room', 'Deluxe', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Room', 'Day Room', sysdate(), 'sys', 0);

insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Security Orientation', 'Pre Travel', sysdate(), 'sys', 0);

insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('SOS Card', 'ExPat', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('SOS Card', 'Frequent', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('SOS Card', 'No Card', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('SOS Card', 'Occasional', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('SOS Card', 'Security', sysdate(), 'sys', 0);

insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Cholera', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Hepatitis A', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Hepatitis A/B', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Hepatitis B', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Influenza', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Japanese Encephalitis', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Measles/Mumps/Rubella', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Meningitis A/C', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Meningococcus', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Polio', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Rabies', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Tetanus/Diptheria', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Tetanus/Diptheria/Polio', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Tuberculin Skin Test - N', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Tuberculin Skin Test - P', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Typhoid - Injectable', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Typhoid - Oral', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Yellow Fever', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vaccination', 'Other', sysdate(), 'sys', 0);

insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vehicle', 'Compact', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vehicle', 'Chauffeur Service', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vehicle', 'Luxury', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vehicle', 'Midsize', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vehicle', 'Other', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vehicle', 'Pickup', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Vehicle', 'Van', sysdate(), 'sys', 0);

insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Visa', 'Green Card', sysdate(), 'sys', 0);
insert into TYPES (dtype, name, audit_datetime, audit_userid, version) values ('Visa', 'Other', sysdate(), 'sys', 0);

insert into WORLDAREAS (name, audit_datetime, audit_userid, version) values ('North America', sysdate(), 'sys', 0);
insert into WORLDAREAS (name, audit_datetime, audit_userid, version) values ('Europe', sysdate(), 'sys', 0);
insert into WORLDAREAS (name, audit_datetime, audit_userid, version) values ('Africa', sysdate(), 'sys', 0);
insert into WORLDAREAS (name, audit_datetime, audit_userid, version) values ('Asia', sysdate(), 'sys', 0);
insert into WORLDAREAS (name, audit_datetime, audit_userid, version) values ('Central America', sysdate(), 'sys', 0);
insert into WORLDAREAS (name, audit_datetime, audit_userid, version) values ('South America', sysdate(), 'sys', 0);
insert into WORLDAREAS (name, audit_datetime, audit_userid, version) values ('South Pacific', sysdate(), 'sys', 0);

insert into CURRENCIES (currency_code, name, exch_rate_to_1_usd, audit_datetime, audit_userid, version) values ('USD', 'US Dollar', 1, sysdate(), 'sys', 0);
insert into CURRENCIES (currency_code, name, exch_rate_to_1_usd, audit_datetime, audit_userid, version) values ('CAD', 'Canadian Dollar', 1.0692, sysdate(), 'sys', 0);
insert into CURRENCIES (currency_code, name, exch_rate_to_1_usd, audit_datetime, audit_userid, version) values ('EUR','Euro',0.708,sysdate(),'sys',0);
insert into CURRENCIES (currency_code, name, exch_rate_to_1_usd, audit_datetime, audit_userid, version) values ('GBP','Pounds Stirling', 0.5681, sysdate(), 'sys', 0);
insert into CURRENCIES (currency_code, name, exch_rate_to_1_usd, audit_datetime, audit_userid, version) values ('TZS','Tanzanian Schillings',0.0009,sysdate(),'sys',0);

insert into CURRENCIES (currency_code, name, exch_rate_to_1_usd, audit_datetime, audit_userid, version) values ('NOC','Norweigan Kroner',0.1829,sysdate(),'sys',0);
insert into CURRENCIES (currency_code, name, exch_rate_to_1_usd, audit_datetime, audit_userid, version) values ('ZAR','African Rand',0.1219,sysdate(),'sys',0);
insert into CURRENCIES (currency_code, name, exch_rate_to_1_usd, audit_datetime, audit_userid, version) values ('MZN','Mozambique Metical',0.0458,sysdate(),'sys',0);
insert into CURRENCIES (currency_code, name, exch_rate_to_1_usd, audit_datetime, audit_userid, version) values ('KES','Kenyan Shillings',67.6708,sysdate(),'sys',0);
insert into CURRENCIES (currency_code, name, exch_rate_to_1_usd, audit_datetime, audit_userid, version) values ('AUD','Australian Dollars',1.2647,sysdate(),'sys',0);

insert into CURRENCIES (currency_code, name, exch_rate_to_1_usd, audit_datetime, audit_userid, version) values ('NZD','New Zealand Dollars',1.4508,sysdate(),'sys',0);
insert into CURRENCIES (currency_code, name, exch_rate_to_1_usd, audit_datetime, audit_userid, version) values ('THB','Thai Baht',28.5064,sysdate(),'sys',0);
insert into CURRENCIES (currency_code, name, exch_rate_to_1_usd, audit_datetime, audit_userid, version) values ('RUB','Rouble',22.2542,sysdate(),'sys',0);
insert into CURRENCIES (currency_code, name, exch_rate_to_1_usd, audit_datetime, audit_userid, version) values ('SGD','Singapore Dollar',1.2128,sysdate(),'sys',0);

insert into COUNTRIES (name, currency_id, worldarea_id, audit_datetime, audit_userid, version) values ('United States', null, null, sysdate(), 'sys', 0);
insert into COUNTRIES (name, currency_id, worldarea_id, audit_datetime, audit_userid, version) values ('Canada', null, null, sysdate(), 'sys', 0);
insert into COUNTRIES (name, currency_id, worldarea_id, audit_datetime, audit_userid, version) values ('France', null, null, sysdate(), 'sys', 0);
insert into COUNTRIES (name, currency_id, worldarea_id, audit_datetime, audit_userid, version) values ('Germany', null, null, sysdate(), 'sys', 0);
insert into COUNTRIES (name, currency_id, worldarea_id, audit_datetime, audit_userid, version) values ('Italy', null, null, sysdate(), 'sys', 0);
insert into COUNTRIES (name, currency_id, worldarea_id, audit_datetime, audit_userid, version) values ('UK', null, null, sysdate(), 'sys', 0);

insert into COUNTRIES (name, currency_id, worldarea_id, audit_datetime, audit_userid, version) values ('Tanzania',null, null,sysdate(),'sys',0);
insert into COUNTRIES (name, currency_id, worldarea_id, audit_datetime, audit_userid, version) values ('Mozambique',null, null,sysdate(),'sys',0);
insert into COUNTRIES (name, currency_id, worldarea_id, audit_datetime, audit_userid, version) values ('Norway',null, null,sysdate(),'sys',0);
insert into COUNTRIES (name, currency_id, worldarea_id, audit_datetime, audit_userid, version) values ('Spain',null, null,sysdate(),'sys',0);
insert into COUNTRIES (name, currency_id, worldarea_id, audit_datetime, audit_userid, version) values ('South Africa',null, null,sysdate(),'sys',0);
insert into COUNTRIES (name, currency_id, worldarea_id, audit_datetime, audit_userid, version) values ('Kenya',null, null,sysdate(),'sys',0);
insert into COUNTRIES (name, currency_id, worldarea_id, audit_datetime, audit_userid, version) values ('Australia',null, null,sysdate(),'sys',0);
insert into COUNTRIES (name, currency_id, worldarea_id, audit_datetime, audit_userid, version) values ('Thailand',null, null,sysdate(),'sys',0);
insert into COUNTRIES (name, currency_id, worldarea_id, audit_datetime, audit_userid, version) values ('Russia',null, null,sysdate(),'sys',0);
insert into COUNTRIES (name, currency_id, worldarea_id, audit_datetime, audit_userid, version) values ('Singapore',null, null,sysdate(),'sys',0);

insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('AL', 'Alabama', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('AK', 'Alaska', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('AZ', 'Arizona', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('AR', 'Arkansas', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('CA', 'California', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('CO', 'Colorado', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('CN', 'Connecticut', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('DE', 'Delaware', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('DC', 'District of Columbia', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('FL', 'Florida', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('GA', 'Georgia', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('HW', 'Hawaii', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('ID', 'Idaho', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('IL', 'Illinois', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('IN', 'Indiana', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('IA', 'Iowa', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('KS', 'Kansas', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('KY', 'Kentucky', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('LA', 'Louisiana', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('ME', 'Maine', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('MA', 'Massachusetts', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('MD', 'Maryland', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('MI', 'Michigan', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('MN', 'Minnesota', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('MS', 'Mississippi', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('MO', 'Missouri', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('MT', 'Montana', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('NE', 'Nebraska', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('NV', 'Nevada', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('NH', 'New Hampshire', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('NJ', 'New Jersey', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('NM', 'New Mexico', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('NY', 'New York', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('NC', 'North Carolina', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('ND', 'North Dakota', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('OH', 'Ohio', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('OK', 'Oklahoma', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('OR', 'Oregon', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('PA', 'Pennsylvania', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('RH', 'Rhode Island', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('SC', 'South Carolina', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('SD', 'South Dakota', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('TE', 'Tennessee', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('TX', 'Texas', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('UT', 'Utah', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('VE', 'Vermont', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('VA', 'Virginia', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('WA', 'Washington', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('WV', 'West Virginia', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('WI', 'Wisconsin', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('WY', 'Wyoming', 1, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('AB', 'Alberta', 2, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('BC', 'British Columbia', 2, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('MB', 'Manitoba', 2, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('NB', 'New Brunswick', 2, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('NL', 'Newfoundland and Labrador', 2, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('NT', 'Northwest Territories', 2, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('NS', 'Nova Scotia', 2, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('NU', 'Nunavut', 2, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('ON', 'Ontario', 2, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('PE', 'Prince Edward Island', 2, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('QC', 'Quebec', 2, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('SK', 'Saskatchewan', 2, sysdate(), 'sys', 0);
insert into STATES (abbrev, name, country_id, audit_datetime, audit_userid, version) values ('YT', 'Yukon', 2, sysdate(), 'sys', 0);

insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Calgary', -7, null, 2, sysdate(), 'sys', 0);
insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Edmonton', -7, null, 2, sysdate(), 'sys', 0);
insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Vancouver', -8, null, 2, sysdate(), 'sys', 0);
insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Red Deer', -7, null, 2, sysdate(), 'sys', 0);
insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Grande Prairie', -7, null, 2, sysdate(), 'sys', 0);

insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Johannesburg', null, null, 2, sysdate(), 'sys', 0);
insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Capetown', null, null, 2, sysdate(), 'sys', 0);
insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Durban', null, null, 2, sysdate(), 'sys', 0);
insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Pemba', null, null, 2, sysdate(), 'sys', 0);
insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Maputo', null, null, 2, sysdate(), 'sys', 0);
insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Dar es Salaam', null, null, 2, sysdate(), 'sys', 0);
insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Kilimanjaro', null, null, 2, sysdate(), 'sys', 0);
insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Zanzibar', null, null, 2, sysdate(), 'sys', 0);
insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Nairobi', null, null, 2, sysdate(), 'sys', 0);
insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('London', null, null, 2, sysdate(), 'sys', 0);
insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Sydney', null, null, 2, sysdate(), 'sys', 0);
insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Houston', null, null, 1, sysdate(), 'sys', 0);
insert into CITIES (name, timezone, state_id, country_id, audit_datetime, audit_userid, version) values ('Washington', null, null, 1, sysdate(), 'sys', 0);


insert into AIRLINES (code, name, audit_datetime, audit_userid, version) values ('AC', 'Air Canada', sysdate(), 'sys', 0);
insert into AIRLINES (code, name, audit_datetime, audit_userid, version) values ('BA', 'British Airways', sysdate(), 'sys', 0);
insert into AIRLINES (code, name, audit_datetime, audit_userid, version) values ('WJ', 'WestJet', sysdate(), 'sys', 0);
insert into AIRLINES (code, name, audit_datetime, audit_userid, version) values ('AA', 'American Airlines', sysdate(), 'sys', 0);
insert into AIRLINES (code, name, audit_datetime, audit_userid, version) values ('CO', 'Continental', sysdate(), 'sys', 0);
insert into AIRLINES (code, name, audit_datetime, audit_userid, version) values ('UA', 'United Airlines', sysdate(), 'sys', 0);
insert into AIRLINES (code, name, audit_datetime, audit_userid, version) values ('SA', 'South African Airways', sysdate(), 'sys', 0);
insert into AIRLINES (code, name, audit_datetime, audit_userid, version) values ('KQ', 'Kenyan Airlines', sysdate(), 'sys', 0);
insert into AIRLINES (code, name, audit_datetime, audit_userid, version) values ('KL', 'KLM', sysdate(), 'sys', 0);

insert into AIRPORTS (iata_code, name, city_id, description, audit_datetime, audit_userid, version) values ('YYC', 'International', 1, '', sysdate(), 'sys', 0);
insert into AIRPORTS (iata_code, name, city_id, description, audit_datetime, audit_userid, version) values ('YEG', 'International', 2, '', sysdate(), 'sys', 0);
insert into AIRPORTS (iata_code, name, city_id, description, audit_datetime, audit_userid, version) values ('YVR', 'International', 3, '', sysdate(), 'sys', 0);
insert into AIRPORTS (iata_code, name, city_id, description, audit_datetime, audit_userid, version) values ('YQF', 'Regional', 4, '', sysdate(), 'sys', 0);
insert into AIRPORTS (iata_code, name, city_id, description, audit_datetime, audit_userid, version) values ('YQU', '', 5, '', sysdate(), 'sys', 0);
insert into AIRPORTS (iata_code, name, city_id, description, audit_datetime, audit_userid, version) values ('JNB',NULL,NULL,NULL, sysdate(), 'sys', 0);
insert into AIRPORTS (iata_code, name, city_id, description, audit_datetime, audit_userid, version) values ('CPT',NULL,NULL,NULL, sysdate(), 'sys', 0);
insert into AIRPORTS (iata_code, name, city_id, description, audit_datetime, audit_userid, version) values ('DUR',NULL,NULL,NULL, sysdate(), 'sys', 0);
insert into AIRPORTS (iata_code, name, city_id, description, audit_datetime, audit_userid, version) values ('MPM',NULL,NULL,NULL, sysdate(), 'sys', 0);
insert into AIRPORTS (iata_code, name, city_id, description, audit_datetime, audit_userid, version) values ('POL',NULL,NULL,NULL, sysdate(), 'sys', 0);
insert into AIRPORTS (iata_code, name, city_id, description, audit_datetime, audit_userid, version) values ('NBO','Jomo Kenyatta',NULL,NULL, sysdate(), 'sys', 0);
insert into AIRPORTS (iata_code, name, city_id, description, audit_datetime, audit_userid, version) values ('YXD','Municipal',NULL,NULL, sysdate(), 'sys', 0);
insert into AIRPORTS (iata_code, name, city_id, description, audit_datetime, audit_userid, version) values ('LHR','Heathrow',NULL,NULL, sysdate(), 'sys', 0);
insert into AIRPORTS (iata_code, name, city_id, description, audit_datetime, audit_userid, version) values ('DAR',NULL,NULL,NULL, sysdate(), 'sys', 0);


insert into HOTELS (name, address, location, phone, city_id, airport_id, audit_datetime, audit_userid, version) values ('Hyatt', 'Eau Claire', 'DTN', '403.555.1212', 1, 1,  sysdate(), 'sys', 0);
insert into HOTELS (name, address, location, phone, city_id, airport_id, audit_datetime, audit_userid, version) values ('International', '4th Avenue', 'DTN', '403.555.2323', 1, 1,  sysdate(), 'sys', 0);


COMMIT;

insert into ITINERARIES (id, traveller_id) VALUES (1, 1);

insert into RESERVATIONS (id, itinerary_id, res_type, resv_begin_date, version) VALUES (1, 1, 'HOTEL', sysdate(), 0);
insert into RESERVATIONS (id, itinerary_id, res_type, resv_begin_date, version) VALUES (2, 1, 'FLIGHT', sysdate(), 0);
insert into RESERVATIONS (id, itinerary_id, res_type, resv_begin_date, version) VALUES (3, 1, 'VEHICLE', sysdate(), 0);
insert into RESERVATIONS (id, itinerary_id, res_type, resv_begin_date, version) VALUES (4, 1, 'OTHER', sysdate(), 0);

