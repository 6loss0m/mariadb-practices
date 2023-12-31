use employees;
show tables;

select * from employees;

select * from salaries where emp_no = 10001;

--
-- select 연습
--

-- 예제1: departments 테이블의 모든 데이터를 출력
select * from departments;

-- 프로젝션(projection)
-- 예제2: emplyees 테이블에서 직원 이름, 성별, 입사일을 출력
select first_name as '이름',
	gender as '성별' ,
    hire_date as '입사일' 
    from employees;
    
-- distinct 
-- 예3: titles 테이블에서 모든 직급을 출력하라.
-- limit는 상단에 limit to 10rows를 통해 자동으로 붙어서 생략이 가능하다. 대신 붙이면, 시작과 끝 index 설정 가능.
SELECT distinct title from titles limit 0, 10;

-- 예4: titles 테이블에서 모든 직급은 어떤 것들이 있는지 직급이름을 한 번씩만 출력하세요.
select distinct title from titles;

--
-- where 절
--
use employees;
-- 예제1: 비교연산자: emplyees 테이블에서 1991년 이전에 입사한 직원의 이름, 
--                성별, 입사일을 출력 
select first_name, gender, hire_date
  from employees
  where hire_date < '1991-01-01'
  order by hire_date desc;
  
  -- 예제2: 논리연산자: employees 테이블에서 1989년 이전에 입사한 여직원의 이름, 성별, 입사일을 출력

select first_name, gender, hire_date
  from employees
  where hire_date <= '1989-12-31' and gender='F'
  order by hire_date desc;
  
-- 예제3: in 연산자: dept_emp 테이블에서 부서 번호가 d005이거나 d009에 속한 사원의 사번, 부서 번호 출력
select emp_no, dept_no
from dept_emp
where dept_no = 'd005' or dept_no = 'd009';

select emp_no, dept_no
from dept_emp
where dept_no in('d005', 'd009');

-- 예제4: like 검색: employees 테이블에서 1989년에 입사한 직원들의 이름, 입사일을 출력하세요
select * 
from employees 
where '1898-01-01' <= hire_date 
and hire_date >= '1989-12-31';

select * 
from employees 
where hire_date between'1898-01-01' and '1989-12-31';

select * from employees where hire_date like '1989%';

--
-- order by
--

-- 예제1: employees 테이블에서 직원 이름, 성별, 입사일을 입사일 빠른 순으로 출력
select concat(first_name,' ',last_name) as 'full name', gender, hire_date
from employees
order by hire_date;

-- 예제2: salaries 테이블에서 2001년 월급이 가장 높은 순으로 사번, 월급을 출력
select emp_no, salary, from_date, to_date from salaries
where to_date like '2001%' or from_date like '2001%'
order by salary desc;

-- 예제3: 남자 직원의 이름, 성별, 입사일을 선임순으로 출력
select concat(first_name,' ',last_name), gender, hire_date
from employees 
where gender='M'
order by hire_date;

-- 예제4: 직원들의 사번, 월급을 사번 순으로 출력하되 같은 직원의 월급이 높은 순도 반영
select emp_no, salary from salaries order by emp_no, salary desc;