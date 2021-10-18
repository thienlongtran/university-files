--1. Find all the buyers (their names) within a minimum price range of $150,000.
SELECT BuyerName FROM Buyer
WHERE LowerPriceLimit >= 150000;

--2. Find all buyers with agent ID 1 and sort the query output by their max price (any direction).
SELECT * FROM Buyer
WHERE AgentID = 'PL1W980' --Default to Agent PL1W980 instead of 1 since my AgentID is complexer than a number.
ORDER BY UpperPriceLimit ASC;

SELECT * FROM Buyer
WHERE AgentID = '1' --Version with strict requirement.
ORDER BY UpperPriceLimit ASC;

--3. Find the names of all buyers who have a phone number with a 504 area code (hint: remember the LIKE operator).
SELECT BuyerName FROM Buyer
WHERE PhoneNumber LIKE '504%';

--4. Return the house addresses that do not have a listing price.
SELECT StreetAddress, StateName FROM House
WHERE AskingPrice IS NULL;

--5. Find the square feet of all houses with a price between $100,000 and $200,000.
SELECT SquareFeet FROM House
WHERE AskingPrice BETWEEN 100000 AND 200000;

--6. Find all buyers who have a phone number with a 312 area code and do not have agent ID 1.
SELECT * FROM Buyer
WHERE PhoneNumber LIKE '312%' AND AgentID <> 'PL1W980'; --Default to Agent PL1W980 instead of 1 since my AgentID is complexer than a number.

SELECT * FROM Buyer
WHERE PhoneNumber LIKE '312%' AND AgentID <> '1'; --Version with strict requirement.

--7. Find the minimum and maximum square feet for all houses. Use only one query.
--8. Find the average max price for all buyers with agent ID 1. 
--9. Find the house with the highest price. Do not hardcode any salaries or other values.
--10. Find the houses that cost less than the average overall price for all houses + 20% (i.e., less than 1.2 * average price). Do not hardcode any prices or other values.
