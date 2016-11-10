#Truncate Exact Target Customer Accounts table
DROP PROCEDURE IF EXISTS truncateEXACTTARGETCustomerAccounts;
DELIMITER ;;
CREATE PROCEDURE truncateEXACTTARGETCustomerAccounts()
BEGIN

	TRUNCATE TABLE EXACTTARGET_account_customer_and_address;
	
END;;
DELIMITER ;

#Truncate Exact Target Subscriber Accounts table
DROP PROCEDURE IF EXISTS truncateEXACTTARGETSubscriberAccounts;
DELIMITER ;;
CREATE PROCEDURE truncateEXACTTARGETSubscriberAccounts()
BEGIN

	TRUNCATE TABLE EXACTTARGET_newsletter_signups;
	
END;;
DELIMITER ;
