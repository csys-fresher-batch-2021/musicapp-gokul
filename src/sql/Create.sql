create table  language(language_Id serial,language_name varchar(10) unique);


insert INTO language (language_name) values ('TAMIL'),('HINDI'),('ENGLISH');

--UserDetails--
create table  userDetail (
	user_Id serial,
	user_Name varchar(20) unique  not null,
	email_Id varchar(25) unique not null,
	mobile_Num Bigint unique  not  null,
	gender varchar(6) not null,
	age int not null,
	pass_word varchar(25) not null,
	date_joined TIMESTAMPTZ ,
	primary key(user_Name)
);

--Default user--
insert into userDetail 
(user_Name,email_Id,mobile_num,gender,age,pass_word,date_joined)values
('gokul','gokul@gmail.com',8771236548,'male',21,'Gokul@123',CURRENT_TIMESTAMP),
('Kiruba','kiruba@gmail.com',8773456788,'female',21,'Kirubs@123',CURRENT_TIMESTAMP);
-- user list---

--admin table creation--
create table adminDetails(
    admin_Id serial,
	admin_Name varchar(20) unique not null,
	email_Id varchar(25) not null,
	pass_word varchar(25) not null,
	primary key(admin_name)
);


--default admin--
insert into adminDetails
(admin_Name,email_Id,pass_word)values
('Ramkumar','ramkumar@gmail.com','Ram@123');

--songs table --
create table songs(
song_Id serial ,
song_Name varchar(20) not null,
movie_Name varchar(20) not null,
language_name varchar(20) not null,
released_On DATE
);

 ---playlist creation---
 create table playlist(
 playlist_id serial,
 playlist_name varchar(20) not null,
 song_id int  not null ,
user_id int not null,
	 created_on Date,
	 foreign key(song_id) references songs(song_Id) on delete cascade,
	 foreign key(user_id) references userDetail(user_Id) on delete cascade,
	 primary key(playlist_id)
  );

insert into playlist (playlist_name,song_id,user_id,created_on) values
('mysongs',1,1,'2021-06-07');

-- image table for styling  --
create table music_images(image_name varchar(70) not null,image bytea);

insert into music_images(image_name,image) values('music1', pg_read_binary_file('D:\music1.jpg'));

---song source table---
create table song_source( song_source_id serial,
					      song_name varchar(100) not null,
						 song bytea,song_image bytea, foreign key(song_Name)
						 references songs(song_Name) on delete cascade,
						 primary key(song_source_id));
						 
--inserting song source-- 						
insert into song_source(song_name,song) values('KUTTY_STORY', pg_read_binary_file('D:\projectMusic\KUTTY_STORY.mp3')),
---creating liked songs---
create table liked_songs(
liked_songs_id  serial primary key,
song_name varchar(20) not null,

user_name varchar(30) not null,

foreign key(song_name) references songs(song_Name) on delete cascade,
foreign key(user_name) references userDetail(user_name) on delete cascade
);
