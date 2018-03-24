/*
 * Lab 4
 * Kelly Mi
 * Online shopping cart item - object with fields for name, description, price, and quantity
 * 3.12.19
 */
//package com.example.lib;

public class ItemToPurchase {
  private String itemName;
  private String itemDescription;
  private int itemPrice;
  private int itemQuantity;
  
  //default constructor
  public ItemToPurchase(){
    itemName = "none";
    itemDescription = "none";
    itemPrice = 0;
    itemQuantity = 0;
  }
  
  //constructor with fields for name/desc/price/qty
  public ItemToPurchase(String name, String desc, int price, int quantity){
    itemName = name;
    itemDescription = desc;
    itemPrice = price;
    itemQuantity = quantity;
  }
  
  //constructor with fields for name/qty
  public ItemToPurchase(String name, int quantity){
    itemName = name;
    itemDescription = "none";
    itemPrice = 0;
    itemQuantity = quantity;
  }
  
  public void setName(String name){
    itemName = name;
  }
  
  public String getName(){
    return itemName;
  }
  
  public void setDescription(String desc){
    this.itemDescription = desc;
  }
  
  public String getDescription(){
    return itemDescription;
  }
  
  public void setPrice(int price){
    this.itemPrice = price;
  }
  
  public int getPrice(){
    return itemPrice;
  }
  
  public void setQuantity(int quantity){
    this.itemQuantity = quantity;
  }
  
  public int getQuantity(){
    return itemQuantity;
  }
  
  //print item price * quantity
  public void printItemCost() {
    System.out.println(itemName + " " + itemQuantity + " @ $" + itemPrice + " = $" + (itemQuantity * itemPrice));
  }
  
  //print item description
  public void printItemDescription(){
    System.out.println(itemName + ": " + itemDescription);
  }
}