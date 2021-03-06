_Taxation is a term for when a taxing authority (usually a government) imposes a tax. Imagine having multiple web sites in many countries (let's call these sites traders) out of which each must follow different local taxation rules and calculations. Site users bets an amount on the give odd, e.g. 5 EUR * 1.5 = 7.5 EUR. Everything will be done in EUR currency to keep it simple.
Prepare a REST service with specified input/output:_
~~~~
 "incoming": {
   "traderId": 1,
   "playedAmount": 5,
   "odd": 3.2
 }
 
 "outgoing" {
   "possibleReturnAmount": Q,
   "possibleReturnAmountBefTax": W,
   "possibleReturnAmountAfterTax": X,
   "taxRate": Y,
   "taxAmount" Z
 }
 ~~~~
_Your service must support two types of taxation:_
##### 1. General #####
  _* taxation is done per rate or per amount:
rate: 10%
7.5EUR * 0.1 = 0.75EUR => possible return amount is 7.5EUR - 0.75EUR = 6.75
amount: 2EUR
7.5EUR - 2EUR = 5.5EUR => possible return amount is 5.5EUR
#####  2. Winnings #####
   * winnings amount: 7.5EUR - 5EUR = 2.5EUR
   * taxation is done per rate or per amount:
rate: 10%
2.5EUR * 0.1 = 0.25EUR => possible return amount is 7.5EUR - 0.25EUR = 7.25EUR
amount: 1EUR
2.5EUR - 1EUR = 1.5EUR => possible return amount is 7.5EUR - 1.5EUR = 6.00EUR_
