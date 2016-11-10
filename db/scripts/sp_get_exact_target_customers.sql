DROP PROCEDURE IF EXISTS getExactTargetCustomers;
DELIMITER ;;
CREATE PROCEDURE getExactTargetCustomers()
BEGIN
  SELECT customer_id, customer_email, customer_name, is_active, is_fraudster, is_VIP, subscribed_to_newsletter, DATE_FORMAT(registration_date, '%Y%m%d %H:%i') AS registration_date, city, state, zip, country, address_order_id
  FROM EXACTTARGET_account_customer_and_address;
END;;
DELIMITER ;