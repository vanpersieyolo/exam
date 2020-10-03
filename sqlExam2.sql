create database exam;
create table city(
cityid int not null auto_increment primary key,
cityname char(120) not null,
nationalid int not null,
cityarea long, 
citygdp int,
cityDescrion varchar(255)
);

drop table city;
create table nationalOfCity(
nationalName char(120) not null ,
nationalid int not null auto_increment primary key
);
drop table nationalOfCity;
insert into nationalOfCity values();

insert into city(city.cityid,city.cityname,city.nationalid,city.cityarea,city.citygdp,city.cityDescrion) values();

delimiter $$
create procedure select_All()
begin
select city.cityid,city.cityname,city.cityarea,city.citygdp,city.cityDescrion,nationalofcity.nationalName from city
left join nationalofcity on city.nationalid = nationalofcity.nationalid;
end $$
delimiter ;
drop procedure select_All;
call select_All();

delimiter $$
create procedure update_city(in input_cityID int ,in input_cityname varchar(120),in input_nationalID int, in input_cityArea long, in input_cityGDP long, in input_cityDescription text)
begin
update city
set cityname = input_cityname, nationalid = input_nationalID,cityarea = input_cityArea,citygdp = input_cityGDP,cityDescrion = input_cityDescription
where city.cityid = input_cityID ;
end $$
delimiter ;
drop procedure update_city;
call update_city(3,'bangkok',1,3232,12,'normal');

delimiter $$
create procedure delete_city(in input_cityId int)
begin
delete from city where city.cityid = input_cityId;
end $$
delimiter ;
call delete_city(4);

delimiter $$
create procedure insert_city(in cityname char(120),nationalid int,cityarea long,citygdp int,cityDescrion varchar(255))
begin
insert into city(city.cityname,city.nationalid,city.cityarea,city.citygdp,city.cityDescrion) values(cityname,nationalid,cityarea,citygdp,cityDescrion);
end $$
delimiter ;
call insert_city('hcm',1,123131,120,'dep');