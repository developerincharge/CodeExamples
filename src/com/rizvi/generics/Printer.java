package com.rizvi.generics;

public class Printer <T , V> {

      T thingToPrint;
      V otherThing;

    public Printer(T thingToPrint, V otherThing) {
       this.thingToPrint = thingToPrint;
       this.otherThing = otherThing;
    }

    public void print() {
        System.out.println(thingToPrint+" "+otherThing);
    }
}
