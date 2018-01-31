--------------------------------------------------------------------------------;

drop database nmb_bank_db;
create database nmb_bank_db;
use nmb_bank_db;

----------------------------------Database Created------------------------------;

create table tbl_customer(
    account_no int primary key auto_increment,
    c_name varchar(100) not null,
    dob date,
    gender enum('M','F') not null,
    status enum('Active','Deactive') DEFAULT 'Active'
);
--------------------------tbl_customer has been created-------------------------;

create table tbl_login(
    id int primary key auto_increment,
    password varchar(20),
    user_name varchar(100) unique,
    user_type enum('CUSTOMER','BANK') default 'CUSTOMER',
    account_no int default 0,
    FOREIGN KEY(account_no) REFERENCES tbl_customer(account_no)
);
-----------------------------tbl_login has been created-------------------------;

create table tbl_account_detail(
    id int primary key auto_increment,
    account_no int  not null,
    account_type enum('CURRENT','SAVING') default 'SAVING',
    opened_date Date,
    branch_name varchar(50),
    FOREIGN KEY(account_no) REFERENCES tbl_customer(account_no)
);
-----------------------tbl_account_type has been created------------------------;

create table tbl_contact(
    id int primary key auto_increment,
    account_no int  not null,
    phone long not null,
    email varchar(100),
    address varchar(200) not null,
    FOREIGN KEY(account_no) REFERENCES tbl_customer(account_no)
);
-------------------------tbl_contact has been created---------------------------;

create table tbl_resources(
    id int primary key auto_increment,
    account_no int  not null,
    img_url varchar(800),
    FOREIGN KEY(account_no) REFERENCES tbl_customer(account_no)
);
---------------------------tbl_resources has been created-----------------------;

create table tbl_amount(
    id int primary key auto_increment,
    account_no int  not null,
    amount double  not null,
    FOREIGN KEY(account_no) REFERENCES tbl_customer(account_no)
);
--------------------------tbl_amount has been created---------------------------;

create table tbl_transaction(
    id int primary key auto_increment,
    date Date,
    account_no int  not null,
    amount double  not null,
    operation enum ( 'DEBITED' , 'CREDITED'),
    FOREIGN KEY(account_no) REFERENCES tbl_customer(account_no)
);


insert into tbl_customer(c_name,gender,dob) values('Admin','M','19981110');
insert into tbl_login(user_name,password,user_type,account_no) values('Admin','Admin@1234','BANK',1);

------------------------tbl_transaction has been created------------------------;






