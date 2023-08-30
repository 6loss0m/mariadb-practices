-- 1) 집계쿼리: select절에 통계함수(avg, max, min, count, sum, stddev, ...)
select avg(salary), sum(salary) from salaries;

-- 2) select 절에 그룹함수(통계함수)가 있는 경우, 어떤 컬럼도 select 절에 올 수 없다.
-- emp_no는 아무런 의미가 없다.
-- 오류!! (에러는 나지 않지만 mysql의 오류)
select emp_no, avg(salary)
from salaries


-- 3) 쿼리 순서
-- 	  1. from: 테이블에 접근
--    2. where: 조건에 맞는 row를 선택
--    3. projection: 집계(임시 테이블, 메모리 캐시)
--    4. 결과를 반환

-- 예제 사번이 10060인 사원이 받은 평균 연봉은?
select avg(salary)
from salaries
where emp_no = 10060;

-- 4) group by에 참여 컬럼은 projection이 가능한가: select 절에 올 수 있다.
-- 예제: 사원별 평균 연봉을 큰 순서대로 출력
select emp_no, avg(salary)
from salaries
group by emp_no;

select emp_no, avg(salary) as avg_salary
from salaries
group by emp_no
order by avg_salary desc;

-- 5) Having
-- 		집계 결과(결과 테이블)에서 row를 선택해야 하는 경우
-- 		이미 where 절은 실행이 되었기 때문에 having 절에서 조건을 주어야 한다.
-- 예제: 평균 연봉이 60,000 달러 이상인 사원의 사번과 평균 연봉을 출력
select emp_no, avg(salary) as avg_salary
from salaries
group by emp_no
having avg_salary >= 60000;

-- 6) order by
-- 		order by는 항상 맨 마지막 출력 전에 한다.
select emp_no, avg(salary) as avg_salary
from salaries
group by emp_no
having avg_salary >= 60000
order by avg_salary desc;

-- 주의)
-- 예제: 사번이 10060인 사원의 사번, 평균 급여, 급여 총합을 출력

-- 문법적으로 오류!
-- 의미적으로는 맞음(where절의 조건 때문에)
select emp_no, avg(salary), sum(salary)
from salaries
where emp_no = 10060; 

select emp_no, avg(salary), sum(salary)
from salaries
group by emp_no
having emp_no = 10060;