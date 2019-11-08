--leetcode 196
drop table test_person cascade;
create table test_person(Id Integer, Email Varchar(50))
insert into test_person(Id, Email) values (1, 'john@example.com');
insert into test_person(Id, Email) values (2, 'bob@example.com');
insert into test_person(Id, Email) values (3, 'john@example.com');

commit;
delete from test_person where id in (
select p1.id from test_person p1, test_person p2 where p1.email = p2.email and p1.id>p2.id)
select * from test_person;

-- Leetcode 197 Rising Temperature
create table temperature(id Integer, RecordDate Date, temperature Integer);
insert into temperature(id,RecordDate, temperature) values 
(1, SYSDATE, 10);
insert into temperature(id,RecordDate, temperature) values 
(2, SYSDATE+1, 25);
insert into temperature(id,RecordDate, temperature) values 
(3, SYSDATE+2, 20);
insert into temperature(id,RecordDate, temperature) values 
(4, SYSDATE+3, 30);
commit;
select *
from temperature t1, temperature t2 
where  (t2.RECORDDATE-t1.RECORDDATE)>=1 and (t2.RECORDDATE-t1.RECORDDATE)<2 and t2.Temperature > t1.temperature;

--leetcode 577
create table test_employee(empId Integer, name varchar2(10), supervisor Integer, salary Integer);
create table test_bonus(empId Integer, bonus Integer);

insert into test_employee(empId, name, supervisor, salary) values (1, 'Jone', 3, 1000);
insert into test_employee(empId, name, supervisor, salary) values (2, 'Dan', 3, 2000);
insert into test_employee(empId, name, supervisor, salary) values (3, 'Brad', null, 4000);
insert into test_employee(empId, name, supervisor, salary) values (4, 'Tomas', 3, 4000);

insert into test_bonus(empId, bonus) values (2,500);
insert into test_bonus(empId, bonus) values (4,2000);
commit;

select e.name, b.bonus from test_employee e left outer join  test_bonus b on e.empId = b.empId where b.bonus<1000 OR b.bonus is NULL;