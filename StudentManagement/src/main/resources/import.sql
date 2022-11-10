insert into users(user_id, username, password) values(1,'normaluser','$2a$10$PCgfWE9xHYSH7dq9qKnWL.Nsds66M4JCwETLrCb3xARTH.wcEggj2');
insert into users(user_id, username, password) values(2, 'adminuser','$2a$10$PCgfWE9xHYSH7dq9qKnWL.Nsds66M4JCwETLrCb3xARTH.wcEggj2');

insert into roles(role_id, name) values (1, 'USER');
insert into roles(role_id, name) values (2, 'ADMIN');

insert into users_roles(role_id, user_id) values (1, 1), (1, 2), (2, 2);

insert into student( First_Name, Last_Name, country, course) values( 'Shabnam','Riaz','UAE','B.Tech');
insert into student( First_Name, Last_Name, country, course) values('Tina','Kumar','India','MBA');
insert into student( First_Name, Last_Name, country, course) values('Akash','Srivastava','Canada','MS');
insert into student( First_Name, Last_Name, country, course) values('Sudhir','Gupta','India','BBE');