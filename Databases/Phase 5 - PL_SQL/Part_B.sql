--Test Insert & Delete
INSERT INTO House(HomeID,StreetAddress,StateName,SquareFeet,AskingPrice,CommisionPercent,SellerID,AgentID) VALUES('UI21053','420 Mercy Dr.','Hawaii',800,150000,5,'776-21-4920','BC8P930');
DELETE FROM House WHERE HomeID = 'UI21053';

INSERT INTO House(HomeID,StreetAddress,StateName,SquareFeet,AskingPrice,CommisionPercent,SellerID,AgentID) VALUES('YR54315','808 Central Dr.','California',6400,2600000,3.75,'627-89-4001','FQ24V32');
DELETE FROM House WHERE HomeID = 'YR54315';

--Trigger Start
DROP TRIGGER HouseAdded;

CREATE OR REPLACE TRIGGER HouseAdded
AFTER INSERT ON House
FOR EACH ROW
DECLARE
    represented INTEGER;
BEGIN
    SELECT HousesRepresented INTO represented FROM RealEstateAgent
    WHERE RealEstateAgent.AgentID = :new.AgentID;
    
    IF represented < 3 THEN
        UPDATE RealEstateAgent SET HousesRepresented = represented + 1 WHERE RealEstateAgent.AgentID = :new.AgentID;
        represented := represented + 1;
        DBMS_OUTPUT.PUT_LINE('Agent is now representing ' || represented || ' homes.');
    ELSIF represented >= 3 THEN
        RAISE_APPLICATION_ERROR(-20000, 'Agent is fully booked. Agent can not represent more houses.');
    END IF;
END;