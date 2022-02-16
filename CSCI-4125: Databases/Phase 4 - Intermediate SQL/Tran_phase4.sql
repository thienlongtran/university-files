--1. Retrieve the street address for houses with an agent in the New Orleans office. 
SELECT StreetAddress FROM House INNER JOIN RealEstateAgent
ON House.AgentID = RealEstateAgent.AgentID
WHERE OfficeName = 'New Orleans';


--2. Retrieve the street address for house which have a seller name that is the same as the listing agent’s name. 
SELECT StreetAddress FROM House, RealEstateAgent, Seller
WHERE House.SellerID = Seller.SocialSecurityNumber AND House.AgentID = RealEstateAgent.AgentID
    AND AgentName = SellerName;


--3. Find names of all agents who represent a buyer with a minimum price range greater than $80K and a maximum price range less than $225K. 
SELECT AgentName FROM RealEstateAgent, Buyer
WHERE Buyer.AgentID = RealEstateAgent.AgentID
    AND LowerPriceLimit > 80000 AND UpperPriceLimit < 225000
GROUP BY AgentName;


--4. For each agent, list their name, office, and the total number of buyers they represent. 
SELECT AgentName, OfficeName, COUNT(BuyerName) AS NumberOfBuyers FROM RealEstateAgent LEFT OUTER JOIN Buyer
ON RealEstateAgent.AgentID = Buyer.AgentID
GROUP BY AgentName, OfficeName;


--5. Retrieve the street address for all houses that have an agent who is representing at least one buyer. 
SELECT * FROM House
WHERE AgentID IN (  
                    SELECT RealEstateAgent.AgentID FROM RealEstateAgent LEFT OUTER JOIN Buyer
                    ON RealEstateAgent.AgentID = Buyer.AgentID
                    GROUP BY RealEstateAgent.AgentID
                    HAVING COUNT(BuyerName) >= 1
                 );


--6. Retrieve the street address for all houses that have an agent who is not representing any buyers. 
SELECT StreetAddress FROM House
WHERE AgentID IN (  
                    SELECT RealEstateAgent.AgentID FROM RealEstateAgent LEFT OUTER JOIN Buyer
                    ON RealEstateAgent.AgentID = Buyer.AgentID
                    GROUP BY RealEstateAgent.AgentID
                    HAVING COUNT(BuyerName) = 0
                 );


--7. For each agent, retrieve the agent’s name and the average commission of all houses they are listing. 
SELECT AgentName, RealEstateAgent.AgentID, AVG(CommisionPercent) FROM RealEstateAgent LEFT OUTER JOIN House
ON RealEstateAgent.AgentID = House.AgentID
GROUP BY AgentName, RealEstateAgent.AgentID;


--8. Retrieve the average price for all houses in the state of Louisiana. 
SELECT AVG(AskingPrice) FROM House
WHERE StateName = 'Louisiana';


--9. List the names of all agents and the number of phone numbers they have. 
SELECT AgentName, RealEstateAgent.AgentID, COUNT(PhoneNumber) FROM RealEstateAgent LEFT OUTER JOIN RealEstateAgentPhone
ON RealEstateAgent.AgentID = RealEstateAgentPhone.AgentID
GROUP BY AgentName, RealEstateAgent.AgentID;


--10. Find the names of all agents who represent exactly two buyers. 
SELECT AgentName, RealEstateAgent.AgentID FROM RealEstateAgent LEFT OUTER JOIN Buyer
ON RealEstateAgent.AgentID = Buyer.AgentID
GROUP BY AgentName, RealEstateAgent.AgentID
HAVING COUNT(BuyerName) = 2;


--11. For each agent whose average commission is greater than $10K, retrieve the agent’s name and the number houses they represent.
SELECT AgentName, RealEstateAgent.AgentID, COUNT(HomeID) AS HousesRepresented FROM RealEstateAgent INNER JOIN House
ON RealEstateAgent.AgentID= House.AgentID
WHERE RealEstateAgent.AgentID IN (
                                SELECT AgentID FROM House
                                WHERE CommisionPercent IS NOT NULL AND AskingPrice IS NOT NULL
                                GROUP BY AgentID
                                HAVING AVG(CommisionPercent*AskingPrice) > 10000
                                )
GROUP BY AgentName, RealEstateAgent.AgentID;


--12. Retrieve the names of all buyers who are represented by the agent who is listing the lowest priced house. 
SELECT BuyerName FROM Buyer
WHERE AgentID = (SELECT AgentID FROM HOUSE
                WHERE AskingPrice = (SELECT MIN(AskingPrice) FROM House));


--13. Retrieve the agent’s name and the buyer’s name for all agents who are listing a house within the buyer’s price range (i.e., house price is between minimum and maximum price range). 
SELECT AgentName, BuyerName FROM RealEstateAgent INNER JOIN Buyer
ON RealEstateAgent.AgentID = Buyer.AgentID
INNER JOIN House
ON RealEstateAgent.AgentID = House.AgentID
WHERE UpperPriceLimit > AskingPrice AND LowerPriceLimit < AskingPrice;


--14. Find sellers whose SSN number has a pattern 321 repeated twice (sequentially). For example, the query should return sellers with the SSN’s ‘321-32-145’ and ‘983-21-3219’, but not ‘321-99-3218’. 
SELECT * FROM Seller
WHERE REGEXP_LIKE(SocialSecurityNumber, '3[\-]*2[\-]*1[\-]*3[\-]*2[\-]*1[\-]*');


--15. Find agents whose office consists of exactly 2 words. For example, the query should return records for “Metairie Office” and “Downtown Office”, but not “University of New Orleans Office”. 
SELECT * FROM RealEstateAgent
WHERE REGEXP_LIKE(OfficeName, '^[a-zA-Z0-9]+\s[a-zA-Z0-9]+$');


--16. Find all houses that include a street number in the street address. For example, the query should return records for “2000 Lakeshore Drive” and “1500 Sugar Bowl Drive” but not “Canal Street”.
SELECT * FROM House
WHERE REGEXP_LIKE(StreetAddress, '^[0-9]+\s');
