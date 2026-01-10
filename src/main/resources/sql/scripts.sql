create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

select * from users;
select * from authorities;

insert into users values('Admin', '{bcrypt}$2a$12$4be08v2aEx7hyy3Yym1ffeTiKBW5is810wp/jsEfw5XknMROgVPPK', '1');
insert into authorities values('Admin', 'admin');

insert into users values('Yogesh', '{bcrypt}$2a$12$cLAf843dpihKWq87chZqSeuXPeiz7Dk.1uQMp82AgtmG06DPd1G0C', '1');
insert into authorities values('Yogesh', 'read');

insert into users values('Sonali', '{bcrypt}$2a$12$DViqAwM610kXsCvMo62PKe1iS.dr4qTJ3uej7i4hCdK/dmkfC0qsO', '1');
insert into authorities values('Sonali', 'read');

create table customer(
    id int NOT NULL AUTO_INCREMENT,
    email varchar(45) NOT NULL,
    pwd varchar(200) NOT NULL,
    role varchar(45) NOT NULL,
    primary key (id)
)
insert into customer(email, pwd, role) values('yogesh@gmail.com', '{bcrypt}$2a$12$cLAf843dpihKWq87chZqSeuXPeiz7Dk.1uQMp82AgtmG06DPd1G0C', 'read');
insert into customer(email, pwd, role) values('sonali@gmail.com', '{bcrypt}$2a$12$DViqAwM610kXsCvMo62PKe1iS.dr4qTJ3uej7i4hCdK/dmkfC0qsO', 'read');
insert into customer(email, pwd, role) values('admin@gmail.com', '{bcrypt}$2a$12$4be08v2aEx7hyy3Yym1ffeTiKBW5is810wp/jsEfw5XknMROgVPPK', 'admin');