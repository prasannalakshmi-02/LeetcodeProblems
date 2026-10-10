/* Write your PL/SQL query statement below */
SELECT to_char(event_day) as day, emp_id, sum(out_time-in_time) as total_time
   from employees group by event_day, emp_id;