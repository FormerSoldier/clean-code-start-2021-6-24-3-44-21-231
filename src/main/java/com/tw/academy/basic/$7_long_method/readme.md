**OrderReceipt**
1. Dead Code(去掉dead code可减少developer去理解代码的时间，提高可读)
- function printCustomerName and comment Deprecated
- comment  output.append("Date - " + order.getDate()
- output.append(order.getCustomerLoyaltyNumber())

**2. Mysterious naming**
- Order o，rename to order
- tot rename to allTotalAmount
- totSalesTx rename to totSalesTax

**3. Magic Number**
- extract .10 to TEN_PERCENT
- extract \t to TAB_CHARACTER

**4. Long Method**
there are many function logic in the printReceipt
- extract calculate totSalesTax to a method calculateTotSalesTax
- extract calculate allTotalAmount to a method calculateAllTotalAmount
- extract get lineitem to a method

**5. Feature Envy**
- extract totSalesTax and allTotalAmount to Order class
- extract lineitem to LineItem class