# 11-onestop-weekday
-- insert into account_tbl(name,amount)values('AA',20000),('BB',20000);

-- show isolation level
-- select @@global.transaction_isolation,@@transaction_isolation;

-- change isolation level
-- set global transaction isolation level SERIALIZABLE

-- create new  user
-- create user 'transactionUser'@'localhost' identified by 'transactionPass';
-- grant all privileges on transactionDb.* to 'transactionUser'@'localhost';
-- flush privileges;

-- show user 
-- select User,Host from mysql.user;
-- drop user 'studentUser'@'localhost';

-- delimiter //
-- create procedure totalUser(In createDate timestamp,out total int)
-- begin
-- select count(*) from user_tbl where create_date <= createDate;
-- end//

-- delimiter ;

-- delimiter //
-- create procedure selectUser(In name varchar(45))
-- begin
-- select * from user_tbl where username = name;
-- end//

-- delimiter ;

-- show procedures 
-- select routine_name from information_schema.routines 
-- where routine_type = 'PROCEDURE' 
-- and routine_schema = 'transactionDb';

-- delete procedure
-- drop procedure totalUser;
