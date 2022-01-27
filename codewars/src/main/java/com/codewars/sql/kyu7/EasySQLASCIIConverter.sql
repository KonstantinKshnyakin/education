/*
 Given a demographics table in the following format:

** demographics table schema **

id
name
birthday
race
you need to return the same table where all text fields (name & race) are changed to the ascii code of their first byte.

e.g. Verlie = 86 Warren = 87 Horace = 72 Tracy = 84
*/

SELECT id,
       ascii(substr(name, 1, 1)) as name,
       birthday,
       ascii(substr(race, 1, 1)) as race
FROM demographics