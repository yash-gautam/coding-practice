# Write your MySQL query statement below
SELECT distinct(p1.email) 
from Person p1, Person p2
WHERE p1.id <> p2.id AND p1.email=p2.email

