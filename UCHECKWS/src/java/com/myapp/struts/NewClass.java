/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.myapp.struts;

import java.math.BigDecimal;


/**
 *
 * @author dell
 */
public class NewClass {
    private static final long serialVersionUID = 1L;
  
             
	private static final Order[] orderList = new Order[] {
 
		new Order("A0001", "Intel CPU", 
				new BigDecimal("700.00"), 1),
		new Order("A0002", "Harddisk 10TB", 
				new BigDecimal("500.00"), 2),
		new Order("A0003", "Dell Laptop", 
				new BigDecimal("11600.00"), 8),
		new Order("A0004", "Samsung LCD", 
				new BigDecimal("5200.00"), 3),
		new Order("A0005", "A4Tech Mouse", 
				new BigDecimal("100.00"), 10)
	};
 
	public Order[] getOrderList() {
 
		return orderList;
 
	}
 
    
        
	public static class Order{
 
		public String orderNo;
		public String productName;
		public BigDecimal price;
		public int qty;
 
		public Order(String orderNo, String productName, 
                                BigDecimal price, int qty) {
 
    			this.orderNo = orderNo;
			this.productName = productName;
			this.price = price;
			this.qty = qty;
		}
 
		//getter and setter methods

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }
                
                
	}
}
