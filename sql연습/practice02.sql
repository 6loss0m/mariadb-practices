-- 집계(통계) SQL 문제입니다.

-- 문제 1. 
-- 최고임금(salary)과  최저임금을 “최고임금, “최저임금”프로젝션 타이틀로 함께 출력해 보세요. 두 임금의 차이는 얼마인가요? 함께 “최고임금 – 최저임금”이란 타이틀로 출력해 보세요.
select max(salary) as '최고임금', min(salary) as '최저임금', (max(salary)-min(salary)) as '최고임금 - 최저임금' from salaries;

-- 문제2.
-- 마지막으로 신입사원이 들어온 날은 언제 입니까? 다음 형식으로 출력해주세요.
-- 예) 2014년 07월 10일
select emp_no, date_format(max(hire_date), '%Y년 %m월 %d일') as '입사일' from employees; 

-- 문제3.
-- 가장 오래 근속한 직원의 입사일은 언제인가요? 다음 형식으로 출력해주세요.
-- 예) 2014년 07월 10일
select emp_no, date_format(min(hire_date), '%Y년 %m월 %d일') as '입사일' from employees; 

-- 문제4.
-- 현재 이 회사의 평균 연봉은 얼마입니까?
select avg(salary) as '평균 연봉' from salaries;

-- 문제5.
-- 현재 이 회사의 최고/최저 연봉은 얼마입니까?
select max(salary) as '최고 연봉' , min(salary) as '최저 연봉' from salaries;

-- 문제6.
-- 최고 어린 사원의 나이와 최 연장자의 나이는?
select year(now())-year(min(birth_date)) as '연장자', year(now())-year(max(birth_date)) as '연소자'
from employees;

select date_format(min(birth_date),'%Y') from employees;
select date_format(max(birth_date),'%Y') from employees;

select 
period_diff(date_format(curdate(), '%y'), date_format(min(birth_date),'%y')) as '연장자',
period_diff(date_format(curdate(), '%y'), date_format(max(birth_date),'%y')) as '연소자' 
from employees;

select
max(period_diff(date_format(curdate(),'%Y%m'),date_format(birth_date,'%Y%m')))/12 as '최연장자',
min(period_diff(date_format(curdate(),'%Y%m'),date_format(birth_date,'%Y%m')))/12 as '최연소자'	
from employees;

use employees;

-- [부가] 부서별 최연장자 최고연봉자

WITH MaxSalary AS (
    SELECT dept_no, MAX(s.salary) AS max_salary
    FROM dept_emp de
    JOIN salaries s ON de.emp_no = s.emp_no
    WHERE s.to_date = '9999-01-01'
    GROUP BY de.dept_no
),

OldestHireDate AS (
    SELECT dept_no, MIN(e.hire_date) AS oldest_hire_date
    FROM dept_emp de
    JOIN employees e ON de.emp_no = e.emp_no
    GROUP BY de.dept_no
)

SELECT 
    d.dept_name,

    -- Oldest employee info
    e1.first_name AS oldest_first_name,
    e1.last_name AS oldest_last_name,
    e1.hire_date,

    -- Highest salary employee info
    e2.first_name AS highest_salary_first_name,
    e2.last_name AS highest_salary_last_name,
    s.salary AS highest_salary

FROM departments d

-- Join for oldest employee
LEFT JOIN OldestHireDate ohd ON d.dept_no = ohd.dept_no
LEFT JOIN dept_emp de1 ON d.dept_no = de1.dept_no AND ohd.oldest_hire_date = e1.hire_date
LEFT JOIN employees e1 ON de1.emp_no = e1.emp_no

-- Join for highest salary employee
LEFT JOIN MaxSalary ms ON d.dept_no = ms.dept_no
LEFT JOIN dept_emp de2 ON d.dept_no = de2.dept_no
LEFT JOIN salaries s ON de2.emp_no = s.emp_no AND ms.max_salary = s.salary AND s.to_date = '9999-01-01'
LEFT JOIN employees e2 ON de2.emp_no = e2.emp_no

ORDER BY d.dept_name;