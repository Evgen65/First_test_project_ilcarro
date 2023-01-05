package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Builder
public class Find {
    String city;
    String dates;
    String firstDates;
    String firstMonth;
    String firstYear;
    String lastDates;
    String lastMonth;
    String lastYear;

}
