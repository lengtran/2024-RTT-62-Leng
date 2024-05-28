select * from employees where firstname = 'Diane';

Select * from employees where job_titles = 'Sales Rep' order by firstname desc;

Select * from offices where country = 'USA';

select distinct country from offices;
select distinct firstname from employees order by firstname;

select count(*) as 'count'
from offices o
where o.country = 'USA'; 

--- To view all emp that work in office in USA
select e.* 
from employees e, offices o
where e.office_id = o.id
	and o.country ='USA';