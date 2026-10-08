/* Write your PL/SQL query statement below */
SELECT * FROM USERS WHERE 
    REGEXP_LIKE(email, '^[A-Za-z0-9_]+@[A-Za-z]+\.com$')
    order by user_id;