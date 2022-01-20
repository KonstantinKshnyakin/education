/*
 Write a select statement that takes name from person table
 and return "Hello, <name> how are you doing today?" results in a column named greeting
 */
SELECT format('Hello, %s how are you doing today?', p.name) as greeting
FROM person as p

