create table  language(language_Id serial,language_name varchar(10) unique);

insert INTO language (language_name) values ('Tamil'),('Hindi'),('English');

--UserDetails--
create table  userDetail (
	user_Id serial,
	user_Name varchar(20) unique  not null,
	email_Id varchar(30) unique not null,
	mobile_Num Bigint unique  not  null,
	gender varchar(6) not null,
	age int not null,
	pass_word varchar(25) not null,
	date_joined TIMESTAMPTZ,
	primary key(user_Name)
);

--Default user--
insert into userDetail 
(user_Name,email_Id,mobile_num,gender,age,pass_word,date_joined)values
('gokul','gok@gmail.com',8771236548,'male',21,'gok@123',CURRENT_TIMESTAMP);
-- user list---


--admin table creation--
create table adminDetails(
    admin_Id serial,
	admin_Name varchar(10) unique not null,
	email_Id varchar(15) not null,
	pass_word varchar(10) not null,
	primary key(admin_name)
);


--default admin--
insert into adminDetails
(admin_Name,email_Id,pass_word)values
('Ram','ram@gmail.com','ram@123');
