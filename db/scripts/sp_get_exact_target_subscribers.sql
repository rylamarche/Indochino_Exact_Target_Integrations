DROP PROCEDURE IF EXISTS getExactTargetSubscribers;
DELIMITER ;;
CREATE PROCEDURE getExactTargetSubscribers()
BEGIN
  SELECT email, DATE_FORMAT(signUpdate, '%Y%m%d %H:%i') AS signUpdate
  FROM EXACTTARGET_newsletter_signups;
END;;
DELIMITER ;