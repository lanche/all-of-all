# 统计流水余额
select account_balance_id, in_out_type, sum(amount)
from account_book_flow_i_gm712131691323525399_54
where state = 1
  and accum_state = 1
  and complete_time < 1617120000000
group by account_balance_id, in_out_type;


