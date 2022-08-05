# SQL

## [175. 组合两个表](https://leetcode.cn/problems/combine-two-tables/)

````sql
# Write your MySQL query statement below
select firstName,lastName,city,state from 
Person  left join Address on Person.personId = Address.personId;
````



