package fitnesse.slim.converters;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateConverterTest extends AbstractConverterTest<Date, DateConverter> {
  public DateConverterTest() {
    super(new DateConverter());
  }

  /*
   * TO STRING
   */
  @Test
  public void toString_should_return_string_which_contains_the_date_when_value_is_a_date() throws ParseException {
    String expected = "05-May-2009";
    Date value = getDate(expected);

    String current = converter.toString(value);

    assertEquals(expected, current);
  }

  /*
   * FROM STRING
   */
  @Test
  public void fromString_should_return_the_date_when_value_is_a_date() throws ParseException {
    String value = "05-May-2009";

    Date current = converter.fromString(value);

    assertEquals(getDate(value), current);
  }

  @Test
  public void fromString_should_return_the_date_when_value_is_a_date_without_leading_zero() throws ParseException {
    String value = "5-May-2009";

    Date current = converter.fromString(value);

    assertEquals(getDate(value), current);
  }

  /*
   * PRIVATE
   */
  private static Date getDate(String dateStr) throws ParseException {
    return DateConverter.dateFormat.parse(dateStr);
  }

}
