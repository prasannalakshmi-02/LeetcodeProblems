/* Write your PL/SQL query statement below */
SELECT USER_ID, UPPER(SUBSTR(name, 1, 1)) || LOWER(SUBSTR(name, 2)) AS NAME
   FROM USERS ORDER BY USER_ID;