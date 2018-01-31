SELECT tc.account_no,tc.gender,tc.STATUS,ta.amount FROM tbl_customer tc
JOIN tbl_amount ta
ON ta.`account_no`=tc.`account_no`;

