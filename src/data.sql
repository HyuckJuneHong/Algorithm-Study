select e.BRANCH_ID, e.NAME
from (select e2.BRANCH_ID, max(e2.SALARY) as S
        from EMPLOYEES e2
        group by e2.BRANCH_ID) t,
     EMPLOYEES e
where t.BRANCH_ID = e.BRANCH_ID and t.S = e.SALARY
order by e.BRANCH_ID, e.NAME
