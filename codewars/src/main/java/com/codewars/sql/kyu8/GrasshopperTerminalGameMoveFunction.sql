/*
 Terminal game move function
In this game, the hero moves from left to right. The player rolls the die and moves the number of spaces indicated by the die two times.

In SQL, you will be given a table moves with columns position and roll. Return a table which uses the current position of the hero and the roll (1-6) and returns the new position in a column res.

Example:
move(3, 6) should equal 15
 */

SELECT (m.position + m.roll * 2) as res
FROM moves as m