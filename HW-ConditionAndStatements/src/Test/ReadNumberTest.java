package Test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import src.ReadNumbers;

public class ReadNumberTest {

   @Test
    public void testfloat(){

        Assert.assertTrue(ReadNumbers.chekfloat(1,2,3));
    }


}
