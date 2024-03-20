insert into user_details(id, birth_date, name)
values(10001, current_date(), 'Busani');

insert into user_details(id, birth_date, name)
values(10002, current_date(), 'Phindile');

insert into user_details(id, birth_date, name)
values(10003, current_date(), 'Welile');

insert into user_details(id, birth_date, name)
values(10004, current_date(), 'Imani');

insert into post(id, description, user_id)
values(20001, 'I want to learn AWS', 10001);

insert into post(id, description, user_id)
values(20002, 'I want to go bungee jumping', 10002);

insert into post(id, description, user_id)
values(20003,'I want to become a world class sofware developer', 10003);

insert into post(id, description, user_id)
values(20004, 'I will live long and healthily', 10004);

insert into todo(id, description, done, target_date, username)
values(20001, 'I want to be the very best version of myself', false, CURRENT_DATE(), 'in28minutes');

insert into todo(id, description, done, target_date, username)
values(20002, 'I will show up everyday', false, CURRENT_DATE(), 'in28minutes');

insert into todo(id, description, done, target_date, username)
values(20003, 'I will push to succeed or die trying', false, CURRENT_DATE(), 'in28minutes');

insert into todo(id, description, done, target_date, username)
values(20004, 'I will become one of the premier developers in the world', false, CURRENT_DATE(), 'in28minutes');