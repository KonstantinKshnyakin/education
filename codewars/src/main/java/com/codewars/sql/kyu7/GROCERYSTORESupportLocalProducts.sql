/*
You are the owner of the Grocery Store. All your products are in the database, that you have created after CodeWars SQL excercises!:)

You care about local market, and want to check how many products come from United States of America or Canada.

Please use SELECT statement and IN to filter out other origins.

In the results show how many products are from United States of America and Canada respectively.

Order by number of products, descending.
 */

SELECT count(*) as products, p.country
FROM products p
WHERE p.country IN ('United States of America', 'Canada')
GROUP BY p.country
ORDER BY products DESC;