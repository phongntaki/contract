create database sunpower
GO 
use sunpower


create table tb_role(
    role_id int identity(1,1) PRIMARY key not null,
    role_name VARCHAR(255)
)

insert tb_role values('admin')
insert tb_role values('member')

GO
create table tb_user(
    user_id int identity(1,1) PRIMARY key not null,
    user_name VARCHAR(255),
    account varchar(255),
    pass varchar(255),
    role_id int FOREIGN KEY REFERENCES tb_role(role_id)
)

insert tb_user values('Nguyen Thanh Phong', 'admin', 'admin', 1)
insert tb_user values('Nguyen Thanh Phong1', 'aaaa', 'aaaa', 1)
insert tb_user values('Nguyen Thanh Phong2', 'bbbb', 'bbbb', 2)
insert tb_user values('Nguyen Thanh Phong3', 'cccc', 'cccc', 2)



GO
create table tb_contract(
    contract_id int identity(1,1) PRIMARY key not null,
    client_name VARCHAR(255),
    create_time VARCHAR(255),
    survey_date VARCHAR(255),
    execute_date VARCHAR(255),
    bid_company VARCHAR(255),
    execute_company VARCHAR(255),
    confirm_date VARCHAR(255),
    sign_image VARCHAR(255),
    user_id int FOREIGN KEY REFERENCES tb_user(user_id)
)

insert tb_contract values('tanaka', '2018-10-22 09:30', '2018-10-23', '09:30', 'liberal solution company', 'Enzi company', '2018-10-24', 'images/a.png', 1)
insert tb_contract values('tanaka2', '2018-10-23 09:31', '2018-10-24', '09:31', 'liberal solution company2', 'Enzi company2', '2018-10-25', 'images/a2.png', 2)
insert tb_contract values('tanaka3', '2018-10-24 09:32', '2018-10-25', '09:32', 'liberal solution company3', 'Enzi company3', '2018-10-26', 'images/a3.png', 2)

GO
create table tb_content(
    content_id int identity(1,1) PRIMARY key not null,
    content_name VARCHAR(4000),
    contract_id int FOREIGN KEY REFERENCES tb_contract(contract_id)
)

insert tb_content values('content1', 1)
insert tb_content values('content1', 1)
insert tb_content values('content1', 2)
insert tb_content values('content1', 1)
insert tb_content values('content1', 3)
insert tb_content values('content1', 1)
insert tb_content values('content1', 2)
insert tb_content values('content1', 1)
insert tb_content values('content1', 2)


GO
create table tb_confirm(
    confirm_id int identity(1,1) PRIMARY key not null,
    confirm_name VARCHAR(4000),
    contract_id int FOREIGN KEY REFERENCES tb_contract(contract_id)
)
insert tb_confirm values('confirm1', 1)
insert tb_confirm values('confirm2', 1)
insert tb_confirm values('confirm3', 1)
insert tb_confirm values('confirm4', 1)
insert tb_confirm values('confirm5', 2)
insert tb_confirm values('confirm6', 1)
insert tb_confirm values('confirm7', 2)
insert tb_confirm values('confirm8', 1)
insert tb_confirm values('confirm9', 3)
insert tb_confirm values('confirm10', 3)
insert tb_confirm values('confirm11', 1)

select * from tb_role
select * from tb_user
select * from tb_contract
select * from tb_content
select * from tb_confirm

drop table tb_confirm
drop table tb_content
drop table tb_contract
drop table tb_user
drop table tb_role

