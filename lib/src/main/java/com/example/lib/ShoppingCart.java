/*
 * Lab 4
 * Kelly Mi
 * Online shopping cart - object with fields for customer name, date, and list of ItemToPurchase
 * 3.12.19
 */
//package com.example.lib;
import java.util.ArrayList;

public class ShoppingCart {
  private String customerName;
  private String currentDate;
  private ArrayList<ItemToPurchase> cartItems;
  
  public ShoppingCart(){
    customerName = "none";
    currentDate = "January 1, 2016";
    cartItems = new ArrayList<ItemToPurchase>();
  }
  
  public ShoppingCart(String name, String date){
    customerName = name;
    currentDate = date;
    cartItems = new ArrayList<ItemToPurchase>();
  }
  
  public String getCustomerName() {
    return customerName;
  }
  
  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }
  
  public String getDate() {
    return currentDate;
  }
  
  public void setDate(String currentDate) {
    this.currentDate = currentDate;
  }
  
  public void addItem(ItemToPurchase item){
    this.cartItems.add(item);
  }
  
  public void removeItem(String name){
    int removeIndex = -1;
    for (int i = 0; i < this.cartItems.size(); i++){
      if (this.cartItems.get(i).getName().equals(name)){
        removeIndex = i; //removes the last item with that name
      }
    }
    
    if (removeIndex == -1){
      System.out.println("Item not found in cart. Nothing removed.");
    } else {
      this.cartItems.remove(removeIndex);
    }
  }
  
  public void modifyItem(ItemToPurchase item1) {
    int modIndex = -1;
    for (int i = 0; i < this.cartItems.size(); i++) {
      if (this.cartItems.get(i).getName().equals(item1.getName())) {
        modIndex = i; //finds the last item with that name
      }
    }
  
    if (modIndex == -1) {
      System.out.println("Item not found in cart. Nothing modified.");
    } else {
      if (!(item1.getName().equals("none"))) {
        this.cartItems.get(modIndex).setName(item1.getName());
      }
      if (!(item1.getDescription().equals("none"))) {
        this.cartItems.get(modIndex).setDescription(item1.getDescription());
      }
      if (!(item1.getPrice() == 0)) {
        this.cartItems.get(modIndex).setPrice(item1.getPrice());
      }
      if (!(item1.getQuantity() == 0)) {
        this.cartItems.get(modIndex).setQuantity(item1.getQuantity());
      }
    }
  }
  
  public int getNumItemsInCart(){
    int total = 0;
    for (ItemToPurchase item : this.cartItems){
      total += item.getQuantity();
    }
    return total;
  }
  
  //return total cost of items
  public int getCostOfCart(){
    int total = 0;
    for (ItemToPurchase item : this.cartItems){
      total = total + (item.getPrice() * item.getQuantity());
    }
    return total;
  }
  
  //prints total price of all items in cart
  public void printTotal(){
    System.out.println(this.getCustomerName() + "'s Shopping Cart - " + this.getDate());
    System.out.println("Number of Items: " + this.getNumItemsInCart());
    System.out.println();
    if (this.cartItems.size() == 0) {
      System.out.println("SHOPPING CART IS EMPTY");
      System.out.println();
      System.out.println("Total: $0");
    } else {
      int total = getCostOfCart();
      
      for (ItemToPurchase item : this.cartItems){
        item.printItemCost();
      }
      
      System.out.println();
      System.out.println("Total: $" + total);
    }
  }
  
  public void printDescriptions(){
    if (this.cartItems.size() == 0) {
      System.out.println("SHOPPING CART IS EMPTY");
    } else {
      System.out.println(this.getCustomerName() + "'s Shopping Cart - " + this.getDate());
      System.out.println();
      System.out.println("Item Descriptions");
      for (ItemToPurchase item : this.cartItems) {
        item.printItemDescription();
      }
    }
  }
}