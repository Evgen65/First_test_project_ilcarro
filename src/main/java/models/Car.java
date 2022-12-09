package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sun.reflect.generics.factory.CoreReflectionFactory;

@Getter
@Setter
@ToString
@Builder

public class Car {
    String address;
    String make;
    String model;
    String year;
    String fuel;
    String seats;
    String carClass;
    String regNumber;
    String carRegNumber;
    String price;


}
