--==============Query for testing Spring Security============
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


--=============================================================================================================
--********************Project Query Start*************************
--=============================================================================================================
create table customers(
    customer_id int NOT NULL AUTO_INCREMENT,
    name varchar(50)NOT NULL,
    email varchar(45) NOT NULL,
    mobile_number varchar(20),
    pwd varchar(500) NOT NULL,
    role varchar(45) NOT NULL,
    create_date DATE DEFAULT NULL,
    PRIMARY KEY (customer_id)
);
insert into customers(name, email, mobile_number, pwd, role, create_date) values('Yogesh Uk','yogesh@gmail.com', '9992222777', '{bcrypt}$2a$12$cLAf843dpihKWq87chZqSeuXPeiz7Dk.1uQMp82AgtmG06DPd1G0C', 'read', CURDATE()); --Password-Yogesh
insert into customers(name, email, mobile_number, pwd, role, create_date) values('Sonali Uk','sonali@gmail.com', '8888888888', '{bcrypt}$2a$12$DViqAwM610kXsCvMo62PKe1iS.dr4qTJ3uej7i4hCdK/dmkfC0qsO', 'read', CURDATE()); --Password-Sonali
insert into customers(name, email, mobile_number, pwd, role, create_date) values('Bank Admin', 'admin@gmail.com', '1234567890', '{bcrypt}$2a$12$4be08v2aEx7hyy3Yym1ffeTiKBW5is810wp/jsEfw5XknMROgVPPK', 'admin', CURDATE()); --Password-Admin

--========================================================================================================================================================
CREATE TABLE authorities (
    id int NOT NULL AUTO_INCREMENT,
    customer_id int NOT NULL,
    name varchar(50) NOT NULL,
    PRIMARY KEY(id),
    KEY customer_id(customer_id),
    CONSTRAINT auth_fk FOREIGN KEY(customer_id) REFERENCES customers (customer_id)
);

insert into authorities (customer_id, name) values (3, 'VIEWLOANS');
insert into authorities (customer_id, name) values (3, 'VIEWACCOUNTS');
insert into authorities (customer_id, name) values (3, 'VIEWCARDS');

insert into authorities (customer_id, name) values (1, 'VIEWACCOUNTS');
insert into authorities (customer_id, name) values (2, 'VIEWCARDS');

insert into authorities (customer_id, name) values (1, 'ROLE_USER');
insert into authorities (customer_id, name) values (3, 'ROLE_ADMIN');

select * from  authorities;

--============================================================================================

create table contacts(
    contact_id varchar(50),
    contact_name varchar(50),
    contact_email varchar(50),
    subject varchar(50),
    message varchar(2000),
    create_date Date DEFAULT NULL,
    primary key(contact_id)
);

CREATE TABLE loans(
    loan_number BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,
    start_dt DATE,
    loan_type VARCHAR(50),
    total_loan DECIMAL(15, 2),
    amount_paid DECIMAL(15, 2),
    outstanding_amount DECIMAL(15, 2),
    created_dt DATE,
    PRIMARY KEY(loan_number)
);

CREATE TABLE cards(
    card_id BIGINT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    card_number varchar(16)NOT NULL,
    card_type varchar(10)NOT NULL,
    total_limit DOUBLE(15,2)NOT NULL,
    amount_used DOUBLE(15,2)NOT NULL,
    available_amount DOUBLE(15,2)NOT NULL,
    create_dt DATE DEFAULT NULL,
    PRIMARY KEY(card_id),
    KEY customer_id(customer_id),
    CONSTRAINT card_fk FOREIGN KEY(customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE
);

CREATE TABLE notices(
    notice_id INT NOT NULL AUTO_INCREMENT,
    notice_summery varchar(200) NOT NULL,
    notice_details varchar(500) NOT NULL,
    notice_start_dt DATE DEFAULT NULL,
    notice_end_dt DATE DEFAULT NULL,
    create_dt DATE DEFAULT NULL,
    modified_dt DATE DEFAULT NULL,
    PRIMARY KEY(notice_id)
);
CREATE TABLE accounts(
    customer_id INT NOT NULL,
    account_number INT NOT NULL,
    account_type varchar(50) NOT NULL,
    branch_address varchar(500) NOT NULL,
    create_dt DATE DEFAULT NULL,
    PRIMARY KEY(account_number),
    key customer_id(customer_id),
    CONSTRAINT cust_fk FOREIGN KEY(customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE
);
CREATE TABLE account_transactions(
    transaction_id varchar(50) NOT NULL,
    account_number int NOT NULL,
    customer_id int NOT NULL,
    transaction_dt Date NOT NULL,
    transaction_summery varchar(200)NOT NULL,
    transaction_type varchar(50) NOT NULL,
    transaction_amt DOUBLE(15,2) NOT NULL,
    closing_balance DOUBLE(15,2),
    create_dt DATE DEFAULT NULL,
    PRIMARY KEY(transaction_id),
    KEY customer_id(customer_id),
    KEY account_number(account_number),
    CONSTRAINT acct_fk FOREIGN KEY(account_number) REFERENCES accounts(account_number) ON DELETE CASCADE,
    CONSTRAINT acct_user_fk FOREIGN KEY(customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE
);


drop table account_transactions;
drop table accounts;
drop table cards;
drop table authorities;
drop table customers;