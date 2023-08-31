-- 서브쿼리(SUBQUERY) SQL 문제입니다.
use employees;

-- 문제1.
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
select avg(salary)
				from salaries 
				where to_date = '9999-01-01';

select count(*)
from salaries
where to_date = '9999-01-01' 
and salary > (select avg(salary)
				from salaries 
				where to_date = '9999-01-01');
-- 문제2. (x)
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다. 

-- 문제3.
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요 
select de.dept_no, avg(s.salary)
	from salaries s, dept_emp de
	where s.emp_no = de.emp_no
		and s.to_date ='9999-01-01'
        and de.to_date = '9999-01-01'
	group by de.dept_no;

select e.emp_no, concat(e.first_name , ' ', e.last_name) as '이름', s.salary
from employees e, salaries s, dept_emp de, (select de.dept_no, avg(s.salary) as avg_salary
										from salaries s, dept_emp de
										where s.emp_no = de.emp_no
											and s.to_date = '9999-01-01'
											and de.to_date = '9999-01-01'
										group by de.dept_no) as dept_avg
where e.emp_no = s.emp_no
	and s.to_date = '9999-01-01'
    and de.to_date = '9999-01-01'
    and s.salary > dept_avg.avg_salary;
						
-- 문제4.
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.

 
-- 문제5.
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.
select de.dept_no
	from dept_emp de, salaries s
	where de.emp_no = s.emp_no
		and de.to_date = '9999-01-01'
        and s.to_date = '9999-01-01'
	group by de.dept_no
    limit 1;

select de.emp_no, e.last_name, t.title, s.salary
from dept_emp de, titles t, salaries s, employees e
where de.emp_no = t.emp_no
	and de.emp_no = s.emp_no
    and de.emp_no = e.emp_no
    and s.to_date = '9999-01-01'
    and de.to_date = '9999-01-01'
    and t.to_date = '9999-01-01'
    and de.dept_no = (select de.dept_no
							from dept_emp de, salaries s
							where de.emp_no = s.emp_no
								and de.to_date = '9999-01-01'
								and s.to_date = '9999-01-01'
							group by de.dept_no
                            order by avg(s.salary)
							limit 1);


-- 문제6.
-- 평균 연봉이 가장 높은 부서는? 
-- 총무 20000
 select d_name, avg_salary
 from (select d.dept_name as d_name, avg(s.salary) as avg_salary
		from dept_emp de, departments d, salaries s
		where de.emp_no = s.emp_no
		and de.dept_no = d.dept_no
		and s.to_date = '9999-01-01'
		and de.to_date = '9999-01-01'
		group by de.dept_no
		order by avg(s.salary) desc)
	limit 1;


select d.dept_name as d_name, avg(s.salary) as avg_salary
		from dept_emp de, departments d, salaries s
		where de.emp_no = s.emp_no
		and de.dept_no = d.dept_no
		and s.to_date = '9999-01-01'
		and de.to_date = '9999-01-01'
		group by de.dept_no
		order by avg(s.salary) desc;
        
-- 문제7.
-- 평균 연봉이 가장 높은 직책?
-- Engineer 40000
select title, avg_salary
from ( select title , avg(s.salary) as avg_salary
			from titles t, salaries s
			where t.emp_no = s.emp_no
			and t.to_date = '9999-01-01'
			and s.to_date = '9999-01-01'
		group by t.title
		order by avg(s.salary) desc) as title_avg
limit 1;


-- 문제8. (순수 join 문제)
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.

